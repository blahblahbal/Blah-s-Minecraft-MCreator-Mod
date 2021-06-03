
package net.mcreator.blahmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.blahmod.item.LimestoneItem;
import net.mcreator.blahmod.BlahmodModElements;

@BlahmodModElements.ModElement.Tag
public class CreativeTabBlahItemsItemGroup extends BlahmodModElements.ModElement {
	public CreativeTabBlahItemsItemGroup(BlahmodModElements instance) {
		super(instance, 700);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabcreative_tab_blah_items") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(LimestoneItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
