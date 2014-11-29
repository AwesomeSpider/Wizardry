package com.awsp8.wizardry.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class NatureOrb
				extends Item{

	public NatureOrb(int maxStackSize, int texture, String name) {
        setMaxStackSize(maxStackSize);
        setUnlocalizedName(name);
        setTextureName("wizardry:" + name);
	}
}