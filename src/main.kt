
import java.awt.BorderLayout

import javax.swing.JFrame

import javax.swing.SwingUtilities


fun main(){

    SwingUtilities.invokeLater {
        val f = JFrame()
        f.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        f.title = "Perceptron"
        f.isResizable = false
        f.add(GUI (), BorderLayout.CENTER)
        f.pack()
        f.setLocationRelativeTo(null)
        f.isVisible = true
    }
}