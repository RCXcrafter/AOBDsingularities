package com.rcx.aobdsingularities.config;

public class SingularitiesConfigs {

	private boolean isEnabled = true;
	private int amountNeeded = 400;

	public SingularitiesConfigs(String name) {

		if ("cobalt".equals(name) || "ardite".equals(name)) {
			//I need to come up with some defaults for common ores
			amountNeeded = 400;
		} else if ("endium".equals(name)) {
			amountNeeded = 400;
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
