package anaydis.search

class TreeMap[K <% Ordered[K], V] extends AbstractTreeMap[K, V] {
  def find(n: Node, k: K): Node = if (n == null) null
  else {
    val cmp = k.compare(n.key)
    if (cmp == 0) n
    else if (cmp < 0) find(n.left, k)
    else find(n.right, k)
  }

  def doPut(n: Node, k: K, v: V): Node = if (n == null) newLeaf(k, v)
  else {
    val cmp = k.compare(n.key)
    if (cmp < 0) n.left = doPut(n.left, k, v)
    else if (cmp > 0) n.right = doPut(n.right, k, v)
    else n.value = v
    n
  }

  def doRemove(n: Node, k: K): Node =
    if (n == null) null
    else {
      val cmp = k.compare(n.key)
      if (cmp < 0) {
        n.left = doRemove(n.left, k); n
      }
      else if (cmp > 0) {
        n.right = doRemove(n.right, k); n
      }
      else if (n.right == null) n.left
      else if (n.left == null) n.right
      else {
        val first = firstNode(n.right)
        first.left = n.left
        first.right = doRemove(n.right, first.key)
        first
      }
    }
}
