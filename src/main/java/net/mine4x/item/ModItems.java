package net.mine4x.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mine4x.GodTierArmor;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    public static final Item ANGEL_TEAR = registerItem("angel_tear", new Item(new Item.Settings().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GodTierArmor.MOD_ID,"angel_tear")))));
    public static final Item ANGEL_EYE = registerItem("angel_eye", new Item(new Item.Settings().rarity(Rarity.RARE).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GodTierArmor.MOD_ID,"angel_eye")))));
    public static final Item ANGEL_METAL = registerItem("angel_metal", new Item(new Item.Settings().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GodTierArmor.MOD_ID,"angel_metal")))));
    public static final Item GODLY_METAL = registerItem("godly_metal", new Item(new Item.Settings().rarity(Rarity.RARE).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GodTierArmor.MOD_ID,"godly_metal")))));
    public static final Item ANGEL_SWORD = registerItem("angel_sword", new SwordItem(ModToolMats.GODLY, 10f, -0.05f, new Item.Settings().rarity(Rarity.EPIC).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GodTierArmor.MOD_ID, "angel_sword")))));


    //Armor Items
    public static final Item GODLY_HELMET = registerItem("godly_helmet", new ArmorItem(ModArmorMats.INSTANCE, EquipmentType.HELMET,
            new Item.Settings().rarity(Rarity.EPIC).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GodTierArmor.MOD_ID, "godly_helmet")))));
    public static final Item GODLY_CHESTPLATE = registerItem("godly_chestplate", new ArmorItem(ModArmorMats.INSTANCE, EquipmentType.CHESTPLATE,
            new Item.Settings().rarity(Rarity.EPIC).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GodTierArmor.MOD_ID, "godly_chestplate")))));
    public static final Item GODLY_LEGGINS = registerItem("godly_leggins", new ArmorItem(ModArmorMats.INSTANCE, EquipmentType.LEGGINGS,
            new Item.Settings().rarity(Rarity.EPIC).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GodTierArmor.MOD_ID, "godly_leggins")))));
    public static final Item GODLY_SHOES = registerItem("godly_shoes", new ArmorItem(ModArmorMats.INSTANCE, EquipmentType.BOOTS,
            new Item.Settings().rarity(Rarity.EPIC).component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(GodTierArmor.MOD_ID, "godly_shoes")))));

    private  static Item registerItem(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(GodTierArmor.MOD_ID, id), item);
    }

    public static void  registerModItems() {
        GodTierArmor.LOGGER.info("Registering mod items for " + GodTierArmor.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ANGEL_TEAR);
            fabricItemGroupEntries.add(ANGEL_EYE);
            fabricItemGroupEntries.add(ANGEL_METAL);
            fabricItemGroupEntries.add(GODLY_METAL);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ANGEL_SWORD);
            fabricItemGroupEntries.add(GODLY_HELMET);
            fabricItemGroupEntries.add(GODLY_CHESTPLATE);
            fabricItemGroupEntries.add(GODLY_LEGGINS);
            fabricItemGroupEntries.add(GODLY_SHOES);
        });
    }

}