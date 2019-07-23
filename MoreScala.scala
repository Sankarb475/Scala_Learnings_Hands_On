The name Scala stands for "scalable language" is a statically typed language.

You can apply Scala to a wide range of programming tasks, from writing small scripts to building large systems.

Scala is good with small scripting as well. A script is just a sequence of statements in a file that will be executed sequentially.

Write the scala statements into a file hello.scala and run using 
scala hello.scala
=======================================================================================================================================
Difference between Statically typed and dynamically typed languages.

A language is statically typed if the type of a variable is known at compile time. For some languages this means that you as the 
programmer must specify what type each variable is (e.g.: Java, C, C++); other languages offer some form of type inference, 
the capability of the type system to deduce the type of a variable 
(e.g.: OCaml, Haskell, Scala, Kotlin)
The main advantage here is that all kinds of checking can be done by the compiler, and therefore a lot of trivial bugs are caught at a 
very early stage.

Scala language is statically typed even when you do not mention the variable type since it can deduce the type of the varibale at compile 
time.

Dynamically typed languages doesnt need you to define the data type explicitely and these gets deduced at run-time. Most scripting 
languages are dynamically typed as there is no compiler to do static type-checking anyway. Although you can define the data type explicitely
but do not require it.
=======================================================================================================================================
Why Scala ?
==>
1) Scala is compatible
Scala can get well mixed with Java, as a matter of fact Scala behind the picture uses a lot of Java libraries including the different 
data types. Run-time performance is usually on par with Java programs. Scala code can call Java methods, access Java fields, inherit from 
Java classes, and implement Java interfaces.

2) Scala is concise
Scala programs tend to be short. It takes half of the line which Java takes for same task. Its functional side helps you implement the
same logic in small.

3) Scala is high-level
Scala helps you manage complexity by letting you raise the level of abstraction in the interfaces you design and use

4) Scala is statically typed but it can deduce the data type most of the time.
==================================================================================================================================Scala=====
Scala Functions ::

scala> def greet() = print("Hello World")                                                                                                                                       
greet: ()Unit                                                                                                                                                                   
                                                                                                                                                                                
scala> greet                                                                                                                                                                    
Hello World  














