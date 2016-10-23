package com.rcx.aobdsingularities;

import com.rcx.aobdsingularities.item.AOBDItemSingularity;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.avaritia.render.FancyHaloRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		//CompatClient.earlyComprettify();
		super.preInit(event);
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		FancyHaloRenderer haloAndGodbye = new FancyHaloRenderer();
		
		for (AOBDItemSingularity singularity : SingularityAddon.singularityItems) {
			MinecraftForgeClient.registerItemRenderer(singularity, haloAndGodbye);
			System.out.println(singularity);
		}

		super.postInit(event);
	}
}