import java.awt.*
import javax.swing.JPanel
import javax.swing.Timer

class Visualisation(val gui: GUI) : JPanel() {

    init {
        val dim = Dimension(640, 240)
        preferredSize = dim
        background = Color.lightGray


        Timer(10) { repaint() }.start()

    }

    override fun paintComponent(gg: Graphics) {
        super.paintComponent(gg)
        val g: Graphics2D = gg as Graphics2D
        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        )
        g.font = Font("Purisa", Font.PLAIN, 20)
        //Inputs
        g.color = Color.darkGray
        g.fillOval(50, 30, 36, 36)
        g.color = Color.white
        g.drawString("X",61,55)
        g.color = Color.darkGray
        g.fillOval(50, 100, 36, 36)
        g.color = Color.white
        g.drawString("Y",61,125)
        g.color = Color.darkGray
        g.fillOval(50, 170, 36, 36)
        g.color = Color.white
        g.drawString("B",61,195)

        //Neuron
        g.color = Color.darkGray
        g.fillOval(350, 100, 36, 36)
        g.color = Color.white
        g.drawString("N",361,125)


        //Weights
        g.color = Color.black
        try {
            g.stroke = BasicStroke((1F+ gui.perc.weights[0]).toFloat()*5)
            g.drawLine(50+36, 30+36/2, 350, 100+36/2)
        }catch (ex: IllegalArgumentException){
            println("Error: negative width")
        }
        try {
            g.stroke = BasicStroke((1F+ gui.perc.weights[1]).toFloat()*5)
            g.drawLine(50+36, 100+36/2, 350, 100+36/2)
        }catch (ex: IllegalArgumentException){
            println("Error: negative width")
        }
        try {
            g.stroke = BasicStroke((1F+ gui.perc.weights[2]).toFloat()*5)
            g.drawLine(50+36, 170+36/2, 350, 100+36/2)
        }catch (ex: IllegalArgumentException){
            println("Error: negative width")
        }



        //Functions
        g.drawString("Real:  f(x) = ${gui.getF()}",300,55)
        g.drawString("Guess: f(x) = ${gui.perc.getGuessY()}",300,195)

        //Training
        g.drawString("Training-Point: ${gui.count}",400,125)




    }

}