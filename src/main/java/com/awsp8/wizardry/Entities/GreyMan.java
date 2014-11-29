package com.awsp8.wizardry.Entities;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class GreyMan
				extends EntityMob{
	
	public GreyMan(World par1World) {
		super(par1World);
        this.isImmuneToFire = true;
        this.experienceValue = 10;
        
        this.getNavigator().setBreakDoors(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
        this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(4, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.tasks.addTask(8, new EntityAIOpenDoor(this, true));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
        this.setSize(1.4F, 0.9F);
	}
	
	@Override
	public boolean isAIEnabled(){
		return true;
	}
	
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
    }
	
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.blaze.breathe";
    }
    
    /**
    * Returns the sound this mob makes when it is hurt.
    */
   protected String getHurtSound()
   {
       return "mob.blaze.hit";
   }

   /**
    * Returns the sound this mob makes on death.
    */
   protected String getDeathSound()
   {
       return "mob.blaze.death";
   }
   
   protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
   {
       this.playSound("mob.skeleton.step", 0.15F, 1.0F);
   }
   
   /**
    * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
    * use this to react to sunlight and start to burn.
    */
   public void onLivingUpdate()
   {
	   super.onLivingUpdate();
	   if (this.isWet()){
		   this.teleportRandomly();
	   }
	   
	   if (this.isInWeb){
		   this.teleportRandomly();
	   }
   }
   
   /**
    * Teleport the grey man to a random nearby position
    */
   protected boolean teleportRandomly()
   {
       double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * 64.0D;
       double d1 = this.posY + (double)(this.rand.nextInt(64) - 32);
       double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * 64.0D;
       return this.teleportTo(d0, d1, d2);
   }
   
   /**
    * Teleport the grey man
    */
   protected boolean teleportTo(double par1, double par3, double par5)
   {
       EnderTeleportEvent event = new EnderTeleportEvent(this, par1, par3, par5, 0);
       if (MinecraftForge.EVENT_BUS.post(event)){
           return false;
       }
       double d3 = this.posX;
       double d4 = this.posY;
       double d5 = this.posZ;
       this.posX = event.targetX;
       this.posY = event.targetY;
       this.posZ = event.targetZ;
       boolean flag = false;
       int i = MathHelper.floor_double(this.posX);
       int j = MathHelper.floor_double(this.posY);
       int k = MathHelper.floor_double(this.posZ);

       if (this.worldObj.blockExists(i, j, k))
       {
           boolean flag1 = false;

           while (!flag1 && j > 0)
           {
               Block block = this.worldObj.getBlock(i, j - 1, k);

               if (block.getMaterial().blocksMovement())
               {
                   flag1 = true;
               }
               else
               {
                   --this.posY;
                   --j;
               }
           }

           if (flag1)
           {
               this.setPosition(this.posX, this.posY, this.posZ);

               if (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox))
               {
                   flag = true;
               }
           }
       }

       if (!flag)
       {
           this.setPosition(d3, d4, d5);
           return false;
       }
       else
       {
           short short1 = 128;

           for (int l = 0; l < short1; ++l)
           {
               double d6 = (double)l / ((double)short1 - 1.0D);
               float f = (this.rand.nextFloat() - 0.5F) * 0.2F;
               float f1 = (this.rand.nextFloat() - 0.5F) * 0.2F;
               float f2 = (this.rand.nextFloat() - 0.5F) * 0.2F;
               double d7 = d3 + (this.posX - d3) * d6 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
               double d8 = d4 + (this.posY - d4) * d6 + this.rand.nextDouble() * (double)this.height;
               double d9 = d5 + (this.posZ - d5) * d6 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
               this.worldObj.spawnParticle("portal", d7, d8, d9, (double)f, (double)f1, (double)f2);
           }

           this.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0F, 1.0F);
           this.playSound("mob.endermen.portal", 1.0F, 1.0F);
           return true;
       }
   }
}
