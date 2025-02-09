package org.minefortress.renderer.gui;

import net.minecraft.client.gui.screen.ingame.BookScreen;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Text;

import java.util.Arrays;
import java.util.List;

public class FortressBookContents implements BookScreen.Contents {

    public static final List<String> HELP_BOOK = Arrays.asList(
            """
            这个模组为游戏添加了策略视图。你可以仅使用鼠标指针和一组棋子进行挖掘和建造。\s

            快捷键绑定：
            左键点击 - 开始选择挖掘
            右键点击 - 开始选择建造
            """,
            """
            中键按下 - 用鼠标旋转摄像机
            ctrl + R - 更改建造动作类型（方块、墙、梯子）
            ctrl + E - 将当前选择向上移动
            ctrl + Q - 将当前选择向下移动
            """,
            """
            ctrl + W - 向下旋转摄像机
            ctrl + S - 向上旋转摄像机
            ctrl + A - 向左旋转摄像机
            ctrl + D - 向右旋转摄像机
            """,
            """
            Z - 取消最近的简单选择任务
            ctrl + Z - 取消所有任务
            """
    );

    private final List<String> pages;

    public FortressBookContents(List<String> pages) {
        this.pages = pages;
    }

    @Override
    public int getPageCount() {
        return pages.size();
    }

    @Override
    public StringVisitable getPageUnchecked(int index) {
        return Text.literal(pages.get(index));
    }

}
