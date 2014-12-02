package com.awsp8.wizardry.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class ArcaneHarnesserGui 
				extends GuiScreen{

	private static final ResourceLocation guiTexture = new ResourceLocation("wizardry", "/textures/gui/arcaneHarnesserGui.png");
	
	private int ImageWidth = 176;
    private int ImageHeight = 166;
    
    @Override
    public void drawScreen(int x, int y, float par3){
    	this.fontRendererObj.drawString("Arcane Harnesser", x, y, 0, false);
    	
    	this.mc.getTextureManager().bindTexture(guiTexture);
        int k = (this.width - this.ImageWidth) / 2;
        byte b0 = 2;
    	
    	this.drawTexturedModalRect(k, b0, 0, 0, this.ImageWidth, this.ImageHeight);
    }
}
