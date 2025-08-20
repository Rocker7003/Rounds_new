package net.mcreator.roundsnew.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.mcreator.roundsnew.RoundsNewMod;
import net.mcreator.roundsnew.network.CardsselectButtonMessage;
import net.mcreator.roundsnew.procedures.Cardg110Procedure;
import net.mcreator.roundsnew.procedures.Cardg111Procedure;
import net.mcreator.roundsnew.procedures.Cardg112Procedure;
import net.mcreator.roundsnew.procedures.Cardg113Procedure;
import net.mcreator.roundsnew.procedures.Cardg114Procedure;
import net.mcreator.roundsnew.procedures.Cardg115Procedure;
import net.mcreator.roundsnew.procedures.Cardg116Procedure;
import net.mcreator.roundsnew.procedures.Cardg117Procedure;
import net.mcreator.roundsnew.procedures.Cardg118Procedure;
import net.mcreator.roundsnew.procedures.Cardg119Procedure;
import net.mcreator.roundsnew.procedures.Cardg11Procedure;
import net.mcreator.roundsnew.procedures.Cardg120Procedure;
import net.mcreator.roundsnew.procedures.Cardg121Procedure;
import net.mcreator.roundsnew.procedures.Cardg122Procedure;
import net.mcreator.roundsnew.procedures.Cardg123Procedure;
import net.mcreator.roundsnew.procedures.Cardg124Procedure;
import net.mcreator.roundsnew.procedures.Cardg125Procedure;
import net.mcreator.roundsnew.procedures.Cardg126Procedure;
import net.mcreator.roundsnew.procedures.Cardg127Procedure;
import net.mcreator.roundsnew.procedures.Cardg128Procedure;
import net.mcreator.roundsnew.procedures.Cardg129Procedure;
import net.mcreator.roundsnew.procedures.Cardg12Procedure;
import net.mcreator.roundsnew.procedures.Cardg130Procedure;
import net.mcreator.roundsnew.procedures.Cardg131Procedure;
import net.mcreator.roundsnew.procedures.Cardg132Procedure;
import net.mcreator.roundsnew.procedures.Cardg133Procedure;
import net.mcreator.roundsnew.procedures.Cardg134Procedure;
import net.mcreator.roundsnew.procedures.Cardg135Procedure;
import net.mcreator.roundsnew.procedures.Cardg136Procedure;
import net.mcreator.roundsnew.procedures.Cardg137Procedure;
import net.mcreator.roundsnew.procedures.Cardg138Procedure;
import net.mcreator.roundsnew.procedures.Cardg139Procedure;
import net.mcreator.roundsnew.procedures.Cardg13Procedure;
import net.mcreator.roundsnew.procedures.Cardg140Procedure;
import net.mcreator.roundsnew.procedures.Cardg141Procedure;
import net.mcreator.roundsnew.procedures.Cardg142Procedure;
import net.mcreator.roundsnew.procedures.Cardg143Procedure;
import net.mcreator.roundsnew.procedures.Cardg14Procedure;
import net.mcreator.roundsnew.procedures.Cardg15Procedure;
import net.mcreator.roundsnew.procedures.Cardg16Procedure;
import net.mcreator.roundsnew.procedures.Cardg17Procedure;
import net.mcreator.roundsnew.procedures.Cardg18Procedure;
import net.mcreator.roundsnew.procedures.Cardg19Procedure;
import net.mcreator.roundsnew.procedures.Cardg210Procedure;
import net.mcreator.roundsnew.procedures.Cardg211Procedure;
import net.mcreator.roundsnew.procedures.Cardg212Procedure;
import net.mcreator.roundsnew.procedures.Cardg213Procedure;
import net.mcreator.roundsnew.procedures.Cardg214Procedure;
import net.mcreator.roundsnew.procedures.Cardg215Procedure;
import net.mcreator.roundsnew.procedures.Cardg216Procedure;
import net.mcreator.roundsnew.procedures.Cardg217Procedure;
import net.mcreator.roundsnew.procedures.Cardg218Procedure;
import net.mcreator.roundsnew.procedures.Cardg219Procedure;
import net.mcreator.roundsnew.procedures.Cardg21Procedure;
import net.mcreator.roundsnew.procedures.Cardg220Procedure;
import net.mcreator.roundsnew.procedures.Cardg221Procedure;
import net.mcreator.roundsnew.procedures.Cardg222Procedure;
import net.mcreator.roundsnew.procedures.Cardg223Procedure;
import net.mcreator.roundsnew.procedures.Cardg224Procedure;
import net.mcreator.roundsnew.procedures.Cardg225Procedure;
import net.mcreator.roundsnew.procedures.Cardg226Procedure;
import net.mcreator.roundsnew.procedures.Cardg227Procedure;
import net.mcreator.roundsnew.procedures.Cardg228Procedure;
import net.mcreator.roundsnew.procedures.Cardg229Procedure;
import net.mcreator.roundsnew.procedures.Cardg22Procedure;
import net.mcreator.roundsnew.procedures.Cardg230Procedure;
import net.mcreator.roundsnew.procedures.Cardg231Procedure;
import net.mcreator.roundsnew.procedures.Cardg232Procedure;
import net.mcreator.roundsnew.procedures.Cardg233Procedure;
import net.mcreator.roundsnew.procedures.Cardg234Procedure;
import net.mcreator.roundsnew.procedures.Cardg235Procedure;
import net.mcreator.roundsnew.procedures.Cardg236Procedure;
import net.mcreator.roundsnew.procedures.Cardg237Procedure;
import net.mcreator.roundsnew.procedures.Cardg238Procedure;
import net.mcreator.roundsnew.procedures.Cardg239Procedure;
import net.mcreator.roundsnew.procedures.Cardg23Procedure;
import net.mcreator.roundsnew.procedures.Cardg240Procedure;
import net.mcreator.roundsnew.procedures.Cardg241Procedure;
import net.mcreator.roundsnew.procedures.Cardg242Procedure;
import net.mcreator.roundsnew.procedures.Cardg243Procedure;
import net.mcreator.roundsnew.procedures.Cardg24Procedure;
import net.mcreator.roundsnew.procedures.Cardg25Procedure;
import net.mcreator.roundsnew.procedures.Cardg26Procedure;
import net.mcreator.roundsnew.procedures.Cardg27Procedure;
import net.mcreator.roundsnew.procedures.Cardg28Procedure;
import net.mcreator.roundsnew.procedures.Cardg29Procedure;
import net.mcreator.roundsnew.procedures.Cardg310Procedure;
import net.mcreator.roundsnew.procedures.Cardg311Procedure;
import net.mcreator.roundsnew.procedures.Cardg312Procedure;
import net.mcreator.roundsnew.procedures.Cardg313Procedure;
import net.mcreator.roundsnew.procedures.Cardg314Procedure;
import net.mcreator.roundsnew.procedures.Cardg315Procedure;
import net.mcreator.roundsnew.procedures.Cardg316Procedure;
import net.mcreator.roundsnew.procedures.Cardg317Procedure;
import net.mcreator.roundsnew.procedures.Cardg318Procedure;
import net.mcreator.roundsnew.procedures.Cardg319Procedure;
import net.mcreator.roundsnew.procedures.Cardg31Procedure;
import net.mcreator.roundsnew.procedures.Cardg320Procedure;
import net.mcreator.roundsnew.procedures.Cardg321Procedure;
import net.mcreator.roundsnew.procedures.Cardg322Procedure;
import net.mcreator.roundsnew.procedures.Cardg323Procedure;
import net.mcreator.roundsnew.procedures.Cardg324Procedure;
import net.mcreator.roundsnew.procedures.Cardg325Procedure;
import net.mcreator.roundsnew.procedures.Cardg326Procedure;
import net.mcreator.roundsnew.procedures.Cardg327Procedure;
import net.mcreator.roundsnew.procedures.Cardg328Procedure;
import net.mcreator.roundsnew.procedures.Cardg329Procedure;
import net.mcreator.roundsnew.procedures.Cardg32Procedure;
import net.mcreator.roundsnew.procedures.Cardg330Procedure;
import net.mcreator.roundsnew.procedures.Cardg331Procedure;
import net.mcreator.roundsnew.procedures.Cardg332Procedure;
import net.mcreator.roundsnew.procedures.Cardg333Procedure;
import net.mcreator.roundsnew.procedures.Cardg334Procedure;
import net.mcreator.roundsnew.procedures.Cardg335Procedure;
import net.mcreator.roundsnew.procedures.Cardg336Procedure;
import net.mcreator.roundsnew.procedures.Cardg337Procedure;
import net.mcreator.roundsnew.procedures.Cardg338Procedure;
import net.mcreator.roundsnew.procedures.Cardg339Procedure;
import net.mcreator.roundsnew.procedures.Cardg33Procedure;
import net.mcreator.roundsnew.procedures.Cardg340Procedure;
import net.mcreator.roundsnew.procedures.Cardg341Procedure;
import net.mcreator.roundsnew.procedures.Cardg342Procedure;
import net.mcreator.roundsnew.procedures.Cardg343Procedure;
import net.mcreator.roundsnew.procedures.Cardg34Procedure;
import net.mcreator.roundsnew.procedures.Cardg35Procedure;
import net.mcreator.roundsnew.procedures.Cardg36Procedure;
import net.mcreator.roundsnew.procedures.Cardg37Procedure;
import net.mcreator.roundsnew.procedures.Cardg38Procedure;
import net.mcreator.roundsnew.procedures.Cardg39Procedure;
import net.mcreator.roundsnew.procedures.Cardg410Procedure;
import net.mcreator.roundsnew.procedures.Cardg411Procedure;
import net.mcreator.roundsnew.procedures.Cardg412Procedure;
import net.mcreator.roundsnew.procedures.Cardg413Procedure;
import net.mcreator.roundsnew.procedures.Cardg414Procedure;
import net.mcreator.roundsnew.procedures.Cardg415Procedure;
import net.mcreator.roundsnew.procedures.Cardg416Procedure;
import net.mcreator.roundsnew.procedures.Cardg417Procedure;
import net.mcreator.roundsnew.procedures.Cardg418Procedure;
import net.mcreator.roundsnew.procedures.Cardg419Procedure;
import net.mcreator.roundsnew.procedures.Cardg41Procedure;
import net.mcreator.roundsnew.procedures.Cardg420Procedure;
import net.mcreator.roundsnew.procedures.Cardg421Procedure;
import net.mcreator.roundsnew.procedures.Cardg422Procedure;
import net.mcreator.roundsnew.procedures.Cardg423Procedure;
import net.mcreator.roundsnew.procedures.Cardg424Procedure;
import net.mcreator.roundsnew.procedures.Cardg425Procedure;
import net.mcreator.roundsnew.procedures.Cardg426Procedure;
import net.mcreator.roundsnew.procedures.Cardg427Procedure;
import net.mcreator.roundsnew.procedures.Cardg428Procedure;
import net.mcreator.roundsnew.procedures.Cardg429Procedure;
import net.mcreator.roundsnew.procedures.Cardg42Procedure;
import net.mcreator.roundsnew.procedures.Cardg430Procedure;
import net.mcreator.roundsnew.procedures.Cardg431Procedure;
import net.mcreator.roundsnew.procedures.Cardg432Procedure;
import net.mcreator.roundsnew.procedures.Cardg433Procedure;
import net.mcreator.roundsnew.procedures.Cardg434Procedure;
import net.mcreator.roundsnew.procedures.Cardg435Procedure;
import net.mcreator.roundsnew.procedures.Cardg436Procedure;
import net.mcreator.roundsnew.procedures.Cardg437Procedure;
import net.mcreator.roundsnew.procedures.Cardg438Procedure;
import net.mcreator.roundsnew.procedures.Cardg439Procedure;
import net.mcreator.roundsnew.procedures.Cardg43Procedure;
import net.mcreator.roundsnew.procedures.Cardg440Procedure;
import net.mcreator.roundsnew.procedures.Cardg441Procedure;
import net.mcreator.roundsnew.procedures.Cardg442Procedure;
import net.mcreator.roundsnew.procedures.Cardg443Procedure;
import net.mcreator.roundsnew.procedures.Cardg44Procedure;
import net.mcreator.roundsnew.procedures.Cardg45Procedure;
import net.mcreator.roundsnew.procedures.Cardg46Procedure;
import net.mcreator.roundsnew.procedures.Cardg47Procedure;
import net.mcreator.roundsnew.procedures.Cardg48Procedure;
import net.mcreator.roundsnew.procedures.Cardg49Procedure;
import net.mcreator.roundsnew.procedures.Cardg510Procedure;
import net.mcreator.roundsnew.procedures.Cardg511Procedure;
import net.mcreator.roundsnew.procedures.Cardg512Procedure;
import net.mcreator.roundsnew.procedures.Cardg513Procedure;
import net.mcreator.roundsnew.procedures.Cardg514Procedure;
import net.mcreator.roundsnew.procedures.Cardg515Procedure;
import net.mcreator.roundsnew.procedures.Cardg516Procedure;
import net.mcreator.roundsnew.procedures.Cardg517Procedure;
import net.mcreator.roundsnew.procedures.Cardg518Procedure;
import net.mcreator.roundsnew.procedures.Cardg519Procedure;
import net.mcreator.roundsnew.procedures.Cardg51Procedure;
import net.mcreator.roundsnew.procedures.Cardg520Procedure;
import net.mcreator.roundsnew.procedures.Cardg521Procedure;
import net.mcreator.roundsnew.procedures.Cardg522Procedure;
import net.mcreator.roundsnew.procedures.Cardg523Procedure;
import net.mcreator.roundsnew.procedures.Cardg524Procedure;
import net.mcreator.roundsnew.procedures.Cardg525Procedure;
import net.mcreator.roundsnew.procedures.Cardg526Procedure;
import net.mcreator.roundsnew.procedures.Cardg527Procedure;
import net.mcreator.roundsnew.procedures.Cardg528Procedure;
import net.mcreator.roundsnew.procedures.Cardg529Procedure;
import net.mcreator.roundsnew.procedures.Cardg52Procedure;
import net.mcreator.roundsnew.procedures.Cardg530Procedure;
import net.mcreator.roundsnew.procedures.Cardg531Procedure;
import net.mcreator.roundsnew.procedures.Cardg532Procedure;
import net.mcreator.roundsnew.procedures.Cardg533Procedure;
import net.mcreator.roundsnew.procedures.Cardg534Procedure;
import net.mcreator.roundsnew.procedures.Cardg535Procedure;
import net.mcreator.roundsnew.procedures.Cardg536Procedure;
import net.mcreator.roundsnew.procedures.Cardg537Procedure;
import net.mcreator.roundsnew.procedures.Cardg538Procedure;
import net.mcreator.roundsnew.procedures.Cardg539Procedure;
import net.mcreator.roundsnew.procedures.Cardg53Procedure;
import net.mcreator.roundsnew.procedures.Cardg540Procedure;
import net.mcreator.roundsnew.procedures.Cardg541Procedure;
import net.mcreator.roundsnew.procedures.Cardg542Procedure;
import net.mcreator.roundsnew.procedures.Cardg543Procedure;
import net.mcreator.roundsnew.procedures.Cardg54Procedure;
import net.mcreator.roundsnew.procedures.Cardg55Procedure;
import net.mcreator.roundsnew.procedures.Cardg56Procedure;
import net.mcreator.roundsnew.procedures.Cardg57Procedure;
import net.mcreator.roundsnew.procedures.Cardg58Procedure;
import net.mcreator.roundsnew.procedures.Cardg59Procedure;
import net.mcreator.roundsnew.world.inventory.CardsselectMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class CardsselectScreen extends AbstractContainerScreen<CardsselectMenu> {
   private static final HashMap<String, Object> guistate = CardsselectMenu.guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   ImageButton imagebutton_aa;
   ImageButton imagebutton_aa1;
   ImageButton imagebutton_aa2;
   ImageButton imagebutton_aa3;
   ImageButton imagebutton_aa4;
   private static final ResourceLocation texture = ResourceLocation.parse("rounds_new:textures/screens/cardsselect.png");

   public CardsselectScreen(CardsselectMenu container, Inventory inventory, Component text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.imageWidth = 0;
      this.imageHeight = 0;
   }

   public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
      this.renderBackground(guiGraphics);
      super.render(guiGraphics, mouseX, mouseY, partialTicks);
      this.renderTooltip(guiGraphics, mouseX, mouseY);
   }

   protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      guiGraphics.blit(texture, this.leftPos, this.topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
      if (Cardg51Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card1.png"), this.leftPos + 131, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg41Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card1.png"), this.leftPos + 46, this.topPos + -67, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg31Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card1.png"), this.leftPos + -38, this.topPos + -76, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg21Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card1.png"), this.leftPos + -124, this.topPos + -67, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg11Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card1.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg12Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card2.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg22Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card2.png"), this.leftPos + -124, this.topPos + -67, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg32Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card2.png"), this.leftPos + -38, this.topPos + -76, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg42Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card2.png"), this.leftPos + 46, this.topPos + -67, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg52Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card2.png"), this.leftPos + 131, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg13Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card3.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg23Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card3.png"), this.leftPos + -124, this.topPos + -67, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg33Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card3.png"), this.leftPos + -38, this.topPos + -76, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg43Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card3.png"), this.leftPos + 46, this.topPos + -67, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg53Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card3.png"), this.leftPos + 131, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg14Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card4.png"), this.leftPos + -209, this.topPos + -57, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg24Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card4.png"), this.leftPos + -124, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg34Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card4.png"), this.leftPos + -38, this.topPos + -75, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg44Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card4.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg54Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card4.png"), this.leftPos + 131, this.topPos + -57, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg15Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card5.png"), this.leftPos + -209, this.topPos + -57, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg25Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card5.png"), this.leftPos + -124, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg35Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card5.png"), this.leftPos + -38, this.topPos + -75, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg45Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card5.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg55Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card5.png"), this.leftPos + 131, this.topPos + -57, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg16Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card6.png"), this.leftPos + -209, this.topPos + -57, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg26Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card6.png"), this.leftPos + -124, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg36Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card6.png"), this.leftPos + -38, this.topPos + -75, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg46Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card6.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg56Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card6.png"), this.leftPos + 131, this.topPos + -57, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg17Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card7.png"), this.leftPos + -209, this.topPos + -57, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg27Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card7.png"), this.leftPos + -124, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg37Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card7.png"), this.leftPos + -38, this.topPos + -75, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg47Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card7.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg57Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card7.png"), this.leftPos + 131, this.topPos + -57, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg18Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card8.png"), this.leftPos + -209, this.topPos + -56, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg28Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card8.png"), this.leftPos + -124, this.topPos + -65, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg38Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card8.png"), this.leftPos + -38, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg48Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card8.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg58Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card8.png"), this.leftPos + 131, this.topPos + -56, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg19Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card9.png"), this.leftPos + -209, this.topPos + -56, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg29Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card9.png"), this.leftPos + -124, this.topPos + -65, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg39Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card9.png"), this.leftPos + -38, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg49Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card9.png"), this.leftPos + 46, this.topPos + -65, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg59Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card9.png"), this.leftPos + 131, this.topPos + -56, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg110Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card10.png"), this.leftPos + -209, this.topPos + -56, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg210Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card10.png"), this.leftPos + -124, this.topPos + -65, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg310Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card10.png"), this.leftPos + -38, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg410Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card10.png"), this.leftPos + 46, this.topPos + -65, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg510Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card10.png"), this.leftPos + 131, this.topPos + -56, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg111Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card11.png"), this.leftPos + -209, this.topPos + -56, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg211Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card11.png"), this.leftPos + -124, this.topPos + -65, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg311Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card11.png"), this.leftPos + -38, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg411Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card11.png"), this.leftPos + 46, this.topPos + -65, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg511Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card11.png"), this.leftPos + 131, this.topPos + -56, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg112Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card12.png"), this.leftPos + -210, this.topPos + -56, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg212Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card12.png"), this.leftPos + -125, this.topPos + -65, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg312Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card12.png"), this.leftPos + -38, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg412Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card12.png"), this.leftPos + 46, this.topPos + -65, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg512Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card12.png"), this.leftPos + 131, this.topPos + -56, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg113Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card13.png"), this.leftPos + -210, this.topPos + -56, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg213Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card13.png"), this.leftPos + -125, this.topPos + -65, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg313Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card13.png"), this.leftPos + -38, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg413Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card13.png"), this.leftPos + 46, this.topPos + -65, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg513Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card13.png"), this.leftPos + 131, this.topPos + -56, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg114Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card14.png"), this.leftPos + -210, this.topPos + -57, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg214Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card14.png"), this.leftPos + -125, this.topPos + -65, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg314Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card14.png"), this.leftPos + -38, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg414Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card14.png"), this.leftPos + 46, this.topPos + -65, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg514Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card14.png"), this.leftPos + 131, this.topPos + -56, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg115Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card15.png"), this.leftPos + -210, this.topPos + -56, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg215Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card15.png"), this.leftPos + -124, this.topPos + -65, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg315Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card15.png"), this.leftPos + -38, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg415Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card15.png"), this.leftPos + 47, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg515Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card15.png"), this.leftPos + 131, this.topPos + -56, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg116Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card16.png"), this.leftPos + -210, this.topPos + -57, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg216Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card16.png"), this.leftPos + -124, this.topPos + -65, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg316Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card16.png"), this.leftPos + -38, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg416Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card16.png"), this.leftPos + 46, this.topPos + -65, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg516Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card16.png"), this.leftPos + 131, this.topPos + -56, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg117Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card17.png"), this.leftPos + -210, this.topPos + -57, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg217Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card17.png"), this.leftPos + -124, this.topPos + -65, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg317Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card17.png"), this.leftPos + -38, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg417Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card17.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg517Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card17.png"), this.leftPos + 131, this.topPos + -57, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg118Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card18.png"), this.leftPos + -210, this.topPos + -57, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg218Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card18.png"), this.leftPos + -124, this.topPos + -65, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg318Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card18.png"), this.leftPos + -38, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg418Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card18.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg518Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card18.png"), this.leftPos + 131, this.topPos + -57, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg119Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card19.png"), this.leftPos + -210, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg219Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card19.png"), this.leftPos + -124, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg319Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card19.png"), this.leftPos + -38, this.topPos + -75, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg419Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card19.png"), this.leftPos + 46, this.topPos + -67, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg519Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card19.png"), this.leftPos + 131, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg120Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card20.png"), this.leftPos + -210, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg220Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card20.png"), this.leftPos + -124, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg320Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card20.png"), this.leftPos + -38, this.topPos + -75, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg420Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card20.png"), this.leftPos + 46, this.topPos + -67, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg520Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card20.png"), this.leftPos + 131, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg121Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card21.png"), this.leftPos + -210, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg221Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card21.png"), this.leftPos + -124, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg321Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card21.png"), this.leftPos + -38, this.topPos + -75, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg421Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card21.png"), this.leftPos + 46, this.topPos + -67, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg521Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card21.png"), this.leftPos + 131, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg122Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card22.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg222Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card22.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg322Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card22.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg422Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card22.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg522Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card22.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg123Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card23.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg223Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card23.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg323Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card23.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg423Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card23.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg523Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card23.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg124Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card24.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg224Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card24.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg324Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card24.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg424Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card24.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg524Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card24.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg125Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card25.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg225Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card25.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg325Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card25.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg425Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card25.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg525Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card25.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg126Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card26.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg226Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card26.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg326Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card26.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg426Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card26.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg526Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card26.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg127Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card27.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg227Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card27.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg327Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card27.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg427Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card27.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg527Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card27.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg128Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card28.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg228Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card28.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg328Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card28.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg428Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card28.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg528Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card28.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg129Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card29.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg229Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card29.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg329Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card29.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg429Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card29.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg529Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card29.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg130Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card30.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg230Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card30.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg330Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card30.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg430Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card30.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg530Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card30.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg131Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card31.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg231Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card31.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg331Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card31.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg431Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card31.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg531Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card31.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg132Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card32.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg232Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card32.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg332Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card32.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg432Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card32.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg532Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card32.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg133Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card33.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg233Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card33.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg333Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card33.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg433Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card33.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg533Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card33.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg134Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card34.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg234Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card34.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg334Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card34.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg434Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card34.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg534Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card34.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg135Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card35.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg235Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card35.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg335Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card35.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg435Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card35.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg535Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card35.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg136Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card36.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg236Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card36.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg336Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card36.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg436Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card36.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg536Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card36.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg137Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card37.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg237Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card37.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg337Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card37.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg437Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card37.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg537Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card37.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg138Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card38.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg238Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card38.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg338Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card38.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg438Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card38.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg538Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card38.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg139Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card39.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg239Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card39.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg339Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card39.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg439Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card39.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg539Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card39.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg140Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card40.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg240Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card40.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg340Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card40.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg440Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card40.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg540Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card40.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg141Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card41.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg241Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card41.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg341Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card41.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg441Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card41.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg541Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card41.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg142Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card42.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg242Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card42.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg342Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card42.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg442Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card42.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg542Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card42.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg143Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card43.png"), this.leftPos + -209, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg243Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card43.png"), this.leftPos + -125, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg343Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card43.png"), this.leftPos + -37, this.topPos + -74, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg443Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card43.png"), this.leftPos + 46, this.topPos + -66, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      if (Cardg543Procedure.execute(this.entity)) {
         guiGraphics.blit(ResourceLocation.parse("rounds_new:textures/screens/card43.png"), this.leftPos + 130, this.topPos + -58, 0.0F, 0.0F, 80, 125, 80, 125);
      }

      RenderSystem.disableBlend();
   }

   public boolean keyPressed(int key, int b, int c) {
      if (key == 256) {
         this.minecraft.player.closeContainer();
         return true;
      } else {
         return super.keyPressed(key, b, c);
      }
   }

   public void containerTick() {
      super.containerTick();
   }

   protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
   }

   public void onClose() {
      super.onClose();
   }

   public void init() {
      super.init();
      this.imagebutton_aa = new ImageButton(
         this.leftPos + -210,
         this.topPos + -55,
         80,
         120,
         0,
         0,
         120,
         ResourceLocation.parse("rounds_new:textures/screens/atlas/imagebutton_aa.png"),
         80,
         240,
         e -> {
            RoundsNewMod.PACKET_HANDLER.sendToServer(new CardsselectButtonMessage(0, this.x, this.y, this.z));
            CardsselectButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z);
         }
      );
      guistate.put("button:imagebutton_aa", this.imagebutton_aa);
      this.addRenderableWidget(this.imagebutton_aa);
      this.imagebutton_aa1 = new ImageButton(
         this.leftPos + -124,
         this.topPos + -65,
         80,
         120,
         0,
         0,
         120,
         ResourceLocation.parse("rounds_new:textures/screens/atlas/imagebutton_aa1.png"),
         80,
         240,
         e -> {
            RoundsNewMod.PACKET_HANDLER.sendToServer(new CardsselectButtonMessage(1, this.x, this.y, this.z));
            CardsselectButtonMessage.handleButtonAction(this.entity, 1, this.x, this.y, this.z);
         }
      );
      guistate.put("button:imagebutton_aa1", this.imagebutton_aa1);
      this.addRenderableWidget(this.imagebutton_aa1);
      this.imagebutton_aa2 = new ImageButton(
         this.leftPos + -38,
         this.topPos + -73,
         80,
         120,
         0,
         0,
         120,
         ResourceLocation.parse("rounds_new:textures/screens/atlas/imagebutton_aa2.png"),
         80,
         240,
         e -> {
            RoundsNewMod.PACKET_HANDLER.sendToServer(new CardsselectButtonMessage(2, this.x, this.y, this.z));
            CardsselectButtonMessage.handleButtonAction(this.entity, 2, this.x, this.y, this.z);
         }
      );
      guistate.put("button:imagebutton_aa2", this.imagebutton_aa2);
      this.addRenderableWidget(this.imagebutton_aa2);
      this.imagebutton_aa3 = new ImageButton(
         this.leftPos + 47,
         this.topPos + -64,
         80,
         120,
         0,
         0,
         120,
         ResourceLocation.parse("rounds_new:textures/screens/atlas/imagebutton_aa3.png"),
         80,
         240,
         e -> {
            RoundsNewMod.PACKET_HANDLER.sendToServer(new CardsselectButtonMessage(3, this.x, this.y, this.z));
            CardsselectButtonMessage.handleButtonAction(this.entity, 3, this.x, this.y, this.z);
         }
      );
      guistate.put("button:imagebutton_aa3", this.imagebutton_aa3);
      this.addRenderableWidget(this.imagebutton_aa3);
      this.imagebutton_aa4 = new ImageButton(
         this.leftPos + 132,
         this.topPos + -54,
         80,
         120,
         0,
         0,
         120,
         ResourceLocation.parse("rounds_new:textures/screens/atlas/imagebutton_aa4.png"),
         80,
         240,
         e -> {
            RoundsNewMod.PACKET_HANDLER.sendToServer(new CardsselectButtonMessage(4, this.x, this.y, this.z));
            CardsselectButtonMessage.handleButtonAction(this.entity, 4, this.x, this.y, this.z);
         }
      );
      guistate.put("button:imagebutton_aa4", this.imagebutton_aa4);
      this.addRenderableWidget(this.imagebutton_aa4);
   }
}
