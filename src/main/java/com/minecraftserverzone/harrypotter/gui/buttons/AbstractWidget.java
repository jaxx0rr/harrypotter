/*
package com.minecraftserverzone.harrypotter.gui.buttons;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.narration.NarratedElementType;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;

public abstract class AbstractWidget extends GuiComponent implements Renderable, GuiEventListener, NarratableEntry {
   public static final ResourceLocation WIDGETS_LOCATION = new ResourceLocation("textures/gui/widgets.png");
   protected int width;
   protected int height;
   public int x;
   public int y;
   private Component message;
   protected boolean isHovered;
   public boolean active = true;
   public boolean visible = true;
   protected float alpha = 1.0F;
   private boolean focused;
   private boolean enoughExp;

   public AbstractWidget(int x, int y, int width, int height, Component message, boolean enoughExp) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.message = message;
      this.enoughExp = enoughExp;
   }

   public int getHeight() {
      return this.height;
   }

   protected int getYImage(boolean hoveredOrFocused) {
      if (!this.active) return 0;
      return hoveredOrFocused ? 2 : 1;
   }

   @Override
   public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
      if (this.visible) {
         this.isHovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
         this.renderButton(guiGraphics, mouseX, mouseY, partialTicks);
      }
   }

   protected MutableComponent createNarrationMessage() {
      return wrapDefaultNarrationMessage(this.getMessage());
   }

   public static MutableComponent wrapDefaultNarrationMessage(Component message) {
      return Component.translatable("gui.narrate.button", message);
   }

   public void renderButton(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
      Minecraft minecraft = Minecraft.getInstance();
      Font font = minecraft.font;

      int i = this.getYImage(this.isHoveredOrFocused());

      guiGraphics.blit(WIDGETS_LOCATION, this.x, this.y, 0, 46 + i * 20, this.width / 2, this.height / 2);
      guiGraphics.blit(WIDGETS_LOCATION, this.x + this.width / 2, this.y, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height / 2);
      guiGraphics.blit(WIDGETS_LOCATION, this.x, this.y + (this.height / 2), 0, 61 + i * 20, this.width / 2, this.height / 2);
      guiGraphics.blit(WIDGETS_LOCATION, this.x + this.width / 2, this.y + (this.height / 2), 200 - this.width / 2, 61 + i * 20, this.width / 2, this.height / 2);

      this.renderBg(guiGraphics, minecraft, mouseX, mouseY);

      int j = getFGColor();
      guiGraphics.drawCenteredString(font, this.getMessage(), (this.x + this.width / 2), this.y + (this.height - 8) / 2, j | Mth.ceil(this.alpha * 255.0F) << 24);
   }


   protected void renderBg(GuiGraphics guiGraphics, Minecraft minecraft, int mouseX, int mouseY) {
   }

   public void onRelease(double mouseX, double mouseY) {
   }

   protected void onDrag(double mouseX, double mouseY, double dragX, double dragY) {
   }

   @Override
   public boolean mouseClicked(double mouseX, double mouseY, int button) {
      if (this.active && this.visible && this.isValidClickButton(button)) {
         if (this.clicked(mouseX, mouseY)) {
            this.playDownSound(Minecraft.getInstance().getSoundManager());
            this.onClick(mouseX, mouseY);
            return true;
         }
      }
      return false;
   }

   @Override
   public boolean mouseReleased(double mouseX, double mouseY, int button) {
      if (this.isValidClickButton(button)) {
         this.onRelease(mouseX, mouseY);
         return true;
      }
      return false;
   }

   protected boolean isValidClickButton(int button) {
      return button == 0;
   }

   @Override
   public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
      if (this.isValidClickButton(button)) {
         this.onDrag(mouseX, mouseY, dragX, dragY);
         return true;
      }
      return false;
   }

   protected boolean clicked(double mouseX, double mouseY) {
      return this.active && this.visible && mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
   }

   public boolean isHoveredOrFocused() {
      return this.isHovered || this.focused;
   }

   @Override
   public boolean changeFocus(boolean forward) {
      if (this.active && this.visible) {
         this.focused = !this.focused;
         this.onFocusedChanged(this.focused);
         return this.focused;
      }
      return false;
   }

   protected void onFocusedChanged(boolean focused) {
   }

   @Override
   public boolean isMouseOver(double mouseX, double mouseY) {
      return this.active && this.visible && mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
   }

   @Override
   public void updateNarration(NarrationElementOutput output) {
      output.add(NarratedElementType.TITLE, this.getMessage());
   }

   @Override
   public Component getMessage() {
      return this.message;
   }

   public void setMessage(Component message) {
      this.message = message;
   }

   public void playDownSound(SoundManager manager) {
      manager.play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 1.0F));
   }

   @Override
   public void setFocused(boolean focused) {
      this.focused = focused;
      this.onFocusedChanged(focused);
   }


   @Override
   public boolean isFocused() {
      return this.focused;
   }

   protected int getFGColor() {
      return 14737632;
   }
}
*/