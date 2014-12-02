package com.awsp8.wizardry.gui;

import net.minecraft.entity.player.EntityPlayer;
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
                    result = new ArcaneHarnesserGui();
            }
            		return result;
    }
}
