package com.github.khanshoaib3.minecraft_access.features.InventoryControls;

import com.github.khanshoaib3.minecraft_access.mixin.LoomScreenAccessor;
import com.github.khanshoaib3.minecraft_access.mixin.StonecutterScreenAccessor;
import net.minecraft.block.entity.BannerPattern;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.LoomScreen;
import net.minecraft.client.gui.screen.ingame.StonecutterScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.StonecuttingRecipe;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.registry.RegistryEntry;

import java.util.List;

public class SlotItem {
    public SlotItem upSlotItem;
    public SlotItem rightSlotItem;
    public SlotItem downSlotItem;
    public SlotItem leftSlotItem;

    public int x;
    public int y;

    public Slot slot;

    private int recipeIndex;

    private int row;
    private int column;

    public SlotItem(Slot slot) {
        this.slot = slot;
        this.x = slot.x + 9;
        this.y = slot.y + 9;
        upSlotItem = null;
        rightSlotItem = null;
        downSlotItem = null;
        leftSlotItem = null;
    }

    public SlotItem(int x, int y, int recipeIndex) {
        this.x = x;
        this.y = y;
        this.recipeIndex = recipeIndex;

        upSlotItem = null;
        rightSlotItem = null;
        downSlotItem = null;
        leftSlotItem = null;
        slot = null;
    }

    public SlotItem(int x, int y, int row, int column) {
        this.x = x;
        this.y = y;
        this.row = row;
        this.column = column;

        upSlotItem = null;
        rightSlotItem = null;
        downSlotItem = null;
        leftSlotItem = null;
        slot = null;
    }

    public String getNarratableText() {
        if (MinecraftClient.getInstance().currentScreen instanceof LoomScreen loomScreen) {
            List<RegistryEntry<BannerPattern>> list = loomScreen.getScreenHandler().getBannerPatterns();
            if (list.size() == 0) return "";

            int p = row + ((LoomScreenAccessor) loomScreen).getVisibleTopRow();
            int q = p * 4 + column;

            return list.get(q).value().getId();
        }

        if (MinecraftClient.getInstance().currentScreen instanceof StonecutterScreen stonecutterScreen) {
            List<StonecuttingRecipe> list = stonecutterScreen.getScreenHandler().getAvailableRecipes();
            if (list.size() == 0) return "";

            int scrollOffset = ((StonecutterScreenAccessor) stonecutterScreen).getScrollOffset();
            ItemStack itemStack = list.get(recipeIndex + scrollOffset).getOutput();
            List<Text> toolTip = MinecraftClient.getInstance().currentScreen.getTooltipFromItem(itemStack);
            StringBuilder toolTipString = new StringBuilder();
            for (Text text : toolTip) {
                toolTipString.append(text.getString()).append(",");
            }

            return "%s %s".formatted(itemStack.getCount(), toolTipString);
        }

        return "";
    }
}
