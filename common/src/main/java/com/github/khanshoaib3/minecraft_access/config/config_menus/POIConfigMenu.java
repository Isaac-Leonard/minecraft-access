package com.github.khanshoaib3.minecraft_access.config.config_menus;

import com.github.khanshoaib3.minecraft_access.MainClass;
import com.github.khanshoaib3.minecraft_access.config.Config;
import com.github.khanshoaib3.minecraft_access.config.ConfigMap;
import com.github.khanshoaib3.minecraft_access.config.config_maps.POIBlocksConfigMap;
import com.github.khanshoaib3.minecraft_access.config.config_maps.POIMarkingConfigMap;
import com.github.khanshoaib3.minecraft_access.utils.BaseScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.text.Text;

import java.util.function.Function;

@SuppressWarnings("DataFlowIssue")
public class POIConfigMenu extends BaseScreen {
    public POIConfigMenu(String title, BaseScreen previousScreen) {
        super(title, previousScreen);
    }

    @Override
    protected void init() {
        super.init();

        ButtonWidget poiBlocksButton = this.buildButtonWidget("minecraft_access.gui.poi_config_menu.button.poi_blocks_button",
                (button) -> this.client.setScreen(new POIBlocksConfigMenu("poi_blocks_config_menu", this)));
        this.addDrawableChild(poiBlocksButton);

        ButtonWidget poiEntitiesButton = this.buildButtonWidget("minecraft_access.gui.poi_config_menu.button.poi_entities_button",
                (button) -> this.client.setScreen(new POIEntitiesConfigMenu("poi_entities_config_menu", this)));
        this.addDrawableChild(poiEntitiesButton);

        ButtonWidget poiLockingButton = this.buildButtonWidget("minecraft_access.gui.poi_config_menu.button.poi_locking_button",
                (button) -> this.client.setScreen(new POILockingConfigMenu("poi_locking_config_menu", this)));
        this.addDrawableChild(poiLockingButton);

        ButtonWidget poiMarkingButton = this.buildButtonWidget("minecraft_access.gui.poi_config_menu.button.poi_marking_button",
                (button) -> this.client.setScreen(new POIMarkingConfigMenu("poi_marking_config_menu", this)));
        this.addDrawableChild(poiMarkingButton);
    }
}

@SuppressWarnings("DataFlowIssue")
class POIBlocksConfigMenu extends BaseScreen {
    public POIBlocksConfigMenu(String title, BaseScreen previousScreen) {
        super(title, previousScreen);
    }

