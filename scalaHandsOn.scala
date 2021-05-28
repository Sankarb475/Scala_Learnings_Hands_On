Scala Constructors
======================================
Constructors are used to initializing the object’s state, it has a set of statments that are executed when an object 
is created.
-- Primary constructor

-- Auxiliary constructor
uses "this" keyword 
a single class can have multiple auxiliary constructors.


Traits, interfaces and Abstract classes
===========================================
Traits can be seen as interfaces in other languages. 
-- They however allow the developers to implement all or some of their methods that is trait is a combination of abstract and non-abstract methods.
-- Whenever there is some code in traits, it is called mixins.
-- but unlike interfaces, a trait can have partially implemented methods.
-- Unlike interface, traits can inherit a class,another trait or an abstract class. Interfaces can only inherit another interface.
-- Traits support multiple inheritance.


-- Traits differ from abstract class on the fact that traits supports multiple inheritance which abstract class doesnt.
-- traits might not have construct parameters but abstract class can have. 


Traits and Mixins
=======================
Traits can be seen as interfaces in other languages. 

-- They however allow the developers to implement all or some of their methods that is trait is a combination of abstract and non-abstract methods.
-- Scala traits cannot be instantiated and have no arguments or parameters.

-- Mixin is the fact that you are extending multiple types of claases with right order and manner.
remember that only a trait can be extended multiple times, abstract and normal classes can only be extended once.
mixin is inheriting more than one trait and inheriting either a class/abstract class

A,B -> abstract classes
test1, test2, test3 -> traits
real1, real2, real3 -> normal classes

class prac1 extends real1 with A => error



Trait as Classes
=====================
trait Beeper {
def beep(times : Int) : Unit = {
assert (times >=0) 
1 to times foreach(i => println(s"Beep number : $i"))}
}

scala> val beeper = new Beeper {}
beeper: Beeper = $anon$1@6987a133

scala> beeper.beep(2)
Beep number : 1
Beep number : 2

--if there exists any non-implemented method in the trait we wouldnt be able to 
instantiate the trait.

SELF/ this 
----------------
"this" make sure if youre extending a trait which in turn extends another trait, while 
extending that trait we need to extend the other trait as well with "key" keyword

scala> trait Notifier{
     | val message : String
     | def clear() 
     | }
defined trait Notifier

scala> trait AlarmNotifier{
     | this : Notifier =>
     | def trigger() : String 
     | }
defined trait AlarmNotifier

scala> class watch
defined class watch

scala> val example = new watch with AlarmNotifier with Notifier{
     | val message = "Message"
     | def trigger = "Message from trigger"
     | def clear() = println("dumdum")
     | }
example: watch with AlarmNotifier with Notifier = $anon$1@2e4d252

Same Signatures and Return types Mixins
==============================================
if we have two methods

scala> trait A {
     | def hello () : String = "trait A"
     | }
defined trait A

scala> trait B {
     | def hello () : String = "trait B"
     | }
defined trait B

scala> object Clashing extends A with B {
     | override def hello() : String = super[A].hello()
     | def main(args : Array[String]) : Unit = {
     | print(hello())
     | }}
defined object Clashing

scala> object Clashing extends A with B {
     | override def hello() : String = super.hello()
     | def main(args : Array[String]) : Unit = {
     | print(hello())
     | }}
defined object Clashing


scala> trait A
defined trait A

scala> trait B {
     | def hello () : String = "trait B"
     | }
defined trait B

scala> object Clashing extends A with B{
     | def main(args : Array[String]) : Unit = {
     | print(hello())
     | }}
defined object Clashing


*** We use Override only when a class extends two or more Classes/Traits having
methods with same name, or when we want to define a method differently than what 
is their in the parent class and the method names are having same name.

scala> trait A {
     | def value(a : Int) : String = a.toString
     | }
defined trait A

scala> trait B {
     | def value(a:Int) : Int = a
     | }
defined trait B

scala> trait A{
     | }
defined trait A

scala> object Notifier extends A with B{
     | println(value(2))
     | }
defined object Notifier

scala> Notifier
2
res2: Notifier.type = Notifier$@6d911985

object Notifier extends A with B{
override def value(a:Int) = super[A].value
println(value(2))
}


METHOD OVERRIDING
================================
when overriding a method in a subclass, you may want to call the original 
implementation as well. This is achieved by prefixing the "super" keyword to the
method name. We can also chosse the trait name while usinfg "super" keyword
like super[trait_name].method_name

