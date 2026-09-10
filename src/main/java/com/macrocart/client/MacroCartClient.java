package com.macrocart.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import com.macrocart.MacroCartMod;

@Environment(EnvType.CLIENT)
public class MacroCartClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        MacroCartMod.LOGGER.info("MacroCart client initialized!");
        
        // Register client events
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // Client tick logic here
        });
    }
}
