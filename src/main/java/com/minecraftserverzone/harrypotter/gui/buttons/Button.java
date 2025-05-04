package com.minecraftserverzone.harrypotter.gui.buttons;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarratedElementType;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Consumer;

@OnlyIn(Dist.CLIENT)
public class Button extends AbstractWidget {
   public static final OnTooltip NO_TOOLTIP = (button, graphics, mouseX, mouseY) -> {};
   protected final OnPress onPress;
   protected final OnTooltip onTooltip;

   private static final ResourceLocation BUTTON_TEXTURE = new ResourceLocation("minecraft", "textures/gui/widgets.png");

   public Button(int x, int y, int width, int height, Component message, OnPress onPress, boolean enoughexp) {
      this(x, y, width, height, message, onPress, NO_TOOLTIP, enoughexp);
   }

   public Button(int x, int y, int width, int height, Component message, OnPress onPress, OnTooltip onTooltip, boolean enoughexp) {
      super(x, y, width, height, message);
      this.onPress = onPress;
      this.onTooltip = onTooltip;
      this.active = enoughexp;
   }

   @Override
   public void onClick(double mouseX, double mouseY) {
      this.onPress.onPress(this);
   }

   @Override
   protected void renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
      int textureY = this.getYImage(this.isHoveredOrFocused());
      int textureX = 0;

      graphics.setColor(1.0F, 1.0F, 1.0F, this.alpha);
      graphics.blit(BUTTON_TEXTURE, this.getX(), this.getY(), textureX+1, textureY-1, this.width-1, this.height-1, 256, 256);
      graphics.blit(BUTTON_TEXTURE, this.getX()+1, this.getY()+1, 200 - this.width + 1, textureY+8, this.width-2, this.height-2, 256, 256);

      int textColor = this.active ? 0xFFFFFF : 0xA0A0A0;
      //drawCenteredString(graphics, this.getFont(), this.getMessage(), this.getX() + this.width / 2, this.getY() + (this.height - 8) / 2, textColor);

      graphics.drawCenteredString(
              Minecraft.getInstance().font,
              this.getMessage(),
              this.getX() + this.width / 2,
              this.getY() + (this.height - 8) / 2,
              textColor
      );

      if (this.isHoveredOrFocused()) {
         this.renderToolTip(graphics, mouseX, mouseY);
      }
   }

   protected int getYImage(boolean hovered) {
      if (!this.active) {
         return 48;
      } else {
         return hovered ? 88 : 68;
      }
   }

   public void renderToolTip(GuiGraphics graphics, int mouseX, int mouseY) {
      this.onTooltip.onTooltip(this, graphics, mouseX, mouseY);
   }

   @Override
   protected void updateWidgetNarration(NarrationElementOutput narration) {
      this.defaultButtonNarrationText(narration);
      this.onTooltip.narrateTooltip(component -> {
         narration.add(NarratedElementType.HINT, component);
      });
   }

   @OnlyIn(Dist.CLIENT)
   public interface OnPress {
      void onPress(Button button);
   }

   @OnlyIn(Dist.CLIENT)
   public interface OnTooltip {
      void onTooltip(Button button, GuiGraphics graphics, int mouseX, int mouseY);

      default void narrateTooltip(Consumer<Component> consumer) {}
   }
}
