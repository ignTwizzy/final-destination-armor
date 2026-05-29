package com.finaldestination.armor;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;

public class FinalDestinationItems {

    public static final Holder<ArmorMaterial> MATERIAL = Holder.direct(FinalDestinationArmorMaterial.INSTANCE);

    public static final ColorShiftingArmorItem CHESTPLATE = new ColorShiftingArmorItem(
        MATERIAL, ArmorItem.Type.CHESTPLATE,
        new Item.Properties()
            .rarity(Rarity.EPIC)
            .fireResistant()
    );

    public static final ColorShiftingArmorItem LEGGINGS = new ColorShiftingArmorItem(
        MATERIAL, ArmorItem.Type.LEGGINGS,
        new Item.Properties()
            .rarity(Rarity.EPIC)
            .fireResistant()
    );

    public static final ColorShiftingArmorItem BOOTS = new ColorShiftingArmorItem(
        MATERIAL, ArmorItem.Type.BOOTS,
        new Item.Properties()
            .rarity(Rarity.EPIC)
            .fireResistant()
    );

    public static void registerItems() {
        Registry.register(BuiltInRegistries.ITEM, FinalDestinationArmor.id("fd_chestplate"), CHESTPLATE);
        Registry.register(BuiltInRegistries.ITEM, FinalDestinationArmor.id("fd_leggings"), LEGGINGS);
        Registry.register(BuiltInRegistries.ITEM, FinalDestinationArmor.id("fd_boots"), BOOTS);

        // Add to combat item group
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> {
            entries.accept(FinalDestinationHelmet.createHelmetStack());
            entries.accept(CHESTPLATE);
            entries.accept(LEGGINGS);
            entries.accept(BOOTS);
        });
    }
}
