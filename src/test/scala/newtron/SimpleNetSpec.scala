package newtron

import org.scalatest._
import matchers.ShouldMatchers

class SimpleNetSpec extends FlatSpec with ShouldMatchers {
  "A SimpleNet" should "support OR semantics" in {
    val or = SimpleNet.or

    for (a <- 0 to 1; b <- 0 to 1) {
      val res = or.run(IndexedSeq(a, b)).head

      if (a == 1 || b == 1) res should equal (1d)
      else res should equal (0d)
    }
  }

  it should "support AND semantics" in {
    val and = SimpleNet.and

    for (a <- 0 to 1; b <- 0 to 1) {
      val res = and.run(IndexedSeq(a, b)).head

      if (a == 1 && b == 1) res should equal (1d)
      else res should equal (0d)
    }
  }
}
