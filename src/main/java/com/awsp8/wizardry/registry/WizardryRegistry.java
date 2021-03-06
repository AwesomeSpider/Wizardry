package com.awsp8.wizardry.registry;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;

import com.awsp8.wizardry.Info;
import com.awsp8.wizardry.Wizardry;
import com.awsp8.wizardry.Entities.ArcanePowerMatrix;
import com.awsp8.wizardry.Entities.GreyMan;
import com.awsp8.wizardry.Entities.MutatedSpider;
import com.awsp8.wizardry.Entities.Wisp;
import com.awsp8.wizardry.Entities.WizardDragon;
import com.awsp8.wizardry.Events.PlayerLoginEventListener;
import com.awsp8.wizardry.Tab.BlocksTab;
import com.awsp8.wizardry.Tab.ItemsTab;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * The class where most of the things are registered. Created 
 * 10/29/2014 at 3:00PM to clean up some things in the 
 * main mod class.
 * @author Awesome_Spider
 *
 */
public class WizardryRegistry {
	
	int itemsRegistered;
	int blocksRegistered;
	
	int entitiesRegistered;
	
	int creativeTabsRegistered;
	
	int creativeTabItemsRegistered;
	int creativeTabBlocksRegistered;
	
	int craftingRecipesRegistered;
	int furnaceRecipesRegistered;
	
