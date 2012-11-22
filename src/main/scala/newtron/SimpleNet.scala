package newtron

/**
 * A simple net has only two layers.
 *
 * @author Markus Kahl
 */
case class SimpleNet(numberInputs: Int, numberOutputs: Int) {

  val weights: Array[Array[Double]] = (1 to numberInputs).map(
    _ => Iterator.continually(math.random).take(numberOutputs).toArray).toArray

  def activate: Double => Double = x => x
  def step(x: Double): Double = if (x > 0) 1 else 0

  val bias = -1

  def run(input: IndexedSeq[Double]): IndexedSeq[Double] = for (j <- 0 until numberOutputs)
    yield activate((0 until numberInputs).map { i =>
      printf("input(%d) = %.2f, weights(%d)(%d) = %.2f, => %.2f%n",
        i, input(i), i, j, weights(i)(j), input(i) * weights(i)(j))
      input(i) * weights(i)(j)
    }.sum + bias)

  override def toString = "SimpleNet(%d, %d, weights = %s)".format(
    numberInputs, numberOutputs, weights.map(_.mkString("[", ", ", "]")).mkString("[", ", ", "]"))
}

object SimpleNet {
  /**
   * Creates a simple net with n inputs and a single output.
   *
   * @param weights Input weights.
   * @return A new simple net.
   */
  def apply(weights: Double*): SimpleNet = {
    val net = SimpleNet(weights.size, 1)
    for (i <- 0 until weights.size) {
      net.weights(i)(0) = weights(i)
    }
    net
  }
}
