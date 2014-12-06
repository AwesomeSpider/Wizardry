package com.awsp8.wizardry.Arcane.Blocks;

import com.awsp8.wizardry.Wizardry;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ArcaneSlot
				extends Slot{

	public ArcaneSlot(IInventory inv, int par1, int par2, int par3) {
		super(inv, par1, par2, par3);
	}

	public boolean isItemValid(ItemStack stack){
        return stack.getItem() == Wizardry.condencedMagic;
    }
}
