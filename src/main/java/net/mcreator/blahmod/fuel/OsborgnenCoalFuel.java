
package net.mcreator.blahmod.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.blahmod.item.OsborgnenFuelItem;
import net.mcreator.blahmod.BlahmodModElements;

@BlahmodModElements.ModElement.Tag
public class OsborgnenCoalFuel extends BlahmodModElements.ModElement {
	public OsborgnenCoalFuel(BlahmodModElements instance) {
		super(instance, 601);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(OsborgnenFuelItem.block, (int) (1)).getItem())
			event.setBurnTime(24000);
	}
}