	public void start(){
		Wizardry.log.info("[Wizardry] Wow, Wizardry hasn't imploded yet. ;)");
		Wizardry.log.info("[Wizardry] WizardryRegistry? Wake up! It's your turn!");
		
		Wizardry.log.info("[WizardryRegistry] Huh?! Oh, Preparing to start registering...");
		/* Make sure that all the amounts are 0 */
		itemsRegistered 			= 0;
		blocksRegistered 			= 0;
		
		entitiesRegistered 			= 0;
		
		creativeTabsRegistered 		= 0;
		
		creativeTabItemsRegistered 	= 0;
		creativeTabBlocksRegistered = 0;
		
		craftingRecipesRegistered 	= 0;
		furnaceRecipesRegistered 	= 0;
		
		Wizardry.log.info("[WizardryRegistry] Registering Items...");
		registerItem(Wizardry.orbOfEssence);
		registerItem(Wizardry.orbOfEssenceFire);
		registerItem(Wizardry.orbOfEssenceWater);
		registerItem(Wizardry.orbOfEssenceNature);
		registerItem(Wizardry.orbOfEssenceLife);
		registerItem(Wizardry.orbOfEssenceMining);
		registerItem(Wizardry.orbOfEssenceRiches);
		registerItem(Wizardry.orbOfEssenceMagic);
		registerItem(Wizardry.condencedMagic);
        
		registerItem(Wizardry.wispyCrystal);
		registerItem(Wizardry.wispyAir);
		registerItem(Wizardry.eternalEmber);
        
		registerItem(Wizardry.emberRubyRough);
		registerItem(Wizardry.emberRubySmooth);
        
		registerItem(Wizardry.maztrixFruit);
		registerItem(Wizardry.maztrixSapling);
        
		registerItem(Wizardry.darkSilk);
        
		registerItem(Wizardry.castIronBlend);
		registerItem(Wizardry.castIron);
        
		registerItem(Wizardry.arcanicIronOre);
		registerItem(Wizardry.arcanicIron);
		
		Wizardry.log.info("[WizardryRegistry] Registering Blocks...");
		registerBlock(Wizardry.maztrixLeaf);
		registerBlock(Wizardry.maztrixLog);
		registerBlock(Wizardry.maztrixPlanks);
		registerBlock(Wizardry.blockMaztrixSapling);
		
		registerBlock(Wizardry.machineFrame);
		registerBlock(Wizardry.arcaneHarnesser);
		
		Wizardry.log.info("[WizardryRegistry] Registering Entities...");
		registerEntity(GreyMan.class, "greyMan", 660000, 050505);
        addSpawn(GreyMan.class, 25, 2, 6, new BiomeGenBase[] {});
        
    	registerEntity(Wisp.class, "wisp", 0255255, 00204);
        addSpawn(GreyMan.class, 25, 2, 6, new BiomeGenBase[] {});
        
    	registerEntity(MutatedSpider.class, "mutatedSpider", 000, 5010);
        addSpawn(GreyMan.class, 25, 2, 6, new BiomeGenBase[] {});
        
    	registerEntity(WizardDragon.class, "wizardDragon", 000, 50050);
        addSpawn(GreyMan.class, 25, 2, 6, new BiomeGenBase[] {});
        
        registerEntity(ArcanePowerMatrix.class, "powerMatrix", 000, 000);
        addSpawn(GreyMan.class, 25, 2, 6, new BiomeGenBase[] {});
        
		Wizardry.log.info("[WizardryRegistry] Registering Creative Tabs...");
		registerCreativeTab(Wizardry.itemsTab);
		
		Wizardry.log.info("[WizardryRegistry] Registering Creative Tab Items...");
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.orbOfEssence);
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.orbOfEssenceFire);
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.orbOfEssenceWater);
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.orbOfEssenceNature);
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.orbOfEssenceLife);
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.orbOfEssenceMining);
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.orbOfEssenceRiches);
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.orbOfEssenceMagic);
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.condencedMagic);
        
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.wispyCrystal);
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.wispyAir);
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.eternalEmber);
        
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.emberRubyRough);
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.emberRubySmooth);
        
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.maztrixFruit);
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.maztrixSapling);
        
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.darkSilk);
        
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.castIronBlend);
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.castIron);
        
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.arcanicIronOre);
		registerCreativeTabItem(Wizardry.itemsTab, Wizardry.arcanicIron);
		
		Wizardry.log.info("[WizardryRegistry] Registering Creative Tab Blocks...");
		registerCreativeTabBlock(Wizardry.blocksTab, Wizardry.maztrixLeaf);
		registerCreativeTabBlock(Wizardry.blocksTab, Wizardry.maztrixLog);
		registerCreativeTabBlock(Wizardry.blocksTab, Wizardry.maztrixPlanks);
		
		registerCreativeTabBlock(Wizardry.blocksTab, Wizardry.machineFrame);
		
		Wizardry.log.info("[WizardryRegistry] Registering Crafting Recipes...");
		registerCraftingRecipe(new ItemStack(Wizardry.orbOfEssence, 4), new Object[]{
    		" x ", 
    		"x x", 
    		" x ",
    		'x', Blocks.glass
    	});
		
		registerCraftingRecipe(new ItemStack(Wizardry.orbOfEssence, 8), new Object[]{
    		"xxx", 
    		"x x", 
    		"xxx",
    		'x', Blocks.glass
    	});
    	
		registerCraftingRecipe(new ItemStack(Wizardry.orbOfEssenceFire), new Object[]{
    		"xyz",
    		"owg",
    		"znx",
    		'x', Items.blaze_powder, 'y', Items.lava_bucket,
    		'z', Items.blaze_rod, 'o', Blocks.obsidian,
    		'w', Wizardry.orbOfEssence, 'g', Items.gunpowder,
    		'n', Blocks.netherrack
    	});
    	
		registerCraftingRecipe(new ItemStack(Wizardry.orbOfEssenceWater), new Object[]{
    		"fwi",
    		"bxb",
    		"itf",
    		'f', Items.fish, 'w', Items.water_bucket,
    		'i', Blocks.ice, 'b', Items.snowball,
    		'x', Wizardry.orbOfEssence, 't', Items.boat
    	});
    	
		registerCraftingRecipe(new ItemStack(Wizardry.orbOfEssenceNature), new Object[]{
    		"awv",
    		"mxd",
    		"lhc",
    		'a', Items.apple, 'w', Items.water_bucket,
    		'v', Blocks.vine, 'm', Items.melon,
    		'x', Wizardry.orbOfEssence, 'd', Blocks.dirt,
    		'l', Blocks.leaves, 'h', Items.wheat,
    		'c', Items.carrot
    	});
    	
		registerCraftingRecipe(new ItemStack(Wizardry.orbOfEssenceLife), new Object[]{
    		"wlf",
    		"bxp",
    		"sce",
    		'w', Blocks.wool, 'l', Items.leather,
    		'f', Items.feather, 'b', Items.beef,
    		'x', Wizardry.orbOfEssence, 'p', Items.porkchop,
    		's', Items.spider_eye, 'c', Items.chicken,
    		'e', Items.egg
    	});
    	
		registerCraftingRecipe(new ItemStack(Wizardry.orbOfEssenceMining, 2), new Object[]{
    		"cli",
    		"gxd",
    		"rst",
    		'c', Items.coal, 'l', Items.lava_bucket,
    		'i', Blocks.iron_ore, 'g', Blocks.gold_ore,
    		'x', Wizardry.orbOfEssence, 'd', Blocks.diamond_ore,
    		'r', Blocks.redstone_ore, 's', Blocks.cobblestone,
    		't', Blocks.torch
    	});
    	
		registerCraftingRecipe(new ItemStack(Wizardry.orbOfEssenceRiches), new Object[]{
    		"drg",
    		"ixi",
    		"gmd",
    		'd', Items.diamond, 'g', Items.gold_ingot,
    		'i', Items.iron_ingot, 'x', Wizardry.orbOfEssence,
    		'r', Items.redstone, 'm', Wizardry.orbOfEssenceMining
    	});
    	
		registerCraftingRecipe(new ItemStack(Wizardry.orbOfEssenceMagic), new Object[]{
    		"fwn",
    		"lrm",
    		"box",
    		'f', Wizardry.orbOfEssenceFire, 'w', Wizardry.orbOfEssenceWater,
    		'n', Wizardry.orbOfEssenceNature, 'l', Wizardry.orbOfEssenceLife,
    		'r', Wizardry.orbOfEssenceRiches, 'm', Wizardry.orbOfEssenceMining,
    		'b', Items.water_bucket, 'o', Wizardry.orbOfEssence,
    		'x', Items.lava_bucket
    	});
		
		registerCraftingRecipe(new ItemStack(Wizardry.machineFrame), new Object[]{
			" i ",
			"iwi",
			" i ",
			'w', Wizardry.maztrixLog, 'i', Wizardry.arcanicIron
		});
    	
		registerShapelessCraftingRecipe(new ItemStack(Wizardry.condencedMagic),
    										new ItemStack(Wizardry.orbOfEssenceMagic));
    	
    		//Fire
		registerCraftingRecipe(new ItemStack(Wizardry.emberRubyRough), new Object[]{
    		"wew",
    		"efe",
    		"wew",
    		'w', Wizardry.wispyCrystal, 'e', Wizardry.eternalEmber,
    		'f', Wizardry.orbOfEssenceFire
    	});
		
		/* Arcane */
			/* Iron */
		registerShapelessCraftingRecipe(new ItemStack(Wizardry.arcanicIronOre), 
				new ItemStack(Wizardry.condencedMagic), new ItemStack(Wizardry.castIron));

		registerShapelessCraftingRecipe(new ItemStack(Wizardry.arcanicIron, 2),
				new ItemStack(Wizardry.arcanicIron), new ItemStack(Items.iron_ingot));

		registerShapelessCraftingRecipe(new ItemStack(Wizardry.arcanicIron, 3),
				new ItemStack(Wizardry.arcanicIron), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot));

		registerShapelessCraftingRecipe(new ItemStack(Wizardry.arcanicIron, 4),
				new ItemStack(Wizardry.arcanicIron), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot));

		registerShapelessCraftingRecipe(new ItemStack(Wizardry.arcanicIron, 5),
				new ItemStack(Wizardry.arcanicIron), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot));

		registerShapelessCraftingRecipe(new ItemStack(Wizardry.arcanicIron, 6),
				new ItemStack(Wizardry.arcanicIron), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot));

		registerShapelessCraftingRecipe(new ItemStack(Wizardry.arcanicIron, 7),
				new ItemStack(Wizardry.arcanicIron), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot));

		registerShapelessCraftingRecipe(new ItemStack(Wizardry.arcanicIron, 8),
				new ItemStack(Wizardry.arcanicIron), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot));

		registerShapelessCraftingRecipe(new ItemStack(Wizardry.arcanicIron, 9),
				new ItemStack(Wizardry.arcanicIron), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot), new ItemStack(Items.iron_ingot),  new ItemStack(Items.iron_ingot));
		
		Wizardry.log.info("[WizardryRegistry] Registering Furnace/Smelting Recipes...");
		registerFurnaceRecipe(Item.getItemFromBlock(Blocks.glass), new ItemStack(Wizardry.orbOfEssence), 0.1f);
		
		registerFurnaceRecipe(Items.ender_pearl, new ItemStack(Wizardry.maztrixSapling), 0.1f);
		registerFurnaceRecipe(new ItemStack(Items.coal, 1, 1).getItem(), new ItemStack(Wizardry.maztrixLog), 0.1f);
    	
    		//Fire
		registerFurnaceRecipe(Wizardry.emberRubyRough, new ItemStack(Wizardry.emberRubySmooth), 2.0f);
    	
    		//Arcane
		registerFurnaceRecipe(Wizardry.castIronBlend, new ItemStack(Wizardry.castIron), 2.0f);
		
		Wizardry.log.info("[WizardryRegistry] Registering Events...");
        MinecraftForge.EVENT_BUS.register(new PlayerLoginEventListener());
        
        Wizardry.log.info("[WizardryRegistry] Registering Other Stuff...");
    	MinecraftForge.addGrassSeed(new ItemStack(Wizardry.itemClover), 10);
	}
	
	/**
	 * Takes the info in the parameter and passes it to the GameRegistry.
	 * @param item
	 */
	public void registerItem(Item item){
		GameRegistry.registerItem(item, item.getUnlocalizedName(), Info.MODID);
		itemsRegistered ++;
	}
	
	/**
	 * Takes the info in the parameter and passes it to the GameRegistry.
	 * @param item
	 */
	public void registerBlock(Block block){
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
		blocksRegistered ++;
	}
	
	/**
	 * Takes the info in the parameter and passes it to the EntityRegistry.
	 * @param entityClass
	 * @param entityName
	 * @param bkEggColor
	 * @param fgEggColor
	 */
	public void registerEntity(Class<? extends Entity> entityClass, String entityName, int bkEggColor, int fgEggColor) {
    	int id = EntityRegistry.findGlobalUniqueEntityId();
    	EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
    	EntityList.entityEggs.put(Integer.valueOf(id), new EntityList.EntityEggInfo(id, bkEggColor, fgEggColor));
    	entitiesRegistered ++;
    }


	public void addSpawn(Class<? extends EntityLiving> entityClass, int spawnProb, int min, int max, BiomeGenBase[] biomes) {
		if (spawnProb > 0) {
				EntityRegistry.addSpawn(entityClass, spawnProb, min, max, EnumCreatureType.creature, biomes);
		}
	}
	
	/**
	 * Takes the info in the parameter and registers the tab.
	 * @param tab
	 */
	public void registerCreativeTab(CreativeTabs tab){
		creativeTabsRegistered ++;
	}
	
	/**
	 * Takes the info in the parameter and passes it to the creativeTab.
	 * @param item
	 */
	public void registerCreativeTabItem(CreativeTabs tab, Item item){
		if (tab != null){
			ItemsTab.addItem(item);
			creativeTabItemsRegistered ++;
		}
	}
	
	/**
	 * Takes the info in the parameter and passes it to the creativeTab.
	 * @param block
	 */
	public void registerCreativeTabBlock(CreativeTabs tab, Block block){
		if (tab != null){
			BlocksTab.addBlock(block);
			creativeTabBlocksRegistered ++;
		}
	}
	
	/**
	 * Takes the info in the parameter and passes it to the GameRegistry.
	 * @param result
	 * @param recipe
	 */
	public void registerCraftingRecipe(ItemStack result, Object... recipe){
		GameRegistry.addRecipe(result, recipe);
		craftingRecipesRegistered ++;
	}
	
	/**
	 * Takes the info in the parameter and passes it to the GameRegistry.
	 * @param result
	 * @param recipe
	 */
	public void registerShapelessCraftingRecipe(ItemStack result, Object... recipe){
		GameRegistry.addShapelessRecipe(result, recipe);
		craftingRecipesRegistered ++;
	}
	
	/**
	 * Takes the info in the parameter and passes it to the GameRegistry.
	 * @param result
	 * @param recipe
	 * @param xp
	 */
	public void registerFurnaceRecipe(Item result, ItemStack recipe, float xp){
		GameRegistry.addSmelting(result, recipe, xp);
		furnaceRecipesRegistered ++;
	}
	
	public void finish(){
		Wizardry.log.info("[WizardryRegistry] Finished Registering! Here is a Bit of a Recap:");
		
		Wizardry.log.info("[WizardryRegistry] " + itemsRegistered + "Items Registed.");
		Wizardry.log.info("[WizardryRegistry] " + blocksRegistered + "Blocks Registed.");
		Wizardry.log.info("[WizardryRegistry] " + entitiesRegistered + "Entities Registed.");
		Wizardry.log.info("[WizardryRegistry] " + creativeTabsRegistered + "Creative Tabs Registed.");
		Wizardry.log.info("[WizardryRegistry] " + creativeTabItemsRegistered + "Creative Tab Items Registed.");
		Wizardry.log.info("[WizardryRegistry] " + creativeTabBlocksRegistered + "Creative Tab Blocks Registed.");
		Wizardry.log.info("[WizardryRegistry] " + craftingRecipesRegistered + "Crafting Recipes Registed.");
		Wizardry.log.info("[WizardryRegistry] " + furnaceRecipesRegistered + "Furnace/Smelting Recipes Registed.");
	}
}