    @Override
    protected void init() {
        super.init();

        POIBlocksConfigMap initMap = POIBlocksConfigMap.getInstance();

        ButtonWidget featureToggleButton = this.buildButtonWidget("minecraft_access.gui.common.button.feature_toggle_button." + (initMap.isEnabled() ? "enabled" : "disabled"),
                (button) -> {
                    POIBlocksConfigMap map = POIBlocksConfigMap.getInstance();
                    map.setEnabled(!map.isEnabled());
                    Config.getInstance().writeJSON();
                    button.setMessage(Text.of(I18n.translate("minecraft_access.gui.common.button.feature_toggle_button." + (map.isEnabled() ? "enabled" : "disabled"))));
                });
        this.addDrawableChild(featureToggleButton);

        ButtonWidget detectFluidBlocksButton = this.buildButtonWidget(
                I18n.translate("minecraft_access.gui.common.button.toggle_button." + (initMap.isDetectFluidBlocks() ? "enabled" : "disabled"),
                        I18n.translate("minecraft_access.gui.poi_blocks_config_menu.button.detect_fluid_blocks_button")
                ),
                (button) -> {
                    POIBlocksConfigMap map = POIBlocksConfigMap.getInstance();
                    map.setDetectFluidBlocks(!map.isDetectFluidBlocks());
                    Config.getInstance().writeJSON();
                    button.setMessage(Text.of(I18n.translate("minecraft_access.gui.common.button.toggle_button." + (map.isDetectFluidBlocks() ? "enabled" : "disabled"),
                            I18n.translate("minecraft_access.gui.poi_blocks_config_menu.button.detect_fluid_blocks_button")
                    )));
                });
        this.addDrawableChild(detectFluidBlocksButton);

        ButtonWidget rangeButton = this.buildButtonWidget(
                I18n.translate("minecraft_access.gui.common.button.range", initMap.getRange()),
                (button) -> this.client.setScreen(new ValueEntryMenu("value_entry_menu", ValueEntryMenu.CONFIG_TYPE.POI_BLOCKS_RANGE, this)));
        this.addDrawableChild(rangeButton);

        ButtonWidget playSoundButton = this.buildButtonWidget("minecraft_access.gui.common.button.play_sound_toggle_button." + (initMap.isPlaySound() ? "enabled" : "disabled"),
                (button) -> {
                    POIBlocksConfigMap map = POIBlocksConfigMap.getInstance();
                    map.setPlaySound(!map.isPlaySound());
                    Config.getInstance().writeJSON();
                    button.setMessage(Text.of(I18n.translate("minecraft_access.gui.common.button.play_sound_toggle_button." + (map.isPlaySound() ? "enabled" : "disabled"))));
                });
        this.addDrawableChild(playSoundButton);

        ButtonWidget volumeButton = this.buildButtonWidget(
                I18n.translate("minecraft_access.gui.common.button.volume", initMap.getVolume()),
                (button) -> this.client.setScreen(new ValueEntryMenu("value_entry_menu", ValueEntryMenu.CONFIG_TYPE.POI_BLOCKS_VOLUME, this)));
        this.addDrawableChild(volumeButton);

        ButtonWidget playSoundForOtherBlocksButton = this.buildButtonWidget(
                I18n.translate("minecraft_access.gui.common.button.toggle_button." + (initMap.isPlaySoundForOtherBlocks() ? "enabled" : "disabled"),
                        I18n.translate("minecraft_access.gui.poi_blocks_config_menu.button.play_sound_for_other_blocks_button")
                ),
                (button) -> {
                    POIBlocksConfigMap map = POIBlocksConfigMap.getInstance();
                    map.setPlaySoundForOtherBlocks(!map.isPlaySoundForOtherBlocks());
                    Config.getInstance().writeJSON();
                    button.setMessage(Text.of(I18n.translate("minecraft_access.gui.common.button.toggle_button." + (map.isPlaySoundForOtherBlocks() ? "enabled" : "disabled"),
                            I18n.translate("minecraft_access.gui.poi_blocks_config_menu.button.play_sound_for_other_blocks_button")
                    )));
                },
                true);
        this.addDrawableChild(playSoundForOtherBlocksButton);

        ButtonWidget delayButton = this.buildButtonWidget(
                I18n.translate("minecraft_access.gui.common.button.delay", initMap.getDelay()),
                (button) -> this.client.setScreen(new ValueEntryMenu("value_entry_menu", ValueEntryMenu.CONFIG_TYPE.POI_BLOCKS_DELAY, this)));
        this.addDrawableChild(delayButton);
    }
}

@SuppressWarnings("DataFlowIssue")
class POIEntitiesConfigMenu extends BaseScreen {
    public POIEntitiesConfigMenu(String title, BaseScreen previousScreen) {
        super(title, previousScreen);
    }

    @Override
    protected void init() {
        super.init();

        ButtonWidget featureToggleButton = this.buildButtonWidget("minecraft_access.gui.common.button.feature_toggle_button." + (MainClass.config.getConfigMap().getPoiConfigMap().getEntitiesConfigMap().isEnabled() ? "enabled" : "disabled"),
                (button) -> {
                    ConfigMap configMap = MainClass.config.getConfigMap();
                    configMap.getPoiConfigMap().getEntitiesConfigMap().setEnabled(!configMap.getPoiConfigMap().getEntitiesConfigMap().isEnabled());
                    MainClass.config.setConfigMap(configMap);
                    button.setMessage(Text.of(I18n.translate("minecraft_access.gui.common.button.feature_toggle_button." + (MainClass.config.getConfigMap().getPoiConfigMap().getEntitiesConfigMap().isEnabled() ? "enabled" : "disabled"))));
                });
        this.addDrawableChild(featureToggleButton);

        ButtonWidget rangeButton = this.buildButtonWidget(
                I18n.translate("minecraft_access.gui.common.button.range",
                        MainClass.config.getConfigMap().getPoiConfigMap().getEntitiesConfigMap().getRange()),
                (button) -> this.client.setScreen(new ValueEntryMenu("value_entry_menu", ValueEntryMenu.CONFIG_TYPE.POI_ENTITIES_RANGE, this)));
        this.addDrawableChild(rangeButton);

        ButtonWidget playSoundButton = this.buildButtonWidget("minecraft_access.gui.common.button.play_sound_toggle_button." + (MainClass.config.getConfigMap().getPoiConfigMap().getEntitiesConfigMap().isPlaySound() ? "enabled" : "disabled"),
                (button) -> {
                    ConfigMap configMap = MainClass.config.getConfigMap();
                    configMap.getPoiConfigMap().getEntitiesConfigMap().setPlaySound(!configMap.getPoiConfigMap().getEntitiesConfigMap().isPlaySound());
                    MainClass.config.setConfigMap(configMap);
                    button.setMessage(Text.of(I18n.translate("minecraft_access.gui.common.button.play_sound_toggle_button." + (MainClass.config.getConfigMap().getPoiConfigMap().getEntitiesConfigMap().isPlaySound() ? "enabled" : "disabled"))));
                });
        this.addDrawableChild(playSoundButton);

        ButtonWidget volumeButton = this.buildButtonWidget(
                I18n.translate("minecraft_access.gui.common.button.volume",
                        MainClass.config.getConfigMap().getPoiConfigMap().getEntitiesConfigMap().getVolume()),
                (button) -> this.client.setScreen(new ValueEntryMenu("value_entry_menu", ValueEntryMenu.CONFIG_TYPE.POI_ENTITIES_VOLUME, this)));
        this.addDrawableChild(volumeButton);

        ButtonWidget delayButton = this.buildButtonWidget(
                I18n.translate("minecraft_access.gui.common.button.delay",
                        MainClass.config.getConfigMap().getPoiConfigMap().getEntitiesConfigMap().getDelay()),
                (button) -> this.client.setScreen(new ValueEntryMenu("value_entry_menu", ValueEntryMenu.CONFIG_TYPE.POI_ENTITIES_DELAY, this)));
        this.addDrawableChild(delayButton);
    }
}

