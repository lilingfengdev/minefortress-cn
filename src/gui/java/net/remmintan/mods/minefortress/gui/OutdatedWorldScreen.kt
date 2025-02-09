package net.remmintan.mods.minefortress.gui

import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.widget.ButtonWidget
import net.minecraft.text.Text

private const val TEXT_STRING =
    "停下，旅行者！你的世界是在MineFortress的早期时代形成的，那是一个古老的时代，其中一些奇迹可能对你没有帮助。要体验它的全部辉煌，你必须铸造一个新世界。请注意，过去并没有承诺！"
private val TEXT = Text.of(TEXT_STRING)

class OutdatedWorldScreen : Screen(Text.of("这个世界不再受支持！")) {

    private val btn: ButtonWidget = ButtonWidget.builder(Text.of("真可惜，但也没办法！")) {
        this.client?.setScreen(null)
    }
        .size(200, 20)
        .build()

    override fun render(context: DrawContext?, mouseX: Int, mouseY: Int, delta: Float) {
        super.render(context, mouseX, mouseY, delta)

        context?.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 50, 0xFFFFFF)
        context?.drawTextWrapped(this.textRenderer, TEXT, 50, 90, this.width - 100, 0xFFFFFF)

        val textHeight = this.textRenderer.getWrappedLinesHeight(TEXT, this.width - 100)
        btn.x = this.width / 2 - 100
        btn.y = 90 + textHeight + 40

        btn.render(context, mouseX, mouseY, delta)
    }

    override fun mouseReleased(mouseX: Double, mouseY: Double, button: Int): Boolean {
        val mouseReleased = super.mouseReleased(mouseX, mouseY, button)

        if (button == 0) {
            btn.onClick(mouseX, mouseY)
            return true
        }

        return mouseReleased
    }
}