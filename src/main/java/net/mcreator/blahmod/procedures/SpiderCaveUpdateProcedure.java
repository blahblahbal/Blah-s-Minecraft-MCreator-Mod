package net.mcreator.blahmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.block.Blocks;

import net.mcreator.blahmod.block.WebstoneBlock;
import net.mcreator.blahmod.block.EggsacBlock;
import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;

@BlahmodModElements.ModElement.Tag
public class SpiderCaveUpdateProcedure extends BlahmodModElements.ModElement {
	public SpiderCaveUpdateProcedure(BlahmodModElements instance) {
		super(instance, 1651);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BlahmodMod.LOGGER.warn("Failed to load dependency x for procedure SpiderCaveUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BlahmodMod.LOGGER.warn("Failed to load dependency y for procedure SpiderCaveUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BlahmodMod.LOGGER.warn("Failed to load dependency z for procedure SpiderCaveUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BlahmodMod.LOGGER.warn("Failed to load dependency world for procedure SpiderCaveUpdate!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())) {
			if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())) {
				if ((Math.random() < 0.5)) {
					world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), WebstoneBlock.block.getDefaultState(), 3);
				}
				if ((Math.random() < 0.02)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("blahmod", "spiderspawner"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) x, (int) y, (int) z),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				}
				if ((Math.random() < 0.02)) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), EggsacBlock.block.getDefaultState(), 3);
				}
				if ((Math.random() < 0.01)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("blahmod", "spiderspawner"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) x, (int) y, (int) z),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				}
			}
			if ((Math.random() < 0.15)) {
				if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())
						|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.STONE.getDefaultState()
								.getBlock())
								|| (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.STONE.getDefaultState()
										.getBlock())
										|| (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.STONE
												.getDefaultState().getBlock())
												|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.STONE
														.getDefaultState().getBlock())
														|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))))
																.getBlock() == Blocks.STONE.getDefaultState().getBlock()))))))) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.COBWEB.getDefaultState(), 3);
				}
				if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.COBWEB.getDefaultState().getBlock())
						|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.COBWEB.getDefaultState()
								.getBlock())
								|| (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.COBWEB
										.getDefaultState().getBlock())
										|| (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.COBWEB
												.getDefaultState().getBlock())
												|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.COBWEB
														.getDefaultState().getBlock())
														|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))))
																.getBlock() == Blocks.COBWEB.getDefaultState().getBlock()))))))) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.COBWEB.getDefaultState(), 3);
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())) {
			if ((Math.random() < 0.5)) {
				world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), WebstoneBlock.block.getDefaultState(), 3);
			}
			if ((Math.random() < 0.02)) {
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
					if ((Math.random() < 0.2)) {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.DIAMOND_ORE.getDefaultState(), 3);
					} else {
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.GOLD_ORE.getDefaultState(), 3);
					}
				}
			}
		}
	}
}
