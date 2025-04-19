package net.mine4x;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.world.World;

public class ModFlightHandler {

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(ModFlightHandler::onServerTick);
    }

    private static void onServerTick(MinecraftServer server) {
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            // === FULL ARMOR SET EFFECTS ===
            if (hasFullGodArmorSet(player) && isInOverworld(player)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 210, 2, true, false, true));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 210, 0, true, false, true));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 210, 0, true,false,true));
            } else if (hasFullGodArmorSet(player)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 210, 0, true, false, true));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 210, 0, true, false, true));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 210, 0, true, false, true));
            }
            if (shouldHaveFlight(player)) {
                if (!player.getAbilities().allowFlying) {
                    player.getAbilities().allowFlying = true;
                    player.sendAbilitiesUpdate();
                }
            } else {
                // Only disable flight if the player is not in creative or spectator
                if (!player.isCreative() && !player.isSpectator()) {
                    if (player.getAbilities().flying) {
                        player.getAbilities().flying = false;
                    }
                    if (player.getAbilities().allowFlying) {
                        player.getAbilities().allowFlying = false;
                        player.sendAbilitiesUpdate();
                    }
                }
            }
        }
    }

    private static boolean shouldHaveFlight(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0); // 0 = boots slot
        Identifier itemId = Registries.ITEM.getId(boots.getItem());
        return itemId != null && itemId.equals(Identifier.of("godtierarmor", "godly_shoes"));
    }

    private static boolean hasFullGodArmorSet(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chest = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return isArmorPiece(boots, "godly_shoes")
                && isArmorPiece(leggings, "godly_leggins")
                && isArmorPiece(chest, "godly_chestplate")
                && isArmorPiece(helmet, "godly_helmet");
    }

    public static boolean isInOverworld(PlayerEntity player) {
        RegistryKey<World> dimension = player.getWorld().getRegistryKey();

        if (dimension.equals(World.OVERWORLD)) {
            return true;
        }

        return false;
    }

    private static boolean isArmorPiece(ItemStack stack, String itemName) {
        Identifier itemId = Registries.ITEM.getId(stack.getItem());
        return itemId != null && itemId.equals(Identifier.of("godtierarmor", itemName));
    }

}
