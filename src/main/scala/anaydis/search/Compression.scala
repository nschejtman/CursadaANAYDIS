import scala.collection.mutable
import scala.math._

trait Entropy {
  def entropy(symbols: List[Char]): Double = {

    val fs = mutable.HashMap[Char, Long]()

    for (s <- symbols) fs(s) = fs.getOrElse(s, 0L) + 1

    var entropy = 0D

    fs foreach {
      case (w, f) => {
        val p = f.toDouble / symbols.size
        entropy += -p * log10(p) / log10(2)
      }
    }
    entropy
  }

  def entropy2(symbols: List[Char]): Double = {
    symbols.groupBy(c => c).values
      .map(f => f.size.toDouble / symbols.size)
      .map(p => -p * log10(p) / log10(2))
      .sum
  }
}

trait StructuredBurrowsWheeler {

  def encode(input: String): (String, Int) = {
    val matrix = rotations(input).sorted
    val lasts = matrix.map(r => r.last)
    val pos = matrix.indexOf(input)
    (lasts.mkString, pos)
  }

  def decode(input: String, pos: Int): String = {
    var matrix = input.toSeq.map(c => "") // init empty Seq of fixed size
    def merge(input: String, rows: Seq[String]): Seq[String] = {
      assert(input.length() == rows.size)
      for (i <- 0 until rows.size)
      yield input(i) + rows(i)
    }
    for (i <- 0 until input.length()) {
      matrix = merge(input, matrix)
      matrix = matrix.sortWith((a: String, b: String) => a.compareTo(b) < 0)
    }
    matrix(pos)
  }

  def rotate(input: String, rotation: Int): String = {
    val module = rotation % input.size
    val r = if (module < 0) module + input.size else module
    input.drop(r) + input.take(r)
  }

  private def rotations(input: String): Seq[String] = {
    for (i <- 0 until input.length())
    yield rotate(input, -i)
  }
}

trait IndexedBurrowsWheeler {

  def encode(input: String): (String, Int) = {
    val matrix = rotations(input).sortWith(sorter(input))
    val lasts = matrix.map(rot => charAt(input, rot, input.length - 1))
    val pos = matrix.indexOf(0)
    (lasts.mkString, pos)
  }

  def sorter(input: String)(a: Int, b: Int): Boolean = {
    for (i <- 0 until input.length) {
      val i1 = charAt(input, a, i)
      val i2 = charAt(input, b, i)
      //      println(s"Comparing $i1 with $i2 resulting ${i1 < i2} at index $i for indexes ($a,$b)")
      if (i1.compareTo(i2) < 0) return true
      else if (i1.compareTo(i2) > 0) return false
    }
    true
  }

  def decode(input: String, pos: Int): String = ???

  def charAt(input: String, rot: Int, index: Int) = input(((input.length - rot) + index) % input.length)

  def rotate(input: String, rotation: Int): String = {
    val module = rotation % input.size
    val r = if (module < 0) module + input.size else module
    input.drop(r) + input.take(r)
  }

  private def rotations(input: String) = 0 until input.length()
}

object BurrowsWheelerMain extends App with IndexedBurrowsWheeler with Entropy {

  compute("^BANANA")

  //  compute("TekGenesis")
  //  compute("Anaydis")
  //  compute("SIX.MIXED.PIXIES.SIFT.SIXTY.PIXIE.DUST.BOXES")

  def compute(input: String) {

    println(s"Original: $input with entropy: ${entropy(input.toList)}")

    val encoded = encode(input)
    println(s"Encoded: $encoded with entropy: ${entropy(encoded._1.toList)}")

    val decoded = decode(encoded._1, encoded._2)
    println(s"Decoded: $decoded")
  }
}