@SuppressWarnings("DataFlowIssue")
class POILockingConfigMenu extends BaseScreen {
    public POILockingConfigMenu(String title, BaseScreen previousScreen) {
        super(title, previousScreen);
    }

    @Override
    protected void init() {
        super.init();

        ButtonWidget featureToggleButton = this.buildButtonWidget("minecraft_access.gui.common.button.feature_toggle_button." + (MainClass.config.getConfigMap().getPoiConfigMap().getLockingConfigMap().isEnabled() ? "enabled" : "disabled"),
                (button) -> {
                    ConfigMap configMap = MainClass.config.getConfigMap();
                    configMap.getPoiConfigMap().getLockingConfigMap().setEnabled(!configMap.getPoiConfigMap().getLockingConfigMap().isEnabled());
                    MainClass.config.setConfigMap(configMap);
                    button.setMessage(Text.of(I18n.translate("minecraft_access.gui.common.button.feature_toggle_button." + (MainClass.config.getConfigMap().getPoiConfigMap().getLockingConfigMap().isEnabled() ? "enabled" : "disabled"))));
                });
        this.addDrawableChild(featureToggleButton);

        ButtonWidget lockOnBlocksButton = this.buildButtonWidget(
                I18n.translate("minecraft_access.gui.common.button.toggle_button." + (MainClass.config.getConfigMap().getPoiConfigMap().getLockingConfigMap().isLockOnBlocks() ? "enabled" : "disabled"),
                        I18n.translate("minecraft_access.gui.poi_locking_config_menu.button.lock_on_blocks_button")
                ),
                (button) -> {
                    ConfigMap configMap = MainClass.config.getConfigMap();
                    configMap.getPoiConfigMap().getLockingConfigMap().setLockOnBlocks(!configMap.getPoiConfigMap().getLockingConfigMap().isLockOnBlocks());
                    MainClass.config.setConfigMap(configMap);
                    button.setMessage(Text.of(I18n.translate("minecraft_access.gui.common.button.toggle_button." + (MainClass.config.getConfigMap().getPoiConfigMap().getLockingConfigMap().isLockOnBlocks() ? "enabled" : "disabled"),
                            I18n.translate("minecraft_access.gui.poi_locking_config_menu.button.lock_on_blocks_button")
                    )));
                });
        this.addDrawableChild(lockOnBlocksButton);

        ButtonWidget speakDistanceButton = this.buildButtonWidget(
                I18n.translate("minecraft_access.gui.common.button.toggle_button." + (MainClass.config.getConfigMap().getPoiConfigMap().getLockingConfigMap().isSpeakDistance() ? "enabled" : "disabled"),
                        I18n.translate("minecraft_access.gui.poi_locking_config_menu.button.speak_distance_button")
                ),
                (button) -> {
                    ConfigMap configMap = MainClass.config.getConfigMap();
                    configMap.getPoiConfigMap().getLockingConfigMap().setSpeakDistance(!configMap.getPoiConfigMap().getLockingConfigMap().isSpeakDistance());
                    MainClass.config.setConfigMap(configMap);
                    button.setMessage(Text.of(I18n.translate("minecraft_access.gui.common.button.toggle_button." + (MainClass.config.getConfigMap().getPoiConfigMap().getLockingConfigMap().isSpeakDistance() ? "enabled" : "disabled"),
                            I18n.translate("minecraft_access.gui.poi_locking_config_menu.button.speak_distance_button")
                    )));
                },
                true);
        this.addDrawableChild(speakDistanceButton);

        ButtonWidget autoLockEyeOfEnderButton = this.buildButtonWidget(
                I18n.translate("minecraft_access.gui.common.button.toggle_button." + (MainClass.config.getConfigMap().getPoiConfigMap().getLockingConfigMap().isAutoLockEyeOfEnderEntity() ? "enabled" : "disabled"),
                        I18n.translate("minecraft_access.gui.poi_locking_config_menu.button.auto_lock_eye_of_ender_button")
                ),
                (button) -> {
                    ConfigMap configMap = MainClass.config.getConfigMap();
                    configMap.getPoiConfigMap().getLockingConfigMap().setAutoLockEyeOfEnderEntity(!configMap.getPoiConfigMap().getLockingConfigMap().isAutoLockEyeOfEnderEntity());
                    MainClass.config.setConfigMap(configMap);
                    button.setMessage(Text.of(I18n.translate("minecraft_access.gui.common.button.toggle_button." + (MainClass.config.getConfigMap().getPoiConfigMap().getLockingConfigMap().isAutoLockEyeOfEnderEntity() ? "enabled" : "disabled"),
                            I18n.translate("minecraft_access.gui.poi_locking_config_menu.button.auto_lock_eye_of_ender_button")
                    )));
                },
                true);
        this.addDrawableChild(autoLockEyeOfEnderButton);

        ButtonWidget unlockingSoundButton = this.buildButtonWidget(
                I18n.translate("minecraft_access.gui.common.button.toggle_button." + (MainClass.config.getConfigMap().getPoiConfigMap().getLockingConfigMap().isUnlockingSound() ? "enabled" : "disabled"),
                        I18n.translate("minecraft_access.gui.poi_locking_config_menu.button.unlocking_sound_button")
                ),
                (button) -> {
                    ConfigMap configMap = MainClass.config.getConfigMap();
                    configMap.getPoiConfigMap().getLockingConfigMap().setUnlockingSound(!configMap.getPoiConfigMap().getLockingConfigMap().isUnlockingSound());
                    MainClass.config.setConfigMap(configMap);
                    button.setMessage(Text.of(I18n.translate("minecraft_access.gui.common.button.toggle_button." + (MainClass.config.getConfigMap().getPoiConfigMap().getLockingConfigMap().isUnlockingSound() ? "enabled" : "disabled"),
                            I18n.translate("minecraft_access.gui.poi_locking_config_menu.button.unlocking_sound_button")
                    )));
                });
        this.addDrawableChild(unlockingSoundButton);

        ButtonWidget delayButton = this.buildButtonWidget(
                I18n.translate("minecraft_access.gui.common.button.delay",
                        MainClass.config.getConfigMap().getPoiConfigMap().getLockingConfigMap().getDelay()),
                (button) -> this.client.setScreen(new ValueEntryMenu("value_entry_menu", ValueEntryMenu.CONFIG_TYPE.POI_LOCKING_DELAY, this)));
        this.addDrawableChild(delayButton);
    }
}

