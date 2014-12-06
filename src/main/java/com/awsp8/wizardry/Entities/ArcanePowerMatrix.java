package com.awsp8.wizardry.Entities;

import com.awsp8.wizardry.Wizardry;

import sun.misc.SharedSecrets;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ArcanePowerMatrix 
				extends EntityLiving{

	
	
	public ArcanePowerMatrix(World world) {
		super(world);
	}
	
	@Override
	public void entityInit(){
		super.entityInit();
	}
	
	@Override
	public void onUpdate(){
		super.onUpdate();
		
		Wizardry.log.debug(this.worldObj.isRemote + ", " + this);
	}
	
	@Override
	public void applyEntityAttributes(){
        super.applyEntityAttributes();
    }
	
	@Override
	public boolean canDespawn(){
		return false;
	}
	
	@Override
	public boolean canBePushed(){
		return false;
	}
}
