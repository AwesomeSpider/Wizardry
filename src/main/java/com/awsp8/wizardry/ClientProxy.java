package com.awsp8.wizardry;

import com.awsp8.wizardry.Entities.ArcanePowerMatrix;
import com.awsp8.wizardry.Entities.GreyMan;
import com.awsp8.wizardry.Entities.MutatedSpider;
import com.awsp8.wizardry.Entities.Wisp;
import com.awsp8.wizardry.Entities.WizardDragon;
import com.awsp8.wizardry.entity.model.ModelGreyMan;
import com.awsp8.wizardry.entity.model.ModelMutatedSpider;
import com.awsp8.wizardry.entity.model.ModelPowerMatrix;
import com.awsp8.wizardry.entity.model.ModelWisp;
import com.awsp8.wizardry.entity.model.ModelWizardDragon;
import com.awsp8.wizardry.entity.render.RenderGreyMan;
import com.awsp8.wizardry.entity.render.RenderMutatedSpider;
import com.awsp8.wizardry.entity.render.RenderPowerMatrix;
import com.awsp8.wizardry.entity.render.RenderWisp;
import com.awsp8.wizardry.entity.render.RenderWizardDragon;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy
				extends CommonProxy {

	@Override
    public void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(GreyMan.class, new RenderGreyMan(new ModelGreyMan(), 0.5F)); 
        RenderingRegistry.registerEntityRenderingHandler(Wisp.class, new RenderWisp(new ModelWisp(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(MutatedSpider.class, new RenderMutatedSpider(new ModelMutatedSpider(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(WizardDragon.class, new RenderWizardDragon(new ModelWizardDragon(0F), 10F));
        
        RenderingRegistry.registerEntityRenderingHandler(ArcanePowerMatrix.class, new RenderPowerMatrix(new ModelPowerMatrix(), 0F));
    }
}
