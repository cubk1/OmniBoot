package client.command;

import org.lwjgl.input.Keyboard;
import org.union4dev.omni.Omni;
import org.union4dev.omni.annotations.features.Command;
import org.union4dev.omni.elements.module.AbstractModule;

@Command(value = {"bind","b"}, usage = "bind <module> <key>")
public class BindCommand {
	@Command.HandleCommand()
	public void run(String[] args) {
		if (args.length == 2) {
			AbstractModule module = Omni.getInstance().getModuleManager().getByName(args[0]);
			if (module != null) {
				module.setKey(Keyboard.getKeyIndex(args[1].toUpperCase()));
				Omni.getInstance().getClient().printMessage(module.getName() + " has been bound to " + args[1] + ".");
			} else {
				Omni.getInstance().getClient().printMessage(args[0] + " not found.");
			}
		}else {
			Omni.getInstance().getClient().printMessage("sb");
		}
	}

}
