import kotlin.random.Random

class Perceptron (n: Int){
    val weights = arrayListOf<Double>()
    private var learningRate = 0.001

    init {
        for (i in 0 until n) {
            weights.add(-1 + Random.nextDouble() * 2)
        }
    }

    fun feedForward(inputs: ArrayList<Double>): Int{
        var sum = 0.0
        for (i in 0 until weights.size){
            sum += weights[i] * inputs[i]
        }
        return activate(sum)
    }

    private fun activate(sum: Double) = if (sum > 0) 1 else -1

    fun train(inputs: ArrayList<Double>, desired: Int){
        val guess = feedForward(inputs)
        val error = desired - guess
        for (i in 0 until weights.size){
            weights[i] += learningRate * error * inputs[i]
        }
    }

    fun guessY(x: Int): Double = -(weights[0]/weights[1]) * x -(weights[2]/weights[1])
    fun getGuessY() = String.format("%.3f", -(weights[0]/weights[1]))+ "x + " + String.format("%.3f", -(weights[2]/weights[1]))
}