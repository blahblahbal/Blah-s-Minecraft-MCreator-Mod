package net.mcreator.blahmod.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.Block;

import net.mcreator.blahmod.item.UraniumPickaxeItem;
import net.mcreator.blahmod.block.DarkMatterJellyOreBlock;
import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Random;
import java.util.Map;

@BlahmodModElements.ModElement.Tag
public class UraniumPickaxeVeinMineProcedure extends BlahmodModElements.ModElement {
	public UraniumPickaxeVeinMineProcedure(BlahmodModElements instance) {
		super(instance, 1768);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BlahmodMod.LOGGER.warn("Failed to load dependency entity for procedure UraniumPickaxeVeinMine!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BlahmodMod.LOGGER.warn("Failed to load dependency x for procedure UraniumPickaxeVeinMine!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BlahmodMod.LOGGER.warn("Failed to load dependency y for procedure UraniumPickaxeVeinMine!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BlahmodMod.LOGGER.warn("Failed to load dependency z for procedure UraniumPickaxeVeinMine!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BlahmodMod.LOGGER.warn("Failed to load dependency world for procedure UraniumPickaxeVeinMine!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((new ItemStack(UraniumPickaxeItem.block, (int) (1)).getItem()
				.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)))))) {
			if (((new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
					}
					return false;
				}
			}.checkGamemode(entity)) && (entity.isSneaking()))) {
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/coal").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-4);
					for (int index0 = 0; index0 < (int) (9); index0++) {
						sy = (double) (-4);
						for (int index1 = 0; index1 < (int) (9); index1++) {
							sz = (double) (-4);
							for (int index2 = 0; index2 < (int) (9); index2++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/coal").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									if ((Math.random() < 0.5)) {
										if (world instanceof World && !world.isRemote()) {
											((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 1));
										}
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/iron").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index3 = 0; index3 < (int) (7); index3++) {
						sy = (double) (-3);
						for (int index4 = 0; index4 < (int) (7); index4++) {
							sz = (double) (-3);
							for (int index5 = 0; index5 < (int) (7); index5++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/iron").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/gold").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index6 = 0; index6 < (int) (7); index6++) {
						sy = (double) (-3);
						for (int index7 = 0; index7 < (int) (7); index7++) {
							sz = (double) (-3);
							for (int index8 = 0; index8 < (int) (7); index8++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/gold").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/diamond").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index9 = 0; index9 < (int) (7); index9++) {
						sy = (double) (-3);
						for (int index10 = 0; index10 < (int) (7); index10++) {
							sz = (double) (-3);
							for (int index11 = 0; index11 < (int) (7); index11++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/diamond").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 4));
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/emerald").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index12 = 0; index12 < (int) (7); index12++) {
						sy = (double) (-3);
						for (int index13 = 0; index13 < (int) (7); index13++) {
							sz = (double) (-3);
							for (int index14 = 0; index14 < (int) (7); index14++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/emerald").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 2));
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/amethyst").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index15 = 0; index15 < (int) (7); index15++) {
						sy = (double) (-3);
						for (int index16 = 0; index16 < (int) (7); index16++) {
							sz = (double) (-3);
							for (int index17 = 0; index17 < (int) (7); index17++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/amethyst").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 2));
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/sapphire").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index18 = 0; index18 < (int) (7); index18++) {
						sy = (double) (-3);
						for (int index19 = 0; index19 < (int) (7); index19++) {
							sz = (double) (-3);
							for (int index20 = 0; index20 < (int) (7); index20++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/sapphire").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 2));
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/ruby").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index21 = 0; index21 < (int) (7); index21++) {
						sy = (double) (-3);
						for (int index22 = 0; index22 < (int) (7); index22++) {
							sz = (double) (-3);
							for (int index23 = 0; index23 < (int) (7); index23++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/ruby").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 2));
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/citrine").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index24 = 0; index24 < (int) (7); index24++) {
						sy = (double) (-3);
						for (int index25 = 0; index25 < (int) (7); index25++) {
							sz = (double) (-3);
							for (int index26 = 0; index26 < (int) (7); index26++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/citrine").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 2));
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/topaz").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index27 = 0; index27 < (int) (7); index27++) {
						sy = (double) (-3);
						for (int index28 = 0; index28 < (int) (7); index28++) {
							sz = (double) (-3);
							for (int index29 = 0; index29 < (int) (7); index29++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/topaz").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 2));
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:obsidian").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index30 = 0; index30 < (int) (7); index30++) {
						sy = (double) (-3);
						for (int index31 = 0; index31 < (int) (7); index31++) {
							sz = (double) (-3);
							for (int index32 = 0; index32 < (int) (7); index32++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:obsidian").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/limestone").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index33 = 0; index33 < (int) (7); index33++) {
						sy = (double) (-3);
						for (int index34 = 0; index34 < (int) (7); index34++) {
							sz = (double) (-3);
							for (int index35 = 0; index35 < (int) (7); index35++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/limestone").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 1));
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/zircon").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index36 = 0; index36 < (int) (7); index36++) {
						sy = (double) (-3);
						for (int index37 = 0; index37 < (int) (7); index37++) {
							sz = (double) (-3);
							for (int index38 = 0; index38 < (int) (7); index38++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/zircon").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 2));
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/uranium").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index39 = 0; index39 < (int) (7); index39++) {
						sy = (double) (-3);
						for (int index40 = 0; index40 < (int) (7); index40++) {
							sz = (double) (-3);
							for (int index41 = 0; index41 < (int) (7); index41++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/uranium").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/sulfur").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index42 = 0; index42 < (int) (7); index42++) {
						sy = (double) (-3);
						for (int index43 = 0; index43 < (int) (7); index43++) {
							sz = (double) (-3);
							for (int index44 = 0; index44 < (int) (7); index44++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/sulfur").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 10));
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/crystal").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index45 = 0; index45 < (int) (7); index45++) {
						sy = (double) (-3);
						for (int index46 = 0; index46 < (int) (7); index46++) {
							sz = (double) (-3);
							for (int index47 = 0; index47 < (int) (7); index47++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/crystal").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/sunstone").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index48 = 0; index48 < (int) (7); index48++) {
						sy = (double) (-3);
						for (int index49 = 0; index49 < (int) (7); index49++) {
							sz = (double) (-3);
							for (int index50 = 0; index50 < (int) (7); index50++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/sunstone").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/quartz").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index51 = 0; index51 < (int) (7); index51++) {
						sy = (double) (-3);
						for (int index52 = 0; index52 < (int) (7); index52++) {
							sz = (double) (-3);
							for (int index53 = 0; index53 < (int) (7); index53++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/quartz").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 2));
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/copper").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-4);
					for (int index54 = 0; index54 < (int) (9); index54++) {
						sy = (double) (-4);
						for (int index55 = 0; index55 < (int) (9); index55++) {
							sz = (double) (-4);
							for (int index56 = 0; index56 < (int) (9); index56++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/copper").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/zinc").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index57 = 0; index57 < (int) (7); index57++) {
						sy = (double) (-3);
						for (int index58 = 0; index58 < (int) (7); index58++) {
							sz = (double) (-3);
							for (int index59 = 0; index59 < (int) (7); index59++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/zinc").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/aluminum").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index60 = 0; index60 < (int) (7); index60++) {
						sy = (double) (-3);
						for (int index61 = 0; index61 < (int) (7); index61++) {
							sz = (double) (-3);
							for (int index62 = 0; index62 < (int) (7); index62++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/aluminum").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/cobalt").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index63 = 0; index63 < (int) (7); index63++) {
						sy = (double) (-3);
						for (int index64 = 0; index64 < (int) (7); index64++) {
							sz = (double) (-3);
							for (int index65 = 0; index65 < (int) (7); index65++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/cobalt").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/iridium").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index66 = 0; index66 < (int) (7); index66++) {
						sy = (double) (-3);
						for (int index67 = 0; index67 < (int) (7); index67++) {
							sz = (double) (-3);
							for (int index68 = 0; index68 < (int) (7); index68++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/iridium").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/lead").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index69 = 0; index69 < (int) (7); index69++) {
						sy = (double) (-3);
						for (int index70 = 0; index70 < (int) (7); index70++) {
							sz = (double) (-3);
							for (int index71 = 0; index71 < (int) (7); index71++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/lead").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/nickel").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index72 = 0; index72 < (int) (7); index72++) {
						sy = (double) (-3);
						for (int index73 = 0; index73 < (int) (7); index73++) {
							sz = (double) (-3);
							for (int index74 = 0; index74 < (int) (7); index74++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/nickel").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/peridot").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index75 = 0; index75 < (int) (7); index75++) {
						sy = (double) (-3);
						for (int index76 = 0; index76 < (int) (7); index76++) {
							sz = (double) (-3);
							for (int index77 = 0; index77 < (int) (7); index77++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/peridot").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/platinum").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index78 = 0; index78 < (int) (7); index78++) {
						sy = (double) (-3);
						for (int index79 = 0; index79 < (int) (7); index79++) {
							sz = (double) (-3);
							for (int index80 = 0; index80 < (int) (7); index80++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/platinum").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/silver").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index81 = 0; index81 < (int) (7); index81++) {
						sy = (double) (-3);
						for (int index82 = 0; index82 < (int) (7); index82++) {
							sz = (double) (-3);
							for (int index83 = 0; index83 < (int) (7); index83++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/silver").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/tin").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index84 = 0; index84 < (int) (7); index84++) {
						sy = (double) (-3);
						for (int index85 = 0; index85 < (int) (7); index85++) {
							sz = (double) (-3);
							for (int index86 = 0; index86 < (int) (7); index86++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/tin").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/tungsten").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index87 = 0; index87 < (int) (7); index87++) {
						sy = (double) (-3);
						for (int index88 = 0; index88 < (int) (7); index88++) {
							sz = (double) (-3);
							for (int index89 = 0; index89 < (int) (7); index89++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/tungsten").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/redstone").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index90 = 0; index90 < (int) (7); index90++) {
						sy = (double) (-3);
						for (int index91 = 0; index91 < (int) (7); index91++) {
							sz = (double) (-3);
							for (int index92 = 0; index92 < (int) (7); index92++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/redstone").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 2));
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:ores/lapis").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
					sx = (double) (-3);
					for (int index93 = 0; index93 < (int) (7); index93++) {
						sy = (double) (-3);
						for (int index94 = 0; index94 < (int) (7); index94++) {
							sz = (double) (-3);
							for (int index95 = 0; index95 < (int) (7); index95++) {
								if ((BlockTags.getCollection()
										.getTagByID(new ResourceLocation(("forge:ores/lapis").toLowerCase(java.util.Locale.ENGLISH)))
										.contains((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
												.getBlock()))) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									if (world instanceof World && !world.isRemote()) {
										((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 2));
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
				if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == DarkMatterJellyOreBlock.block.getDefaultState()
						.getBlock())) {
					sx = (double) (-3);
					for (int index96 = 0; index96 < (int) (7); index96++) {
						sy = (double) (-3);
						for (int index97 = 0; index97 < (int) (7); index97++) {
							sz = (double) (-3);
							for (int index98 = 0; index98 < (int) (7); index98++) {
								if (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
										.getBlock() == DarkMatterJellyOreBlock.block.getDefaultState().getBlock())) {
									if (world instanceof World) {
										Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))),
												(World) world, new BlockPos((int) x, (int) y, (int) z));
										world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
									}
									{
										ItemStack _ist = ((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY);
										if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
											_ist.shrink(1);
											_ist.setDamage(0);
										}
									}
								}
								sz = (double) ((sz) + 1);
							}
							sy = (double) ((sy) + 1);
						}
						sx = (double) ((sx) + 1);
					}
				}
			}
		}
	}
}
