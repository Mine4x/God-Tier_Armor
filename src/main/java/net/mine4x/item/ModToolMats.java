package net.mine4x.item;

import net.mine4x.GodTierArmor;
import net.mine4x.util.ModTags;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.ItemTags;

public class ModToolMats {

    public static final ToolMaterial GODLY = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_GODLY_TOOL, 50000, 12.0f, 10.0f, 15, ModTags.Items.GODLY_METALS);
        //public static final ToolMaterial GODLY = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 50000, 12.0F, 10.0F, 15, ItemTags.WOODEN_TOOL_MATERIALS);

    public static void registerToolMats() {
        GodTierArmor.LOGGER.info("Registering mod mats for "+GodTierArmor.MOD_ID);
    }

}
