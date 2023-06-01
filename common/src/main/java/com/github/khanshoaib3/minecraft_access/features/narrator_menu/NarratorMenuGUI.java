package com.github.khanshoaib3.minecraft_access.features.narrator_menu;

import com.github.khanshoaib3.minecraft_access.MainClass;
import com.github.khanshoaib3.minecraft_access.config.Config;
import com.github.khanshoaib3.minecraft_access.features.ScreenshotDescription;
import com.github.khanshoaib3.minecraft_access.screen_reader.ScreenReaderController;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

/**
 * GUI screen for the narrator menu.
 */
public class NarratorMenuGUI extends Screen {
    int centerX;
    int buttonHeight;
    int marginY;
    int calculatedYPosition;
    int leftColumnX;
    int rightColumnX;
    boolean shouldRenderInLeftColumn;

    public NarratorMenuGUI(String title) {
        super(Text.of(I18n.translate("minecraft_access.gui.screen." + title)));
    }

    @Override
    protected void init() {
        this.centerX = this.width / 2;
        this.buttonHeight = 20;
        this.marginY = buttonHeight + buttonHeight / 4;
        this.calculatedYPosition = this.height / 6 - marginY; // Starting Y position (marginY will again be added in buildButtonWidget() so it is subtracted here to equate)
        this.leftColumnX = 10;
        this.rightColumnX = centerX + 10;
        shouldRenderInLeftColumn = true;


        ButtonWidget blockAndFluidTargetInformationButton = this.buildButtonWidget("minecraft_access.narrator_menu.gui.button.block_and_fluid_target_info",
                (button) -> NarratorMenu.getBlockAndFluidTargetInformation());
        this.addDrawableChild(blockAndFluidTargetInformationButton);

        ButtonWidget blockAndFluidTargetPositionButton = this.buildButtonWidget("minecraft_access.narrator_menu.gui.button.block_and_fluid_target_position",
                (button) -> NarratorMenu.getBlockAndFluidTargetPosition());
        this.addDrawableChild(blockAndFluidTargetPositionButton);

        ButtonWidget lightLevelButton = this.buildButtonWidget("minecraft_access.narrator_menu.gui.button.light_level",
                (button) -> NarratorMenu.getLightLevel());
        this.addDrawableChild(lightLevelButton);

        ButtonWidget findWaterButton = this.buildButtonWidget("minecraft_access.narrator_menu.gui.button.find_water",
                (button) -> MainClass.fluidDetector.findClosestWaterSource(true));
        this.addDrawableChild(findWaterButton);

        ButtonWidget findLavaButton = this.buildButtonWidget("minecraft_access.narrator_menu.gui.button.find_lava",
                (button) -> MainClass.fluidDetector.findClosestLavaSource(true));
        this.addDrawableChild(findLavaButton);

        ButtonWidget biomeButton = this.buildButtonWidget("minecraft_access.narrator_menu.gui.button.biome",
                (button) -> NarratorMenu.getBiome());
        this.addDrawableChild(biomeButton);

        ButtonWidget timeOfDayButton = this.buildButtonWidget("minecraft_access.narrator_menu.gui.button.time_of_day",
                (button) -> NarratorMenu.getTimeOfDay());
        this.addDrawableChild(timeOfDayButton);

        ButtonWidget xpButton = this.buildButtonWidget("minecraft_access.narrator_menu.gui.button.xp",
                (button) -> NarratorMenu.getXP());
        this.addDrawableChild(xpButton);

        ButtonWidget refreshScreenReaderButton = this.buildButtonWidget("minecraft_access.narrator_menu.gui.button.refresh_screen_reader",
                (button) -> ScreenReaderController.refreshScreenReader(true));
        this.addDrawableChild(refreshScreenReaderButton);

        ButtonWidget refreshConfigButton = this.buildButtonWidget("minecraft_access.narrator_menu.gui.button.refresh_config",
                (button) -> Config.refresh(true));
        this.addDrawableChild(refreshConfigButton);

        ButtonWidget screenshotAIButton = this.buildButtonWidget("Scan",
                (button) -> ScreenshotDescription.initialize());
        this.addDrawableChild(screenshotAIButton);
    }

    private ButtonWidget buildButtonWidget(String translationKey, ButtonWidget.PressAction pressAction) {
        int calculatedButtonWidth = this.textRenderer.getWidth(I18n.translate((translationKey))) + 35;
        if (shouldRenderInLeftColumn) calculatedYPosition += marginY;
        shouldRenderInLeftColumn = !shouldRenderInLeftColumn;

        return ButtonWidget.builder(Text.translatable(translationKey), pressAction)
                .dimensions((shouldRenderInLeftColumn) ? leftColumnX : rightColumnX, calculatedYPosition, calculatedButtonWidth, buttonHeight)
                .build();
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        DrawableHelper.drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }
}