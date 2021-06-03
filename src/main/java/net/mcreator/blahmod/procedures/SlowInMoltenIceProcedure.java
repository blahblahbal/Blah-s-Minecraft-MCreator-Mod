package net.mcreator.blahmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;

import net.mcreator.blahmod.potion.WarmthPotion;
import net.mcreator.blahmod.potion.FreezingPotion;
import net.mcreator.blahmod.entity.*;
import net.mcreator.blahmod.BlahmodModElements;

import java.util.Map;
import java.util.Collection;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.GhastEntity;

@BlahmodModElements.ModElement.Tag
public class SlowInMoltenIceProcedure extends BlahmodModElements.ModElement {
	public SlowInMoltenIceProcedure(BlahmodModElements instance) {
		super(instance, 147);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SlowInMoltenIce!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((!(new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == WarmthPotion.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity))))
		{
			if (entity instanceof LivingEntity)
			{
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 4, (false), (true)));
				//((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, (int) 60, (int) 1, (false), (true)));
				//((LivingEntity) entity).extinguish();
			}
			if (entity instanceof EskimoZombieEntity.CustomEntity || entity instanceof IceCubeEntity.CustomEntity || entity instanceof GhastEntity)
			{
				return;
			}
			else
			{
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(FreezingPotion.potion, (int) 120, (int) 2, (false), (false)));
			}
		}
	}
}
