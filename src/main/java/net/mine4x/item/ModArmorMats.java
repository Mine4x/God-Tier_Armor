package net.mine4x.item;

import net.mine4x.GodTierArmor;
import net.mine4x.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ModArmorMats {

    public static final int BASE_DURABILITY = 15;
    public static final RegistryKey<EquipmentAsset> GODLY_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(GodTierArmor.MOD_ID, "godly"));
    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 60,
                    EquipmentType.CHESTPLATE, 160,
                    EquipmentType.LEGGINGS, 120,
                    EquipmentType.BOOTS, 60
            ),
            1000,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            10.0F,
            10.0F,
            ModTags.Items.GODLY_METALS,
            GODLY_ARMOR_MATERIAL_KEY
    );



    public static void register() {
        GodTierArmor.LOGGER.info("Registering Armor Mats for: "+ GodTierArmor.MOD_ID);
    }
}
