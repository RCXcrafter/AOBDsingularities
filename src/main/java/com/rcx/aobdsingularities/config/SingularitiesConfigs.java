package com.rcx.aobdsingularities.config;

public class SingularitiesConfigs {

	private boolean isEnabled = true;
	private int amountNeeded = 400;

	public SingularitiesConfigs(String name) {

		if ("atlarus".equals(name) || "adamantine".equals(name) || "sanguinite".equals(name) || "meutoite".equals(name) || "iridium".equals(name) || "plutonium".equals(name)) {
			amountNeeded = 50;
		} else if ("platinum".equals(name) || "orichalcum".equals(name) || "kalendrite".equals(name) || "vulcanite".equals(name) || "eximite".equals(name)) {
			amountNeeded = 100;
		} else if ("cobalt".equals(name) || "ardite".equals(name) || "mithril".equals(name) || "rubracium".equals(name) || "ceruclase".equals(name) || "alduorite".equals(name) || "osmium".equals(name) || "tungsten".equals(name) || "titanium".equals(name) || "uranium".equals(name)) {
			amountNeeded = 200;
		} else if ("endium".equals(name) || "manganese".equals(name) || "oureclase".equals(name) || "astralsilver".equals(name) || "carmot".equals(name) || "midasium".equals(name) || "vyroxeres".equals(name) || "darkiron".equals(name)) {
			amountNeeded = 300;
		} else {
			amountNeeded = 400;
		}
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public int getAmountNeeded() {
		return amountNeeded;
	}

	public void setAmountNeeded(int amountNeeded) {
		this.amountNeeded = amountNeeded;
	}
}
