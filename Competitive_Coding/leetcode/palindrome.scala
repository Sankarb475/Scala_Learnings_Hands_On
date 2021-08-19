object Solution {
    def isPalindrome(s: String): Boolean = {
        val d = s.replaceAll("[^A-Za-z0-9]","").toLowerCase()
       
        d == d.reverse
    }
}


object Solution {
  def isPalindrome(s: String): Boolean = {
    val l = s.filter(_.isLetterOrDigit).toLowerCase
    l.reverse == l
  }
}
