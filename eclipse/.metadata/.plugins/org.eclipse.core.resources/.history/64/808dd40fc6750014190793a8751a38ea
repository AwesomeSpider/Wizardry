package com.awsp8.wizardry.Blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class BlockMaztrixSapling 
				extends BlockSapling {

	public BlockMaztrixSapling() {
		super();
		setBlockName("blockMaztrixSapling");
		setBlockTextureName("wizardry:maztrixSapling");
		setHardness(0.2F);
		setLightLevel(1);
		setTickRandomly(true);
	}
	
	/**
     * A randomly called display update to be able to add particles or other items for display
     */
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random){
        if (world.getBlock(x, y + 1, z) != Blocks.air)
        	world.spawnParticle("magicCrit", (double)x + 0.5f, (double)y + 1f, (double)z + 0.5f, 0.0D, 0.0D, 0.0D);
    }
}
