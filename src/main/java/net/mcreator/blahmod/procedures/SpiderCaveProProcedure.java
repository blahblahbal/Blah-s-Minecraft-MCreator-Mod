package net.mcreator.blahmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;
import java.util.HashMap;

@BlahmodModElements.ModElement.Tag
public class SpiderCaveProProcedure extends BlahmodModElements.ModElement {
	public SpiderCaveProProcedure(BlahmodModElements instance) {
		super(instance, 1652);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BlahmodMod.LOGGER.warn("Failed to load dependency x for procedure SpiderCavePro!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BlahmodMod.LOGGER.warn("Failed to load dependency y for procedure SpiderCavePro!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BlahmodMod.LOGGER.warn("Failed to load dependency z for procedure SpiderCavePro!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BlahmodMod.LOGGER.warn("Failed to load dependency world for procedure SpiderCavePro!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double zs = 0;
		double ys = 0;
		double xs = 0;
		if ((y <= 30)) {
			zs = (double) (-32);
			for (int index0 = 0; index0 < (int) (64); index0++) {
				xs = (double) (-32);
				for (int index1 = 0; index1 < (int) (64); index1++) {
					ys = (double) (-8);
					for (int index2 = 0; index2 < (int) (16); index2++) {
						ys = (double) ((ys) + 1);
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("world", world);
							$_dependencies.put("x", (x + (xs)));
							$_dependencies.put("y", (y + (ys)));
							$_dependencies.put("z", (z + (zs)));
							SpiderCaveUpdateProcedure.executeProcedure($_dependencies);
						}
					}
					xs = (double) ((xs) + 1);
				}
				zs = (double) ((zs) + 1);
			}
		}
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.STONE.getDefaultState(), 3);
	}
}
