package com.finaldestination.armor;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FinalDestinationArmor implements ModInitializer {
    public static final String MOD_ID = "finaldestination";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        FinalDestinationItems.registerItems();
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
            FinalDestinationCommands.register(dispatcher));
        LOGGER.info("Final Destination Armor mod loaded!");
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
