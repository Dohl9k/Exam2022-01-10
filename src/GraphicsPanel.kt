import java.awt.Color
import java.awt.Graphics
import javax.swing.JPanel
import kotlin.math.sin

class GraphicsPanel() : JPanel() {

    override fun paint(g: Graphics?) {
        super.paint(g)
        g?.let {
            it.drawLine(width/2, 0, width/2, height)
            it.drawLine(0, height/2, width, height/2)
            var x = 0
            while (x < width) {
                it.drawLine(x, height/2 + 10, x, height/2 - 10)
                x += 20
            }
            var y = 0
            while (y < height) {
                it.drawLine(width/2 + 10, y, width/2- 10, y)
                y += 20
            }
            var x_var = 0
            var y_var = x_var * sin(x_var.toDouble())
            while (x < width) {
                x_var += 1
                val pred = y_var
                y_var = x_var * sin(x_var.toDouble())
                it.drawLine(x_var - 1, pred.toInt(), x_var, y_var.toInt())
            }
        }
    }
}