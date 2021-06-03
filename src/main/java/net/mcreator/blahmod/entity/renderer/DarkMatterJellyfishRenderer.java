package net.mcreator.blahmod.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.blahmod.entity.DarkMatterJellyfishEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class DarkMatterJellyfishRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(DarkMatterJellyfishEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelcustom_model(), 1f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("blahmod:textures/dark_jellyfish.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelcustom_model extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer leg1;
		private final ModelRenderer cube_r1;
		private final ModelRenderer leg2;
		private final ModelRenderer cube_r2;
		private final ModelRenderer leg3;
		private final ModelRenderer cube_r3;
		private final ModelRenderer leg4;
		private final ModelRenderer cube_r4;
		private final ModelRenderer leg5;
		private final ModelRenderer cube_r5;
		private final ModelRenderer leg6;
		private final ModelRenderer cube_r6;
		private final ModelRenderer leg7;
		private final ModelRenderer cube_r7;
		private final ModelRenderer leg8;
		private final ModelRenderer cube_r8;
		public Modelcustom_model() {
			textureWidth = 64;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 24.0F, 0.0F);
			head.setTextureOffset(0, 0).addBox(-3.0F, -11.0F, -2.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-5.0F, -10.0F, -4.0F, 9.0F, 1.0F, 9.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-6.0F, -9.0F, -5.0F, 11.0F, 2.0F, 11.0F, 0.0F, false);
			leg1 = new ModelRenderer(this);
			leg1.setRotationPoint(-3.0F, -7.0F, 0.5F);
			head.addChild(leg1);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(3.0F, 7.0F, -0.5F);
			leg1.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 0.0F, 0.0436F);
			cube_r1.setTextureOffset(4, 0).addBox(-5.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 0).addBox(-4.0F, -7.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			leg2 = new ModelRenderer(this);
			leg2.setRotationPoint(-3.2F, -7.0F, 3.2F);
			head.addChild(leg2);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(3.2F, 7.0F, -3.2F);
			leg2.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0436F, 0.0F, 0.0436F);
			cube_r2.setTextureOffset(0, 0).addBox(-4.0F, -7.0F, 3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(4, 0).addBox(-5.0F, -3.0F, 4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			leg3 = new ModelRenderer(this);
			leg3.setRotationPoint(-3.2F, -7.0F, -2.2F);
			head.addChild(leg3);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(3.2F, 7.0F, 2.2F);
			leg3.addChild(cube_r3);
			setRotationAngle(cube_r3, -0.0436F, 0.0F, 0.0436F);
			cube_r3.setTextureOffset(0, 0).addBox(-4.0F, -7.0F, -3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			cube_r3.setTextureOffset(4, 0).addBox(-5.0F, -3.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			leg4 = new ModelRenderer(this);
			leg4.setRotationPoint(-0.5F, -7.0F, -2.0F);
			head.addChild(leg4);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.5F, 7.0F, 2.0F);
			leg4.addChild(cube_r4);
			setRotationAngle(cube_r4, -0.0436F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(4, 0).addBox(-1.0F, -3.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r4.setTextureOffset(0, 0).addBox(-1.0F, -7.0F, -3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			leg5 = new ModelRenderer(this);
			leg5.setRotationPoint(2.2F, -7.0F, -2.2F);
			head.addChild(leg5);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-2.2F, 7.0F, 2.2F);
			leg5.addChild(cube_r5);
			setRotationAngle(cube_r5, -0.0436F, 0.0F, -0.0436F);
			cube_r5.setTextureOffset(0, 0).addBox(2.0F, -7.0F, -3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			cube_r5.setTextureOffset(4, 0).addBox(3.0F, -3.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			leg6 = new ModelRenderer(this);
			leg6.setRotationPoint(2.1F, -7.0F, 0.5F);
			head.addChild(leg6);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(-2.1F, 7.0F, -0.5F);
			leg6.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0F, 0.0F, -0.0436F);
			cube_r6.setTextureOffset(0, 0).addBox(2.0F, -7.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			cube_r6.setTextureOffset(4, 0).addBox(3.0F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			leg7 = new ModelRenderer(this);
			leg7.setRotationPoint(2.2F, -7.0F, 3.2F);
			head.addChild(leg7);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-2.2F, 7.0F, -3.2F);
			leg7.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.0436F, 0.0F, -0.0436F);
			cube_r7.setTextureOffset(0, 0).addBox(2.0F, -7.0F, 3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			cube_r7.setTextureOffset(4, 0).addBox(3.0F, -3.0F, 4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			leg8 = new ModelRenderer(this);
			leg8.setRotationPoint(-0.5F, -7.0F, 3.2F);
			head.addChild(leg8);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(0.5F, 7.0F, -3.2F);
			leg8.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.0436F, 0.0F, 0.0F);
			cube_r8.setTextureOffset(0, 0).addBox(-1.0F, -7.0F, 3.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			cube_r8.setTextureOffset(4, 0).addBox(-1.0F, -3.0F, 4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leg4.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leg5.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leg3.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leg8.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leg6.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leg7.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
