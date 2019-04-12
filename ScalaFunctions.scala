Difference between map function and reduce function in Scala
==============================================================================================================================
reduce ::
===========
The reduce() method is a higher-order function that takes all the elements in a collection (Array, List, etc) and combines them
using a binary operation to produce a single value. It is necessary to make sure that operations are commutative and 
associative. Anonymous functions are passed as parameter to the reduce function.

scala> val a = List("rahul","is","awesome")
a: List[String] = List(rahul, is, awesome)

scala> val b = a.reduce((i,j) => i.toUpperCase)
b: String = RAHUL

scala> val b = a.reduce((i,j) => i+j.toUpperCase)
b: String = rahulISAWESOME

scala> val b = a.reduce((i,j) => (i+j).toUpperCase)
b: String = RAHULISAWESOME

so basically, it takes random pairs and after summing it up, converts into upper case. It acts best when you want to sum 
paired elements or do paired operations etc.

map ::
========
map on the other hand traverse through each element of the collection and does some operation on each row and returns the 
output.

scala> val a = Array(1,2,3,4,5)
a: Array[Int] = Array(1, 2, 3, 4, 5)

scala> val b = a.map(i => i+3)
b: Array[Int] = Array(4, 5, 6, 7, 8)

scala> val b = a.map(i => (i,2))
b: Array[(Int, Int)] = Array((1,2), (2,2), (3,2), (4,2), (5,2))


reduceByKey ::
=================
scala> val a = List(1,3,3,4,5,6,9,9,2,2,11,10,4,4,4,4,4,5)
a: List[Int] = List(1, 3, 3, 4, 5, 6, 9, 9, 2, 2, 11, 10, 4, 4, 4, 4, 4, 5)

scala> val rdd1 = sc.parallelize(a)
rdd1: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[14] at parallelize at <console>:28

scala> val rdd2 = rdd1.map(i => (i,1)).reduceByKey(_+_)
rdd2: org.apache.spark.rdd.RDD[(Int, Int)] = ShuffledRDD[16] at reduceByKey at <console>:30

scala> rdd2.collect().foreach(println)
(1,1)
(2,2)
(3,2)
(4,6)
(5,2)
(6,1)
(9,2)
(10,1)
(11,1)

scala> val rdd2 = rdd1.map(i => (i,1)).groupByKey()
rdd2: org.apache.spark.rdd.RDD[(Int, Iterable[Int])] = ShuffledRDD[18] at groupByKey at <console>:30

scala> rdd2.collect.foreach(println)
(1,CompactBuffer(1))
(2,CompactBuffer(1, 1))
(3,CompactBuffer(1, 1))
(4,CompactBuffer(1, 1, 1, 1, 1, 1))
(5,CompactBuffer(1, 1))
(6,CompactBuffer(1))
(9,CompactBuffer(1, 1))
(10,CompactBuffer(1))
(11,CompactBuffer(1))







