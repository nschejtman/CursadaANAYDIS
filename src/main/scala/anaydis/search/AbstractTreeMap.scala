package anaydis.search


trait AbstractTreeMap[K, V] extends MyMap[K, V] {

  case class Node(key: K, var value: V, var left: Node = null, var right: Node = null, var size: Int = 1) {

    //Method to print nodes
    override def toString: String = s"k $key, v $value, l:$left r:$right"

    //Method that returns the value of a node
    def element = value

    //Method that return the size of a node
    def doSize: Int = 1 + {
      if (left == null) 0 else left.size
    } + {
      if (right == null) 0 else right.size
    }

    //Method that updates the size of a node
    def updateSize = size = 1 + nodeSize(left) + nodeSize(right)

    //Method used by the update method to calculate the size
    def nodeSize(n: Node) = if (n != null) n.size else 0


    // Method that returns a node given its index
    def nth(n: Int): Node = {
      val idx = if (left != null) left.size else 0
      if (n == idx) this
      else if (n < idx && left != null) left.nth(n)
      else if (n > idx && right != null) right.nth(n - idx - 1)
      else throw new IndexOutOfBoundsException
    }

    //Method that returns the range of nodes from lo to hi index
    //TODO (improve)
    def range(lo: Int, hi: Int): List[Node] = {
      if (lo > hi) throw new IllegalArgumentException
      val idx = size
      if (lo > idx || hi > idx) throw new IllegalArgumentException
      var list = List[Node]()

      for (x <- lo to hi) {
        list = list ++ List(nth(x))
      }

      list
    }
  }

  protected var head: Node = null

  def contains(k: K): Boolean = find(head, k) == null

  def get(k: K): V = {
    val n = find(head, k)
    if (n == null) notFound(k)
    n.value
  }

  def newLeaf(k: K, v: V) = {
    Node(k, v)
  }

  def size: Int = {
    if (head == null) 0
    else head.size
  }

  def put(k: K, v: V) = head = doPut(head, k, v)

  def remove(k: K) = head = doRemove(head, k)

  def find(n: Node, k: K): Node

  def doPut(n: Node, k: K, v: V): Node

  def doRemove(n: Node, k: K): Node

  def firstNode(n: Node): Node = if (n == null || n.left == null) n else firstNode(n.left)

  def nth(n: Int): Node = {
    head.nth(n)
  }

  def range(lo: Int, hi: Int): List[Node] = {
    head.range(lo, hi)
  }

  override def toString: String = if (head == null) "{}" else head.toString()


}
