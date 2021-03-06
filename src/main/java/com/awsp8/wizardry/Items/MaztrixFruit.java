package com.awsp8.wizardry.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class MaztrixFruit
				extends ItemFood{

	public MaztrixFruit(int maxStackSIze, String name, int healAmt, float saturation, boolean wolfFood) {
		super(healAmt, saturation, wolfFood);
		setMaxStackSize(maxStackSize);
        setUnlocalizedName(name);
        setTextureName("wizardry:" + name);
	}
	
	@Override
	public void onFoodEaten(ItemStack item, World world, EntityPlayer player){
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 2400, 5));
	}
}
