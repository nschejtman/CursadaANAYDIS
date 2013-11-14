package anaydis.search

trait ImmutableList[+A] {
  def ::[B >: A](b: B): ImmutableList[B]
  def head: A
  def tail: ImmutableList[A]
  def size: Int
  def reverse: ImmutableList[A]

}

private case class Node[A](head: A, tail: ImmutableList[A] = null) extends ImmutableList[A] {
  def ::[B >: A](b: B): ImmutableList[B] = Node(b, this)


  def size: Int = {
    var sizeDummy = 1
    var listDummy: ImmutableList[A] = this
    while (listDummy.tail != Nil) {
      sizeDummy += 1
      listDummy = listDummy.tail
    }
    return sizeDummy
  }

  def reverse: ImmutableList[A] = {
    var listDummy: ImmutableList[A] = this
    var listReverse: ImmutableList[A] = Nil
    while(listDummy != Nil){
    listReverse = listDummy.head :: listReverse
    listDummy = listDummy.tail
    }
    listReverse
  }

  override def toString = s"$head -> $tail"
}

private object Nil extends ImmutableList[Nothing] {
  def ::[B >: Nothing](b: B): ImmutableList[B] = Node(b, Nil)

  def head: Nothing = throw exception("head")

  def tail: ImmutableList[Nothing] = throw exception("tail")

  def size: Int = 0

  def reverse: ImmutableList[Nothing] = throw exception("reverse")


  override def toString = "Nil"

  def exception(method: String) = new UnsupportedOperationException(s"Empty list: $method")
}

object ImmutableListMain extends App {
  var lst = 1 :: 2 :: 3 :: 4 :: Nil
  print(lst.reverse)
}
