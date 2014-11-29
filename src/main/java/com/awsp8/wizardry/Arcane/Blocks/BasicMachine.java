package com.awsp8.wizardry.Arcane.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class BasicMachine
				extends Block{

	int maxPower = 0;
	int power = 0;
	
	int powerPerTick = 0;
	
	String powerType;
	
	public BasicMachine(Material material) {
		super(material);
		
		//set default values
		this.setPowerPerTick(50);
		this.setMaxPower(500);
		this.setPowerType("Aura");
	}

	public void setPowerPerTick(int power){
		this.powerPerTick = power;
	}
	
	public int getPowerPerTick(){
		return powerPerTick;
	}
	
	public void setMaxPower(int power){
		this.maxPower = power;
	}
	
	public int getMaxPower(){
		return maxPower;
	}
	
	public void setPower(int power){
		this.power = power;
	}
	
	public int getPower(){
		return power;
	}
	
	public void setPowerType(String type){
		this.powerType = type;
	}
	
	public String getPowerType(){
		return powerType;
	}
	
	public boolean updatePowerLevel(ItemStack block){
		boolean result;
		
		if (block.stackTagCompound != null){
			NBTTagCompound nbt = block.stackTagCompound;
			
			nbt.setInteger("powerLevel", power);
			
			block.stackTagCompound = nbt;
			
			result = true;
		} else {
			result = false;
		}
		
		return result;
	}
	
	public boolean updatePowerPerTick(ItemStack block){
		boolean result;
		
		if (block.stackTagCompound != null){
			NBTTagCompound nbt = block.stackTagCompound;
			
			nbt.setInteger("powerPerTick", powerPerTick);
			
			block.writeToNBT(nbt);
			
			result = true;
		} else {
			result = false;
		}
		
		return result;
	}
	
	/**
	 * Generates a new slot name using the parameters.
	 * @param slotNumber - The number of the slot.
	 * @return A slot name.
	 */
	public String assignSlotName(int slotNumber){
		return "slot " + slotNumber;
	}
	
	public void saveSlotToNBT(String slotName, ItemStack item, ItemStack machine){
		NBTTagCompound nbt = machine.stackTagCompound;
		
		nbt.setString(slotName, item.getUnlocalizedName());
		
		machine.stackTagCompound = nbt;
	}
	
	public Item readSlotItemFromNBT(String slotName, ItemStack machine){
		NBTTagCompound nbt = machine.stackTagCompound;
		
		String itemName = nbt.getString(slotName);
		
		return (Item) Item.itemRegistry.getObject(itemName);
	}
}
