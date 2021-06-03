package net.mcreator.blahmod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;

import net.mcreator.blahmod.item.UraniumItem;
import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;
import java.util.HashMap;

@BlahmodModElements.ModElement.Tag
public class UraniumArmorCraftedProcedure extends BlahmodModElements.ModElement {
	public UraniumArmorCraftedProcedure(BlahmodModElements instance) {
		super(instance, 1798);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				BlahmodMod.LOGGER.warn("Failed to load dependency itemstack for procedure UraniumArmorCrafted!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((itemstack).getItem() == new ItemStack(UraniumItem.helmet, (int) (1)).getItem())) {
			((itemstack)).addEnchantment(Enchantments.BLAST_PROTECTION, (int) 6);
		} else if (((itemstack).getItem() == new ItemStack(UraniumItem.body, (int) (1)).getItem())) {
			((itemstack)).addEnchantment(Enchantments.BLAST_PROTECTION, (int) 6);
		} else if (((itemstack).getItem() == new ItemStack(UraniumItem.legs, (int) (1)).getItem())) {
			((itemstack)).addEnchantment(Enchantments.BLAST_PROTECTION, (int) 6);
		} else if (((itemstack).getItem() == new ItemStack(UraniumItem.boots, (int) (1)).getItem())) {
			((itemstack)).addEnchantment(Enchantments.BLAST_PROTECTION, (int) 6);
		}
	}

	@SubscribeEvent
	public void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
		Entity entity = event.getPlayer();
		World world = entity.world;
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
		ItemStack itemStack = event.getCrafting();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("itemstack", itemStack);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
