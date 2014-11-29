package com.awsp8.wizardry.Items;

import net.minecraft.item.Item;

public class CastIronBlend
				extends Item{

	public CastIronBlend(int maxStackSize, int texture, String name) {
        setMaxStackSize(maxStackSize);
        setUnlocalizedName(name);
        setTextureName("wizardry:" + name);
	}
}
