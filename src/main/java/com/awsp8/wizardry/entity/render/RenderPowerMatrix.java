package com.awsp8.wizardry.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.awsp8.wizardry.Entities.GreyMan;
import com.awsp8.wizardry.entity.model.ModelGreyMan;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPowerMatrix
				extends RenderLiving{

	public RenderPowerMatrix(ModelBase modelBase, float shadowSize) {
		super(modelBase, shadowSize);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return new ResourceLocation("wizardry", "/textures/entities/PowerMatrix.png");
	}
}
