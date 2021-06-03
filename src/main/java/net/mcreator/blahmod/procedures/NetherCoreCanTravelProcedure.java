package net.mcreator.blahmod.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;

import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;

@BlahmodModElements.ModElement.Tag
public class NetherCoreCanTravelProcedure extends BlahmodModElements.ModElement {
	public NetherCoreCanTravelProcedure(BlahmodModElements instance) {
		super(instance, 953);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BlahmodMod.LOGGER.warn("Failed to load dependency world for procedure NetherCoreCanTravel!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (((World.THE_NETHER) != (world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD))) {
			System.out.println("You are not in the correct dimension.");
		}
	}
}
