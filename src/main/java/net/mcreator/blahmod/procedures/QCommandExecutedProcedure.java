package net.mcreator.blahmod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;

@BlahmodModElements.ModElement.Tag
public class QCommandExecutedProcedure extends BlahmodModElements.ModElement {
	public QCommandExecutedProcedure(BlahmodModElements instance) {
		super(instance, 1355);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BlahmodMod.LOGGER.warn("Failed to load dependency entity for procedure QCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double rn = 0;
		rn = (double) Math.random();
		if (((rn) < 0.025)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q0").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.05)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q30").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.075)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q31").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.1)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q32").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.125)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q33").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.15)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q34").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.175)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q35").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.2)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q36").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.225)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q37").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.25)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q38").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.275)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q39").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.3)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q22").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.325)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q23").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.35)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q24").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.375)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q1").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.4)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q2").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.425)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q3").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.45)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q4").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.475)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q5").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.5)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q6").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.525)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q7").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.55)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q8").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.575)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q9").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.6)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q10").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.625)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q11").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.65)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q12").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.675)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q13").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.7)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q14").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.725)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q15").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.75)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q16").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.775)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q17").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.8)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q18").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.825)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q19").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.85)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q20").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.875)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q21").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.9)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q25").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.915)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q26").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.93)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q27").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.945)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q28").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.96)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q29").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 0.975)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q40").setDamageBypassesArmor(), (float) 100);
			}
		} else if (((rn) < 1)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("q41").setDamageBypassesArmor(), (float) 100);
			}
		}
	}
}
