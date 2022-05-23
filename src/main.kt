
import java.awt.BorderLayout

import javax.swing.JFrame

import javax.swing.SwingUtilities


fun main(){

    SwingUtilities.invokeLater {
        val f = JFrame()
        val gui = GUI ()
        f.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        f.title = "Perceptron: ${gui.getF()}"
        f.isResizable = false
        f.add(gui, BorderLayout.CENTER)
        f.pack()
        f.setLocationRelativeTo(null)
        f.isVisible = true
    }
}