scala> class A{
     | def identity : Int = 1
     | }
defined class A

scala> trait B extends A {
     | override def identity : Int = 2 * super.identity
     | }
defined trait B

***here below we need not have to extend the class parent class is extending : 

scala> class A{
     | def identity : Int = 1
     | }
defined class A

scala> trait B extends A {
     | override def identity : Int = 2 * super.identity
     | }
defined trait B

scala> class C extends B
defined class C

TRAITS vs Classess
=======================
1) Traits should be used when a piece of code is being used in multiple unrelated 
classes while classes when a behaviour is noty going to be reused at all.

2) When you want to define interfaces and want to use them outside scala, then Trait.
when the scala code is going to get used from another language.


ScalaTest
=======================
ScalaTest makes three assertions available by default in any style trait. You can use:

assert for general assertions;
assertResult to differentiate expected from actual values;
assertThrows to ensure a bit of code throws an expected exception.


scala> val a = 2
a: Int = 2

scala> val b = 3
b: Int = 3

scala> assert(a==b)
java.lang.AssertionError: assertion failed
  at scala.Predef$.assert(Predef.scala:204)
  ... 29 elided
  
scala> val b = 2
b: Int = 2

scala> assert(a==b)


TYPE aliasing
============================
trait base{
type T
def method : T
}

object Implementation extends base{
type T = Int
def method: T = 2
}


Difference between case class and a normal class
==================================================
for case class::

You can do pattern matching on it.

You can construct instances of these classes without using the new keyword.

All constructor arguments are accessible from outside using automatically generated 
accessor functions.

The toString method is automatically redefined to print the name of the case class 
and all its arguments.

The equals method is automatically redefined to compare two instances of the same 
case class structurally rather than by identity.

The hashCode method is automatically redefined to use the hashCodes of constructor 
arguments.


Most of the time you declare a class as a case class because of point 1, i.e. 
to be able to do pattern matching on its instances.

Basically, you can think of a case class as a named tuple, whose fields are named as well.


example :: Pattern Matching using Case Class
=======================================================
scala> case class MyCase(name: String, age: Int)
defined class MyCase

scala> val data : List[MyCase] = List(MyCase("Sankar",1),MyCase("Jordan",2),MyCase("Susan",3))
data: List[MyCase] = List(MyCase(Sankar,1), MyCase(Jordan,2), MyCase(Susan,3))

scala> data foreach { 
     |     case MyCase(_, age) if age > 21 => println("old enough")
     |     case MyCase("fred", _ ) => println("Got you")
     |     case _ => println("Error")
     | }
Error
Error
Error


example - Automatic field creation: Name is immutable field automatically created 
by Scala in Case class but not in normal class
========================================================

scala> case class MyClass(Name:String)
defined class MyClass

scala> class YourClass(Name:String)
defined class YourClass

scala> val objMy = MyClass("Sankar")
objMy: MyClass = MyClass(Sankar)

scala> val objYour = new YourClass("Sankar")
objYour: YourClass = YourClass@36ad5f2a

scala> objMy.Name
res20: String = Sankar

scala> objYour.Name
<console>:10: error: value Name is not a member of YourClass
              objYour.Name


'final' keyword in scala
==================================================

You can't override final variables in subclass

scala> class Vehicle{
     | final val speed: Int = 60
     | }
defined class Vehicle

scala> class Bike extends Vehicle{
     | override val speed : Int = 100
     | println(speed)
     | }
<console>:9: error: overriding value speed in class Vehicle of type Int;
 value speed cannot override final member
       override val speed : Int = 100
                    ^

You can't override final methods in subclass

scala> trait Dummy{
     | final def sum(a:Int,b:Int) = a*b
     | }
defined trait Dummy

scala> 

scala> class Man extends Dummy{
     | override def sum(a:Int,b:Int) = a/b
     | }
<console>:12: error: overriding method sum in trait Dummy of type (a: Int, b: Int)Int;
 method sum cannot override final member
       override def sum(a:Int,b:Int) = a/b
                    ^


You can also make final class. Final class can't be inherited. If you make a class final, 
it can't be extended further.



App trait extends DelayedInit
===================================
The App trait can be used to quickly turn objects into executable programs.

The App trait is a convenient way of creating an executable scala program. The 
difference to the main method altenative is that the App trait uses the delayed 
initalization feature.

