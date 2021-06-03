package net.mcreator.blahmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import net.mcreator.blahmod.BlahmodModElements;

import java.util.Map;
import net.minecraft.entity.player.PlayerEntity;

@BlahmodModElements.ModElement.Tag
public class SoulSnowSpeedUpProcedure extends BlahmodModElements.ModElement {
	public SoulSnowSpeedUpProcedure(BlahmodModElements instance) {
		super(instance, 512);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SoulSnowSpeedUp!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (!(entity instanceof PlayerEntity))
		{
			if (entity instanceof LivingEntity)
			{
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 30, (int) 1, (false), (false)));

			}
		}			
	}
}
