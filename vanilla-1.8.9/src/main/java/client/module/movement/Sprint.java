package client.module.movement;

import client.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import org.lwjgl.input.Keyboard;
import org.union4dev.omni.annotations.event.EventTarget;
import org.union4dev.omni.annotations.features.BindKeyPress;
import org.union4dev.omni.annotations.features.RegisterTo;
import org.union4dev.omni.components.event.internal.TickUpdateEvent;
import org.union4dev.omni.components.features.Category;
import org.union4dev.omni.components.features.ModuleManager;

@RegisterTo(ModuleManager.class)
public class Sprint extends Module {
    public Sprint() {
        super("Sprint", Category.MOVEMENT, Keyboard.KEY_R);
    }

    @EventTarget
    public void onTick(TickUpdateEvent event){
        if(!mc.thePlayer.isCollidedHorizontally && mc.thePlayer.moveForward > 0) {
            mc.thePlayer.setSprinting(true);
        }
    }

    @BindKeyPress(Keyboard.KEY_F)
    public static void test(){
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Fuck!"));
    }
}
