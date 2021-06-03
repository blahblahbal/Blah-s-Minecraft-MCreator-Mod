
package net.mcreator.blahmod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import java.util.Random;

import net.mcreator.blahmod.itemgroup.CreativeTabBlahBlocksItemGroup;
import net.mcreator.blahmod.BlahmodModElements;

import java.util.List;
import java.util.Collections;
import net.minecraft.block.IGrowable;

@BlahmodModElements.ModElement.Tag
public class BonesandBlock extends BlahmodModElements.ModElement {
	@ObjectHolder("blahmod:bonesand")
	public static final Block block = null;
	public BonesandBlock(BlahmodModElements instance) {
		super(instance, 1419);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(CreativeTabBlahBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends FallingBlock implements IGrowable {
		public CustomBlock() {
			super(Block.Properties.create(Material.SAND).sound(SoundType.SAND).hardnessAndResistance(0.8f, 0.8f).setLightLevel(s -> 0).harvestTool(ToolType.SHOVEL));
			setRegistryName("bonesand");
		}

		@Override
		public MaterialColor getMaterialColor() {
			return MaterialColor.SAND;
		}

		@Override
		public boolean canSustainPlant(BlockState state, IBlockReader blockReader, BlockPos pos, Direction direction, IPlantable iPlantable)
		{
			final BlockPos plantPos = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
			final PlantType plantType = iPlantable.getPlantType(blockReader, plantPos);
			if (plantType == PlantType.DESERT)
			{
				return true;
			}
			else if (plantType == PlantType.WATER)
			{
				return blockReader.getBlockState(pos).getMaterial() == Material.WATER && blockReader.getBlockState(pos) == getDefaultState();
			}
			else if (plantType == PlantType.BEACH)
			{
				return ((blockReader.getBlockState(pos.east()).getMaterial() == Material.WATER || blockReader.getBlockState(pos.east()).hasProperty(BlockStateProperties.WATERLOGGED))
						|| (blockReader.getBlockState(pos.west()).getMaterial() == Material.WATER || blockReader.getBlockState(pos.west()).hasProperty(BlockStateProperties.WATERLOGGED))
						|| (blockReader.getBlockState(pos.north()).getMaterial() == Material.WATER || blockReader.getBlockState(pos.north()).hasProperty(BlockStateProperties.WATERLOGGED))
						|| (blockReader.getBlockState(pos.south()).getMaterial() == Material.WATER || blockReader.getBlockState(pos.south()).hasProperty(BlockStateProperties.WATERLOGGED)));
			}
			else
			{
				return false;
			}
		}

		@Override
		public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state)
		{
			return;
		}
		
		@Override
		public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient)
		{
			return worldIn.getBlockState(pos.up()).isAir();
		}

		@Override
		public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state)
		{
			return false;
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
