package net.mcreator.blahmod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.vector.Vector3d;

import net.mcreator.blahmod.block.PlayerPistonBlock;
import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;
import java.util.HashMap;

@BlahmodModElements.ModElement.Tag
public class PlayerPistonProcedureProcedure extends BlahmodModElements.ModElement {
	public PlayerPistonProcedureProcedure(BlahmodModElements instance) {
		super(instance, 1172);
		MinecraftForge.EVENT_BUS.register(this);
	}

	static boolean RO = true;
	static int timer = 0;
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BlahmodMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerPistonProcedure!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BlahmodMod.LOGGER.warn("Failed to load dependency x for procedure PlayerPistonProcedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BlahmodMod.LOGGER.warn("Failed to load dependency y for procedure PlayerPistonProcedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BlahmodMod.LOGGER.warn("Failed to load dependency z for procedure PlayerPistonProcedure!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BlahmodMod.LOGGER.warn("Failed to load dependency world for procedure PlayerPistonProcedure!");
			return;
		}
		timer++;
		if (timer > 45)
		{
			RO = true;
			timer = 0;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((world instanceof World) ? ((World) world).getRedstonePowerFromNeighbors(new BlockPos((int) (x - 0), (int) (y - 1), (int) z - 0)) : 0) > 0)
				&& ((world.getBlockState(new BlockPos((int) (x - 0), (int) (y - 1), (int) z - 0))).getBlock() == PlayerPistonBlock.block.getDefaultState()
						.getBlock()))) {
			if (((new Object() {
				public Direction getDirection(BlockPos pos) {
					try {
						BlockState _bs = world.getBlockState(pos);
						DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (property != null)
							return _bs.get(property);
						return Direction.getFacingFromAxisDirection(
								_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
								Direction.AxisDirection.POSITIVE);
					} catch (Exception e) {
						return Direction.NORTH;
					}
				}
			}.getDirection(new BlockPos((int) (x - 0), (int) (y - 1), (int) z - 0))) == Direction.UP))
			{
				Vector3d v3 = entity.getMotion();
				entity.setMotion(v3.x, (double)((World)world).getRedstonePowerFromNeighbors(new BlockPos((int)x - 0, (int)y - 1, (int)z - 0)) / 7, v3.z);
			}
		}

		if (((((world instanceof World) ? ((World) world).getRedstonePowerFromNeighbors(new BlockPos((int) (x - 0), (int) (y + 2), (int) z - 0)) : 0) > 0)
				&& ((world.getBlockState(new BlockPos((int) (x - 0), (int) (y + 2), (int) z - 0))).getBlock() == PlayerPistonBlock.block.getDefaultState()
						.getBlock()))) {
			if (((new Object() {
				public Direction getDirection(BlockPos pos) {
					try {
						BlockState _bs = world.getBlockState(pos);
						DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (property != null)
							return _bs.get(property);
						return Direction.getFacingFromAxisDirection(
								_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
								Direction.AxisDirection.POSITIVE);
					} catch (Exception e) {
						return Direction.NORTH;
					}
				}
			}.getDirection(new BlockPos((int) (x - 0), (int) (y + 2), (int) z - 0))) == Direction.DOWN))
			{
				Vector3d v3 = entity.getMotion();
				entity.setMotion(v3.x, -(double)((World)world).getRedstonePowerFromNeighbors(new BlockPos((int)x - 0, (int)y + 2, (int)z - 1)) / 7, v3.z);
			}
		}

		
		if (((((world instanceof World) ? ((World) world).getRedstonePowerFromNeighbors(new BlockPos((int) x + 1, (int) y, (int) z - 0)) : 0) > 0)
				&& ((world.getBlockState(new BlockPos((int) x + 1, (int) y, (int) z - 0))).getBlock() == PlayerPistonBlock.block.getDefaultState()
						.getBlock()))) {
			if (((new Object() {
				public Direction getDirection(BlockPos pos) {
					try {
						BlockState _bs = world.getBlockState(pos);
						DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (property != null)
							return _bs.get(property);
						return Direction.getFacingFromAxisDirection(
								_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
								Direction.AxisDirection.POSITIVE);
					} catch (Exception e) {
						return Direction.NORTH;
					}
				}
			}.getDirection(new BlockPos((int) x + 1, (int) y, (int) z - 0))) == Direction.WEST))
			{
				Vector3d v3 = entity.getMotion();
				entity.setMotion(-(double)((World)world).getRedstonePowerFromNeighbors(new BlockPos((int)x + 1, (int)y, (int)z - 0)) / 7, v3.y, v3.z);
			}
		}
		if (((((world instanceof World) ? ((World) world).getRedstonePowerFromNeighbors(new BlockPos((int) (x - 1), (int) y, (int) z - 0)) : 0) > 0)
				&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z - 0))).getBlock() == PlayerPistonBlock.block.getDefaultState()
						.getBlock()))) {
			if (((new Object() {
				public Direction getDirection(BlockPos pos) {
					try {
						BlockState _bs = world.getBlockState(pos);
						DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (property != null)
							return _bs.get(property);
						return Direction.getFacingFromAxisDirection(
								_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
								Direction.AxisDirection.POSITIVE);
					} catch (Exception e) {
						return Direction.NORTH;
					}
				}
			}.getDirection(new BlockPos((int) (x - 1), (int) y, (int) z - 0))) == Direction.EAST))
			{
				Vector3d v3 = entity.getMotion();
				entity.setMotion((double)((World)world).getRedstonePowerFromNeighbors(new BlockPos((int)x - 1, (int)y, (int)z - 0)) / 7, v3.y, v3.z);
			}
		}
		if (((((world instanceof World) ? ((World) world).getRedstonePowerFromNeighbors(new BlockPos((int) (x - 0), (int) y, (int) (z - 1))) : 0) > 0)
				&& ((world.getBlockState(new BlockPos((int) (x - 0), (int) y, (int) (z - 1)))).getBlock() == PlayerPistonBlock.block.getDefaultState()
						.getBlock()))) {
			if (((new Object() {
				public Direction getDirection(BlockPos pos) {
					try {
						BlockState _bs = world.getBlockState(pos);
						DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (property != null)
							return _bs.get(property);
						return Direction.getFacingFromAxisDirection(
								_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
								Direction.AxisDirection.POSITIVE);
					} catch (Exception e) {
						return Direction.NORTH;
					}
				}
			}.getDirection(new BlockPos((int) (x - 0), (int) y, (int) (z - 1)))) == Direction.SOUTH))
			{
				Vector3d v3 = entity.getMotion();
				entity.setMotion(v3.x, v3.y, (double)((World)world).getRedstonePowerFromNeighbors(new BlockPos((int)x - 0, (int)y, (int)z - 1)) / 7);
			}
		}
		if (((((world instanceof World) ? ((World) world).getRedstonePowerFromNeighbors(new BlockPos((int) (x - 0), (int) y, (int) (z + 1))) : 0) > 0)
				&& ((world.getBlockState(new BlockPos((int) (x - 0), (int) y, (int) (z + 1)))).getBlock() == PlayerPistonBlock.block.getDefaultState()
						.getBlock()))) {
			if (((new Object() {
				public Direction getDirection(BlockPos pos) {
					try {
						BlockState _bs = world.getBlockState(pos);
						DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
						if (property != null)
							return _bs.get(property);
						return Direction.getFacingFromAxisDirection(
								_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
								Direction.AxisDirection.POSITIVE);
					} catch (Exception e) {
						return Direction.NORTH;
					}
				}
			}.getDirection(new BlockPos((int) (x - 0), (int) y, (int) (z + 1)))) == Direction.NORTH))
			{
				Vector3d v3 = entity.getMotion();
				entity.setMotion(v3.x, v3.y, -(double)((World)world).getRedstonePowerFromNeighbors(new BlockPos((int)x - 0, (int)y, (int)z + 1)) / 7);
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
