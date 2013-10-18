package anaydis.search

object Main extends App {
  var map: TreeMap[Int, String] = new TreeMap[Int, String]
  map.put(5, "Pepe")
  map.put(2, "Pepo")
  map.put(7, "Pepa")
  print(map.range(0,1))

}
