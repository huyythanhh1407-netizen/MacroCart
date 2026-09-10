package com.macrocart;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MacroCartMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("macrocart");

    @Override
    public void onInitialize() {
        LOGGER.info("MacroCart mod loaded!");
    }
}
