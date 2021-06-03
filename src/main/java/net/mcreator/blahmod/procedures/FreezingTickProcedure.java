package net.mcreator.blahmod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;

@BlahmodModElements.ModElement.Tag
public class FreezingTickProcedure extends BlahmodModElements.ModElement {
	public FreezingTickProcedure(BlahmodModElements instance) {
		super(instance, 989);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BlahmodMod.LOGGER.warn("Failed to load dependency entity for procedure FreezingTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double previousRecipe = 0;
		if ((Math.random() < 0.25)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("freezing").setDamageBypassesArmor(), (float) 2);
			}
		}
	}
}
