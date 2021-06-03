package net.mcreator.blahmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;

import net.mcreator.blahmod.block.SaltBlock;
import net.mcreator.blahmod.block.MoltenIceBlock;
import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;
import java.util.HashMap;

@BlahmodModElements.ModElement.Tag
public class SaltDeltasUpdateProcedure extends BlahmodModElements.ModElement {
	public SaltDeltasUpdateProcedure(BlahmodModElements instance) {
		super(instance, 1723);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BlahmodMod.LOGGER.warn("Failed to load dependency x for procedure SaltDeltasUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BlahmodMod.LOGGER.warn("Failed to load dependency y for procedure SaltDeltasUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BlahmodMod.LOGGER.warn("Failed to load dependency z for procedure SaltDeltasUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BlahmodMod.LOGGER.warn("Failed to load dependency world for procedure SaltDeltasUpdate!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean found = false;
		double circle1 = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double width = 0;
		double height = 0;
		double maxheight = 0;
		double rand = 0;
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == SaltBlock.block.getDefaultState().getBlock())) {
			if ((Math.random() < 0.0075)) {
				circle1 = (double) (-3);
				for (int index0 = 0; index0 < (int) (6); index0++) {
					sz = (double) (-3);
					for (int index1 = 0; index1 < (int) (6); index1++) {
						{
							BlockPos _bp = new BlockPos((int) (x + (circle1)), (int) (y - 1), (int) (z + (sz)));
							BlockState _bs = MoltenIceBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_property != null && _bs.get(_property) != null)
									try {
										_bs = _bs.with(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							world.setBlockState(_bp, _bs, 3);
						}
						if (((((circle1) == (-3)) && (((sz) >= (-3)) && ((sz) <= 2))) || ((((circle1) == 2) && (((sz) >= (-3)) && ((sz) <= 2)))
								|| ((((sz) == (-3)) && (((circle1) >= (-3)) && ((circle1) <= 2)))
										|| (((sz) == 2) && (((circle1) >= (-3)) && ((circle1) <= 2))))))) {
							{
								BlockPos _bp = new BlockPos((int) (x + (circle1)), (int) (y - 1), (int) (z + (sz)));
								BlockState _bs = SaltBlock.block.getDefaultState();
								BlockState _bso = world.getBlockState(_bp);
								for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
									Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
									if (_property != null && _bs.get(_property) != null)
										try {
											_bs = _bs.with(_property, (Comparable) entry.getValue());
										} catch (Exception e) {
										}
								}
								world.setBlockState(_bp, _bs, 3);
							}
						}
						if (((((circle1) <= 2) && ((circle1) >= (-2))) && (((sz) <= 2) && ((sz) >= (-2))))) {
							{
								BlockPos _bp = new BlockPos((int) (x + (circle1)), (int) (y - 2), (int) (z + (sz)));
								BlockState _bs = SaltBlock.block.getDefaultState();
								BlockState _bso = world.getBlockState(_bp);
								for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
									Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
									if (_property != null && _bs.get(_property) != null)
										try {
											_bs = _bs.with(_property, (Comparable) entry.getValue());
										} catch (Exception e) {
										}
								}
								world.setBlockState(_bp, _bs, 3);
							}
						}
						sz = (double) ((sz) + 1);
					}
					circle1 = (double) ((circle1) + 1);
				}
			}
			if ((Math.random() < 0.005)) {
				width = (double) 1;
				maxheight = (double) (Math.random() * 15);
				for (int index2 = 0; index2 < (int) ((maxheight)); index2++) {
					if (((width) == 1)) {
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("world", world);
							$_dependencies.put("x", x);
							$_dependencies.put("y", (y + (height)));
							$_dependencies.put("z", z);
							CoreSpikeRandomThingProcedure.executeProcedure($_dependencies);
						}
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("world", world);
							$_dependencies.put("x", (x + 1));
							$_dependencies.put("y", (y + (height)));
							$_dependencies.put("z", z);
							CoreSpikeRandomThingProcedure.executeProcedure($_dependencies);
						}
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("world", world);
							$_dependencies.put("x", (x - 1));
							$_dependencies.put("y", (y + (height)));
							$_dependencies.put("z", z);
							CoreSpikeRandomThingProcedure.executeProcedure($_dependencies);
						}
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("world", world);
							$_dependencies.put("x", x);
							$_dependencies.put("y", (y + (height)));
							$_dependencies.put("z", (z + 1));
							CoreSpikeRandomThingProcedure.executeProcedure($_dependencies);
						}
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("world", world);
							$_dependencies.put("x", x);
							$_dependencies.put("y", (y + (height)));
							$_dependencies.put("z", (z - 1));
							CoreSpikeRandomThingProcedure.executeProcedure($_dependencies);
						}
						if ((Math.random() < 0.3)) {
							width = (double) 0;
						}
						if (((height) >= ((maxheight) * 0.5))) {
							width = (double) 0;
						}
					} else {
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("world", world);
							$_dependencies.put("x", x);
							$_dependencies.put("y", (y + (height)));
							$_dependencies.put("z", z);
							CoreSpikeRandomThingProcedure.executeProcedure($_dependencies);
						}
					}
					height = (double) ((height) + 1);
				}
			}
		}
	}
}
