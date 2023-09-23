package org.union4dev.omni;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.union4dev.omni.annotations.features.BindKeyPress;
import org.union4dev.omni.annotations.features.Command;
import org.union4dev.omni.annotations.features.RegisterTo;
import org.union4dev.omni.components.ComponentManager;
import org.union4dev.omni.components.bind.BindManager;
import org.union4dev.omni.components.command.CommandManager;
import org.union4dev.omni.components.event.EventManager;
import org.union4dev.omni.components.event.internal.InitiateEvent;
import org.union4dev.omni.components.module.ModuleManager;
import org.union4dev.omni.elements.IClient;
import org.union4dev.omni.elements.IRender;
import org.union4dev.omni.elements.data.Pair;
import org.union4dev.omni.elements.plugin.OmniPlugin;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@Log4j2
public class Omni {

    private static final Omni INSTANCE = new Omni();

    @Getter
    private ComponentManager componentManager;

    @Getter
    private IClient client;

    @Getter
    private IRender render;

    @Getter
    private final Properties properties = new Properties();

    public static Omni getInstance() {
        return INSTANCE;
    }

    @SneakyThrows
    @SuppressWarnings("unchecked")
    public void start(IClient client){
        log.info("starting omni manager...");
        this.client = client;

        componentManager = new ComponentManager();

        properties.load(Omni.class.getResourceAsStream("/omni.properties"));

        String[] pluginList = properties.getProperty("plugins").split(",");

        for(String pluginClass : pluginList){
            try {
                Class<? extends OmniPlugin> plugin = (Class<? extends OmniPlugin>) Class.forName(pluginClass);
                OmniPlugin instance = plugin.newInstance();
                instance.load(client,componentManager);
                log.info("Loaded plugin {}.",instance.getName());
            }catch (ClassNotFoundException e){
                log.warn("Plugin class {} is not present.",pluginClass);
            }
        }

        componentManager.initiate();

        List<URL> urls = new ArrayList<>();
        if (Omni.class.getClassLoader() instanceof URLClassLoader) {
            Collections.addAll(urls, ((URLClassLoader) Omni.class.getClassLoader()).getURLs());
        } else {
            for (String s : System.getProperty("java.class.path").split(";")) {
                urls.add(new File(s).toURI().toURL());
            }
        }
        scanClasses(urls).forEach(s -> {
            if(s.startsWith(client.getClass().getName().split("\\.")[0]) || s.startsWith("net.minecraft")) {
                try {
                    Class<?> clazz = Class.forName(s);
                    if (clazz.isAnnotationPresent(RegisterTo.class)) {
                        RegisterTo registerTo = clazz.getAnnotation(RegisterTo.class);
                        componentManager.getByClass(registerTo.value()).addInstance(clazz);
                    }
                    if (clazz.isAnnotationPresent(Command.class)) {
                        getCommandManager().addInstance(clazz);
                    }
                    for(Method method : clazz.getDeclaredMethods()){
                        if(method.isAnnotationPresent(BindKeyPress.class)){
                            if(!Modifier.isStatic(method.getModifiers()) || method.getParameters().length > 0){
                                log.warn("Method {} is not a valid bind method",method.getName());
                                continue;
                            }
                            BindKeyPress keyPress = method.getAnnotation(BindKeyPress.class);
                            getBindManager().addValue(new Pair<>(keyPress.value(),method));
                        }
                    }
                } catch (Throwable e) {
                    log.warn(e.getMessage());
                }
            }
        });

        client.initiate();

        getEventManager().call(new InitiateEvent());
    }

    public EventManager getEventManager(){
        return componentManager.getByClass(EventManager.class);
    }

    public ModuleManager getModuleManager(){
        return componentManager.getByClass(ModuleManager.class);
    }

    public BindManager getBindManager(){
        return componentManager.getByClass(BindManager.class);
    }

    public CommandManager getCommandManager(){
        return componentManager.getByClass(CommandManager.class);
    }

    private static Set<String> scanClasses(List<URL> urls) throws URISyntaxException, IOException {
        Set<String> classes = new HashSet<>();
        for (URL url : urls) {
            if ("file".equals(url.toURI().getScheme())) {
                File file = new File(url.toURI());
                if (!file.exists()) {
                    continue;
                }
                if (file.isDirectory()) {
                    Files.walk(file.toPath())
                            .filter(path -> path.toFile().getName().endsWith(".class"))
                            .forEach(path -> {
                                String className = getClassNameFromFile(file, path.toFile());
                                classes.add(className);
                            });
                } else if (file.getName().endsWith(".jar")) {
                    try (JarFile jarFile = new JarFile(file)) {
                        Enumeration<JarEntry> entries = jarFile.entries();
                        while (entries.hasMoreElements()) {
                            JarEntry jarEntry = entries.nextElement();
                            if (jarEntry.getName().endsWith(".class")) {
                                String className = getClassNameFromJarEntry(jarEntry);
                                classes.add(className);
                            }
                        }
                    }
                }
            }
        }
        return classes;
    }

    private static String getClassNameFromFile(File baseDir, File classFile) {
        String relativePath = baseDir.toPath().relativize(classFile.toPath()).toString();
        String className = relativePath.replace(File.separator, ".");
        return className.substring(0, className.length() - 6);
    }

    private static String getClassNameFromJarEntry(JarEntry jarEntry) {
        String className = jarEntry.getName().replace("/", ".");
        return className.substring(0, className.length() - 6);
    }
}
