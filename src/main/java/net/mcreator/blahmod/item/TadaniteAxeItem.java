
package net.mcreator.blahmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.blahmod.itemgroup.CreativeTabBlahItemsItemGroup;
import net.mcreator.blahmod.BlahmodModElements;

import java.util.List;

@BlahmodModElements.ModElement.Tag
public class TadaniteAxeItem extends BlahmodModElements.ModElement {
	@ObjectHolder("blahmod:tadanite_axe")
	public static final Item block = null;
	public TadaniteAxeItem(BlahmodModElements instance) {
		super(instance, 19);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 4000;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 11f;
			}

			public int getHarvestLevel() {
				return 5;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(TadaniteCrystalItem.block, (int) (1)));
			}
		}, 1, -3.1f, new Item.Properties().group(CreativeTabBlahItemsItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A7eEfficient"));
			}
		}.setRegistryName("tadanite_axe"));
	}
}
