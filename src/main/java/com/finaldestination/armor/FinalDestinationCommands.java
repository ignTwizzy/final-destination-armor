package com.finaldestination.armor;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.core.component.DataComponents;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import java.util.UUID;

public class FinalDestinationCommands {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("fdhelmet")
            .requires(source -> source.hasPermission(2))
            .executes(context -> {
                var player = context.getSource().getPlayerOrException();
                ItemStack skull = new ItemStack(Items.PLAYER_HEAD);
                GameProfile profile = new GameProfile(UUID.randomUUID(), "FinalDestination");
                profile.getProperties().put("textures", new Property("textures", FinalDestinationHelmet.SKIN_VALUE));
                skull.set(DataComponents.PROFILE, new ResolvableProfile(profile));
                skull.set(DataComponents.CUSTOM_NAME,
                    Component.literal("Final Destination Helmet")
                        .withStyle(s -> s.withColor(0xAD00FF).withItalic(false).withBold(true)));
                player.getInventory().add(skull);
                context.getSource().sendSuccess(() -> Component.literal("Given Final Destination Helmet!"), false);
                return 1;
            })
        );
    }
}
