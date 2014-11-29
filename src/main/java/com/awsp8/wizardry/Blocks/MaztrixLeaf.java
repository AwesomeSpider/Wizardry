package com.awsp8.wizardry.Blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import com.awsp8.wizardry.Info;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MaztrixLeaf
				extends BlockLeaves
					implements IShearable{

    int[] field_150128_a;
    @SideOnly(Side.CLIENT)
    protected int field_150127_b;
	
	public MaztrixLeaf() {
		super();
		setBlockName("leavesMaztrix");
		setBlockTextureName("wizardry:leavesMaztrix");
		setLightOpacity(1);
		setHardness(0.2F);
		setStepSound(Block.soundTypeGrass);
		setLightLevel(1);
		setTickRandomly(true);
	}

	@SideOnly(Side.CLIENT)
	public static IIcon mainIcon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon){
		mainIcon = icon.registerIcon(Info.NAME.toLowerCase() + ":leavesMaztrixGrey");
	}
	
	@Override
	public IIcon getIcon(int side, int metadata) {
		return mainIcon;
	}
	
	@Override
	public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return 153153255;
	}
	
    public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_)
    {
        byte b0 = 1;
        int i1 = b0 + 1;

        if (p_149749_1_.checkChunksExist(p_149749_2_ - i1, p_149749_3_ - i1, p_149749_4_ - i1, p_149749_2_ + i1, p_149749_3_ + i1, p_149749_4_ + i1))
        {
            for (int j1 = -b0; j1 <= b0; ++j1)
            {
                for (int k1 = -b0; k1 <= b0; ++k1)
                {
                    for (int l1 = -b0; l1 <= b0; ++l1)
                    {
                        Block block = p_149749_1_.getBlock(p_149749_2_ + j1, p_149749_3_ + k1, p_149749_4_ + l1);
                        if (block.isLeaves(p_149749_1_, p_149749_2_ + j1, p_149749_3_ + k1, p_149749_4_ + l1))
                        {
                            block.beginLeavesDecay(p_149749_1_, p_149749_2_ + j1, p_149749_3_ + k1, p_149749_4_ + l1);
                        }
                    }
                }
            }
        }
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
    {
        if (!p_149674_1_.isRemote)
        {
            int l = p_149674_1_.getBlockMetadata(p_149674_2_, p_149674_3_, p_149674_4_);

            if ((l & 8) != 0 && (l & 4) == 0)
            {
                byte b0 = 4;
                int i1 = b0 + 1;
                byte b1 = 32;
                int j1 = b1 * b1;
                int k1 = b1 / 2;

                if (this.field_150128_a == null)
                {
                    this.field_150128_a = new int[b1 * b1 * b1];
                }

                int l1;

                if (p_149674_1_.checkChunksExist(p_149674_2_ - i1, p_149674_3_ - i1, p_149674_4_ - i1, p_149674_2_ + i1, p_149674_3_ + i1, p_149674_4_ + i1))
                {
                    int i2;
                    int j2;

                    for (l1 = -b0; l1 <= b0; ++l1)
                    {
                        for (i2 = -b0; i2 <= b0; ++i2)
                        {
                            for (j2 = -b0; j2 <= b0; ++j2)
                            {
                                Block block = p_149674_1_.getBlock(p_149674_2_ + l1, p_149674_3_ + i2, p_149674_4_ + j2);

                                if (!block.canSustainLeaves(p_149674_1_, p_149674_2_ + l1, p_149674_3_ + i2, p_149674_4_ + j2))
                                {
                                    if (block.isLeaves(p_149674_1_, p_149674_2_ + l1, p_149674_3_ + i2, p_149674_4_ + j2))
                                    {
                                        this.field_150128_a[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -2;
                                    }
                                    else
                                    {
                                        this.field_150128_a[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -1;
                                    }
                                }
                                else
                                {
                                    this.field_150128_a[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = 0;
                                }
                            }
                        }
                    }

                    for (l1 = 1; l1 <= 4; ++l1)
                    {
                        for (i2 = -b0; i2 <= b0; ++i2)
                        {
                            for (j2 = -b0; j2 <= b0; ++j2)
                            {
                                for (int k2 = -b0; k2 <= b0; ++k2)
                                {
                                    if (this.field_150128_a[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1] == l1 - 1)
                                    {
                                        if (this.field_150128_a[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2)
                                        {
                                            this.field_150128_a[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
                                        }

                                        if (this.field_150128_a[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2)
                                        {
                                            this.field_150128_a[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
                                        }

                                        if (this.field_150128_a[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] == -2)
                                        {
                                            this.field_150128_a[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] = l1;
                                        }

                                        if (this.field_150128_a[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] == -2)
                                        {
                                            this.field_150128_a[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] = l1;
                                        }

                                        if (this.field_150128_a[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] == -2)
                                        {
                                            this.field_150128_a[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] = l1;
                                        }

                                        if (this.field_150128_a[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] == -2)
                                        {
                                            this.field_150128_a[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] = l1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                l1 = this.field_150128_a[k1 * j1 + k1 * b1 + k1];

                if (l1 >= 0)
                {
                    p_149674_1_.setBlockMetadataWithNotify(p_149674_2_, p_149674_3_, p_149674_4_, l & -9, 4);
                }
                else
                {
                    this.removeLeaves(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
                }
            }
        }
    }

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        if (world.canLightningStrikeAt(x, y + 1, z) && !World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && random.nextInt(15) == 1)
        {
            double d0 = (double)((float)x + random.nextFloat());
            double d1 = (double)y - 0.05D;
            double d2 = (double)((float)z + random.nextFloat());
            world.spawnParticle("dripWater", d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
        
        if (world.getBlock(x, y - 1, z) != Blocks.air)
        	world.spawnParticle("magicCrit", (double)x + 0.5f, (double)y + 0f, (double)z + 0.5f, 0.0D, 0.0D, 0.0D);
    }

    private void removeLeaves(World p_150126_1_, int p_150126_2_, int p_150126_3_, int p_150126_4_)
    {
        this.dropBlockAsItem(p_150126_1_, p_150126_2_, p_150126_3_, p_150126_4_, p_150126_1_.getBlockMetadata(p_150126_2_, p_150126_3_, p_150126_4_), 0);
        p_150126_1_.setBlockToAir(p_150126_2_, p_150126_3_, p_150126_4_);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random p_149745_1_)
    {
        return p_149745_1_.nextInt(20) == 0 ? 1 : 0;
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(Blocks.sapling);
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_)
    {
        if (!p_149690_1_.isRemote)
        {
            int j1 = this.func_150123_b(p_149690_5_);

            if (p_149690_7_ > 0)
            {
                j1 -= 2 << p_149690_7_;

                if (j1 < 10)
                {
                    j1 = 10;
                }
            }

            if (p_149690_1_.rand.nextInt(j1) == 0)
            {
                Item item = this.getItemDropped(p_149690_5_, p_149690_1_.rand, p_149690_7_);
                this.dropBlockAsItem(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, new ItemStack(item, 1, this.damageDropped(p_149690_5_)));
            }

            j1 = 200;

            if (p_149690_7_ > 0)
            {
                j1 -= 10 << p_149690_7_;

                if (j1 < 40)
                {
                    j1 = 40;
                }
            }

            this.func_150124_c(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, j1);
        }
    }

    protected void func_150124_c(World p_150124_1_, int p_150124_2_, int p_150124_3_, int p_150124_4_, int p_150124_5_, int p_150124_6_) {}

    protected int func_150123_b(int p_150123_1_)
    {
        return 20;
    }

    /**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    public void harvestBlock(World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_)
    {
        {
            super.harvestBlock(p_149636_1_, p_149636_2_, p_149636_3_, p_149636_4_, p_149636_5_, p_149636_6_);
        }
    }
    
    public String[] func_150125_e() {
		return null;
	}


    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z)
    {
        return true;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1));
        return ret;
    }

    @Override
    public void beginLeavesDecay(World world, int x, int y, int z)
    {

        int i2 = world.getBlockMetadata(x, y, z);

        if ((i2 & 8) == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, i2 | 8, 4);
        }
        world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) | 8, 4);
    }

    @Override
    public boolean isLeaves(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }
}
