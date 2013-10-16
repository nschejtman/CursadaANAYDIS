package anaydis.search

trait MyMap[K, V] {
  def get(k: K): V

  def put(k: K, v: V): Unit

  def size: Int

  def isEmpty = size == 0

  def contains(k: K): Boolean

  def remove(k: K): Unit

  def notFound(k: K) = throw new NoSuchElementException(s"Key $k not found")

}