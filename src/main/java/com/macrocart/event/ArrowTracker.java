package com.macrocart.event;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Environment(EnvType.CLIENT)
public class ArrowTracker {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(ArrowTracker::onClientTick);
    }

    private static void onClientTick(MinecraftClient client) {
        if (client.world == null || client.player == null) {
            return;
        }

        World world = client.world;

        // Track all arrow entities
        world.getEntities().forEach(entity -> {
            if (entity instanceof ArrowEntity arrow) {
                trackArrow(arrow, world);
            }
        });
    }

    private static void trackArrow(ArrowEntity arrow, World world) {
        // Check if arrow has hit ground or block
        if (arrow.inGround || arrow.isInWall()) {
            BlockPos impactPos = arrow.getBlockPos();
            
            // Place minecart at arrow impact location
            placeCartAtPosition(impactPos, world);
            
            // Remove arrow after placing cart
            arrow.discard();
        }
    }

    private static void placeCartAtPosition(BlockPos pos, World world) {
        // Logic to place minecart at the position
        // This will be implemented with proper NBT and entity spawning
        if (client.player != null) {
            // Send packet to server or handle locally
            // For now, just log
            // System.out.println("Cart should be placed at: " + pos);
        }
    }
}
