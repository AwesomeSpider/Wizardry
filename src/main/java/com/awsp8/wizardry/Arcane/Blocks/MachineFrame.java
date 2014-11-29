package com.awsp8.wizardry.Arcane.Blocks;

import com.awsp8.wizardry.Info;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class MachineFrame 
				extends Block{

	public MachineFrame(Material material) {
		super(material);
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
}
