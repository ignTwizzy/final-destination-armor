package com.finaldestination.armor;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.core.Holder;

import java.util.List;
import java.util.Map;

public class FinalDestinationArmorMaterial {

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
        // Defense values per slot (boots, leggings, chestplate, helmet) - netherite is 3,6,8,3
        Map.of(
            ArmorItem.Type.BOOTS, 3,
            ArmorItem.Type.LEGGINGS, 6,
            ArmorItem.Type.CHESTPLATE, 8,
            ArmorItem.Type.HELMET, 3
        ),
        15, // enchantability (netherite is 15)
        SoundEvents.ARMOR_EQUIP_NETHERITE,
        () -> Ingredient.of(net.minecraft.world.item.Items.ENDER_PEARL),
        List.of(new ArmorMaterial.Layer(FinalDestinationArmor.id("final_destination"))),
        3.0f, // toughness (netherite is 3.0)
        0.1f  // knockback resistance (netherite is 0.1)
    );
}
