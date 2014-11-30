package com.awsp8.wizardry.Items;

import java.util.List;

import com.awsp8.wizardry.Wizardry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class CondencedMagic
					extends Item{
	public static ItemStack condensedMagic;
	
	public CondencedMagic(int maxStackSize, int texture, String name) {
        setMaxStackSize(maxStackSize);
        setUnlocalizedName(name);
        setTextureName("wizardry:" + name);
        
        setMaxDamage(100);
	}
	
	/**
	 * Updates the info on the item given.
	 * @param ItemStack item
	 */
	public void update(ItemStack item, int damage){
		item.setItemDamage(damage);
		
			showDurabilityBar(item);
		
		condensedMagic = item;
	}
	
	/**
     * allows items to add custom lines of information to the mouseover description
     */
	@Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    	if (par1ItemStack.stackTagCompound != null) {
            String description = par1ItemStack.stackTagCompound.getString("description");
            par3List.add(EnumChatFormatting.AQUA + description);
            
            int power = par1ItemStack.stackTagCompound.getInteger("power");
            par3List.add(EnumChatFormatting.DARK_PURPLE + "Power: " + power);
    	}
    }
    
	@Override
	public void onCreated(ItemStack item, World world, EntityPlayer player){		
		player.inventory.addItemStackToInventory(new ItemStack(Wizardry.orbOfEssence));
		player.inventory.dropAllItems();
		
		item.stackTagCompound = new NBTTagCompound();
		item.stackTagCompound.setString("description", "Unstable, but shouldn't implode... yet.");
		item.stackTagCompound.setInteger("power", 20);
		
		this.setMaxDamage(20);
		
		condensedMagic = item;
	}
	
	@Override
	public boolean showDurabilityBar(ItemStack item){
		boolean result;
		
		if (item.getItemDamage() <= 19){
			result = true;
		} else {
			result = false;
		}
		
		return result;
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
		boolean result = false;
		
		if (stack.stackTagCompound.getInteger("power") != 0)
			if (world.getBlock(x, y, z) == Blocks.dirt){
				world.setBlock(x, y, z, Blocks.grass);
				stack.stackTagCompound.setInteger("power", stack.stackTagCompound.getInteger("power") - 1);
				update(stack, stack.stackTagCompound.getInteger("power"));
				result = true;
			} else if (world.getBlock(x, y, z) == Blocks.grass){
				world.setBlock(x, y, z, Blocks.mycelium);
				stack.stackTagCompound.setInteger("power", stack.stackTagCompound.getInteger("power") - 1);
				update(stack, stack.stackTagCompound.getInteger("power"));
				result = true;
			} else {
				result = false;
			}
		
		return result;
	}
}
