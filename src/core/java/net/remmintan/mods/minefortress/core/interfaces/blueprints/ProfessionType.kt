package net.remmintan.mods.minefortress.core.interfaces.blueprints

import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.util.StringIdentifiable

enum class ProfessionType(val icon: Item, val displayName: String, val blueprintIds: List<String>) :
    StringIdentifiable {

    NONE(Items.AIR, "无", emptyList()),
    FARMER(Items.WHEAT, "农民", listOf("small_farm_1", "large_farm_1")),
    MINER(Items.STONE_PICKAXE, "矿工", listOf("miner_house_wooden", "miner_house_stone", "miner_house_guild")),
    LUMBERJACK(
        Items.STONE_AXE,
        "伐木工",
        listOf("lumberjack_house_wooden", "lumberjack_house_stone", "lumberjack_house_guild")
    ),
    BLACKSMITH(Items.FURNACE, "铁匠", listOf("small_house_3_with_furnace", "weaponsmith_1")),
    FORESTER(Items.APPLE, "林务员", listOf("forester_house")),
    WARRIOR(Items.STONE_SWORD, "战士", listOf("warrior_1", "warrior_2")),
    ARCHER(Items.BOW, "弓箭手", listOf("shooting_gallery")),
    FISHERMAN(Items.FISHING_ROD, "渔夫", listOf("fisher_cottage_1")),
    CRAFTSMAN(Items.CRAFTING_TABLE, "工匠", listOf("crafting_table", "tool_smith_1"));

    override fun asString() = name.lowercase()
}
