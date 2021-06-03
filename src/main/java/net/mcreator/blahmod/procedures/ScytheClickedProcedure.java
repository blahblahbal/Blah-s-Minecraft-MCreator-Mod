package net.mcreator.blahmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.blahmod.block.DarkMatterSmallBushBlock;
import net.mcreator.blahmod.block.DarkMatterBushBlock;
import net.mcreator.blahmod.block.EtherealTallGrassBlock;
import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.BushBlock;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.TallGrassBlock;
import net.minecraft.block.DeadBushBlock;
import net.minecraft.block.SeaGrassBlock;

@BlahmodModElements.ModElement.Tag
public class ScytheClickedProcedure extends BlahmodModElements.ModElement {
	public ScytheClickedProcedure(BlahmodModElements instance) {
		super(instance, 1396);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BlahmodMod.LOGGER.warn("Failed to load dependency entity for procedure ScytheClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BlahmodMod.LOGGER.warn("Failed to load dependency x for procedure ScytheClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BlahmodMod.LOGGER.warn("Failed to load dependency y for procedure ScytheClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BlahmodMod.LOGGER.warn("Failed to load dependency z for procedure ScytheClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BlahmodMod.LOGGER.warn("Failed to load dependency world for procedure ScytheClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((!(entity.isSneaking())))
		{
			if (world.getBlockState(new BlockPos(x, y, z)).getBlock() instanceof TallGrassBlock || world.getBlockState(new BlockPos(x, y, z)).getBlock() instanceof LeavesBlock ||
				world.getBlockState(new BlockPos(x, y, z)).getBlock() instanceof DoublePlantBlock || world.getBlockState(new BlockPos(x, y, z)).getBlock() instanceof DeadBushBlock ||
				world.getBlockState(new BlockPos(x, y, z)).getBlock() instanceof SeaGrassBlock || world.getBlockState(new BlockPos(x, y, z)).getBlock() instanceof DarkMatterSmallBushBlock.BlockCustomFlower ||
				world.getBlockState(new BlockPos(x, y, z)).getBlock() instanceof EtherealTallGrassBlock.BlockCustomFlower)
			{
				sx = (double) (-5);
				for (int index0 = 0; index0 < (int) (10); index0++) {
					sy = (double) (-5);
					for (int index1 = 0; index1 < (int) (10); index1++) {
						sz = (double) (-5);
						for (int index2 = 0; index2 < (int) (10); index2++) {
							if (world.getBlockState(new BlockPos((x + sx), (y + sy), (z + sz))).getBlock() instanceof TallGrassBlock || world.getBlockState(new BlockPos((x + sx), (y + sy), (z + sz))).getBlock() instanceof LeavesBlock ||
								world.getBlockState(new BlockPos((x + sx), (y + sy), (z + sz))).getBlock() instanceof DoublePlantBlock || world.getBlockState(new BlockPos((x + sx), (y + sy), (z + sz))).getBlock() instanceof DeadBushBlock ||
								world.getBlockState(new BlockPos((x + sx), (y + sy), (z + sz))).getBlock() instanceof SeaGrassBlock || world.getBlockState(new BlockPos((x + sx), (y + sy), (z + sz))).getBlock() instanceof DarkMatterSmallBushBlock.BlockCustomFlower ||
								world.getBlockState(new BlockPos((x + sx), (y + sy), (z + sz))).getBlock() instanceof EtherealTallGrassBlock.BlockCustomFlower)
							{
								world.destroyBlock(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz))), false);
							}
							sz = (double) ((sz) + 1);
						}
						sy = (double) ((sy) + 1);
					}
					sx = (double) ((sx) + 1);
				}
			}
		} else {
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() instanceof BushBlock)
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() instanceof LeavesBlock))
			{
				sx = (double) (-5);
				for (int index3 = 0; index3 < (int) (10); index3++) {
					sy = (double) (-5);
					for (int index4 = 0; index4 < (int) (10); index4++) {
						sz = (double) (-5);
						for (int index5 = 0; index5 < (int) (10); index5++) {
							if ((((world.getBlockState(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz)))).getBlock() instanceof LeavesBlock)
											|| ((world.getBlockState(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz)))).getBlock() instanceof BushBlock))) {
								world.destroyBlock(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz)), false);
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
