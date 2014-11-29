package com.awsp8.wizardry.Gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class Generate implements IWorldGenerator
{
    public void generate(Random random, int x, int z, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
        switch (world.provider.dimensionId){
        case -1:
            generateNether(world, random, x * 16, z * 16);
            break;
        case 0:
            generateSurface(world, random, x * 16, z * 16);
            break;
        case 1:
            generateEnd(world, random, x * 16, z * 16);
            break;
        }
    }
 
    private void generateEnd(World world, Random random, int x, int z){
        
    }
 
    private void generateSurface(World world, Random random, int x, int z){
        for(int i = 0; i < 15; i++){ // 15 is rarity
            int randPosX= x + random.nextInt(16);
            int randPosZ= z + random.nextInt(16);
            int randPosY= world.getHeightValue(randPosX, randPosZ);
            (new MaztrixTreeGen(false, 4, 0, 0, false)).generate(world, random, randPosX, randPosY, randPosZ);
        }
    }
 
    private void generateNether(World world, Random random, int x, int z){
        
    }
}
