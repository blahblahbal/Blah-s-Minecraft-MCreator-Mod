package net.mcreator.blahmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.blahmod.block.NetherIceBlock;
import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;

@BlahmodModElements.ModElement.Tag
public class CoreSpikeRandomThingProcedure extends BlahmodModElements.ModElement {
	public CoreSpikeRandomThingProcedure(BlahmodModElements instance) {
		super(instance, 1728);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BlahmodMod.LOGGER.warn("Failed to load dependency x for procedure CoreSpikeRandomThing!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BlahmodMod.LOGGER.warn("Failed to load dependency y for procedure CoreSpikeRandomThing!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BlahmodMod.LOGGER.warn("Failed to load dependency z for procedure CoreSpikeRandomThing!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BlahmodMod.LOGGER.warn("Failed to load dependency world for procedure CoreSpikeRandomThing!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double rand = 0;
		rand = (double) Math.random();
		if (((rand) < 0.25)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), NetherIceBlock.block.getDefaultState(), 3);
		} else if (((rand) < 0.5)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.PACKED_ICE.getDefaultState(), 3);
		} else if (((rand) < 0.75)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.ICE.getDefaultState(), 3);
		} else {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.BLUE_ICE.getDefaultState(), 3);
		}
	}
}
