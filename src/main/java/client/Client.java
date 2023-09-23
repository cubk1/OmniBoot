package client;

import client.module.movement.Sprint;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import org.union4dev.omni.Omni;
import org.union4dev.omni.elements.IClient;

public class Client implements IClient {
    @Override
    public void initiate() {

    }

    @Override
    public boolean nullCheck() {
        return Minecraft.getMinecraft().thePlayer == null || Minecraft.getMinecraft().theWorld == null;
    }

    @Override
    public void printMessage(String message) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(message));
    }
}
