package com.awsp8.wizardry.Entities;

import java.util.Random;

import com.awsp8.wizardry.Wizardry;

import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class Wisp
				extends EntityMob{

    private ChunkCoordinates spawnPosition;
    private static final String __OBFID = "CL_00001637";
	
	public Wisp(World world) {
		super(world);
		this.setSize(1f, 1f);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIFleeSun(this, 1.0D));
        this.tasks.addTask(2, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(3, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	}
	
	@Override
	public boolean isAIEnabled(){
		return true;
	}
	
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
    }
    
    @Override
    public void onLivingUpdate()
    {
 	   super.onLivingUpdate();
    }
	
    protected Item getDropItem(){
		return Wizardry.wispyCrystal;
	}
    
    protected void dropRareDrop(int par1)
    {
        switch (this.rand.nextInt(2))
        {
            case 0:
                this.dropItem(Wizardry.wispyAir, 1);
                break;
            case 1:
                this.dropItem(Wizardry.eternalEmber, 1);
        }
    }
}