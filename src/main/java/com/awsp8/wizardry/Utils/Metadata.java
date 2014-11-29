package com.awsp8.wizardry.Utils;

import com.awsp8.wizardry.Wizardry;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * @category Planned
 * @author Wyatt Andersen
 *
 */
public class Metadata {
	//Change If you get ArrayOutOfBounds
	//                               \/
	String[] ItemNames 	= new String[100];
	String[] BlockNames = new String[100];
	
	int ItemIndexes = 1;
	int BlockIndexes = 1;
	
	public Metadata(){}
	
	public int nextIndex(Item item){
		int result = 1;
		if (ItemIndexes >= 1){
			result = ItemIndexes;
			ItemIndexes = ItemIndexes + 1;
		}
		
		//NBTTagCompound tags = ItemUtils.getItemTag(new ItemStack(item));
		//tags.setInteger("MetaIndex", result);
		
		return result;
	}
	
	public int nextIndex(Block block){
		int result = 1;
		if (BlockIndexes >= 1){
			result = BlockIndexes;
			BlockIndexes = BlockIndexes + 1;
		}
		
		//NBTTagCompound tags = ItemUtils.getItemTag(new ItemStack(block));
		//tags.setInteger("MetaIndex", result);
		
		return result;
	}
	
	public void addItem(Item item, String name, int index){
		ItemNames[index] = name;
		
		//NBTTagCompound tags = ItemUtils.getItemTag(new ItemStack(item));
		//tags.setString("name", name);
	}
	
	public void addBlock(Block block, String name, int index){
		BlockNames[index] = name;
		
		//NBTTagCompound tags = ItemUtils.getItemTag(new ItemStack(block));
		//tags.setString("name", name);
	}
	
	public void close(){
		ItemIndexes = ItemIndexes - 1;
		BlockIndexes = BlockIndexes - 1;
		
		Wizardry.log.info("[Metadata Database] Added " + ItemIndexes + " items.");
		Wizardry.log.info("[Metadata Database] Added " + BlockIndexes + " blocks.");
		
		ItemIndexes = ItemIndexes + 1;
		BlockIndexes = BlockIndexes + 1;
	}
}
