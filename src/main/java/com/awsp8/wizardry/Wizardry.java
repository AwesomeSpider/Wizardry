package com.awsp8.wizardry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

import org.apache.logging.log4j.Logger;

import com.awsp8.wizardry.Arcane.Blocks.ArcaneHarnesser;
import com.awsp8.wizardry.Arcane.Blocks.MachineFrame;
import com.awsp8.wizardry.Blocks.BlockMaztrixSapling;
import com.awsp8.wizardry.Blocks.MaztrixLeaf;
import com.awsp8.wizardry.Blocks.MaztrixLog;
import com.awsp8.wizardry.Blocks.MaztrixPlanks;
import com.awsp8.wizardry.Blocks.SparklingWater;
import com.awsp8.wizardry.Events.BucketHandler;
import com.awsp8.wizardry.Events.PlayerLoginEventListener;
import com.awsp8.wizardry.Gen.Generate;
import com.awsp8.wizardry.Items.ArcanicIronOre;
import com.awsp8.wizardry.Items.CastIron;
import com.awsp8.wizardry.Items.CastIronBlend;
import com.awsp8.wizardry.Items.CondencedMagic;
import com.awsp8.wizardry.Items.DarkSilk;
import com.awsp8.wizardry.Items.EmberRubyRough;
import com.awsp8.wizardry.Items.EmberRubySmooth;
import com.awsp8.wizardry.Items.EternalEmber;
import com.awsp8.wizardry.Items.FireOrb;
import com.awsp8.wizardry.Items.ItemClover;
import com.awsp8.wizardry.Items.LifeOrb;
import com.awsp8.wizardry.Items.MagicOrb;
import com.awsp8.wizardry.Items.MaztrixFruit;
import com.awsp8.wizardry.Items.MaztrixSapling;
import com.awsp8.wizardry.Items.MiningOrb;
import com.awsp8.wizardry.Items.NatureOrb;
import com.awsp8.wizardry.Items.OrbOfEssence;
import com.awsp8.wizardry.Items.RichesOrb;
import com.awsp8.wizardry.Items.WaterOrb;
import com.awsp8.wizardry.Items.WispyAir;
import com.awsp8.wizardry.Items.WispyCrystal;
import com.awsp8.wizardry.Tab.BlocksTab;
import com.awsp8.wizardry.Tab.ItemsTab;
import com.awsp8.wizardry.gui.GuiHandler;
import com.awsp8.wizardry.registry.WizardryRegistry;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Info.MODID, name = Info.NAME, version = Info.VERSION)
public class Wizardry{
	
    @Instance(value = Info.MODID)
    public static Wizardry instance;
    
    @SidedProxy(clientSide = Info.clientSide, serverSide = Info.serverSide)
    public static CommonProxy proxy;
    public static ClientProxy clientProxy = new ClientProxy();
    
    public static WizardryRegistry wizardryRegistry = new WizardryRegistry();
    
    	//Items
    public static Item orbOfEssence;
    public static Item orbOfEssenceFire;
    public static Item orbOfEssenceWater;
    public static Item orbOfEssenceNature;
    public static Item orbOfEssenceLife;
    public static Item orbOfEssenceMining;
    public static Item orbOfEssenceRiches;
    
    public static Item orbOfEssenceMagic;
    public static Item condencedMagic;
    
    public static Item itemClover;
    
    public static Item wispyCrystal;
    public static Item wispyAir;
    public static Item eternalEmber;
    
    public static Item emberRubyRough;
    public static Item emberRubySmooth;
    
    public static ItemFood maztrixFruit;
    public static Item maztrixSapling;
    
    public static Item darkSilk;
    
    public static Item castIronBlend;
    public static Item castIron;
    
    public static Item arcanicIronOre;
    public static Item arcanicIron;
    
    public static Item sparklingWaterBucket;
    
    	//Block
    public static BlockLeaves maztrixLeaf;
    public static Block maztrixLog;
    public static Block maztrixPlanks;
    public static BlockBush blockMaztrixSapling;
    
    	//Arcane Blocks
    public static Block machineFrame;
    public static Block arcaneHarnesser;
    
    	//Fluids
    public static Block sparklingWaterBlock;
    public static Fluid sparklingWater;
    
    //Creative Tabs
    public static CreativeTabs itemsTab;
    public static CreativeTabs blocksTab;
    
    Generate gen = new Generate();
    
    public static Logger log;
    
    public static Configuration config;
    
    public static boolean checkForUpdates = false;
    
