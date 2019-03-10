1) how scala constructor works?

==> Scala classes do not have a special name for constructor and the class initialization is just written in the body of the 
class. 

In Scala Language, a class can have two types of constructors:
1) Primary Constructor
2) Auxiliary Constructor

1) Primary constructors are those which has been defined in the class body or has been passed as arguments to the class.
2) We can define Auxiliary Constructors like methods by using “def” and “this” keywords. “this” is the constructor name. One 
   class can have any number of auxiliary constructor. Each Auxiliary Constructor should call one of the previous defined 
   constructor. An Auxiliary Constructor can call either Primary Constructor or another Auxiliary constructors by using “this” 
   name.

//We define Auxiliary Constructors in Class Body with “def” and “this” keywords, but not in Class Definition. We use Class 
//Definition to declare Primary Constructor.

scala> class foo{
     | def init(): Unit = {print("inside it ")}
     | init()
     | }
defined class foo

scala> val a = new foo()
inside it a: foo = foo@123772c4

that is how we generally counter the constructor thingy. But the scope of the init() variables are within init() itself.

scala> class foo{
     | def init() : Unit = {print("I am inside it "); val out = 23}
     | init()
     | }
defined class foo

scala> val a = new foo()
I am inside it a: foo = foo@5bcab519

scala> a.out
<console>:10: error: value out is not a member of foo
              a.out
              
out is not under the scope of foo but init() itself.

// Auxiliary constructor 
scala> class Employee1(val empId : Int, val empName:String){
     |     println("From Primary Constructor")
     |     def this(){
     |         this(0,null)
     |         println("From Zero-Argument Auxiliary Constructor")
     |     }
     | }
defined class Employee1

scala> val a = new Employee1(1,"Sankar")
From Primary Constructor
a: Employee1 = Employee1@12028586


==============================================================================================================================
2) What does '???' (three question marks) mean in Scala?

==> The syntax of using three question marks in Scala lets you write a not-yet implemented method.

def doSomething(s: String): Int = ???

`???` can be used for marking methods that remain to be implemented.

==============================================================================================================================
3) how to add jars in scala REPL?

==> if you are already inside Scala REPL, try this :: 

scala> :cp json4s-native_2.12-3.6.0.jar

in general ":cp path/jarName.jar"

While getting into the scala shell ::

scala -cp json4s-native_2.12-3.6.0.jar

Try doing a :help, you will get to see other utilities as well.



