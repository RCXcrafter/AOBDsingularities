package com.rcx.aobdsingularities;

import ganymedes01.aobd.api.IAOBDAddon;
import ganymedes01.aobd.items.AOBDItem;
import ganymedes01.aobd.ore.Ore;
import ganymedes01.aobd.ore.OreFinder;
import ganymedes01.aobd.recipes.RecipesModule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.rcx.aobdsingularities.config.ConfigHandler;
import com.rcx.aobdsingularities.config.SingularitiesConfigs;
import com.rcx.aobdsingularities.item.AOBDItemSingularity;
import com.rcx.aobdsingularities.lib.Reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import fox.spiteful.avaritia.crafting.CompressorManager;
import fox.spiteful.avaritia.crafting.CompressorRecipe;
import fox.spiteful.avaritia.crafting.Grinder;

public class SingularityAddon implements IAOBDAddon {
    
	public static Map<Ore, SingularitiesConfigs> singulMap = new HashMap<Ore, SingularitiesConfigs>();
	
	@Override
	public void receiveOreList(Collection<Ore> ores) {
		
		for (Ore ore : ores) {
			if (!ore.isEnabled())
				continue;
			
			String name = ore.name();
			if ("Iron".equals(name) ||
				"Gold".equals(name) ||
				"Copper".equals(name) ||
				"Tin".equals(name) ||
				"Lead".equals(name) ||
				"Silver".equals(name) ||
				"Nickel".equals(name))
					continue;
			if (Loader.isModLoaded("thermsingul"))
				if ("Mithril".equals(name) ||
					"Platinum".equals(name))
						continue;
			if (!OreDictionary.getOres("singularity" + name).isEmpty())
				continue;

			SingularitiesConfigs config = ConfigHandler.INSTANCE.init(ore);
			singulMap.put(ore, config);
			if (!config.isEnabled())
				continue;

			// Create the ore chunk item
			String base = "singularity";
			AOBDItemSingularity singularity = new AOBDItemSingularity(base, ore);
			singularity.setTextureName("avaritia:singularity");
			singularity.setUnlocalizedName(Reference.MOD_ID + "." + singularity + ore);
			OreFinder.registerOre(base + name, singularity);
			OreDictionary.registerOre(base + name, singularity);

			// Add compressing recipe
			CompressorManager.addOreRecipe(new ItemStack(singularity), config.getAmountNeeded(), "block" + ore);
			
			//add singularity to catalyst recipe
			Grinder.catalyst.getInput().add(new ItemStack(singularity));
		}
	}	
	public void notifyColourCreation() {}
}