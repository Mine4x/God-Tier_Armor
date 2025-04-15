package net.mine4x.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.mine4x.GodTierArmor;
import net.mine4x.block.ModBlocks;
import net.mine4x.item.ModArmorMats;
import net.mine4x.item.ModItems;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModModleProvider extends FabricModelProvider {
    public ModModleProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //blockStateModelGenerator.registerSimpleCubeAll(block);
        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANGEL_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //itemModelGenerator.register(ModItems.GODLY_HELMET, Models.GENERATED);
        //itemModelGenerator.register(ModItems.GODLY_CHESTPLATE, Models.GENERATED);
        //itemModelGenerator.register(ModItems.GODLY_LEGGINS, Models.GENERATED);
        //itemModelGenerator.register(ModItems.GODLY_SHOES, Models.GENERATED);

        itemModelGenerator.registerArmor(ModItems.GODLY_HELMET, RegistryKey.of(RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")), Identifier.of(GodTierArmor.MOD_ID, "godly.json")),
                "helmet", false);
        itemModelGenerator.registerArmor(ModItems.GODLY_CHESTPLATE, RegistryKey.of(RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")), Identifier.of(GodTierArmor.MOD_ID, "godly.json")),
                "chestplate", false);
        itemModelGenerator.registerArmor(ModItems.GODLY_LEGGINS, RegistryKey.of(RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")), Identifier.of(GodTierArmor.MOD_ID, "godly.json")),
                "leggings", false);
        itemModelGenerator.registerArmor(ModItems.GODLY_SHOES, RegistryKey.of(RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")), Identifier.of(GodTierArmor.MOD_ID, "godly.json")),
                "boots", false);

        //itemModelGenerator.register(ModBlocks.ANGEL_ORE.asItem(), Models.CUBE_ALL);

        //itemModelGenerator.registerArmor(((ArmorItem) ModItems.GODLY_SHOES), ModArmorMats.GODLY_ARMOR_MATERIAL_KEY, null ,false);
        //itemModelGenerator.registerArmor(((ArmorItem) ModItems.GODLY_LEGGINS), ModArmorMats.GODLY_ARMOR_MATERIAL_KEY, null ,false);
        //itemModelGenerator.registerArmor(((ArmorItem) ModItems.GODLY_CHESTPLATE), ModArmorMats.GODLY_ARMOR_MATERIAL_KEY, null ,false);
        //itemModelGenerator.registerArmor(((ArmorItem) ModItems.GODLY_HELMET), ModArmorMats.GODLY_ARMOR_MATERIAL_KEY, null ,false);
    }
}
