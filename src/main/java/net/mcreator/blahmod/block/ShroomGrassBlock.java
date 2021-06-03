
package net.mcreator.blahmod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.blahmod.itemgroup.CreativeTabBlahBlocksItemGroup;
import net.mcreator.blahmod.BlahmodModElements;

@BlahmodModElements.ModElement.Tag
public class ShroomGrassBlock extends BlahmodModElements.ModElement {
	@ObjectHolder("blahmod:shroom_grass")
	public static final Block block = null;
	public ShroomGrassBlock(BlahmodModElements instance) {
		super(instance, 1674);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(CreativeTabBlahBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ORGANIC).sound(SoundType.WET_GRASS).hardnessAndResistance(0.5f, 1f).setLightLevel(s -> 7)
					.harvestLevel(0).harvestTool(ToolType.SHOVEL));
			setRegistryName("shroom_grass");
		}
	}
}
