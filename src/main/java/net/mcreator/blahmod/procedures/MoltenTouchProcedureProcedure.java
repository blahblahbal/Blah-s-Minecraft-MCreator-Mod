package net.mcreator.blahmod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Inventory;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import net.mcreator.blahmod.enchantment.MoltenTouchEnchantment;
import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;
import java.util.HashMap;

@BlahmodModElements.ModElement.Tag
public class MoltenTouchProcedureProcedure extends BlahmodModElements.ModElement {
	public MoltenTouchProcedureProcedure(BlahmodModElements instance) {
		super(instance, 1435);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BlahmodMod.LOGGER.warn("Failed to load dependency entity for procedure MoltenTouchProcedure!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BlahmodMod.LOGGER.warn("Failed to load dependency x for procedure MoltenTouchProcedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BlahmodMod.LOGGER.warn("Failed to load dependency y for procedure MoltenTouchProcedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BlahmodMod.LOGGER.warn("Failed to load dependency z for procedure MoltenTouchProcedure!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BlahmodMod.LOGGER.warn("Failed to load dependency world for procedure MoltenTouchProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean removeBlock = false;
		if (((EnchantmentHelper.getEnchantmentLevel(MoltenTouchEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) > 0)) {
			if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
					.canHarvestBlock((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))))) == (true))) {
				if ((!(((world instanceof World && ((World) world).getRecipeManager()
						.getRecipe(IRecipeType.SMELTING,
								new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
								((World) world))
						.isPresent())
								? ((World) world).getRecipeManager()
										.getRecipe(IRecipeType.SMELTING,
												new Inventory(
														(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
												(World) world)
										.get().getRecipeOutput().copy()
								: ItemStack.EMPTY).getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
					if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE,
							((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) > 0)) {
						if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE,
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) == 1)) {
							if ((Math.random() < 0.25)) {
								if (world instanceof World && !world.isRemote()) {
									ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, ((world instanceof World && ((World) world)
											.getRecipeManager()
											.getRecipe(IRecipeType.SMELTING, new Inventory(
													(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
													((World) world))
											.isPresent())
													? ((World) world).getRecipeManager()
															.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																	(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																	(World) world)
															.get().getRecipeOutput().copy()
													: ItemStack.EMPTY));
									entityToSpawn.setPickupDelay((int) 10);
									world.addEntity(entityToSpawn);
								}
							}
						} else if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE,
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) == 2)) {
							if ((Math.random() < 0.25)) {
								for (int index0 = 0; index0 < (int) (2); index0++) {
									if (world instanceof World && !world.isRemote()) {
										ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, ((world instanceof World && ((World) world)
												.getRecipeManager()
												.getRecipe(IRecipeType.SMELTING, new Inventory(
														(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
														((World) world))
												.isPresent())
														? ((World) world).getRecipeManager()
																.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																		(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																		(World) world)
																.get().getRecipeOutput().copy()
														: ItemStack.EMPTY));
										entityToSpawn.setPickupDelay((int) 10);
										world.addEntity(entityToSpawn);
									}
								}
							}
						} else if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE,
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))) == 3)) {
							if ((Math.random() < 0.15)) {
								for (int index1 = 0; index1 < (int) (3); index1++) {
									if (world instanceof World && !world.isRemote()) {
										ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, ((world instanceof World && ((World) world)
												.getRecipeManager()
												.getRecipe(IRecipeType.SMELTING, new Inventory(
														(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
														((World) world))
												.isPresent())
														? ((World) world).getRecipeManager()
																.getRecipe(IRecipeType.SMELTING, new Inventory((new ItemStack(
																		(world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
																		(World) world)
																.get().getRecipeOutput().copy()
														: ItemStack.EMPTY));
										entityToSpawn.setPickupDelay((int) 10);
										world.addEntity(entityToSpawn);
									}
								}
							}
						}
					}
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
								((world instanceof World && ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING,
										new Inventory((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
										((World) world)).isPresent())
												? ((World) world).getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(
														(new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))),
														(World) world).get().getRecipeOutput().copy()
												: ItemStack.EMPTY));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
					removeBlock = (boolean) (true);
				} else {
					removeBlock = (boolean) (false);
				}
				if (((removeBlock) == (true))) {
					world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
				} else {
					if (world instanceof World) {
						Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
								new BlockPos((int) x, (int) y, (int) z));
						world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
					}
				}
			}
			if (world instanceof World && !world.isRemote()) {
				((World) world).addEntity(new ExperienceOrbEntity(((World) world), x, y, z, (int) 3));
			}
		}
	}

	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event) {
		Entity entity = event.getPlayer();
		IWorld world = event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("xpAmount", event.getExpToDrop());
		dependencies.put("x", event.getPos().getX());
		dependencies.put("y", event.getPos().getY());
		dependencies.put("z", event.getPos().getZ());
		dependencies.put("px", entity.getPosX());
		dependencies.put("py", entity.getPosY());
		dependencies.put("pz", entity.getPosZ());
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