    @EventHandler
    public void Preinit(FMLPreInitializationEvent event){
    	config = new Configuration(event.getSuggestedConfigurationFile());
    	
    	if (event.getSuggestedConfigurationFile().exists() == false)
    		config.save();
    	
    	FMLCommonHandler.instance().bus().register(new PlayerLoginEventListener());
    	
    	log = event.getModLog();
    	log.info("Initializing Items...");
    	orbOfEssence = new OrbOfEssence(16, 1, "orbEmpty");
    	orbOfEssenceFire = new FireOrb(16, 1, "orbFire");
    	orbOfEssenceWater = new WaterOrb(16, 1, "orbWater");
    	orbOfEssenceNature = new NatureOrb(16, 1, "orbNature");
    	orbOfEssenceLife = new LifeOrb(16, "orbLife");
    	orbOfEssenceMining = new MiningOrb(16, 1, "orbMining");
    	orbOfEssenceRiches = new RichesOrb(16, 1, "orbRiches");
    	orbOfEssenceMagic = new MagicOrb(1, 1, "orbMagic");
    	
    	condencedMagic = new CondencedMagic(1, 1, "magic");
    	
    	darkSilk = new DarkSilk(64, 1, "darkSilk");
    	
    	castIronBlend = new CastIronBlend(64, 1, "castIronBlend");
    	castIron = new CastIron(64, 1, "castIron");
    	
    	//Nature
    		//Items
    	itemClover = new ItemClover(64, CreativeTabs.tabMaterials, 1, "clover");
    	maztrixFruit = new MaztrixFruit(64, "fruitOfMaztrix", 8, 0.5f, false);
    	maztrixSapling = new MaztrixSapling(64, 1, "maztrixSapling");
    	
    	//Necromancy
    		//Items
    	wispyCrystal = new WispyCrystal(64, 1, "wispyCrystal");
    	wispyAir = new WispyAir(16, 1, "wispyAir");
    	eternalEmber = new EternalEmber(1, 1, "eternalEmber");
    	
    	//Fire
    		//Items
    	emberRubyRough = new EmberRubyRough(32, 1, "emberRuby1");
    	emberRubySmooth = new EmberRubySmooth(32, 1, "emberRuby2");
    	
    	//Arcane Items
    	arcanicIronOre = new ArcanicIronOre(64, 1, "arcanicIronOre");
    	arcanicIron = new ArcanicIronOre(64, 1, "arcanicIron");
    	
    	log.info("Initializing Blocks...");
    	maztrixLeaf = new MaztrixLeaf();
    	maztrixLog = new MaztrixLog(Material.wood)
			.setBlockName("logMaztrix")
				.setBlockTextureName("wizardry:logMaztrix")
						.setStepSound(Block.soundTypeWood)
							.setLightLevel(1);
    	maztrixPlanks = new MaztrixPlanks(Material.wood)
			.setBlockName("woodPlanksMaztrix")
				.setBlockTextureName("wizardry:woodPlanksMaztrix")
						.setStepSound(Block.soundTypeWood)
							.setLightLevel(1);
    	blockMaztrixSapling = new BlockMaztrixSapling();
    	
    	//Arcane Blocks
    	machineFrame = new MachineFrame(Material.rock)
    		.setBlockName("machineFrame")
    			.setBlockTextureName("wizardry:machineFrame")
    				.setStepSound(Block.soundTypeMetal)
    					.setLightLevel(0.5f);
    	
    	arcaneHarnesser = new ArcaneHarnesser(Material.rock)
		.setBlockName("arcaneHarnesser")
			.setBlockTextureName("wizardry:arcaneHarnesser")
				.setStepSound(Block.soundTypeMetal)
					.setLightLevel(0.5f)
						.setHardness(5f);
    	
    	log.info("Initalizing Creative Tabs...");
    	itemsTab = new ItemsTab("itemsTab", condencedMagic);
    	blocksTab = new BlocksTab("blocksTab", maztrixPlanks);
    	
    	log.info("Initializing (And Registering, Because of Errors) Fluids...");
    	sparklingWater = new Fluid("sparklingWater").setLuminosity(15)
    			.setDensity(1000).setTemperature(265).setViscosity(1000)
    				.setGaseous(false);
    	FluidRegistry.registerFluid(sparklingWater);
    	sparklingWaterBlock = new SparklingWater(sparklingWater, Material.water)
		.setBlockName("sparklingWaterBlock");
    	GameRegistry.registerBlock(sparklingWaterBlock, sparklingWaterBlock.getUnlocalizedName());
    	
    	sparklingWaterBucket = new SparklingWaterBucket(sparklingWaterBlock);
    	sparklingWaterBucket.setUnlocalizedName("sparklingWaterBucket").setTextureName(Info.MODID + ":sparklingWaterBucket").setContainerItem(Items.bucket);
    	GameRegistry.registerItem(sparklingWaterBucket, sparklingWaterBucket.getUnlocalizedName());
    	FluidContainerRegistry.registerFluidContainer(sparklingWater, new ItemStack(sparklingWaterBucket), new ItemStack(Items.bucket));
    	
    	BucketHandler.INSTANCE.buckets.put(sparklingWaterBlock, sparklingWaterBucket);
    	MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
    	
    	GameRegistry.registerWorldGenerator(gen, 0);
    	
    	config.load();
    }
    
    @EventHandler 
    public void init(FMLInitializationEvent event){
    	checkForUpdates = config.get(config.CATEGORY_GENERAL, "CheckForUpdates", true).getBoolean();
    	config.getCategory(config.CATEGORY_GENERAL).get("CheckForUpdates").comment = "Enables The Update Checker, Defaults To True.";
    	
    	checkForUpdates = config.get(config.CATEGORY_GENERAL, "allowMagicEditWorld", true).getBoolean();
    	config.getCategory(config.CATEGORY_GENERAL).get("allowMagicEditWorld").comment = "Enables The Ability of Condensed Magic To Edit The World, Defaults To True.";
    	
    	wizardryRegistry.start();
        
        clientProxy.registerRenderers();
        
    	NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
    }
    
    @EventHandler
    public void Postinit(FMLPostInitializationEvent event){
    	wizardryRegistry.finish();
    	
    	config.save();
    }
}