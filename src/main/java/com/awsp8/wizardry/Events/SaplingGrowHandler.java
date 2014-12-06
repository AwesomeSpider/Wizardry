package com.awsp8.wizardry.Events;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.player.BonemealEvent;

import com.awsp8.wizardry.Wizardry;
import com.awsp8.wizardry.Gen.MaztrixTreeGen;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SaplingGrowHandler {

	@SubscribeEvent
	public void onBoneMeal(BonemealEvent event){ //To add more plants just add an else if statement
												//to the end of most current if statement (use Copy and paste).
		if (event.world.getBlock(event.x, event.y, event.z) == Wizardry.blockMaztrixSapling){
			if (new Random().nextInt(5) == 1)
				generateTree("maztrix", event);
		}
	}
	
	/**
	 * Only use for use of boneMealing a sapling
	 * @param treeType
	 * @param event
	 */
	public void generateTree(String treeType, BonemealEvent event) {
			MaztrixTreeGen gen = new MaztrixTreeGen(false, 4, 0, 0, false);
			
			gen.generate(event.world, new Random(), event.x, event.y, event.z);
	}
}
