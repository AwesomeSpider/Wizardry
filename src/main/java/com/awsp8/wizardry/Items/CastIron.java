package com.awsp8.wizardry.Items;

import java.util.List;

import com.awsp8.wizardry.Wizardry;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class CastIron 
				extends Item{
	
	public CastIron(int maxStackSize, int texture, String name) {
        setMaxStackSize(maxStackSize);
        setUnlocalizedName(name);
        setTextureName("wizardry:" + name);
	}
	
	/**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    	if (par1ItemStack.stackTagCompound != null) {
            String description = par1ItemStack.stackTagCompound.getString("description");
            par3List.add(EnumChatFormatting.AQUA + description);
    	}
    }
	
    @Override
	public void onCreated(ItemStack item, World world, EntityPlayer player){
		item.stackTagCompound = new NBTTagCompound();
		item.stackTagCompound.setString("description", "Not the strongest metal...");
	}
}
