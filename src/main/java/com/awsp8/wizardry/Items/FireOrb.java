package com.awsp8.wizardry.Items;

import com.awsp8.wizardry.Wizardry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FireOrb
				extends Item{

	public FireOrb(int maxStackSize, int texture, String name) {
        setMaxStackSize(maxStackSize);
        setUnlocalizedName(name);
        setTextureName("wizardry:" + name);
	}
}
