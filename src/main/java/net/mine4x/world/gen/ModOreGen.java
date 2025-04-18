package net.mine4x.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mine4x.world.ModPlaceFeatures;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGen {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlaceFeatures.ANGEL_ORE_PLACED_KEY);
    }
}
