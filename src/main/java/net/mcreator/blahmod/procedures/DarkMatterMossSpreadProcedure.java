package net.mcreator.blahmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.blahmod.block.DarkMatterStoneBlock;
import net.mcreator.blahmod.block.DarkMatterGrassBlock;
import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;

@BlahmodModElements.ModElement.Tag
public class DarkMatterMossSpreadProcedure extends BlahmodModElements.ModElement {
	public DarkMatterMossSpreadProcedure(BlahmodModElements instance) {
		super(instance, 1319);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BlahmodMod.LOGGER.warn("Failed to load dependency x for procedure DarkMatterMossSpread!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BlahmodMod.LOGGER.warn("Failed to load dependency y for procedure DarkMatterMossSpread!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BlahmodMod.LOGGER.warn("Failed to load dependency z for procedure DarkMatterMossSpread!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BlahmodMod.LOGGER.warn("Failed to load dependency world for procedure DarkMatterMossSpread!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Math.random() < 0.5)) {
			if (((world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z)))
					&& (((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == DarkMatterStoneBlock.block
							.getDefaultState().getBlock())
							|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == DarkMatterStoneBlock.block
									.getDefaultState().getBlock()))
							|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == DarkMatterStoneBlock.block
									.getDefaultState().getBlock())
									|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == DarkMatterStoneBlock.block
											.getDefaultState().getBlock())))
							|| (((((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getBlock() == DarkMatterStoneBlock.block
									.getDefaultState().getBlock())
									|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z)))
											.getBlock() == DarkMatterStoneBlock.block.getDefaultState().getBlock()))
									|| (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z)))
											.getBlock() == DarkMatterStoneBlock.block.getDefaultState().getBlock())
											|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z)))
													.getBlock() == DarkMatterStoneBlock.block.getDefaultState().getBlock())))
									|| ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1))))
											.getBlock() == DarkMatterStoneBlock.block.getDefaultState().getBlock())
											|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1))))
													.getBlock() == DarkMatterStoneBlock.block.getDefaultState().getBlock()))
											|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1))))
													.getBlock() == DarkMatterStoneBlock.block.getDefaultState().getBlock())
													|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1))))
															.getBlock() == DarkMatterStoneBlock.block.getDefaultState().getBlock()))))))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), DarkMatterGrassBlock.block.getDefaultState(), 3);
			}
		}
	}
}
