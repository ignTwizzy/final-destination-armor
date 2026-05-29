package com.finaldestination.armor;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.permissions.Permission;
import net.minecraft.server.permissions.PermissionLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ResolvableProfile;

import java.util.Optional;
import java.util.UUID;

public class FinalDestinationCommands {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("fdhelmet")
            .requires(source -> source.permissions().hasPermission(
                new Permission.HasCommandLevel(PermissionLevel.GAMEMASTERS)))
            .executes(context -> {
                var player = context.getSource().getPlayerOrException();
                ItemStack skull = new ItemStack(Items.PLAYER_HEAD);
                GameProfile profile = new GameProfile(UUID.randomUUID(), "FinalDestination");
                profile.getProperties().put("textures", new Property("textures", FinalDestinationHelmet.SKIN_VALUE));
                skull.set(DataComponents.PROFILE, new ResolvableProfile(Optional.of("FinalDestination"), Optional.of(UUID.randomUUID()), profile.getProperties()));
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
