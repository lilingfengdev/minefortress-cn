package org.minefortress.fortress.resources.gui.smelt;

import org.jetbrains.annotations.NotNull;
import org.minefortress.fortress.resources.gui.AbstractMissingProfessionScreen;

public class MissingBlacksmithScreen extends AbstractMissingProfessionScreen {
    public MissingBlacksmithScreen(boolean missingBuilding) {
        super(missingBuilding);
    }


    @Override
    protected @NotNull String getMissingObjectName() {
        return this.irregularReson ? "带炉子的房子" : "铁匠";
    }

    @Override
    protected String getActionText() {
        return "前往蓝图菜单并建造一个";
    }

}
