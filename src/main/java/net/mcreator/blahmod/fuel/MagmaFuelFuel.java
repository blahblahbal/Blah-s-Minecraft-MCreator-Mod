
package net.mcreator.blahmod.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;

import net.mcreator.blahmod.BlahmodModElements;

@BlahmodModElements.ModElement.Tag
public class MagmaFuelFuel extends BlahmodModElements.ModElement {
	public MagmaFuelFuel(BlahmodModElements instance) {
		super(instance, 785);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(Blocks.MAGMA_BLOCK, (int) (1)).getItem())
			event.setBurnTime(1000);
	}
}
