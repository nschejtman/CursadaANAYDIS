package anaydis.search

import scala.collection.mutable.ArrayBuffer

class ArrayMap[K, V] extends MyMap[K, V] {
  protected val keys = new ArrayBuffer[K]
  protected val values = new ArrayBuffer[V]
  protected var sizeInt = 0

  def indexOf(k: K): Int = {
    var i = 0
    while (i < size && keys(i) != k) i += 1
    if (i < size) i else -1
  }

  def get(k: K): V = {
    val index = indexOf(k)
    if (index < 0) notFound(k)
    else {
      values(index)
    }
  }

  def put(k: K, v: V) {
    val index = indexOf(k)
    if (index >= 0) {
      values(index) = v
    }
    else {
      keys += k
      values += v
    }
  }

  def size: Int = sizeInt

  def contains(k: K): Boolean = indexOf(k) != -1

  def remove(k: K) {
    val index = indexOf(k)
    if (index >= 0) for (i <- index + 1 to sizeInt) {
      keys(i) = keys(i+1)
      values(i) = values(i+1)
    }
  }
}
