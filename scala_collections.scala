Scala Collections
=================================================================================
var||val||def difference
-------------------------------------
val and var will immediately evaluate the expression while def will be lazily evaluated, will evaluate when first time called

scala> val a  = 1
a: Int = 1

scala> var a = 1
a: Int = 1

scala> def a = 1
a: Int

scala> a
res19: Int = 1



Maps
-------------------------------------
By default Map() will give you an immutable map.

scala> val map1 = Map(1->2,2->3,3->4)
map1: scala.collection.immutable.Map[Int,Int] = Map(1 -> 2, 2 -> 3, 3 -> 4)

scala> map1.get(13)
res14: Option[Int] = None

scala> map1.get(1)
res15: Option[Int] = Some(2)

scala> map1.getOrElse(13)
<console>:27: error: not enough arguments for method getOrElse: (key: Int, default: => B1)B1.
Unspecified value parameter default.
       map1.getOrElse(13)
                     ^

scala> map1.getOrElse(13,0)
res17: Int = 0

scala> map1.getOrElse(1,0)
res18: Int = 2


// if you import scala.collection.mutable.Map, then mutable Map will be created, and we can modify those if created using var
scala> import scala.collection.mutable.Map
import scala.collection.mutable.Map

scala> val a = Map(1->1)
a: scala.collection.mutable.Map[Int,Int] = Map(1 -> 1)

scala> a = Map(2->2)
<console>:27: error: reassignment to val
       a = Map(2->2)
         ^

scala> var a = Map(1->1)
a: scala.collection.mutable.Map[Int,Int] = Map(1 -> 1)

scala> a = Map(2->2)
a: scala.collection.mutable.Map[Int,Int] = Map(2 -> 2)

// keys extraction
scala> map1.keys
res21: Iterable[Int] = Set(2, 1, 3)

//values extraction
scala> map1.values
res22: Iterable[Int] = HashMap(3, 2, 4)

// traversing a scala map 
//way1
scala> for ((k,v) <- map1){
     | println("keys::", k)
     | println("values::",v)
     | }
(keys::,2)
(values::,3)
(keys::,1)
(values::,2)
(keys::,3)
(values::,4)


// immutable Map - element addition 
scala> map1 = map1 ++ scala.collection.mutable.Map(13->14)
map1: scala.collection.mutable.Map[Int,Int] = Map(2 -> 3, 13 -> 14, 1 -> 2, 3 -> 4)

scala> map1 = map1 + (5->5)
map1: scala.collection.mutable.Map[Int,Int] = Map(2 -> 3, 5 -> 5, 13 -> 14, 1 -> 2, 3 -> 4)

// Map to String 
scala> map1.mkString("")
res31: String = 2 -> 35 -> 513 -> 141 -> 23 -> 4

scala> map1
res32: scala.collection.mutable.Map[Int,Int] = Map(2 -> 3, 5 -> 5, 13 -> 14, 1 -> 2, 3 -> 4)

// length of scala map 
scala> map1.size
res35: Int = 5


// Map to List
scala> map1.toList
res36: List[(Int, Int)] = List((2,3), (5,5), (13,14), (1,2), (3,4))

scala> map1.toList.mkString(" ")
res37: String = (2,3) (5,5) (13,14) (1,2) (3,4)


// updating value in a Map 
scala> map1.update(1,100)

scala> map1
res45: scala.collection.mutable.Map[Int,Int] = Map(2 -> 3, 5 -> 5, 13 -> 14, 1 -> 100, 3 -> 4)






Scala Core
==================================================
Break concept
--------------------
import scala.util.control.Breaks._

scala> a.sorted
res0: Array[Int] = Array(4, 9, 11, 12, 53, 77, 90)

scala> val b = a.sorted
b: Array[Int] = Array(4, 9, 11, 12, 53, 77, 90)

scala> breakable{ for (i <- b){ if (i > 10){println(i); break;}}}
11



Anonymous function
-----------------------------
In Scala, An anonymous function is also known as a function literal. A function which does not contain a 
name is known as an anonymous function. An anonymous function provides a lightweight function definition. 
It is useful when we want to create an inline function.

scala> val a = (x:Int) => x*x
a: Int => Int = <function1>

scala> b
res7: Array[Int] = Array(4, 9, 11, 12, 53, 77, 90)

scala> b.foreach{m => println(a(m))}
16
81
121
144
2809
5929
8100



Partial Function 
-----------------------------
The partitial functions does not work for all the values of the input variable
you can check whether a particular value is a valid one for the function or not before 
calling the function.

val divide = new PartialFunction[Int, Int] {
    def apply(x: Int) = 42 / x
    def isDefinedAt(x: Int) = x != 0
}

scala> if (divide.isDefinedAt(2)) println(divide(2))
21

-- the isDefinedAt/apply function is mandatory || we can use case inside the partitial function


val divide = new PartialFunction[Int, Int] {
    def apply(x: Int):Int = 42 / x
    def isDefinedAt(x: Int):Boolean = x != 0
}


*** using case 
val divide2: PartialFunction[Int, Int] = {
    case d: Int if d != 0 => 42 / d
}


Tail recursion
---------------------
scala> import scala.annotation.tailrec
import scala.annotation.tailrec

scala> def factorial(curr:Int, n:Int): Int = {
     | if (n <=1) return curr
     | else factorial(curr*n, n-1)
     | }
factorial: (curr: Int, n: Int)Int

scala> factorial(1,7)
res5: Int = 5040

** use partially applied function 

scala> val fact = factorial(1,_:Int)
fact: Int => Int = <function1>

scala> fact(10)
res7: Int = 3628800


Scala Implicit parameters
---------------------------------
Implicit parameters are the parameters that are passed to a function with implicit keyword in Scala, which means the 
values will be taken from the context in which they are called. In simpler terms, if no value or parameter is passed 
to a method or function, then the compiler will look for implicit value and pass it further as the parameter.

changing an integer variable to a string variable can be done by a Scala compiler rather than calling it explicitly.

scala> implicit val multiplier = 3
multiplier: Int = 3

scala> val value = 10
value: Int = 10

scala> def multiply(implicit by: Int) = value * by
multiply: (implicit by: Int)Int

scala> multiply
res9: Int = 30



Scala Option
---------------------------------





Concurrency vs Parrallelism
----------------------------------
Concurrency is when two or more tasks can start, run, and complete in overlapping time periods. 
It doesnt necessarily mean they'll ever both be running at the same instant. For example, multitasking on a single-core machine.

Parallelism is when tasks literally run at the same time, e.g., on a multicore processor.














