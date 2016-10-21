package com.rcx.aobdsingularities;

import ganymedes01.aobd.api.AOBDAddonManager;

public class AddonRegisterer {

	public static void registerAddon() {
		AOBDAddonManager.registerAddon(new SingularityAddon());
	}
}