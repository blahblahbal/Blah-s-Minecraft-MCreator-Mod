
package net.mcreator.blahmod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.blahmod.itemgroup.CreativeTabBlahBlocksItemGroup;
import net.mcreator.blahmod.BlahmodModElements;

import java.util.List;
import java.util.Collections;

@BlahmodModElements.ModElement.Tag
public class ZirconStairsBlock extends BlahmodModElements.ModElement {
	@ObjectHolder("blahmod:zircon_stairs")
	public static final Block block = null;
	public ZirconStairsBlock(BlahmodModElements instance) {
		super(instance, 411);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(CreativeTabBlahBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(() -> new Block(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(2f, 6f).setLightLevel(s -> 0)
					.harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool()).getDefaultState(),
					Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(2f, 6f).setLightLevel(s -> 0).harvestLevel(0)
							.harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("zircon_stairs");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}