
package net.mcreator.blahmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.blahmod.itemgroup.CreativeTabBlahItemsItemGroup;
import net.mcreator.blahmod.BlahmodModElements;

@BlahmodModElements.ModElement.Tag
public class LumiteAxeItem extends BlahmodModElements.ModElement {
	@ObjectHolder("blahmod:lumite_axe")
	public static final Item block = null;
	public LumiteAxeItem(BlahmodModElements instance) {
		super(instance, 27);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 4500;
			}

			public float getEfficiency() {
				return 15f;
			}

			public float getAttackDamage() {
				return 14f;
			}

			public int getHarvestLevel() {
				return 6;
			}

			public int getEnchantability() {
				return 25;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(LumiteIngotItem.block, (int) (1)));
			}
		}, 1, -3.1f, new Item.Properties().group(CreativeTabBlahItemsItemGroup.tab).isImmuneToFire()) {
		}.setRegistryName("lumite_axe"));
	}
}
