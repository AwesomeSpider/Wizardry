package com.awsp8.wizardry.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArcaneBookGui 
				extends GuiScreen {
    public static final int GUI_ID = 20;
    
    private static final ResourceLocation bookGuiTextures = new ResourceLocation("wizardry", "/textures/gui/book.png");
    
    private int bookImageWidth = 192;
    private int bookImageHeight = 192;
    
    public ArcaneBookGui() {
    	
    }
    
    @Override
    public void drawScreen(int x, int y, float par3){
    	this.mc.getTextureManager().bindTexture(bookGuiTextures);
        int k = (this.width - this.bookImageWidth) / 2;
        byte b0 = 2;
    	
    	this.drawTexturedModalRect(k, b0, 0, 0, this.bookImageWidth, this.bookImageHeight);
    }
}
