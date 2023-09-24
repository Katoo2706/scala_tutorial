import scala.io.Source
import play.api.libs.json._

object IPGeolocation extends App {
//  if (args.length != 1) {
//    println("Usage: scala IPGeolocation.scala <IP_ADDRESS>")
//    sys.exit(1)
//  }

  val ipAddress = "24.114.108.233"
  val apiUrl = s"http://ip-api.com/json/$ipAddress"

  try {
    val response = Source.fromURL(apiUrl).mkString
    val locationData = Json.parse(response)

    val city = (locationData \ "city").asOpt[String]
    val country = (locationData \ "country").asOpt[String]
    val region = (locationData \ "regionName").asOpt[String]

    if (city.isDefined && country.isDefined && region.isDefined) {
      println(s"Location for IP Address $ipAddress:")
      println(s"City: ${city.get}")
      println(s"Country: ${country.get}")
      println(s"Region: ${region.get}")
    } else {
      println(s"Location not found for IP Address $ipAddress.")
    }
  } catch {
    case e: Exception =>
      println(s"Error fetching location data: ${e.getMessage}")
  }
}
