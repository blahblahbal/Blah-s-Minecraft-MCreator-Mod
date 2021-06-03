package net.mcreator.blahmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;

@BlahmodModElements.ModElement.Tag
public class LumiteSwordLightOnFireProcedure extends BlahmodModElements.ModElement {
	public LumiteSwordLightOnFireProcedure(BlahmodModElements instance) {
		super(instance, 711);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BlahmodMod.LOGGER.warn("Failed to load dependency entity for procedure LumiteSwordLightOnFire!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 5);
	}
}
