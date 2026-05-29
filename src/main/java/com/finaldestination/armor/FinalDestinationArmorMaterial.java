package com.finaldestination.armor;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.equipment.ArmorMaterial.Layer;

import java.util.List;
import java.util.Map;

public class FinalDestinationArmorMaterial {
    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
        Map.of(
            ArmorType.BOOTS, 3,
            ArmorType.LEGGINGS, 6,
            ArmorType.CHESTPLATE, 8,
            ArmorType.HELMET, 3
        ),
        15,
        SoundEvents.ARMOR_EQUIP_NETHERITE,
        () -> Ingredient.of(net.minecraft.world.item.Items.ENDER_PEARL),
        List.of(new Layer(FinalDestinationArmor.id("final_destination"))),
        3.0f,
        0.1f
    );
}
