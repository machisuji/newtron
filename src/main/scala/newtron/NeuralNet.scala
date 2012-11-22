package newtron

/**
 * A basic neural net.
 *
 * @author Markus Kahl
 */
case class NeuralNet(numberInputs: Int, numberHiddenUnits: Int, numberOutputs: Int) {

  protected val inputUnits: Array[Double] = Array.ofDim(numberInputs)
  protected val hiddenUnitWeights: Array[Array[Double]] = Array.ofDim(numberInputs, numberHiddenUnits)

  protected val hiddenUnits: Array[Double] = Array.ofDim(numberHiddenUnits)
  protected val outputWeights: Array[Double] = Array.ofDim(numberHiddenUnits)

  protected val outputUnits: Array[Double] = Array.ofDim(numberOutputs)

  def activate: Double => Double = sigmoid
  def sigmoid(x: Double): Double = 1 / (1 + math.exp(-x))

  val bias = -1

  val isLayered = numberHiddenUnits > 0

  def updateHidden = 0

  /*def run(input: IndexedSeq[Double]): IndexedSeq[Double] = for (j <- 0 until numberOutputs)
  yield activate((0 until numberInputs).map { i =>
      printf("input(%d) = %.2f, weights(%d)(%d) = %.2f, => %.2f%n",
        i, input(i), i, j, weights(i)(j), input(i) * weights(i)(j))
      input(i) * weights(i)(j)
    }.sum + bias)

  def classifyInput(x: Double): Double =
    if (x >= 0.9) 1
    else if (x <= 0.1) 0
    else -1
  def classify(input: IndexedSeq[Double]): IndexedSeq[Double] = run(input).map(classifyInput)*/
}
