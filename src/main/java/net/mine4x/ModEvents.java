package net.mine4x;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public class ModEvents {
    public static void register() {
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            ItemStack stack = player.getStackInHand(hand);
            Item item = stack.getItem();
            Identifier itemId = Registries.ITEM.getId(item);

            // Check if the item is your custom sword by ID
            if (!world.isClient && itemId != null && itemId.toString().equals("godtierarmor:angel_sword")) {
                if (entity instanceof LivingEntity target) {
                    // Set entity on fire
                    target.setOnFireFor(5);

                    // Summon lightning
                    if (world instanceof ServerWorld serverWorld) {
                        LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, serverWorld);
                        lightning.refreshPositionAfterTeleport(target.getX(), target.getY(), target.getZ());
                        serverWorld.spawnEntity(lightning);
                    }

                    // Apply knockback
                    Vec3d knockback = target.getPos().subtract(player.getPos()).normalize().multiply(2.0);
                    target.addVelocity(knockback.x, 0.5, knockback.z);
                    target.velocityModified = true;
                }
            }

            return ActionResult.PASS;
        });
    }
}
