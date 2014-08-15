package anaydis.search

import java.util.Comparator

class ImmutableTST[V](var head: Node = null, var sizeInt: Int = 0) {

  case class Node(char: Char, var value: Option[V], var left: Node = null, var center: Node = null, var right: Node = null)

  def contains(k: String): Boolean = ???

  def get(k: String): V = ???

  def put(k: String, v: V): ImmutableTST[V] = ???

  def size: Int = sizeInt

  def remove(k: String): ImmutableTST[V] = ???

  <!--private-->

  private def validateKey(k: String): Unit = if (k == null || k.length == 0) throw new IllegalArgumentException("Empty String")

  private def doPut

  private def doRemove()

  private def pack

  private def find

}