object extends App was not executed by "scala MyObject.scala" command, but the 
object containing the main method was executed by "scala MyObject.scala" command


object Application extends App {
   println("Hello World")
}

object Application {
    def main(args: Array[String]): Unit = {
        println("Hello World");
    }
}


For rapid prototyping, I use App, because you just write your script in the body 
and that's it, no unnecessary noise. As others have explained, the problem occurs 
when other objects refer to vals in your main object, because those will not be 
initialized like a regular object but only when the main method has 
actually been called. So in that case, go with an explicit main method.



***The code in the body of the object is automatically run, just as if it were 
inside a main method.

so when you extend App class, whatever you write inside


When using this approach, any command-line arguments to your application are 
implicitly available through an args object, which is inherited from the App trait. 
The args object is an instance of Array[String], just as if you had declared a main 
method yourself. The following code demonstrates how to use the args object:

object Hello extends App {
    if (args.length == 1)
        println(s"Hello, ${args(0)}")
    else
        println("I didn't get your name.")
}
After it’s been compiled, this program yields the following results:

$ scala Hello
I didn't get your name.

$ scala Hello Joe
Hello, Joe


Finding the Largest Key or Value in a Map
======================================================================================
scala> val grades = Map("Al" -> 80, "Kim" -> 95, "Teri" -> 85, "Julia" -> 90)
grades: scala.collection.mutable.Map[String,Int] = Map(Teri -> 85, Julia -> 90, Kim -> 95, Al -> 80)

scala> grades.max
res33: (String, Int) = (Teri,85)

***finds the maximum Map key-value pair based on the Keys and then values

scala> grades.keysIterator.max
res34: String = Teri

scala> grades.keysIterator.reduceLeft((x,y) => if (x > y) x else y)
res2: String = Teri

***gets the maximum key value out of the map

scala> grades.keysIterator.reduceLeft((x,y) => if (x.length > y.length) x else y)
res3: String = Julia

***gets the key with the highest length

scala> grades.valuesIterator.max
res4: Int = 95

scala> grades.valuesIterator.reduceLeft(_ max _)
res5: Int = 95

***gets the maximum value from the map

======================================================================================
scala> val b = if(a.toLong > pow(2,31)-1 || a.toLong < -pow(2,31)) 2147483647 else -2147483648
b: Int = 2147483647

scala> val b = if(a.toLong > pow(2,31)-1) 2147483647 else if(a.toLong < -pow(2,31)) -2147483648 else a.toLong
b: Long = -2147483648

scala> val a = "-91283472332"
a: String = -91283472332


val b = a.toLong match{
case m if m > pow(2,31)-1 => 2147483647
case m if m < -pow(2,31) => -2147483648
case other => other
}


scala> val b = a.toLong match{
     | case m if m > pow(2,31)-1 => 2147483647
     | case m if m < -pow(2,31) => -2147483648
     | case other => other
     | }
b: Long = -2147483648

def checkWords(str : String) = {
val reg = "^\\w".r
val b = reg.findFirstIn(str)
if(!b.isEmpty){
}
else{
}
}


val a1 = if(b.startsWith("+") || b.startsWith("-") || arr.contains(b(0))) true else false

val a = "//S".r
val b = a.findAllIn(str).toBuffer.mkString

Range.myAtoi("-99980&798797979")

Range.myAtoi("words 999")

Range.myAtoi("999")

Range.myAtoi("+999")

Range.myAtoi("-999")

Range.myAtoi("")

Range.myAtoi("+")

Range.myAtoi("   ")

Range.myAtoi("+-2")

Range.myAtoi("20000000000000000000")

Range.myAtoi("- 234")

Range.myAtoi("3141678.59888")

Range.myAtoi("  0000000000012345678")

Range.myAtoi("1a")


"3.14159"
"20000000000000000000"

"  0000000000012345678"

var str1 : String = if(str.slice(1,str.length).toLong > 214748364799) str.slice(0,11).toString else str.toString


"words 999"

isFlagBlaBla

creating Implicit in function
====================================================
scala> implicit class InOperation[T](v: T) extends AnyVal { def in(s: Set[T]) = { s contains v } }
defined class InOperation

scala> val x = Set(1,2,3)
x: scala.collection.immutable.Set[Int] = Set(1, 2, 3)

scala> 2 in x
res0: Boolean = true
====================================================

