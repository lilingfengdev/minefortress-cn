package org.minefortress.renderer.gui.blueprints;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;
import net.remmintan.mods.minefortress.core.interfaces.blueprints.BlueprintGroup;
import org.apache.logging.log4j.util.Strings;
import net.remmintan.mods.minefortress.networking.c2s.ServerboundEditBlueprintPacket;
import net.remmintan.mods.minefortress.networking.helpers.FortressChannelNames;
import net.remmintan.mods.minefortress.networking.helpers.FortressClientNetworkHelper;

public class AddBlueprintScreen extends Screen {

    private final BlueprintGroup group;

    public AddBlueprintScreen(BlueprintGroup group) {
        super(Text.literal("添加新蓝图"));
        this.group = group;
    }

    @Override
    protected void init() {
        super.init();
        final var textField = new TextFieldWidget(
                this.textRenderer,
                this.width / 2 - 102,
                this.height / 4 + 24 - 16, 204, 20,
                Text.literal("蓝图名称")
        );
        this.addDrawableChild(textField);

        final var saveBlueprintBtn = ButtonWidget
                .builder(Text.literal("保存蓝图"), button -> {
                    final var text = textField.getText();
                    if(Strings.isNotBlank(text)) {
                        final var packet = ServerboundEditBlueprintPacket.add(text, group);
                        FortressClientNetworkHelper.send(FortressChannelNames.FORTRESS_EDIT_BLUEPRINT, packet);
                        if(this.client != null) this.client.setScreen(null);
                    }
                })
                .dimensions(this.width / 2 - 102, this.height / 4 + 48 - 16, 204, 20)
                .build();
        this.addDrawableChild(saveBlueprintBtn);
    }

    @Override
    public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) {
        this.renderBackground(drawContext, mouseX, mouseY, delta);
        drawContext.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 40, 0xFFFFFF);
        super.render(drawContext, mouseX, mouseY, delta);
    }

    @Override
    public void close() {
        if(this.client != null) this.client.setScreen(new BlueprintsScreen());
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
