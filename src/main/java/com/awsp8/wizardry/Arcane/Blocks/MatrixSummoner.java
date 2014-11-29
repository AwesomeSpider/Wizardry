package com.awsp8.wizardry.Arcane.Blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class MatrixSummoner 
				extends BasicMachine{

	boolean hasMatrixItem = false;
	
	boolean activated = false;
	
	public MatrixSummoner(Material material) {
		super(material);
		setBlockName("matrixSummoner");
		setBlockTextureName("wizardry:matrixSummoner");
		setHardness(1F);
		setStepSound(Block.soundTypeMetal);
		setTickRandomly(true);
	}
	
	public void activate(){
		activated = true;
	}
	
	public void deactivate(){
		activated = false;
	}
	
	/**
     * A randomly called display update to be able to add particles or other items for display
     */
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
    	if (hasMatrixItem == false)
    		if (activated == false)
    			if (random.nextInt(4) == 1)
    				world.spawnParticle("crit", (double)x + 0.5f, (double)y, (double)z + 0.5f, 0.0D, 0.0D, 0.0D);
    	
    	if (hasMatrixItem == true)
    		if (activated == false)
    			if (random.nextInt(4) == 1)
    				world.spawnParticle("magicCrit", (double)x + 0.5f, (double)y, (double)z + 0.5f, 0.0D, 0.0D, 0.0D);
    }
}
