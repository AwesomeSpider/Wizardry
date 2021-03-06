package com.awsp8.wizardry.Events;

import java.io.IOException;

import com.awsp8.wizardry.Info;
import com.awsp8.wizardry.Wizardry;
import com.awsp8.wizardry.registry.UpdateRegistry;

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
    	
    	if (Wizardry.checkForUpdates == true){
    		UpdateRegistry ur = new UpdateRegistry();
    		
    		String newVersion = null;
    		String featurePhrase = null;
			String changelogLink = null;
    		
			try {
				newVersion = ur.version();
				featurePhrase = ur.featurePhrase();
				changelogLink = ur.changelogLink();
			} catch (IOException e) {
				e.printStackTrace();
			}
    		
    		ChatComponentText CheckingMsg = new ChatComponentText(EnumChatFormatting.GREEN + "Checking for updates...");
    		ChatComponentText UpdateFoundMsg = new ChatComponentText(EnumChatFormatting.GREEN + "Update Found! Version [" + EnumChatFormatting.GOLD + newVersion + " - " + featurePhrase + EnumChatFormatting.GREEN + "] If your " + EnumChatFormatting.GREEN + "into Changelogs, click here to go to this version's Changelog.");
    		
    		event.player.addChatMessage(CheckingMsg);
    		
    		if (newVersion != Info.VERSION)
				event.player.addChatMessage(UpdateFoundMsg);
    	}
    }
}
