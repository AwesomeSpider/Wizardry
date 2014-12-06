package com.awsp8.wizardry.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.awsp8.wizardry.Arcane.Blocks.ArcaneSlot;
import com.awsp8.wizardry.Arcane.Blocks.ContainerArcaneHarnesser;
import com.awsp8.wizardry.Arcane.Blocks.TileEntityArcaneHarnesser;

public class ArcaneHarnesserGui 
				extends GuiContainer{
	
	private TileEntityArcaneHarnesser tileEntity;
	
	public ArcaneHarnesserGui(InventoryPlayer inv, TileEntityArcaneHarnesser tileEntity) {
		super(new ContainerArcaneHarnesser(inv, tileEntity));
		this.tileEntity = tileEntity;
	}

	public static final int GUI_ID = 20;

	private static final ResourceLocation guiTexture = new ResourceLocation("wizardry", "/textures/gui/arcaneHarnesserGui.png");
	
	private int ImageWidth = 176;
    private int ImageHeight = 166;
    
    @Override
    public void drawScreen(int x, int y, float par3){ 	
        int k = (this.width - this.ImageWidth) / 2;
        byte b0 = 2;
    	
        this.mc.getTextureManager().bindTexture(guiTexture);                                  
        
    	this.drawTexturedModalRect(k, b0, 0, 0, this.ImageWidth, this.ImageHeight);   
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {
		
	}
}
