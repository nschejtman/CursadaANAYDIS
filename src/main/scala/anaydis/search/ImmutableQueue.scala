package anaydis.search

trait ImmutableQueue[+A] {

  def enqueue[B >: A](b: B): ImmutableQueue[B]

  def dequeue: (ImmutableQueue[A], A)

  def last: A

  def first: A

  def size: Int
}

private case class Cons[+A](var front: ImmutableList[A], var back: ImmutableList[A] = null) extends ImmutableQueue[A] {

  def enqueue[B >: A](b: B): ImmutableQueue[B] = Cons(front, b :: back)

  def dequeue: (A, ImmutableQueue[A]) = {
    if (front != Nil)
      (front.head, Cons(front.tail, back))
    else {
      val hi = size / 2
      back = back.reverse
      for (i <- 1 to hi) {
        front = back.head :: front
        back = back.tail
      }
      back = back.reverse
      (front.head, Cons(front.tail, back))
    }
  }

  def last: A = back.head

  def first: A = front.head

  def size: Int = front.size + back.size
}


