package com.awsp8.wizardry.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RichesOrb
				extends Item{

	public RichesOrb(int maxStackSize, int texture, String name) {
        setMaxStackSize(maxStackSize);
        setUnlocalizedName(name);
        setTextureName("wizardry:" + name);
	}
}