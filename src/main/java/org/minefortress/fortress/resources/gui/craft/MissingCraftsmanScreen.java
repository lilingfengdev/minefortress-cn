package org.minefortress.fortress.resources.gui.craft;

import org.jetbrains.annotations.NotNull;
import org.minefortress.fortress.resources.gui.AbstractMissingProfessionScreen;

public class MissingCraftsmanScreen extends AbstractMissingProfessionScreen {

    @Override
    protected @NotNull String getMissingObjectName() {
        return "工匠";
    }

    @Override
    protected String getActionText() {
        return "前往职业经理处雇佣一个";
    }

}
