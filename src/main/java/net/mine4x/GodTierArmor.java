package net.mine4x;

import net.fabricmc.api.ModInitializer;

import net.mine4x.block.ModBlocks;
import net.mine4x.item.ModItems;
import net.mine4x.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GodTierArmor implements ModInitializer {
	public static final String MOD_ID = "godtierarmor";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModEvents.register();
		ModBlocks.register();
		ModFlightHandler.register();
		ModWorldGeneration.generateModWorldGen();
	}
}