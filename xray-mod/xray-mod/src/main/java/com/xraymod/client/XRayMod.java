package com.xraymod.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class XRayMod implements ClientModInitializer {

    public static boolean xrayEnabled = false;
    private static KeyBinding xrayKey;
    private static boolean wasPressed = false;

    @Override
    public void onInitializeClient() {
        xrayKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.xraymod.open",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_LEFT_ALT,
                "category.xraymod"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            boolean isPressed = xrayKey.isPressed();
            if (isPressed && !wasPressed) {
                if (client.currentScreen == null) {
                    client.setScreen(new XRayScreen());
                }
            }
            wasPressed = isPressed;
        });
    }
}
