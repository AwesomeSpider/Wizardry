package com.awsp8.wizardry.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class EternalEmber
				extends Item{
	
	public EternalEmber(int maxStackSize, int texture, String name) {
        setMaxStackSize(maxStackSize);
        setUnlocalizedName(name);
        setTextureName("wizardry:" + name);
	}
}
