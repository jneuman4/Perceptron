import java.awt.*
import javax.swing.JPanel
import javax.swing.Timer
import kotlin.random.Random


class GUI: JPanel() {


    private val training = arrayListOf<Trainer>()
    private val perc = Perceptron(3)
    private var count = 0


    private var xmin = -1.0
    private var ymin = -1.0
    private var xmax = 1.0
    private var ymax = 1.0

    private val m = (-1 + Random.nextDouble() * 2)
    private val b = (-1 + Random.nextDouble() * 2)


    init {
        val dim = Dimension(640, 360)
        preferredSize = dim
        background = Color.white


        for (i in 0 until 2000) {
            val x = (-1 + Random.nextDouble() * 2)
            val y = (-1 + Random.nextDouble() * 2)
            val answer = if (y > f(x)) -1 else 1
            training.add(Trainer(x, y, answer))
        }

        Timer(10) { repaint() }.start()

    }

    private fun f (x: Double) = m*x+b
    fun getF () = String.format("%.3f", m) + "x + " + String.format("%.3f", b)


    override fun paintComponent(gg: Graphics) {
        super.paintComponent(gg)
        val g: Graphics2D = gg as Graphics2D
        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        )


        //Richtige Linie
        g.stroke = BasicStroke(2F)
        g.color = Color.orange
        var x1 = map(xmin, xmin, xmax, 0.0, width.toDouble())
        var y1 = map(f(xmin), ymin, ymax, height.toDouble(), 0.0)
        var x2 = map(xmax, xmin, xmax, 0.0, width.toDouble())
        var y2 = map(f(xmax), ymin, ymax, height.toDouble(), 0.0)
        g.drawLine(x1, y1, x2, y2)


        //Vermutete Linie
        g.color = Color.red
        g.stroke = BasicStroke(1F)
        x1 = map(xmin, xmin, xmax, 0.0, width.toDouble())
        y1 = map(perc.guessY(xmin.toInt()), ymin, ymax, height.toDouble(), 0.0)
        x2 = map(xmax, xmin, xmax, 0.0, width.toDouble())
        y2 = map(perc.guessY(xmax.toInt()), ymin, ymax, height.toDouble(), 0.0)
        g.drawLine(x1, y1, x2, y2)

        if (count%25 == 0){
            println(perc.getGuessY())
        }

        g.stroke = BasicStroke(1F)
        g.color = Color.black
        perc.train(training[count].inputs, training[count].answer)
        count = (count + 1) % training.size

        for (i in 0 until count) {
            val guess = perc.feedForward(training[i].inputs)
            val x = map(training[i].inputs[0], xmin, xmax, 0.0, width.toDouble())
            val y = map(training[i].inputs[1], ymin, ymax, height.toDouble(), 0.0)

            if (guess > 0) g.drawOval(x, y, 8, 8)
            else g.fillOval(x, y, 8, 8)
        }

    }

    fun map(n: Double, start1: Double, stop1: Double, start2: Double, stop2: Double): Int = ((n - start1) / (stop1 - start1) * (stop2 - start2) + start2).toInt()

}