package com.awsp8.wizardry.Blocks;

import com.awsp8.wizardry.Info;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MaztrixLog
				extends Block {

	public MaztrixLog(Material material) {
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
		topIcon = icon.registerIcon(Info.NAME.toLowerCase() + ":logMaztrixTop");
		sideIcon = icon.registerIcon(Info.NAME.toLowerCase() + ":logMaztrixSide");
		bottomIcon = icon.registerIcon(Info.NAME.toLowerCase() + ":logMaztrixTop");
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
