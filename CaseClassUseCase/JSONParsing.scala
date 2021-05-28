import org.json4s._
import org.json4s.jackson.JsonMethods._
import scala.io.Source

object JSONParsing extends App {

  implicit val formats : DefaultFormats.type = DefaultFormats // Brings in default date formats etc.

  case class BookDetails(bookId: String, bookName: String, authorName: String, authorCountry: String)

  for (line <- Source.fromFile("/Users/sankar.biswas/Desktop/jsonFile.json").getLines) {
    val bookDetails = jsonStrToMap(line)
    println(bookDetails.bookName)
  }

  def jsonStrToMap(jsonStr: String): BookDetails = {
    parse(jsonStr).camelizeKeys.extract[BookDetails]
  }
}



//content of jsonFile
{"book_id":"1","book_name":"Scala","author_name":"Edward","author_country":"Poland"}
{"book_id":"1","book_name":"Scala","author_name":"Edward","author_country":"Poland"}
{"book_id":"1","book_name":"Scala","author_name":"Edward","author_country":"Poland"}
{"book_id":"1","book_name":"Scala","author_name":"Edward","author_country":"Poland"}

// scala case classes are normal classes which are immutable in nature and used especially for pattern matching

// It has a pre-defined apply method, which initiates the objects, thus we dont need a new keyword while creatig the object 
// of a case class.


//so here you can see case class can give schema to your input dataset, I have had to analyse many uniform complex dataset, and 
//the best way to handle those data is to use case class and give custom schema. Using custom schema you can easily fetch and 
//traverse through your data.

