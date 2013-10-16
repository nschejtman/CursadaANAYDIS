package anaydis.search

import scala.collection.immutable.Stack
import scala.collection.mutable.LinkedList

trait AbstractTreeMap[K, V] extends MyMap[K, V] {

  case class Node(key: K, var value: V, var left: Node = null, var right: Node = null) {
    override def toString: String = s"k $key, v $value, l:$left r:$right"

    def size: Int = 1 + left.size + right.size
  }

  protected var head: Node = null

  def contains(k: K): Boolean = find(head, k) == null

  def get(k: K): V = {
    val n = find(head, k)
    if (n == null) notFound(k)
    n.value
  }

  def newLeaf(k: K, v: V) = {
    size += 1;
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
    val stack = toStack(head)
    for (x <- 0 to n) {
      stack.pop
    }
    stack.top
  }

  def range(lo: Int, hi: Int): LinkedList[Node] = {
    val list = new LinkedList[Node]
    val stack = toStack(head)
    for (i <- 0 to lo - 1) {
      stack.pop
    }
    for (i <- lo to hi) {
      list -> stack.top
      stack.pop
    }
    list
  }


  def toStack(node: Node): Stack[Node] = {
    val stack = new Stack[Node]
    stack.pushAll(toStack(node.right))
    stack.push(node)
    stack.pushAll(toStack(node.left))
    stack
  }


  override def toString: String = if (head == null) "{}" else head.toString()


}
