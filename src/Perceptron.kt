import kotlin.random.Random

class Perceptron (n: Int){
    val weights = arrayListOf<Double>()
    private var c = 0.01

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
            weights[i] += c * error * inputs[i]
        }
    }

    fun guessY(x: Int): Double = -(weights[2]/weights[1]) - (weights[0]/weights[1]) * x

}