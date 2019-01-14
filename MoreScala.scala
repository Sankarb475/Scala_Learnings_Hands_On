//while running spark-shell if you want to add some external jar so that you can import some functionalities, follow this ::

./spark-shell --jars /Users/sankar.biswas/Desktop/spark-cassandra-connector_2.11-2.0.10.jar, /Users/dummy.jar2


//Higher Order Function => Function which takes a function as input and/or returns a function as output

scala> def dumdum : (String => String) = _.toUpperCase
dumdum: String => String

scala> dumdum
res26: String => String = <function1>

scala> val a = "My name is Anthony"
a: String = My name is Anthony

scala> val b = a.toUpperCase
b: String = MY NAME IS ANTHONY

scala> val c = dumdum(a)
c: String = MY NAME IS ANTHONY

// I will convert this function into a Spark UDF in sparkLearnings.scala file in this repository only
