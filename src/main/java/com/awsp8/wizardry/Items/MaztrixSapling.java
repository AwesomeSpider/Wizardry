package com.awsp8.wizardry.Items;

import com.awsp8.wizardry.Wizardry;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Can be planted on Dirt, Grass, or Mycelium
 * @author Awesome_Spider
 *
 */
public class MaztrixSapling 
				extends Item{

	public MaztrixSapling(int maxStackSize, int texture, String name) {
		setMaxStackSize(maxStackSize);
        setUnlocalizedName(name);
        setTextureName("wizardry:maztrixSapling");
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
		boolean result = false;
		
		if (world.getBlock(x, y, z) == Blocks.dirt){ //Check if the block is dirt
			player.inventory.consumeInventoryItem(item.getItem());
			world.setBlock(x, y + 1, z, Wizardry.blockMaztrixSapling);
			
			result = true;
		} else if (world.getBlock(x, y, z) == Blocks.grass){ //If it isn't, check if the block is grass
			player.inventory.consumeInventoryItem(item.getItem());
			world.setBlock(x, y + 1, z, Wizardry.blockMaztrixSapling);
			
			result = true;
		} else if (world.getBlock(x, y, z) == Blocks.mycelium){ //If it still isn't, check if the block is mycelium
			player.inventory.consumeInventoryItem(item.getItem());
			world.setBlock(x, y + 1, z, Wizardry.blockMaztrixSapling);
			
			result = true;
		}
		
		return result;
	}
}
