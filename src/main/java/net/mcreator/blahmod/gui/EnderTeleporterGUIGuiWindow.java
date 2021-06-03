
package net.mcreator.blahmod.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.blahmod.BlahmodMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class EnderTeleporterGUIGuiWindow extends ContainerScreen<EnderTeleporterGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	TextFieldWidget xCoord;
	TextFieldWidget yCoord;
	TextFieldWidget zCoord;
	public EnderTeleporterGUIGuiWindow(EnderTeleporterGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 210;
	}
	private static final ResourceLocation texture = new ResourceLocation("blahmod:textures/ender_teleporter_gui.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		xCoord.render(ms, mouseX, mouseY, partialTicks);
		yCoord.render(ms, mouseX, mouseY, partialTicks);
		zCoord.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("blahmod:textures/x.png"));
		this.blit(ms, this.guiLeft + 11, this.guiTop + 20, 0, 0, 5, 7, 5, 7);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("blahmod:textures/y.png"));
		this.blit(ms, this.guiLeft + 11, this.guiTop + 41, 0, 0, 5, 7, 5, 7);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("blahmod:textures/z.png"));
		this.blit(ms, this.guiLeft + 11, this.guiTop + 62, 0, 0, 5, 7, 5, 7);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("blahmod:textures/ender_teleporter.png"));
		this.blit(ms, this.guiLeft + 41, this.guiTop + 4, 0, 0, 86, 8, 86, 8);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("blahmod:textures/teleport.png"));
		this.blit(ms, this.guiLeft + 32, this.guiTop + 85, 0, 0, 42, 8, 42, 8);
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("blahmod:textures/save.png"));
		this.blit(ms, this.guiLeft + 118, this.guiTop + 85, 0, 0, 23, 7, 23, 7);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (xCoord.isFocused())
			return xCoord.keyPressed(key, b, c);
		if (yCoord.isFocused())
			return yCoord.keyPressed(key, b, c);
		if (zCoord.isFocused())
			return zCoord.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		xCoord.tick();
		yCoord.tick();
		zCoord.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		xCoord = new TextFieldWidget(this.font, this.guiLeft + 24, this.guiTop + 14, 120, 20, new StringTextComponent(""));
		EnderTeleporterGUIGui.guistate.put("text:xCoord", xCoord);
		xCoord.setMaxStringLength(32767);
		this.children.add(this.xCoord);
		yCoord = new TextFieldWidget(this.font, this.guiLeft + 24, this.guiTop + 35, 120, 20, new StringTextComponent(""));
		EnderTeleporterGUIGui.guistate.put("text:yCoord", yCoord);
		yCoord.setMaxStringLength(32767);
		this.children.add(this.yCoord);
		zCoord = new TextFieldWidget(this.font, this.guiLeft + 24, this.guiTop + 56, 120, 20, new StringTextComponent(""));
		EnderTeleporterGUIGui.guistate.put("text:zCoord", zCoord);
		zCoord.setMaxStringLength(32767);
		this.children.add(this.zCoord);
		this.addButton(new Button(this.guiLeft + 18, this.guiTop + 100, 75, 20, new StringTextComponent(" "), e -> {
			if (true) {
				BlahmodMod.PACKET_HANDLER.sendToServer(new EnderTeleporterGUIGui.ButtonPressedMessage(0, x, y, z));
				EnderTeleporterGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 106, this.guiTop + 100, 50, 20, new StringTextComponent(" "), e -> {
			if (true) {
				BlahmodMod.PACKET_HANDLER.sendToServer(new EnderTeleporterGUIGui.ButtonPressedMessage(1, x, y, z));
				EnderTeleporterGUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
