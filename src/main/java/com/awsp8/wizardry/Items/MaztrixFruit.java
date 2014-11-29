package com.awsp8.wizardry.Items;

import net.minecraft.item.ItemFood;

public class MaztrixFruit
				extends ItemFood{

	public MaztrixFruit(int maxStackSIze, String name, int healAmt, float saturation, boolean wolfFood) {
		super(healAmt, saturation, wolfFood);
		setMaxStackSize(maxStackSize);
        setUnlocalizedName(name);
        setTextureName("wizardry:" + name);
        
        this.setPotionEffect(1, 60, 5, 100);
	}
}
