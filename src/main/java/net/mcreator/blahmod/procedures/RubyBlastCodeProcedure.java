package net.mcreator.blahmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.blahmod.BlahmodModElements;
import net.mcreator.blahmod.BlahmodMod;

import java.util.Map;

@BlahmodModElements.ModElement.Tag
public class RubyBlastCodeProcedure extends BlahmodModElements.ModElement {
	public RubyBlastCodeProcedure(BlahmodModElements instance) {
		super(instance, 830);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BlahmodMod.LOGGER.warn("Failed to load dependency entity for procedure RubyBlastCode!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 8);
	}
}
