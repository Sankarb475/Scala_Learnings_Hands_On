
//Taking input dynamically
//==========================================================================
val a = Console.readLine   //it has been depreciated

import scala.io._

val a = StdIn.readLine("Give Input \n")    //the input is always in String
val aInt = a.toInt


//Defining two dimensional array(10 * 10) with 'null' as default value
//==========================================================================

var myArray = Array.ofDim[String](10, 10)
val a = ArrayBuffer.fill(10,10)(null)
val a : ArrayBuffer[ArrayBuffer[String]] = ArrayBuffer.fill(10,10)("null")




//Generating all the combination subsets of a list
//==========================================================================

val xs = List( 'a', 'b' , 'c' , 'd' , 'e','a')
val output = (1 to xs.length flatMap (x => xs.combinations(x))) map ( x => x.mkString(""))

/*output ==> output1: Seq[String] = Vector(a, b, c, d, e, aa, ab, ac, ad, ae, bc, bd, be, cd, ce, de, aab, aac, aad, aae, 
abc, abd, abe, acd, ace, ade, bcd, bce, bde, cde, aabc, aabd, aabe, aacd, aace, aade, abcd, abce, abde, acde, bcde, aabcd, 
aabce, aabde, aacde, abcde, aabcde)
*/
def combine(in: List[Char]): Seq[String] = 
    for {
        len <- 1 to in.length
        combinations <- in combinations len
    } yield combinations.mkString 

combine(xs) // Gives the same output



//Sorting two collection
//==========================================================================
val l1 = List(1,2,3) 
val l2 = List(2,3,1)

//If what you want is "these lists contain the same elements, irrespective of order or repetitions":
l1.toSet == l2.toSet  //output = true , because there are no duplicate elements

//If what you want is "these lists contain the same elements, and with the same number of repetitions of each":
l1.sorted == l2.sorted  //output = true

//If what you want is "these lists contain the same elements and are the same size, but the number of repetitions of a 
//given element can differ between the two lists":
l1.size == l2.size && l1.toSet == l2.toSet




//Definign multiple parameters at a time
//==========================================================================

scala> val (l,r) = (1,2)
l: Int = 1
r: Int = 2


scala> val (l,r,m) = (1,2,Array.range(1,5))
l: Int = 1
r: Int = 2
m: Array[Int] = Array(1, 2, 3, 4)



//Scala Multilines
//==========================================================================

val a = """I am a Big Data Engineer
        working for a MNC"""

//output
a: String =                         
I am a Big Data Engineer
        working for a MNC

//if we wanna avoid the unneccesary spaces

val a = """I am a Big Data Engineer
        #working for a MNC""".stripMargin('#')
//output
a: String =
I am a Big Data Engineer
working for a MNC

//stripMargin by default takes '|' as delimiter

//If we wanna write multilines but want to have it in a single line

val a = """This is an example of Multilines,
        |but we would rather want to see the
        |output in a single line""".stripMargin.replaceAll("\n", " ")

//output
a: String = This is an example of Multilines, but we would rather want to see the output in a single line




//Scala Options
//==========================================================================
scala> val m = 98
m: Int = 98

scala> val p : Option[Int] = if (m > 100) Some(m) else None
p: Option[Int] = None

scala> val result = p.getOrElse("None")  //p.get will throw an error because "p" is None
result: Any = None

scala> p.isDefined
res124: Boolean = false


scala> val p : Option[Int] = if (m > 10) Some(m) else None
p: Option[Int] = Some(98)

scala> val result = p.get
result: Int = 98

scala> p.isEmpty
res114: Boolean = false

scala> p.exists(_ > 90)
res116: Boolean = true

scala> p.foreach(println)
98

scala> p.filter(_ > 30)
res121: Option[Int] = Some(98)

scala> p.filter(_ > 30).getOrElse("None")
res122: Any = 98

scala> p.filter(_ > 100).getOrElse("Empty")
res123: Any = Empty

scala> p.isDefined
res125: Boolean = true




/*Scala concept "Either" which kind of works like Options, it helps us define different return type A common use of Either 
is as an alternative to Option for dealing with possible missing values. In this usage, scala.None is replaced with a 
Left which can contain useful information. Right takes the place of Some. Convention dictates that Left is used for failure 
and Right is used for success
====================================================================================================
*/
def either (a:Int,b:Int) : Either[Double,String] = {
  if (b == 0) Right("divide by 0 exception")
  else Left(a/b)
}

scala> val a = either(3,0)
a: Either[Double,String] = Right(divide by 0 exception)

scala> val b = either(31,3)
b: Either[Double,String] = Left(10.0)

//taking the value out from the Right/Left Wrapper

scala> val c = b match {
     |   case Right(x) => x.toString
     |   case Left(x) => x.toDouble
     | }
c: Any = 10.0

scala> val output = b.fold(l => l.toDouble, r => r.toString)
output: Any = 10.0

scala> val d = Right(5.0)
d: scala.util.Right[Nothing,Double] = Right(5.0)

scala> val d : Either[Any,String] = Right("Dummy")
d: Either[Any,String] = Right(Dummy)

scala> val e = d.fold(l => l.toString, r => r.toString)
e: String = Dummy

//using "merge" we can get the output, but the return type always ends up being "Any"

scala> val empty : Either[String,Int] = Right(1000)
empty: Either[String,Int] = Right(1000)

scala> val emptyVal = empty.merge
emptyVal: Any = 1000


//Scala Sealed Classes and final methods/classes/parameters
//==========================================================================
A final class cannot be extended.

//Final Class

scala> final class Dummy
defined class Dummy

scala> class DummyName extends Dummy
<console>:8: error: illegal inheritance from final class Dummy
       class DummyName extends Dummy


//Final Method
scala> class Dummy {
     | final def example(a: Int, b : Int) = {
     | a+b
     | }
     | }
defined class Dummy

scala> class Dummy2 extends Dummy{
     | def example (c : Int, d : Int) = {
     | c+d
     | }
     | }
<console>:12: error: overriding method example in class Dummy of type (a: Int, b: Int)Int;
 method example cannot override final member
       def example (c : Int, d : Int) = {
           

//Final Parameters

scala> trait dummy {
     | final val a : String = "Puja"
     | }
defined trait dummy

scala> class Dummy2 extends dummy{
     | val a = "Sankar"
     | }
<console>:9: error: overriding value a in class dummy$class of type String;
 value a cannot override final member
       val a = "Sankar"     
           
/*
Sealed Class : A sealed class may not be directly inherited, except if the inheriting template is defined in 
the same source file as the inherited class. However, subclasses of a sealed class can inherited anywhere. 
A sealed trait can only be extended in the same source file as it's declared.
Option is a sealed class.
*/
     
scala> sealed trait Option[+A]
defined trait Option

//Because Option[A] is sealed, it cannot be extended by other developers - doing so would alter its meaning
//As an added bonus, if a trait is sealed, the compiler can warn you if your pattern matches are not exhaustive 
//enough because it knows that Option is limited to Some and None.
    
