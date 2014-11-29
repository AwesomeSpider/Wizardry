package com.awsp8.wizardry.Events;

import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;

import com.awsp8.wizardry.Wizardry;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class MagicRechargeHandler {

	@SubscribeEvent
	public void onWakeUp(PlayerWakeUpEvent event){
		if (event.entityPlayer.inventory.getCurrentItem().getItem() == Wizardry.condencedMagic){
			event.entityPlayer.inventory.getCurrentItem().stackTagCompound.setInteger("power",
					event.entityPlayer.inventory.getCurrentItem().stackTagCompound.getInteger("power") + 5);
		}
	}
	
	@SubscribeEvent
	public void onPickupXp(PlayerPickupXpEvent event){
		if (event.entityPlayer.inventory.getCurrentItem().getItem() == Wizardry.condencedMagic){
			event.entityPlayer.experience = event.entityPlayer.experience - event.orb.xpValue;
			event.entityPlayer.inventory.getCurrentItem().stackTagCompound.setInteger("power",
					event.entityPlayer.inventory.getCurrentItem().stackTagCompound.getInteger("power") + event.orb.xpValue);
		}
	}
}
