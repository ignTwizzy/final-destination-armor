package com.finaldestination.armor;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

public class FinalDestinationItems {

    public static final Holder<ArmorMaterial> MATERIAL = Holder.direct(FinalDestinationArmorMaterial.INSTANCE);

    public static final ColorShiftingArmorItem CHESTPLATE = new ColorShiftingArmorItem(
        MATERIAL, ArmorType.CHESTPLATE,
        new Item.Properties().rarity(Rarity.EPIC).fireResistant()
    );

    public static final ColorShiftingArmorItem LEGGINGS = new ColorShiftingArmorItem(
        MATERIAL, ArmorType.LEGGINGS,
        new Item.Properties().rarity(Rarity.EPIC).fireResistant()
    );

    public static final ColorShiftingArmorItem BOOTS = new ColorShiftingArmorItem(
        MATERIAL, ArmorType.BOOTS,
        new Item.Properties().rarity(Rarity.EPIC).fireResistant()
    );

    public static void registerItems() {
        Registry.register(BuiltInRegistries.ITEM, FinalDestinationArmor.id("fd_chestplate"), CHESTPLATE);
        Registry.register(BuiltInRegistries.ITEM, FinalDestinationArmor.id("fd_leggings"), LEGGINGS);
        Registry.register(BuiltInRegistries.ITEM, FinalDestinationArmor.id("fd_boots"), BOOTS);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> {
            entries.accept(FinalDestinationHelmet.createHelmetStack());
            entries.accept(CHESTPLATE);
            entries.accept(LEGGINGS);
            entries.accept(BOOTS);
        });
    }
}
