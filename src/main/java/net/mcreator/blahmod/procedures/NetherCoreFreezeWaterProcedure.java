package net.mcreator.blahmod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.blahmod.block.PermaIceBlock;
import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;
import net.mcreator.blahmod.block.MineralWaterBlock;

import java.util.Map;
import java.util.HashMap;

@BlahmodModElements.ModElement.Tag
public class NetherCoreFreezeWaterProcedure extends BlahmodModElements.ModElement {
	public NetherCoreFreezeWaterProcedure(BlahmodModElements instance) {
		super(instance, 1791);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BlahmodMod.LOGGER.warn("Failed to load dependency x for procedure NetherCoreFreezeWater!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BlahmodMod.LOGGER.warn("Failed to load dependency y for procedure NetherCoreFreezeWater!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BlahmodMod.LOGGER.warn("Failed to load dependency z for procedure NetherCoreFreezeWater!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BlahmodMod.LOGGER.warn("Failed to load dependency world for procedure NetherCoreFreezeWater!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
				new ResourceLocation("blahmod:nether_core"))))) {
			if ((/* @BlockState */(world.getFluidState(new BlockPos((int) x, (int) y, (int) z)).getBlockState()).getBlock() == Blocks.WATER
					.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))),
						PermaIceBlock.block.getDefaultState(), 3);
			}
			if ((/* @BlockState */(world.getFluidState(new BlockPos((int) x, (int) y, (int) z)).getBlockState()).getBlock() == MineralWaterBlock.block
					.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) (Math.floor(x)), (int) (Math.floor(y)), (int) (Math.floor(z))),
						PermaIceBlock.block.getDefaultState(), 3);
			}

		}
	}

	@SubscribeEvent
	@SuppressWarnings("unused")
	public void onBlockUpdate(BlockEvent.NeighborNotifyEvent event) {
		//Entity entity = event.getEntity();
		IWorld world = event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", event.getPos().getX());
		dependencies.put("y", event.getPos().getY());
		dependencies.put("z", event.getPos().getZ());
		//dependencies.put("px", entity.getPosX());
		//dependencies.put("py", entity.getPosY());
		//dependencies.put("pz", entity.getPosZ());
		dependencies.put("world", world);
		//dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
