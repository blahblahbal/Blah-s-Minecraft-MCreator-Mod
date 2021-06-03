package net.mcreator.blahmod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;

import net.mcreator.blahmod.item.LumiteArmorItem;
import net.mcreator.blahmod.BlahmodModElements;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Comparator;

@BlahmodModElements.ModElement.Tag
public class LumiteArmorThornsAuraProcedure extends BlahmodModElements.ModElement {
	public LumiteArmorThornsAuraProcedure(BlahmodModElements instance) {
		super(instance, 1042);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure LumiteArmorThornsAura!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure LumiteArmorThornsAura!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure LumiteArmorThornsAura!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure LumiteArmorThornsAura!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure LumiteArmorThornsAura!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double enchantLevel = 0;
		if (((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 0) : ItemStack.EMPTY)
				.getItem() == new ItemStack(LumiteArmorItem.boots, (int) (1)).getItem())
				&& ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 1) : ItemStack.EMPTY)
						.getItem() == new ItemStack(LumiteArmorItem.legs, (int) (1)).getItem())
						&& ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get((int) 2) : ItemStack.EMPTY)
								.getItem() == new ItemStack(LumiteArmorItem.body, (int) (1)).getItem())
								&& (((entity instanceof PlayerEntity)
										? ((PlayerEntity) entity).inventory.armorInventory.get((int) 3)
										: ItemStack.EMPTY).getItem() == new ItemStack(LumiteArmorItem.helmet, (int) (1)).getItem()))))) {
			{
				PlayerEntity p = (PlayerEntity)entity;
				AxisAlignedBB aabb = p.getBoundingBox().expand(8, 8, 8);
				//List entities = p.worldObj.getEntitiesWithinAABBExcludingEntity(p, aabb);
				List entities = p.world.getEntitiesWithinAABBExcludingEntity(p, aabb);
				/*List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (9 / 2d), y - (9 / 2d), z - (9 / 2d), x + (9 / 2d), y + (9 / 2d), z + (9 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());*/
				for (int j = 0; j < entities.size(); j++)
				{
					Entity entity2 = (Entity)entities.get(j);
					if (entity2 instanceof MobEntity)
					{
						entity2.attackEntityFrom(DamageSource.CACTUS, 4);
					}
					//entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 4);
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			Entity imediatesourceentity = event.getSource().getImmediateSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			double amount = event.getAmount();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("amount", amount);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("imediatesourceentity", imediatesourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
