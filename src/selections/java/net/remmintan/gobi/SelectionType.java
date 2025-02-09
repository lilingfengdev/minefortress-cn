package net.remmintan.gobi;

import net.remmintan.mods.minefortress.core.interfaces.selections.ISelection;
import net.remmintan.mods.minefortress.core.interfaces.selections.ISelectionType;

import java.util.function.Supplier;

public enum SelectionType implements ISelectionType {

    SQUARES(TwoDotsSelection::new, "方形", "SQ"),
    WALLS(WallsSelection::new, "墙壁", "WA"),
    WALLS_EVERY_SECOND(WallsEverySecond::new, "棋子墙", "CW"),
    LADDER(LadderSelection::new, "梯子X方向", "LX"),
    LADDER_Z_DIRECTION(LadderSelectionZDirection::new, "梯子Z方向", "LZ"),
    TREE(TreeSelection::new, "树木", "TR"),
    ROADS(RoadsSelection::new, "道路", "RO"),;

    private final Supplier<ISelection> selectionGenerator;
    private final String name;
    private final String buttonText;

    SelectionType(Supplier<ISelection> selectionGenerator, String name, String buttonText) {
        this.selectionGenerator = selectionGenerator;
        this.name = name;
        this.buttonText = buttonText;
    }

    @Override
    public ISelection generate() {
        return selectionGenerator.get();
    }

    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public String getButtonText() {
        return buttonText;
    }
}
