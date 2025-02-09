package net.remmintan.mods.minefortress.core.interfaces.blueprints;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

import java.util.Arrays;
import java.util.List;

public enum BlueprintGroup {
    WORKSHOPS(true, Items.IRON_AXE, "工作坊"),
    LIVING_HOUSES(true, Items.OAK_PLANKS, "住宅"),
    DECORATION(true, Items.ROSE_BUSH, "装饰"),
    FARMS(true, Items.WHEAT, "农场", true),
    SOCIAL_BUILDINGS(true, Items.BOOKSHELF, "社交建筑", true),
    HIDDEN(true, Items.AIR, "", true)
    ;

    private final boolean topRow;
    private final ItemStack icon;
    private final Text nameText;
    private final boolean hidden;

    BlueprintGroup(boolean topRow, Item item, String name) {
        this(topRow, item, name, false);
    }

    BlueprintGroup(boolean topRow, Item item, String name, boolean hidden) {
        this.topRow = topRow;
        this.icon = new ItemStack(item);
        this.nameText = Text.literal(name);
        this.hidden = hidden;
    }

    public boolean isTopRow() {
        return topRow;
    }

    public ItemStack getIcon() {
        return icon;
    }

    public Text getNameText() {
        return nameText;
    }

    public static List<BlueprintGroup> nonHidden() {
        return Arrays.stream(BlueprintGroup.values()).filter(it -> !it.hidden).toList();
    }
}
