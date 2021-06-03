
package net.mcreator.blahmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.blahmod.procedures.MiningHammerBlockDestroyedProcedure;
import net.mcreator.blahmod.itemgroup.CreativeTabBlahItemsItemGroup;
import net.mcreator.blahmod.block.TropicsCobblestoneBlock;
import net.mcreator.blahmod.BlahmodModElements;

import java.util.Map;
import java.util.HashMap;

@BlahmodModElements.ModElement.Tag
public class StoneHammerItem extends BlahmodModElements.ModElement {
	@ObjectHolder("blahmod:stone_hammer")
	public static final Item block = null;
	public StoneHammerItem(BlahmodModElements instance) {
		super(instance, 48);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 78;
			}

			public float getEfficiency() {
				return 2f;
			}

			public float getAttackDamage() {
				return 6.5f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 5;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.COBBLESTONE, (int) (1)), new ItemStack(TropicsCobblestoneBlock.block, (int) (1)));
			}
		}, 1, -3.6f, new Item.Properties().group(CreativeTabBlahItemsItemGroup.tab)) {
			@Override
			public boolean onBlockDestroyed(ItemStack itemstack, World world, BlockState bl, BlockPos pos, LivingEntity entity) {
				boolean retval = super.onBlockDestroyed(itemstack, world, bl, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					MiningHammerBlockDestroyedProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("stone_hammer"));
	}
}
