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

scala> :paste
// Entering paste mode (ctrl-D to finish)

val fw = new FileWriter("/Users/sankar.biswas/Desktop/hello1.txt",true)
fw.write("\nMy line appended!\n")
fw.close()

Source.fromFile("/Users/sankar.biswas/Desktop/hello1.txt").foreach{
print
}

// Exiting paste mode, now interpreting.

Hello, world

My line appended!
fw: java.io.FileWriter = java.io.FileWriter@775e19db

//if we donot give "true" inside FileWriter, it will work as a normal PrintWriter
