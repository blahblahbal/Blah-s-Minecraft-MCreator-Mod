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

import net.mcreator.blahmod.block.MoltenIceBlock;
import net.mcreator.blahmod.block.CoreNyliumBlock;
import net.mcreator.blahmod.block.CoreFungusBlock;
import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;
import java.util.HashMap;

@BlahmodModElements.ModElement.Tag
public class NetherCoreGroveAirUpdateProcedure extends BlahmodModElements.ModElement {
	public NetherCoreGroveAirUpdateProcedure(BlahmodModElements instance) {
		super(instance, 1716);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BlahmodMod.LOGGER.warn("Failed to load dependency x for procedure NetherCoreGroveAirUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BlahmodMod.LOGGER.warn("Failed to load dependency y for procedure NetherCoreGroveAirUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BlahmodMod.LOGGER.warn("Failed to load dependency z for procedure NetherCoreGroveAirUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BlahmodMod.LOGGER.warn("Failed to load dependency world for procedure NetherCoreGroveAirUpdate!");
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
		double aircount = 0;
		double rn1 = 0;
		double ypos = 0;
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == CoreNyliumBlock.block.getDefaultState().getBlock())) {
			if ((Math.random() < 0.015)) {
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("blahmod", "core_roots"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) x, (int) y, (int) z),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
			}
			if ((Math.random() < 0.002)) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CoreFungusBlock.block.getDefaultState(), 3);
			}
			if ((Math.random() < 0.00075)) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					CoreVineGroundVineThingProcedure.executeProcedure($_dependencies);
				}
			}
			sx = (double) (-4);
			found = (boolean) (false);
			for (int index0 = 0; index0 < (int) (7); index0++) {
				sy = (double) (-5);
				for (int index1 = 0; index1 < (int) (10); index1++) {
					sz = (double) (-4);
					for (int index2 = 0; index2 < (int) (7); index2++) {
						if (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))))).getBlock() == Blocks.AIR
								.getDefaultState().getBlock())) {
							aircount = (double) ((aircount) + 1);
						}
						sz = (double) ((sz) + 1);
					}
					sy = (double) ((sy) + 1);
				}
				sx = (double) ((sx) + 1);
			}
			if ((Math.random() < 0.00075)) {
				if (((aircount) > 100)) {
					rn1 = (double) Math.random();
					ypos = (double) (y - 1);
					while (((world.getBlockState(new BlockPos((int) x, (int) (ypos), (int) z))).getBlock() == Blocks.AIR.getDefaultState()
							.getBlock())) {
						ypos = (double) ((ypos) - 1);
						if (((world.getBlockState(new BlockPos((int) x, (int) (ypos), (int) z))).getBlock() == CoreNyliumBlock.block.getDefaultState()
								.getBlock())) {
							break;
						}
					}
					if ((!((world.getBlockState(new BlockPos((int) x, (int) (ypos), (int) z))).getBlock() == MoltenIceBlock.block.getDefaultState()
							.getBlock()))) {
						if (((rn1) < 0.25)) {
							if (world instanceof ServerWorld) {
								Template template = ((ServerWorld) world).getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("blahmod", "small_core_tree"));
								if (template != null) {
									template.func_237144_a_(
											(ServerWorld) world, new BlockPos((int) (x - 3), (int) y, (int) (z - 3)), new PlacementSettings()
													.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
											((World) world).rand);
								}
							}
						} else if (((rn1) < 0.5)) {
							if (world instanceof ServerWorld) {
								Template template = ((ServerWorld) world).getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("blahmod", "small_core_tree"));
								if (template != null) {
									template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 3), (int) y, (int) (z - 3)),
											new PlacementSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setChunk(null)
													.setIgnoreEntities(false),
											((World) world).rand);
								}
							}
						} else if (((rn1) < 0.75)) {
							if (world instanceof ServerWorld) {
								Template template = ((ServerWorld) world).getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("blahmod", "small_core_tree"));
								if (template != null) {
									template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 3), (int) y, (int) (z - 3)),
											new PlacementSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setChunk(null)
													.setIgnoreEntities(false),
											((World) world).rand);
								}
							}
						} else {
							if (world instanceof ServerWorld) {
								Template template = ((ServerWorld) world).getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("blahmod", "small_core_tree"));
								if (template != null) {
									template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 3), (int) y, (int) (z - 3)),
											new PlacementSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setChunk(null)
													.setIgnoreEntities(false),
											((World) world).rand);
								}
							}
						}
					}
				} else if (((aircount) > 200)) {
					rn1 = (double) Math.random();
					ypos = (double) (y - 1);
					while (((world.getBlockState(new BlockPos((int) x, (int) (ypos), (int) z))).getBlock() == Blocks.AIR.getDefaultState()
							.getBlock())) {
						ypos = (double) ((ypos) - 1);
						if (((world.getBlockState(new BlockPos((int) x, (int) (ypos), (int) z))).getBlock() == CoreNyliumBlock.block.getDefaultState()
								.getBlock())) {
							break;
						}
					}
					if ((!((world.getBlockState(new BlockPos((int) x, (int) (ypos), (int) z))).getBlock() == MoltenIceBlock.block.getDefaultState()
							.getBlock()))) {
						if (((rn1) < 0.25)) {
							if (world instanceof ServerWorld) {
								Template template = ((ServerWorld) world).getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("blahmod", "core_tree"));
								if (template != null) {
									template.func_237144_a_(
											(ServerWorld) world, new BlockPos((int) (x - 3), (int) y, (int) (z - 3)), new PlacementSettings()
													.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
											((World) world).rand);
								}
							}
						} else if (((rn1) < 0.5)) {
							if (world instanceof ServerWorld) {
								Template template = ((ServerWorld) world).getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("blahmod", "core_tree"));
								if (template != null) {
									template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 3), (int) y, (int) (z - 3)),
											new PlacementSettings().setRotation(Rotation.CLOCKWISE_90).setMirror(Mirror.NONE).setChunk(null)
													.setIgnoreEntities(false),
											((World) world).rand);
								}
							}
						} else if (((rn1) < 0.75)) {
							if (world instanceof ServerWorld) {
								Template template = ((ServerWorld) world).getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("blahmod", "core_tree"));
								if (template != null) {
									template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 3), (int) y, (int) (z - 3)),
											new PlacementSettings().setRotation(Rotation.CLOCKWISE_180).setMirror(Mirror.NONE).setChunk(null)
													.setIgnoreEntities(false),
											((World) world).rand);
								}
							}
						} else {
							if (world instanceof ServerWorld) {
								Template template = ((ServerWorld) world).getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("blahmod", "core_tree"));
								if (template != null) {
									template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 3), (int) y, (int) (z - 3)),
											new PlacementSettings().setRotation(Rotation.COUNTERCLOCKWISE_90).setMirror(Mirror.NONE).setChunk(null)
													.setIgnoreEntities(false),
											((World) world).rand);
								}
							}
						}
					}
				}
			}
		}
	}
}
