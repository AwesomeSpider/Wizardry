package com.awsp8.wizardry.Tab;

import com.awsp8.wizardry.Wizardry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemsTab
				extends CreativeTabs{

	Item iconItem;
	
	public ItemsTab(String name, Item icon) {
		super(name);
		iconItem = icon;
	}

	@Override
	public Item getTabIconItem() {
		return iconItem;
	}

	public static void addItem(Item item) {
		item.setCreativeTab(Wizardry.itemsTab);
	}
	
}
