package com.rcx.aobdsingularities;

import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;

import com.rcx.aobdsingularities.config.ConfigHandler;
import com.rcx.aobdsingularities.lib.Reference;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER, dependencies = Reference.DEPENDENCIES, guiFactory = Reference.GUI_FACTORY_CLASS)
public class AOBDSingular {

	@Instance(Reference.MOD_ID)
	public static AOBDSingular instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigHandler.INSTANCE.preInit(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(ConfigHandler.INSTANCE);
		AddonRegisterer.registerAddon();

		MinecraftForge.EVENT_BUS.register(this);
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		ConfigHandler.INSTANCE.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

	}
}
