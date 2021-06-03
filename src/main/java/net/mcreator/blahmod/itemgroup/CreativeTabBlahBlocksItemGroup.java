
package net.mcreator.blahmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.blahmod.block.BlazeBrickBlock;
import net.mcreator.blahmod.BlahmodModElements;

@BlahmodModElements.ModElement.Tag
public class CreativeTabBlahBlocksItemGroup extends BlahmodModElements.ModElement {
	public CreativeTabBlahBlocksItemGroup(BlahmodModElements instance) {
		super(instance, 701);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabcreative_tab_blah_blocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BlazeBrickBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
