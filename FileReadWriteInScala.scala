//Scala doesn’t offer any special file writing capability, so Java i/o has been foloowed in scala as well

scala> import java.io._
import java.io._

//PrintWriter helps you create/overwrite an existing file, doesnt append to the existing

scala> val pw = new PrintWriter(new File("/Users/sankar.biswas/Desktop/hello.txt"))
pw: java.io.PrintWriter = java.io.PrintWriter@5f38ca27

scala> pw.write("Hello, world")

scala> pw.close

scala> import scala.io.Source
import scala.io.Source

scala> Source.fromFile("/Users/sankar.biswas/Desktop/hello1.txt").foreach{
     | print
     | }
Hello, world

//FileWriter helps you append content to the existing file 
//if we donot give "true" inside FileWriter, it will work as a normal PrintWriter

scala> :paste
// Entering paste mode (ctrl-D to finish)

val fw = new FileWriter("/Users/sankar.biswas/Desktop/hello.txt",true)
fw.write("\nMy line appended!\n")
fw.close()

Source.fromFile("/Users/sankar.biswas/Desktop/hello.txt").foreach{
print
}

// Exiting paste mode, now interpreting.

Hello, world

My line appended!
fw: java.io.FileWriter = java.io.FileWriter@775e19db

//Reading a file and iterate over it using scala "Source", i have added a few lines to the existing contents of hello.txt
scala> for (line <- Source.fromFile("/Users/sankar.biswas/Desktop/hello.txt").getLines) {
     | println(line)
     | }
Hello, world
My line appended!
Hello Scala
Hello Universe
Hello Sankar
Sankar has written this 

scala> val lines = Source.fromFile("/Users/sankar.biswas/Desktop/hello.txt").getLines.toList
lines: List[String] = List(Hello, world, My line appended!, Hello Scala, Hello Universe, Hello Sankar, "Sankar has written this ")

scala> val lines = Source.fromFile("/Users/sankar.biswas/Desktop/hello.txt").getLines.toArray
lines: Array[String] = Array(Hello, world, My line appended!, Hello Scala, Hello Universe, Hello Sankar, "Sankar has written this ")

scala> val fileContents = Source.fromFile("/Users/sankar.biswas/Desktop/hello.txt").getLines.mkString
fileContents: String = "Hello, worldMy line appended!Hello ScalaHello UniverseHello SankarSankar has written this "


//Exception handling if the file is not found
scala> try {
     |     for (line <- Source.fromFile("/Users/sankar.biswas/Desktop/hello1.txt").getLines) {
     |         println(line)
     |     }
     | } catch {
     |     case e: FileNotFoundException => println("Couldn't find that file.")
     |     case e: IOException => println("Got an IOException!")
     | }
Couldn't find that file.
