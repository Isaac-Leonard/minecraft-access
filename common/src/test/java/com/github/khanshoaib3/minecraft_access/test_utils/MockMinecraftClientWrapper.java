package com.github.khanshoaib3.minecraft_access.test_utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;

/**
 * Reusable mock Minecraft Client for testing.
 * Based on Mockito, we can make use of Mockito's techniques,
 * but with this additional layer of wrap, we can easily write and reuse our own custom logic.
 */
public class MockMinecraftClientWrapper {

    private final MinecraftClient mockitoClient;

    public MockMinecraftClientWrapper() {
        mockitoClient = Mockito.mock(MinecraftClient.class);
    }

    public MinecraftClient mockito() {
        return mockitoClient;
    }

    public void verifyOpeningMenuOf(Class<? extends Screen> screenClass) {
        Mockito.verify(mockitoClient, Mockito.times(1)
                .description("the menu should be opened"))
                .setScreen(any(screenClass));
    }

    public Screen setScreen(Class<? extends Screen> screenClass) {
        Screen screen = Mockito.mock(screenClass);
        mockitoClient.currentScreen = screen;
        return screen;
    }

    public void verifyClosingMenu() {
        Mockito.verify(mockitoClient.currentScreen, Mockito.times(1)
                .description("the menu should be closed"))
                .close();
    }
}
