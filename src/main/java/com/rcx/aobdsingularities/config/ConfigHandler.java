package com.rcx.aobdsingularities.config;

import ganymedes01.aobd.ore.Ore;

import java.io.File;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import com.rcx.aobdsingularities.SingularityAddon;
import com.rcx.aobdsingularities.lib.Reference;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigHandler {

	public static ConfigHandler INSTANCE = new ConfigHandler();
	public Configuration configFile;
	public Set<String> usedCategories = new HashSet<String>();

	public void preInit(File file) {
		configFile = new Configuration(file, true);
	}

	public void init() {
		usedCategories.clear();
		//usedCategories.add("AOBDsingularities");
		for (Entry<Ore, SingularitiesConfigs> entry : SingularityAddon.singulMap.entrySet())
			init(entry.getKey().name(), entry.getValue());
	}

	public SingularitiesConfigs init(Ore ore) {
		SingularitiesConfigs config = new SingularitiesConfigs(ore.name().toLowerCase());
		init(ore.name(), config);

		return config;
	}

	public void init(String name, SingularitiesConfigs config) {
		config.setEnabled(getBoolean(name, "Enabled", true, true));
		config.setAmountNeeded(getInt(name, "Amount of blocks needed for a singularity", config.getAmountNeeded()));
		usedCategories.add(name);

		if (configFile.hasChanged())
			configFile.save();
	}


	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (Reference.MOD_ID.equals(eventArgs.modID)) {
			configFile.load();
			init();
		}
	}

	private boolean getBoolean(String category, String name, boolean requiresRestart, boolean def) {
		return configFile.get(category, name, def).setRequiresMcRestart(requiresRestart).getBoolean(def);
	}

	private int getInt(String category, String name, int def) {
		return configFile.get(category, name, def).getInt(def);
	}
}