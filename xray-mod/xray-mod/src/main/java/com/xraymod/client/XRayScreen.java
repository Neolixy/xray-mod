package com.xraymod.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class XRayScreen extends Screen {

    public XRayScreen() {
        super(Text.literal("X-Ray Panel"));
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        // Toggle X-Ray button
        this.addDrawableChild(ButtonWidget.builder(
                Text.literal(XRayMod.xrayEnabled ? "§aX-Ray: ON" : "§cX-Ray: OFF"),
                button -> {
                    XRayMod.xrayEnabled = !XRayMod.xrayEnabled;
                    button.setMessage(Text.literal(XRayMod.xrayEnabled ? "§aX-Ray: ON" : "§cX-Ray: OFF"));
                }
        ).dimensions(centerX - 75, centerY - 10, 150, 20).build());

        // Close button
        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("Fermer"),
                button -> this.close()
        ).dimensions(centerX - 50, centerY + 20, 100, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Background semi-transparent
        context.fill(this.width / 2 - 100, this.height / 2 - 40,
                this.width / 2 + 100, this.height / 2 + 50, 0xAA000000);

        // Title
        context.drawCenteredTextWithShadow(this.textRenderer,
                Text.literal("§6§l✦ X-Ray Mod ✦"),
                this.width / 2, this.height / 2 - 30, 0xFFFFFF);

        // Status
        String status = XRayMod.xrayEnabled ? "§aActif" : "§cInactif";
        context.drawCenteredTextWithShadow(this.textRenderer,
                Text.literal("Statut: " + status),
                this.width / 2, this.height / 2 - 18, 0xFFFFFF);

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
