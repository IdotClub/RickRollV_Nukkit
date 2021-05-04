package com.github.blackjack200;

import cn.nukkit.plugin.PluginBase;

import java.io.IOException;

public final class RickRoll extends PluginBase {
	@Override
	public void onEnable() {
		Impl.invoke();
	}
}
