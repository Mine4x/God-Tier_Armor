package net.mine4x.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRegistryDataGenerator extends FabricDynamicRegistryProvider {
    public ModRegistryDataGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup, Entries entries) {
        wrapperLookup.getOptional(RegistryKeys.CONFIGURED_FEATURE)
                .ifPresent(entries::addAll);

        wrapperLookup.getOptional(RegistryKeys.PLACED_FEATURE)
                .ifPresent(entries::addAll);
    }


    @Override
    public String getName() {
        return "Mine4x Registry Data Generator";
    }
}
