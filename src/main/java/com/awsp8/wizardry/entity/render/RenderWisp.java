package com.awsp8.wizardry.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderWisp 
				extends RenderLiving{

	public RenderWisp(ModelBase modelBase, float par2) {
		super(modelBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return new ResourceLocation("wizardry", "/textures/entities/wisp.png");
	}
}
