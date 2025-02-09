package org.minefortress.fortress.resources.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.remmintan.mods.minefortress.core.utils.CoreModUtils;
import org.jetbrains.annotations.NotNull;
import org.minefortress.renderer.gui.professions.ProfessionsScreen;

public abstract class AbstractMissingProfessionScreen extends Screen {

    protected final boolean irregularReson;

    public AbstractMissingProfessionScreen() {
        this(false);
    }

    public AbstractMissingProfessionScreen(boolean irregularReson) {
        super(Text.literal("缺失职业"));
        this.irregularReson = irregularReson;
    }

    @Override
    protected void init() {
        final var backButton = ButtonWidget
                .builder(Text.literal("返回"),
                        button -> {
                            if (this.client != null)
                                this.client.setScreen(null);
                        })
                .dimensions(this.width / 2 - 102,
                        this.height / 2 + 24 - 16,
                        204,
                        20)
                .build();

        this.addDrawableChild(backButton);

        if(!irregularReson) {
            final var toProfessionsMenuButton =
                    ButtonWidget
                            .builder(Text.literal("前往职业菜单"),
                                    button -> {
                                        if (this.client != null)
                                            this.client.setScreen(new ProfessionsScreen(CoreModUtils.getManagersProvider()));
                                    })
                            .dimensions(this.width / 2 - 102,
                                    this.height / 2 + 48 - 16,
                                    204,
                                    20)
                            .build();
            this.addDrawableChild(toProfessionsMenuButton);
        }
    }

    @Override
    public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) {
        this.renderBackground(drawContext, mouseX, mouseY, delta);
        final var missingText = String.format("您在村庄中至少需要一个 %s", getMissingObjectName());
        drawContext.drawCenteredTextWithShadow(this.textRenderer, missingText, this.width / 2, this.height / 2 - 40, 0xFFFFFF);
        if(irregularReson) {
            drawContext.drawCenteredTextWithShadow(this.textRenderer, getActionText(), this.width / 2, this.height / 2 - 25, 0xFFFFFF);
        } else {
            drawContext.drawCenteredTextWithShadow(this.textRenderer, "前往职业菜单并雇佣一个", this.width / 2, this.height / 2 - 25, 0xFFFFFF);
        }
        super.render(drawContext, mouseX, mouseY, delta);
    }

    @NotNull
    protected abstract String getMissingObjectName();

    protected abstract String getActionText();
}
