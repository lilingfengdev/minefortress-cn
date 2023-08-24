package org.minefortress.interfaces;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import org.minefortress.blueprints.manager.ClientBlueprintManager;
import net.remmintan.panama.renderer.BlueprintRenderer;
import org.minefortress.fight.influence.ClientInfluenceManager;
import org.minefortress.fortress.FortressClientManager;
import org.minefortress.fortress.automation.areas.AreasClientManager;
import org.minefortress.professions.hire.HireInfo;
import org.minefortress.renderer.gui.hud.FortressHud;
import org.minefortress.selections.SelectionManager;
import net.remmintan.panama.renderer.CampfireRenderer;
import net.remmintan.panama.renderer.SelectionRenderer;
import net.remmintan.panama.renderer.TasksRenderer;

import java.util.Map;

public interface FortressMinecraftClient {

    void openHireScreen(MinecraftClient client, String screenName1, Map<String, HireInfo> professions1);
    SelectionManager getSelectionManager();
    FortressHud getFortressHud();
    AreasClientManager getAreasClientManager();
    ClientBlueprintManager getBlueprintManager();
    BlueprintRenderer getBlueprintRenderer();
    CampfireRenderer getCampfireRenderer();
    SelectionRenderer getSelectionRenderer();
    TasksRenderer getTasksRenderer();
    FortressClientManager getFortressClientManager();
    boolean isFortressGamemode();
    BlockPos getHoveredBlockPos();
    ClientInfluenceManager getInfluenceManager();
}
