package net.mine4x.util;

import net.mine4x.GodTierArmor;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> NEEDS_GODLY_TOOL = createTag("needs_godly_tool");
        public static final TagKey<Block> INCORRECT_FOR_GODLY_TOOL = createTag("incorrect_for_godly_tool");
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(GodTierArmor.MOD_ID, name));
        }
    }

    public static class Items{
        // example:
        public static final TagKey<Item> GODLY_METALS = createTag("godly_metals");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(GodTierArmor.MOD_ID, name));
        }
    }

}
