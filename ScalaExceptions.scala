// Custom Exception creation in Scala
 We do it creating a case class which extends class Excetion
 
 final case class CustomException(private val message: String = "", 
                           private val cause: Throwable = None.orNull)
                      extends Exception(message, cause) 
                      
 try {
    throw CustomException("optional")
} catch {
    case c: CustomException =>
          c.printStackTrace
}

