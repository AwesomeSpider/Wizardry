package com.awsp8.wizardry.Entities;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class MutatedSpider 
				extends EntityMob{

	public MutatedSpider(World world) {
		super(world);
        this.experienceValue = 10;
            
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
        this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(4, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
        this.setSize(0.6F, 1.8F);
	}
	
	@Override
	public boolean isAIEnabled(){
		return true;
	}
	
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.46000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
    }
	
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }
    
    @Override
    public void onLivingUpdate(){
    	super.onLivingUpdate();
    }
    
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.spider.say";
    }
    
    /**
    * Returns the sound this mob makes when it is hurt.
    */
   protected String getHurtSound()
   {
       return "mob.spider.say";
   }

   /**
    * Returns the sound this mob makes on death.
    */
   protected String getDeathSound()
   {
       return "mob.spider.death";
   }
   
   protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
   {
       this.playSound("mob.spider.step", 0.15F, 1.0F);
   }
      
   protected Item getDropItem()
   {
       return Items.string;
   }

   /**
    * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
    * par2 - Level of Looting used to kill this mob.
    */
   protected void dropFewItems(boolean par1, int par2)
   {
       super.dropFewItems(par1, par2);

       if (par1 && (this.rand.nextInt(3) == 0 || this.rand.nextInt(1 + par2) > 0))
       {
           this.dropItem(Items.spider_eye, 1);
       }
   }

   /**
    * returns true if this entity is by a ladder, false otherwise
    */
   public boolean isOnLadder()
   {
       return this.isBesideClimbableBlock();
   }

   /**
    * Sets the Entity inside a web block.
    */
   public void setInWeb() {}

   /**
    * Get this Entity's EnumCreatureAttribute
    */
   public EnumCreatureAttribute getCreatureAttribute()
   {
       return EnumCreatureAttribute.ARTHROPOD;
   }

   public boolean isPotionApplicable(PotionEffect par1PotionEffect)
   {
       return par1PotionEffect.getPotionID() == Potion.poison.id ? false : super.isPotionApplicable(par1PotionEffect);
   }

   /**
    * Returns true if the WatchableObject (Byte) is 0x01 otherwise returns false. The WatchableObject is updated using
    * setBesideClimableBlock.
    */
   public boolean isBesideClimbableBlock()
   {
       return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
   }

   /**
    * Updates the WatchableObject (Byte) created in entityInit(), setting it to 0x01 if par1 is true or 0x00 if it is
    * false.
    */
   public void setBesideClimbableBlock(boolean par1)
   {
       byte b0 = this.dataWatcher.getWatchableObjectByte(16);

       if (par1)
       {
           b0 = (byte)(b0 | 1);
       }
       else
       {
           b0 &= -2;
       }

       this.dataWatcher.updateObject(16, Byte.valueOf(b0));
   }
}