class POIMarkingConfigMenu extends BaseScreen {
    public POIMarkingConfigMenu(String title, BaseScreen previousScreen) {
        super(title, previousScreen);
    }

    @Override
    protected void init() {
        super.init();

        POIMarkingConfigMap initMap = POIMarkingConfigMap.getInstance();

        ButtonWidget b1 = this.buildButtonWidget(featureToggleButtonMessage(initMap.isEnabled()),
                (button) -> {
                    POIMarkingConfigMap map = POIMarkingConfigMap.getInstance();
                    map.setEnabled(!map.isEnabled());
                    button.setMessage(Text.of(featureToggleButtonMessage(map.isEnabled())));
                    Config.getInstance().writeJSON();
                });
        this.addDrawableChild(b1);

        Function<Boolean, String> t2 = featureToggleButtonMessageWith("minecraft_access.gui.poi_marking_config_menu.button.suppress_other_when_enabled_button");
        ButtonWidget b2 = this.buildButtonWidget(
                t2.apply(initMap.isSuppressOtherWhenEnabled()),
                (button) -> {
                    POIMarkingConfigMap map = POIMarkingConfigMap.getInstance();
                    map.setSuppressOtherWhenEnabled(!map.isSuppressOtherWhenEnabled());
                    button.setMessage(Text.of(t2.apply(map.isSuppressOtherWhenEnabled())));
                    Config.getInstance().writeJSON();
                });
        this.addDrawableChild(b2);
    }
}