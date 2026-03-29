package com.xraymod.client.mixin;

import com.xraymod.client.XRayMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.chunk.ChunkRendererRegion;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Set;

@Mixin(BlockState.class)
public class BlockStateMixin {

    private static final Set<String> VISIBLE_BLOCKS = Set.of(
            "minecraft:diamond_ore",
            "minecraft:deepslate_diamond_ore",
            "minecraft:iron_ore",
            "minecraft:deepslate_iron_ore",
            "minecraft:gold_ore",
            "minecraft:deepslate_gold_ore",
            "minecraft:emerald_ore",
            "minecraft:deepslate_emerald_ore",
            "minecraft:lapis_ore",
            "minecraft:deepslate_lapis_ore",
            "minecraft:redstone_ore",
            "minecraft:deepslate_redstone_ore",
            "minecraft:coal_ore",
            "minecraft:deepslate_coal_ore",
            "minecraft:copper_ore",
            "minecraft:deepslate_copper_ore",
            "minecraft:ancient_debris",
            "minecraft:nether_gold_ore",
            "minecraft:nether_quartz_ore",
            "minecraft:chest",
            "minecraft:trapped_chest",
            "minecraft:ender_chest",
            "minecraft:spawner",
            "minecraft:air",
            "minecraft:cave_air",
            "minecraft:void_air"
    );

    @Inject(method = "isOpaque", at = @At("HEAD"), cancellable = true)
    private void onIsOpaque(CallbackInfoReturnable<Boolean> cir) {
        if (!XRayMod.xrayEnabled) return;

        BlockState self = (BlockState) (Object) this;
        Block block = self.getBlock();
        Identifier id = Registries.BLOCK.getId(block);
        String blockId = id.toString();

        if (!VISIBLE_BLOCKS.contains(blockId)) {
            cir.setReturnValue(false);
        }
    }
}
