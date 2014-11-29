package com.awsp8.wizardry.registry;

import com.awsp8.wizardry.Wizardry;

import cpw.mods.fml.common.Loader;

public class ModCompatabilityRegistry {

	int modsRegistered;
	
	public boolean tinkers;
	
	public void start(){
		Wizardry.log.info("[Wizardry ModCompatabilityRegistry] Searching for other mods...");
		
		if (Loader.isModLoaded("TConstruct")){
			Wizardry.log.info("[Wizardry ModCompatabilityRegistry] Establishing connection with 'Tinker's Construct'...");
			tinkers = true;
			modsRegistered ++;
		}
	}
}
