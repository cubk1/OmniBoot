package client;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import org.union4dev.omni.elements.IClient;
import org.union4dev.omni.elements.IRender;

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

    @Override
    public IRender getRenderer() {
        return new RenderImpl();
    }
}
