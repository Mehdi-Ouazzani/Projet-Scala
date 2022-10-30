package MowerProject

//classe de notre tondeuse

//Constructeur qui contient les coordonnées x et y, la direction et la pelouse
class Tondeuse(x: Int, y: Int, direction : Char, lawn: Pelouse ) {
  private var cx : Int = x
  private var cy : Int = y
  private var Direction : Char = direction
  private var Lawn : Pelouse = lawn

  def getPositionX(): Int = {
    return cx
  }

  def getPositionY(): Int = {
    return cy
  }

  def getDirection(): Char = {
    return Direction
  }

  //la fonction move contient les mouvements de notre tondeuse
  //donc on fait un match case pour notre direction qui sera G ou D ou A
  def move(direction : Char) {
    direction  match
    {
      //vu que G et D pivotent la tondeuse de 90° donc on va modifier que la direction
      case 'G' => {
        if (Direction == 'N') Direction = 'W'
        else if (Direction == 'W') Direction = 'S'
        else if( Direction == 'S') Direction = 'E'
        else if( Direction == 'E') Direction = 'N'
      }
      case 'D' => {
        if (Direction == 'N') Direction = 'E'
        else if (Direction == 'E') Direction = 'S'
        else if (Direction == 'S') Direction = 'W'
        else if (Direction == 'W') Direction = 'N'
      }
      //pour le cas de A qui signifie que l'on avance on modifie les coordonnées x et y
      //si la direction est N ou S et nous avons la possibilité d'avancer : on avance par rapport à y
      //si la direction est E ou W et nous avons la possibilité d'avancer : on avance par rapport à x
      case 'A' => {
        if (Direction == 'N' && cy < Lawn.getPositionY()) cy= cy+1
        else if (Direction == 'S' && cy > 0) cy= cy-1
        else if (Direction == 'E' && cx < Lawn.getPositionX()) cx = cx + 1
        else if (Direction == 'W' && cx > 0) cx = cx - 1
      }
      case _ => println(Direction + "Non existing direction")
    }
  }

}

