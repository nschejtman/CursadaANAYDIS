package anaydis.search

trait ImmutableMap[K, V] {
  def get(k: K): V
  def put(k: K, v: V): ImmutableMap[K, V]
  def remove(k: K): ImmutableMap[K, V]
  def size: Int
  def isEmpty = size == 0
  def contains(k: K): Boolean
  def notFound(k: K) = throw new NoSuchElementException(s"Key $k not found")
}
