package com.awsp8.wizardry.Arcane.Blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import com.awsp8.wizardry.Info;
import com.awsp8.wizardry.Wizardry;
import com.awsp8.wizardry.Entities.ArcanePowerMatrix;
import com.awsp8.wizardry.gui.ArcaneHarnesserGui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * A block that will harvest power from nature! :)
 * @author Awesome_Spider
 *
 */
public class ArcaneHarnesser 
				extends BasicMachine{
	
	public ArcaneHarnesser(Material material) {
		super(material);
		
		setTickRandomly(true);
	}
	
	@SideOnly(Side.CLIENT)
	public static IIcon topIcon;

	@SideOnly(Side.CLIENT)
	public static IIcon sideIcon;
	
	@SideOnly(Side.CLIENT)
	public static IIcon bottomIcon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon){
		topIcon = icon.registerIcon(Info.NAME.toLowerCase() + ":machineFrameTop");
		sideIcon = icon.registerIcon(Info.NAME.toLowerCase() + ":machineFrameSide");
		bottomIcon = icon.registerIcon(Info.NAME.toLowerCase() + ":machineFrameTop");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata){
		if (side == 0){
			return bottomIcon;
		}else if (side == 1){
			return topIcon;
		}else {
			return sideIcon;
		}
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_){
		
		player.openGui(Wizardry.instance, ArcaneHarnesserGui.GUI_ID, world, x, y, z);
		
		return true;
	}
	
	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player){
		ItemStack block = new ItemStack(world.getBlock(x, y, z));
		
		if (block.stackTagCompound == null){
			block.stackTagCompound = new NBTTagCompound();
			
			block.stackTagCompound.setBoolean("collectingPower", false);
		}
		
		if (block.stackTagCompound.getBoolean("collectingPower") == true){
			block.stackTagCompound.setBoolean("collectingPower", false);
		} else {
			block.stackTagCompound.setBoolean("collectingPower", true);
		}
	}
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random){
		ItemStack block = new ItemStack(world.getBlock(x, y, z));
		
			if (world.canBlockSeeTheSky(x, y, z) == true)
				if (block.stackTagCompound.getBoolean("collectingPower") == true){
					world.spawnParticle("magicCrit", (double)x + 0.5f, (double)y + 1f, (double)z + 0.5f, 0.0D, 0.0D, 0.0D);
					
					collectPower(world, x, y, z, block);
				} else {
					world.spawnParticle("crit", (double)x + 0.5f, (double)y + 1f, (double)z + 0.5f, 0.0D, 0.0D, 0.0D);
				}
			
		world.spawnEntityInWorld(new ArcanePowerMatrix(world));
	}
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata){
		ItemStack block = new ItemStack(world.getBlock(x, y, z));
		
		NBTTagCompound nbt = block.stackTagCompound;
		
		if (nbt == null){
			nbt = new NBTTagCompound();
			
			nbt.setBoolean("collectingPower", false);
		}
		
		nbt.setInteger("coord x", x);
		nbt.setInteger("coord y", y);
		nbt.setInteger("coord z", z);
		
		block.stackTagCompound = nbt;
		
		return metadata;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int par1){
		return new TileEntityArcaneHarnesser();
	}
	
	public void collectPower(World world, int x, int y, int z, ItemStack block){
		NBTTagCompound nbt = block.stackTagCompound;
		
		Random random = new Random();
		
		if(world.getBiomeGenForCoords(x, z) == BiomeGenBase.plains){
			nbt.setInteger("powerLevel", nbt.getInteger("powerLevel") + 1);
		} else if(world.getBiomeGenForCoords(x, z) == BiomeGenBase.forest){
			nbt.setInteger("powerLevel", nbt.getInteger("powerLevel") + 5);
		} else if(world.getBiomeGenForCoords(x, z) == BiomeGenBase.birchForest){
			nbt.setInteger("powerLevel", nbt.getInteger("powerLevel") + 5);
		} else if(world.getBiomeGenForCoords(x, z) == BiomeGenBase.hell){
			nbt.setInteger("powerLevel", nbt.getInteger("powerLevel") - 1);
		} else if(world.getBiomeGenForCoords(x, z) == BiomeGenBase.jungle){
			nbt.setInteger("powerLevel", nbt.getInteger("powerLevel") + 5);
		} else if(world.getBiomeGenForCoords(x, z) == BiomeGenBase.savanna){
			nbt.setInteger("powerLevel", nbt.getInteger("powerLevel") + 1);
		} else if(world.getBiomeGenForCoords(x, z) == BiomeGenBase.roofedForest){
			nbt.setInteger("powerLevel", nbt.getInteger("powerLevel") + 5);
		} else if(world.getBiomeGenForCoords(x, z) == BiomeGenBase.swampland){
			nbt.setInteger("powerLevel", nbt.getInteger("powerLevel") + 5);
		} else {
			nbt.setInteger("powerLevel", nbt.getInteger("powerLevel") + 0);
		}
		
		if (world.getClosestPlayer(x, y, z, 16).posX >= 16)
			if (world.getClosestPlayer(x, y, z, 16).posZ >= 16)
				world.spawnParticle("magicCrit", world.getClosestPlayer(x, y, z, 16).posX, world.getClosestPlayer(x, y, z, 16).posY + 2.5f, world.getClosestPlayer(x, y, z, 16).posZ, 0.0D, 0.0D, 0.0D);
	}
}
