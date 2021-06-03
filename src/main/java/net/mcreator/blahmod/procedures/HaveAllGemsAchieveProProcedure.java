package net.mcreator.blahmod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.blahmod.item.ZirconItem;
import net.mcreator.blahmod.item.TopazItem;
import net.mcreator.blahmod.item.SapphireItem;
import net.mcreator.blahmod.item.RubyItem;
import net.mcreator.blahmod.item.CitrineItem;
import net.mcreator.blahmod.item.AmethystItem;
import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

@BlahmodModElements.ModElement.Tag
public class HaveAllGemsAchieveProProcedure extends BlahmodModElements.ModElement {
	public HaveAllGemsAchieveProProcedure(BlahmodModElements instance) {
		super(instance, 1794);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BlahmodMod.LOGGER.warn("Failed to load dependency entity for procedure HaveAllGemsAchievePro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(RubyItem.block, (int) (1))) : false)
				&& (((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CitrineItem.block, (int) (1)))
						: false)
						&& (((entity instanceof PlayerEntity)
								? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(TopazItem.block, (int) (1)))
								: false)
								&& (((entity instanceof PlayerEntity)
										? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Items.EMERALD, (int) (1)))
										: false)
										&& (((entity instanceof PlayerEntity)
												? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Items.DIAMOND, (int) (1)))
												: false)
												&& (((entity instanceof PlayerEntity)
														? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(SapphireItem.block, (int) (1)))
														: false)
														&& (((entity instanceof PlayerEntity)
																? ((PlayerEntity) entity).inventory
																		.hasItemStack(new ItemStack(AmethystItem.block, (int) (1)))
																: false)
																&& ((entity instanceof PlayerEntity)
																		? ((PlayerEntity) entity).inventory
																				.hasItemStack(new ItemStack(ZirconItem.block, (int) (1)))
																		: false))))))))) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("blahmod:taste_the_rainbow"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
