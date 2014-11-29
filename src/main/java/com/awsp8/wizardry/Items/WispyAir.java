package com.awsp8.wizardry.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class WispyAir
				extends Item{

	public WispyAir(int maxStackSize, int texture, String name) {
        setMaxStackSize(maxStackSize);
        setUnlocalizedName(name);
        setTextureName("wizardry:" + name);
	}
}
