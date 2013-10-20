package anaydis.search

class RWayTrie[V] extends MyMap[String, V] {
  var head: Node = null

  class Node {
    var value: Option[V] = None
    val next: Array[Node] = new Array[Node](256)
  }

  def get(k: String): V = ???


  def size: Int = ???

  def contains(k: String): Boolean = ???


  def find(n: Node, k: String): Node = {
    if (n == null) null
    else if (k.length == 0) n
    else find(n.next(k.charAt(0)), k.substring(1))
  }

  def put(k: String, v: V): Unit = {
    validateKey(k);
    head = doPut(k, v, head)
  }

  def doPut(k: String, v: V, n: Node = null): Node = {
    val node = if (n == null) new Node() else n
    if (k.length != 0) {
      val l = k.charAt(0)
      node.next(l) = doPut(k.substring(1), v, node.next(l))
    }
    else {
      if (node.value.isEmpty) size += 1
      node.value = Some(v)
    }
    node
  }

  def remove(k: String): Unit = {
    validateKey(k);
    head = doRemove(k, head)
  }

  def doRemove(k: String, n: Node): Node = {
    if (n == null) null
    else if (k.length != 0) {
      val l = k.charAt(0)
      n.next(l) = doRemove(k.substring(1), n.next(l))
      n
    } else {
      if (n.value != None) {
        size -= 1
        n.value = None
      }
      if (n.next.exists(_ != null)) n else null
    }
  }

  def validateKey(k: String): Unit = if (k == null) throw new IllegalArgumentException("Empty string")
}
