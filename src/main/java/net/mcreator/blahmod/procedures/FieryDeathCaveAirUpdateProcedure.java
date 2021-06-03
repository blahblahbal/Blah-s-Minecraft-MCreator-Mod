package net.mcreator.blahmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.Blocks;

import net.mcreator.blahmod.block.SunstoneOreBlock;
import net.mcreator.blahmod.block.ScoriaWallBlock;
import net.mcreator.blahmod.block.ScoriaSlabBlock;
import net.mcreator.blahmod.block.ScoriaBlock;
import net.mcreator.blahmod.block.RedstoneOreScoriaBlock;
import net.mcreator.blahmod.block.LightlyCharredScoriaWallBlock;
import net.mcreator.blahmod.block.LightlyCharredScoriaSlabBlock;
import net.mcreator.blahmod.block.LightlyCharredScoriaBlock;
import net.mcreator.blahmod.block.IronOreScoriaBlock;
import net.mcreator.blahmod.block.GoldOreScoriaBlock;
import net.mcreator.blahmod.block.EmeraldOreScoriaBlock;
import net.mcreator.blahmod.block.DiamondOreScoriaBlock;
import net.mcreator.blahmod.block.CoalOreScoriaBlock;
import net.mcreator.blahmod.block.CharredScoriaWallBlock;
import net.mcreator.blahmod.block.CharredScoriaSlabBlock;
import net.mcreator.blahmod.block.CharredScoriaBlock;
import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;

@BlahmodModElements.ModElement.Tag
public class FieryDeathCaveAirUpdateProcedure extends BlahmodModElements.ModElement {
	public FieryDeathCaveAirUpdateProcedure(BlahmodModElements instance) {
		super(instance, 1637);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BlahmodMod.LOGGER.warn("Failed to load dependency x for procedure FieryDeathCaveAirUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BlahmodMod.LOGGER.warn("Failed to load dependency y for procedure FieryDeathCaveAirUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BlahmodMod.LOGGER.warn("Failed to load dependency z for procedure FieryDeathCaveAirUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BlahmodMod.LOGGER.warn("Failed to load dependency world for procedure FieryDeathCaveAirUpdate!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())) {
			if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK)) {
				if ((Math.random() < 0.01)) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.FIRE.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), CharredScoriaBlock.block.getDefaultState(), 3);
				}
				if ((Math.random() < 0.01)) {
					world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), Blocks.MAGMA_BLOCK.getDefaultState(), 3);
				}
				if ((!(((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))).getBlock() instanceof IWaterLoggable))) {
					if ((Math.random() < 0.01)) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ScoriaSlabBlock.block.getDefaultState(), 3);
					}
					if ((Math.random() < 0.01)) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CharredScoriaSlabBlock.block.getDefaultState(), 3);
					}
					if ((Math.random() < 0.01)) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), LightlyCharredScoriaSlabBlock.block.getDefaultState(), 3);
					}
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.COAL_ORE.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CoalOreScoriaBlock.block.getDefaultState(), 3);
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.IRON_ORE.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), IronOreScoriaBlock.block.getDefaultState(), 3);
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.GOLD_ORE.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), GoldOreScoriaBlock.block.getDefaultState(), 3);
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.EMERALD_ORE.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), EmeraldOreScoriaBlock.block.getDefaultState(), 3);
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.DIAMOND_ORE.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DiamondOreScoriaBlock.block.getDefaultState(), 3);
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.REDSTONE_ORE.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), RedstoneOreScoriaBlock.block.getDefaultState(), 3);
		}
		if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())
				|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.ANDESITE.getDefaultState().getBlock())
						|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.DIORITE.getDefaultState()
								.getBlock())))) {
			if ((Math.random() < 1)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ScoriaBlock.block.getDefaultState(), 3);
			}
			if ((Math.random() < 0.2)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CharredScoriaBlock.block.getDefaultState(), 3);
			}
			if ((Math.random() < 0.05)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.MAGMA_BLOCK.getDefaultState(), 3);
			}
			if ((Math.random() < 0.8)) {
				if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == CharredScoriaBlock.block.getDefaultState()
						.getBlock())
						|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == CharredScoriaBlock.block
								.getDefaultState().getBlock())
								|| (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == CharredScoriaBlock.block
										.getDefaultState().getBlock())
										|| (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)))
												.getBlock() == CharredScoriaBlock.block.getDefaultState().getBlock())
												|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))))
														.getBlock() == CharredScoriaBlock.block.getDefaultState().getBlock())
														|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))))
																.getBlock() == CharredScoriaBlock.block.getDefaultState().getBlock()))))))) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CharredScoriaBlock.block.getDefaultState(), 3);
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
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.LAVA.getDefaultState(), 3);
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CharredScoriaBlock.block.getDefaultState().getBlock())) {
			if ((Math.random() < 0.6)) {
				if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == ScoriaBlock.block.getDefaultState()
						.getBlock())
						|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == ScoriaBlock.block.getDefaultState()
								.getBlock())
								|| (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == ScoriaBlock.block
										.getDefaultState().getBlock())
										|| (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == ScoriaBlock.block
												.getDefaultState().getBlock())
												|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))))
														.getBlock() == ScoriaBlock.block.getDefaultState().getBlock())
														|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))))
																.getBlock() == ScoriaBlock.block.getDefaultState().getBlock()))))))) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), LightlyCharredScoriaBlock.block.getDefaultState(), 3);
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.DIRT.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CharredScoriaBlock.block.getDefaultState(), 3);
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())) {
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())) {
				if ((Math.random() < 0.01)) {
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), ScoriaBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ScoriaWallBlock.block.getDefaultState(), 3);
				}
				if ((Math.random() < 0.01)) {
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), LightlyCharredScoriaBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CharredScoriaWallBlock.block.getDefaultState(), 3);
				}
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())) {
				if ((Math.random() < 0.01)) {
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), LightlyCharredScoriaBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), LightlyCharredScoriaWallBlock.block.getDefaultState(), 3);
				}
				if ((Math.random() < 0.01)) {
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), LightlyCharredScoriaBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CharredScoriaWallBlock.block.getDefaultState(), 3);
				}
				if ((Math.random() < 0.01)) {
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), LightlyCharredScoriaBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ScoriaWallBlock.block.getDefaultState(), 3);
				}
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())) {
				if ((Math.random() < 0.01)) {
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), CharredScoriaBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CharredScoriaWallBlock.block.getDefaultState(), 3);
				}
				if ((Math.random() < 0.01)) {
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), CharredScoriaBlock.block.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), LightlyCharredScoriaWallBlock.block.getDefaultState(), 3);
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.ROCK)) {
			if ((Math.random() < 0.002)) {
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
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SunstoneOreBlock.block.getDefaultState(), 3);
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.GRAVEL.getDefaultState().getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.RED_SAND.getDefaultState(), 3);
		}
	}
}
