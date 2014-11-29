package com.awsp8.wizardry.Items;

import net.minecraft.item.Item;

public class DarkSilk
				extends Item{

	public DarkSilk(int maxStackSize, int texture, String name) {
        setMaxStackSize(maxStackSize);
        setUnlocalizedName(name);
        setTextureName("wizardry:" + name);
	}
}
