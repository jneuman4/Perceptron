
import java.awt.BorderLayout

import javax.swing.JFrame

import javax.swing.SwingUtilities


fun main(){

    SwingUtilities.invokeLater {
        val f = JFrame()
        val gui = GUI ()
        f.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        f.title = "Perceptron"
        f.isResizable = false
        f.add(gui, BorderLayout.CENTER)
        f.add(Visualisation(gui), BorderLayout.SOUTH)
        f.pack()
        f.setLocationRelativeTo(null)
        f.isVisible = true
    }
}