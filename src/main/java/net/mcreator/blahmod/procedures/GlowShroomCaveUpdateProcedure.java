package net.mcreator.blahmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.Blocks;

import net.mcreator.blahmod.block.ShroomTallGrassBlock;
import net.mcreator.blahmod.block.ShroomMudBlock;
import net.mcreator.blahmod.block.ShroomGrassBlock;
import net.mcreator.blahmod.block.MineralWaterBlock;
import net.mcreator.blahmod.block.GlowShroomBlock;
import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;

@BlahmodModElements.ModElement.Tag
public class GlowShroomCaveUpdateProcedure extends BlahmodModElements.ModElement {
	public GlowShroomCaveUpdateProcedure(BlahmodModElements instance) {
		super(instance, 1660);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BlahmodMod.LOGGER.warn("Failed to load dependency x for procedure GlowShroomCaveUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BlahmodMod.LOGGER.warn("Failed to load dependency y for procedure GlowShroomCaveUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BlahmodMod.LOGGER.warn("Failed to load dependency z for procedure GlowShroomCaveUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BlahmodMod.LOGGER.warn("Failed to load dependency world for procedure GlowShroomCaveUpdate!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean found = false;
		double x2 = 0;
		double y2 = 0;
		double z2 = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.WATER.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), MineralWaterBlock.block.getDefaultState(), 3);
			world.getPendingBlockTicks().scheduleTick(new BlockPos((int) x, (int) y, (int) z),
					world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock(), (int) 20);
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())) {
			if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())) {
				if ((Math.random() < 0.95)) {
					world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), ShroomGrassBlock.block.getDefaultState(), 3);
					world.getPendingBlockTicks().scheduleTick(new BlockPos((int) x, (int) (y - 1), (int) z),
							world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)).getBlock(), (int) 20);
					if ((Math.random() < 0.33)) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), GlowShroomBlock.block.getDefaultState(), 3);
					}
					if ((Math.random() < 0.33)) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ShroomTallGrassBlock.block.getDefaultState(), 3);
					}
				}
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK)) {
				if ((!(((world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z)))).getBlock() instanceof IWaterLoggable))) {
					if ((Math.random() < 0.02)) {
						if ((Math.random() < 0.75)) {
							world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), ShroomMudBlock.block.getDefaultState(), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), Blocks.DIRT.getDefaultState(), 3);
						}
					}
				}
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK)) {
				if ((!(((world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z)))).getBlock() instanceof IWaterLoggable))) {
					if ((Math.random() < 0.02)) {
						if ((Math.random() < 0.75)) {
							world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), ShroomMudBlock.block.getDefaultState(), 3);
						} else {
							world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), Blocks.DIRT.getDefaultState(), 3);
						}
					}
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())) {
			if ((Math.random() < 0.5)) {
				if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())
						|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
								.getBlock())
								|| (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR
										.getDefaultState().getBlock())
										|| (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR
												.getDefaultState().getBlock())
												|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))))
														.getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())
														|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))))
																.getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock()))))))) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ShroomMudBlock.block.getDefaultState(), 3);
					if ((Math.random() < 0.25)) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.DIRT.getDefaultState(), 3);
					}
				}
			}
			if ((Math.random() < 0.012)) {
				if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())
						|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
								.getBlock())
								|| (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR
										.getDefaultState().getBlock())
										|| (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR
												.getDefaultState().getBlock())
												|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))))
														.getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())
														|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))))
																.getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock()))))))) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), MineralWaterBlock.block.getDefaultState(), 3);
					world.getPendingBlockTicks().scheduleTick(new BlockPos((int) x, (int) (y - 1), (int) z),
							world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)).getBlock(), (int) 20);
				}
			}
		}
	}
}
