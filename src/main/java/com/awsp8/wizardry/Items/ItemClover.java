package com.awsp8.wizardry.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemClover
				extends Item{

	public ItemClover(int maxStackSize, CreativeTabs tab, int texture, String name) {
        setMaxStackSize(maxStackSize);
        setCreativeTab(tab);
        setUnlocalizedName(name);
        setTextureName("wizardry:" + name);
	}
}
