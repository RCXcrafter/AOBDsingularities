package com.rcx.aobdsingularities;

import com.rcx.aobdsingularities.item.AOBDItemSingularity;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import fox.spiteful.avaritia.render.FancyHaloRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		FancyHaloRenderer haloAndGudbye = new FancyHaloRenderer();
		
		for (AOBDItemSingularity singularity : SingularityAddon.singularityItems) {
			MinecraftForgeClient.registerItemRenderer(singularity, haloAndGudbye);
		}

		super.postInit(event);
	}
}