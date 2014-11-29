package com.awsp8.wizardry.Events;

import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class PlayerLoginEventListener {

    @SubscribeEvent
    public void loginEvent(PlayerLoggedInEvent event){
    	ChatComponentText TYmsg = new ChatComponentText(EnumChatFormatting.DARK_AQUA + "Thank you for downloading Wizardry!");
    	
    	event.player.addChatMessage(TYmsg);
    }
}
