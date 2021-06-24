Scala closures and Anonymous function 
=========================================
Closures
----------------------------
scala> val a = 4
a: Int = 4

scala> val b = (x:Int) => x*a
b: Int => Int = <function1>

scala> val c = b(a)
c: Int = 16

Anonymous function
-----------------------------
scala> val a = 4
a: Int = 4

scala> val b = (x:Int) => x*x
b: Int => Int = <function1>

scala> val d = b(a)
d: Int = 16


Partially applied function and Currying
===========================================
Partially applied function
-----------------------------
scala> def test(x:Int, y:Int) : Int = x*y
test: (x: Int, y: Int)Int

scala> val partial_test = test(10, _:Int)
partial_test: Int => Int = <function1>

scala> partial_test(20)
res0: Int = 200


Currying
-----------------------------
scala> def add2(a: Int) = (b: Int) => a + b
add2: (a: Int)Int => Int

-- def add2(a: Int) (b: Int) = a + b

scala> val m = add2(20)(10)
m: Int = 30

scala> val n = add2(20)
n: Int => Int = <function1>

scala> n(20)
res1: Int = 40

** another example
scala> def add2(a: Int) = (b: Int) => a/b
add2: (a: Int)Int => Int

scala> val p = add2(20)
p: Int => Int = <function1>

scala> val q = p(5)
q: Int = 4

scala> val q = p(40)
q: Int = 0



Placeholder syntax
=====================================
Scala allows the use of underscores (denoted as ‘_’) to be used as placeholders for one or more parameters. 
we can consider the underscore to something that needs to be filled in with a value. However, each parameter must 
appear only one time within the function literal.

scala> val a = List(1,2,34,5)
a: List[Int] = List(1, 2, 34, 5)

scala> a.filter(_ > 5)
res0: List[Int] = List(34)

scala> val b = (_ : Int) + (_ : Int)
b: (Int, Int) => Int = <function2>

scala> b(20,30)
res1: Int = 50


This keyword | Auxiliary constructor
==============================================
-- it is used to refer current object
-- this keyword is used to define auxiliary constructor, instances, variables

scala> class test_this{
     | val test_val = 34
     | def this(out:Int){
     | this()
     | println("nothing")
     | }
     | }
defined class test_this

scala> val a = new test_this(34)
nothing
a: test_this = test_this@6092d41


Implicit 
==============================================
scala> implicit val a = 34
a: Int = 34

scala> def test_implicit(implicit out:Int) = 10*out
test_implicit: (implicit out: Int)Int

scala> val test = test_implicit
test: Int = 340


Difference between Val, Var and def
==============================================
-- the val and var are evaluated when defined, while def is evaluated on call.

scala> val a = (input1:Int, input2:Int) => input1 + input2
a: (Int, Int) => Int = <function2>

scala> var a = (input1:Int, input2:Int) => input1 + input2
a: (Int, Int) => Int = <function2>

scala> def a = (input1:Int, input2:Int) => input1 + input2
a: (Int, Int) => Int


-- Lazy evaluation will make the behaviour same 
if we never use "a"? We wasted our map operation (CPU computations) which can be very costly when we write more complex and bigger code. 
Here lazy evaluation helps us in optimizing the process by evaluating the expression only when it’s needed and avoiding unnecessary overhead.

scala> lazy val a = (input1:Int, input2:Int) => input1 + input2
a: (Int, Int) => Int = <lazy>


Constructors 
=============================================
when you create an object of a class, the constructors are automatically called. It initializes the 
state of a class.

whatever statements are written inside the curly braces after class definition belongs to the constructor.


Scala Option
=============================================
Scala option return a "None" when there is null value present.
-- many a times that could be a reason for an exception 

scala> val capitals = Map("India"-> "Delhi","Japan"->"Tokyo")
capitals: scala.collection.immutable.Map[String,String] = Map(India -> Delhi, Japan -> Tokyo)

scala> capitals("USA")
java.util.NoSuchElementException: key not found: USA
  at scala.collection.MapLike$class.default(MapLike.scala:228)
  at scala.collection.AbstractMap.default(Map.scala:59)
  at scala.collection.MapLike$class.apply(MapLike.scala:141)
  at scala.collection.AbstractMap.apply(Map.scala:59)
  ... 49 elided

scala> capitals("India")
res6: String = Delhi

scala> capitals.get("USA")
res7: Option[String] = None

scala> capitals.getOrElse("USA", "Not Present")
res9: String = Not Present


Scala Yield function
=============================================
yield will return you result after a loop iteration

scala> val m = for (x <- 1 to 3; y <- 5 to 7) yield List(x,y)
m: scala.collection.immutable.IndexedSeq[List[Int]] = Vector(List(1, 5), List(1, 6), List(1, 7), List(2, 5), List(2, 6), List(2, 7), List(3, 5), List(3, 6), List(3, 7))


Scala Types
================================================
-- In Scala, all values have a type, including numerical values and functions
Any is the supertype of all types. It defines certain universal methods such as equals, hashCode, and toString. 
Any has two direct subclasses: AnyVal and AnyRef.

-- AnyVal represents value types. There are nine predefined value types and they are non-nullable: 
Double, Float, Long, Int, Short, Byte, Char, Unit, and Boolean

-- AnyRef represents reference types. All non-value types are defined as reference types. Every user-defined type in Scala is a subtype of AnyRef.
List, option, user-defined classes.

Scala type casting is unidirectional and follows like this - 
bytes -> short -> Int -> Long -> Float -> Double
Char -> Int

-- Nothing is subtype of all types, and null is subtype of all reference types.


Scala Data Structures 
===============================================
Arrays, List, Sets, Tuples, Maps, Option

Arrays
--------------------------------------
it is a fixed size data structure that stores elements of the same data type.
Arrays preserve order, can contain duplicates, and are mutable.

scala> val arr = Array(1 to 2)
arr: Array[scala.collection.immutable.Range.Inclusive] = Array(Range(1, 2))

scala> for (i <- arr) {
     | println(i)
     | }
Range(1, 2)

scala> var name = new Array[String](4)
name: Array[String] = Array(null, null, null, null)

scala> var name = new Array[Int](4)
name: Array[Int] = Array(0, 0, 0, 0)

scala> name(3)
res15: Int = 0

scala> name(3)= 4

scala> name
res17: Array[Int] = Array(0, 0, 0, 4)

scala> name:+id
res27: Array[Any] = Array(0, 0, 0, 4, Array(7))

Adding two arrays - 
using concat method 
concat(name, id)

scala> name++id
res30: Array[Int] = Array(0, 0, 0, 4, 7)


:+	append 1 item			old_array :+ e
++	append N item			old_array ++ new_array
+:	prepend 1 item			e +: old_array
++:	prepend N items			new_array ++: old_array



Map/dictionary
-----------------------------
scala> m
res31: scala.collection.immutable.Map[Int,String] = Map(1 -> one)

scala> val n = Map(2->"Two")
n: scala.collection.immutable.Map[Int,String] = Map(2 -> Two)

scala> m++n
res32: scala.collection.immutable.Map[Int,String] = Map(1 -> one, 2 -> Two)


