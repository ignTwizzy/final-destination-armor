package com.finaldestination.armor;

import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Holder;

public class ColorShiftingArmorItem extends ArmorItem implements DyeableLeatherItem {

    private static final int[] COLORS = {
        0xFB87FF, 0xFB87FF, 0xFA87FF, 0xFA87FF, 0xF987FF, 0xF987FF,
        0xF887FF, 0xF887FF, 0xF787FF, 0xF787FF, 0xF687FF, 0xF687FF,
        0xF587FF, 0xF587FF, 0xF487FF, 0xF487FF, 0xF387FF, 0xF387FF,
        0xF287FF, 0xF287FF, 0xF187FF, 0xF187FF, 0xF087FF, 0xF087FF,
        0xEF87FF, 0xEF87FF, 0xEE87FF, 0xEE87FF, 0xED87FF, 0xED87FF
    };

    public ColorShiftingArmorItem(Holder<ArmorMaterial> material, ArmorType type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public int getColor(ItemStack stack) {
        int frame = (int) ((System.currentTimeMillis() / 100) % COLORS.length);
        return COLORS[frame];
    }

    @Override
    public boolean hasCustomColor(ItemStack stack) {
        return true;
    }
}
