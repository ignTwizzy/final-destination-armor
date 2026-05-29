package com.finaldestination.armor;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.ResolvableProfile;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import java.util.Optional;
import java.util.UUID;

public class FinalDestinationHelmet extends ArmorItem {

    // Base64 encoded skin value for the Ender Knight skin
    public static final String SKIN_VALUE = "eyJ0ZXh0dXJlcyI6IHsiU0tJTiI6IHsidXJsIjogImh0dHBzOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2Y2ZWFhMWZkOWQyZDQ5ZDA2YTg5NDc5OGQzYjE0NWQzYWU0ZGNjYTAzOGI3ZGE3MThjN2I4M2E2NmVmMjY0ZjAifX19";

    public FinalDestinationHelmet(Holder<ArmorMaterial> material, Properties properties) {
        super(material, Type.HELMET, properties);
    }

    // Returns a player skull ItemStack with the Ender Knight skin
    public static ItemStack createHelmetStack() {
        ItemStack skull = new ItemStack(Items.PLAYER_HEAD);
        GameProfile profile = new GameProfile(UUID.randomUUID(), "FinalDestination");
        profile.getProperties().put("textures", new Property("textures", SKIN_VALUE));
        skull.set(DataComponents.PROFILE, new ResolvableProfile(profile));
        // Custom name
        skull.set(DataComponents.CUSTOM_NAME,
            net.minecraft.network.chat.Component.literal("§5§lFinal Destination Helmet")
                .withStyle(s -> s.withItalic(false)));
        return skull;
    }
}
