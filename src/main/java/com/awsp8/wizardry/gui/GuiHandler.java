package com.awsp8.wizardry.gui;

import com.awsp8.wizardry.Arcane.Blocks.TileEntityArcaneHarnesser;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler
				implements IGuiHandler {

    @Override
    public Object getServerGuiElement ( int ID, EntityPlayer player, World world, int x, int y, int z ) {
            return null;
    }

    @Override
    public Object getClientGuiElement ( int ID, EntityPlayer player, World world, int x, int y, int z ) {
    	Object result = null;
    	
            if (ID == ArcaneHarnesserGui.GUI_ID){
            		TileEntity tileEntity = world.getTileEntity(x, y, z);
            	
                    result = new ArcaneHarnesserGui(player.inventory, (TileEntityArcaneHarnesser) tileEntity);
            }
            		return result;
    }
}
