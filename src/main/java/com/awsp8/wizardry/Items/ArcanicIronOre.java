package com.awsp8.wizardry.Items;

import com.awsp8.wizardry.Wizardry;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ArcanicIronOre 
				extends Item{
	
	public ArcanicIronOre(int maxStackSize, int texture, String name) {
        setMaxStackSize(maxStackSize);
        setUnlocalizedName(name);
        setTextureName("wizardry:" + name);
	}
	
	@Override
	public void onCreated(ItemStack item, World world, EntityPlayer player){
		player.inventory.addItemStackToInventory(new ItemStack(Wizardry.condencedMagic));
	}
}

