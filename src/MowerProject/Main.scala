package MowerProject
import java.io.FileNotFoundException
import scala.io.Source

//Notre programme principal

object Main {

  def main(args: Array[String]) {

    // on fait un try catch sur notre fichier
    try {
      val fileName = "D:/ENSIIE/Paris Saclay/test.txt"
      val fileSource = Source.fromFile(fileName)

      // on prend les coordonnées x et y de la première ligne du fichier
      val lawnCoords = fileSource.getLines().take(1).mkString.split(" ")

      var dimX = 0
      var dimY = 0

      // on fait un try catch pour faire un casting sur les dimensions
      try{
        dimX = lawnCoords(0).toInt
        dimY = lawnCoords(1).toInt
      }
      catch {
        case x: Exception => println("Exception: Not a number.")
          return
      }

      // on crée notre pelouse avec les dimensions qu'on a récuperé du fichier
      val lawn = new Pelouse(dimX, dimY)

      // ici on prend le nombre de ligne de notre fichier pour l'utiliser dans la boucle
      val size = Source.fromFile(fileName).getLines.size

      // on récupère toutes les lignes sauf la première qui a été déjà récuperer dans la ligne 15 (lawnCoords)
      val data = fileSource.getLines().toArray

      for (i <- 1 to size - 1 by 2) {

        // dans cette boucle on récupère la premiére ligne qui contient la position initiale de notre tondeuse
        var initPosition = data(i - 1).split(" ")
        var mower = new Tondeuse(initPosition(0).toInt, initPosition(1).toInt, initPosition(2).charAt(0), lawn)

        //puis on récupère la liste des instructions à suivre et on fait l'appel à notre fonction de mouvements
        var instructions = data(i)
        for (j <- 0 to instructions.length - 1) {
          mower.move(instructions.charAt(j))
        }

        //on affiche les tondeuses et leur position finale
        println("Tondeuse " +  (i+1)/2 + " : " + mower.getPositionX() + " " + mower.getPositionY() + " " + mower.getDirection())
      }
      fileSource.close()
    }
    catch{
      case fnfe: FileNotFoundException => println(s"Couldn't find that file : $fnfe")
      case ioe: IndexOutOfBoundsException => println(s"Got an IOException : $ioe")
    }
  }

}

