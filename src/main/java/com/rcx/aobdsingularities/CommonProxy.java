package com.rcx.aobdsingularities;

import com.rcx.aobdsingularities.config.ConfigHandler;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.INSTANCE.preInit(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(ConfigHandler.INSTANCE);
		AddonRegisterer.registerAddon();
	}

	public void init(FMLInitializationEvent event) {
		ConfigHandler.INSTANCE.init();
	}

	public void postInit(FMLPostInitializationEvent event) {

	}
}
