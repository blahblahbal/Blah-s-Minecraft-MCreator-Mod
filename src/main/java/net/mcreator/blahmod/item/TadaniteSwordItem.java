
package net.mcreator.blahmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.blahmod.itemgroup.CreativeTabBlahItemsItemGroup;
import net.mcreator.blahmod.BlahmodModElements;

@BlahmodModElements.ModElement.Tag
public class TadaniteSwordItem extends BlahmodModElements.ModElement {
	@ObjectHolder("blahmod:tadanite_sword")
	public static final Item block = null;
	public TadaniteSwordItem(BlahmodModElements instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 4000;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 8f;
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
		}, 3, -2.4f, new Item.Properties().group(CreativeTabBlahItemsItemGroup.tab).isImmuneToFire()) {
		}.setRegistryName("tadanite_sword"));
	}
}
