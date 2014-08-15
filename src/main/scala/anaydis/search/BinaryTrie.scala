package anaydis.search

class BinaryTrie[V] extends MyMap[String, V] {

  case class Node(value: V, key: String, right: Node = null, left: Node = null)

  var root: Node = null


  def get(k: String): V = {
    doGet(k, root, 0).value
  }

  def doGet(k: String, node: Node, level: Int): Node = {
    if (node.key == k) node
    else if (k(level) == 1) doGet(k, node.right, level + 1)
    else doGet(k, node.left, level + 1)
  }

  def put(k: String, v: V): Unit = {

  }

  def doPut(node: Node, v: V, k: String): Node = {
    if(node == null) Node(v, k)
    else if(node.right != null || node.left != null)
      //TODO
  }

  def size: Int = ???

  def contains(k: String): Boolean = ???

  def remove(k: String): Unit = ???
}
