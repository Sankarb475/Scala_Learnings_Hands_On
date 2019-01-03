//Scala doesn’t offer any special file writing capability, so Java i/o has been foloowed in scala as well

scala> import java.io._
import java.io._

scala> val pw = new PrintWriter(new File("/Users/sankar.biswas/Desktop/hello.txt"))
pw: java.io.PrintWriter = java.io.PrintWriter@5f38ca27

scala> pw.write("Hello, world")

scala> pw.close
