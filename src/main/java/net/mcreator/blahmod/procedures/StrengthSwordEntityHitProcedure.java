package net.mcreator.blahmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;

@BlahmodModElements.ModElement.Tag
public class StrengthSwordEntityHitProcedure extends BlahmodModElements.ModElement {
	public StrengthSwordEntityHitProcedure(BlahmodModElements instance) {
		super(instance, 1352);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				BlahmodMod.LOGGER.warn("Failed to load dependency sourceentity for procedure StrengthSwordEntityHit!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (sourceentity instanceof LivingEntity)
			((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 120, (int) 1));
	}
}
