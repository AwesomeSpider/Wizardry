package com.awsp8.wizardry.Tab;

import com.awsp8.wizardry.Wizardry;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlocksTab
				extends CreativeTabs{

	Block iconBlock;
	
	public BlocksTab(String name, Block icon) {
		super(name);
		iconBlock = icon;
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(iconBlock);
	}
	
	public static void addBlock(Block block) {
		block.setCreativeTab(Wizardry.blocksTab);
	}
}
