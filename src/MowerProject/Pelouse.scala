package MowerProject

//classe de notre pelouse

//Constructeur qui contient les coordonnées x et y
class Pelouse(x: Int, y: Int ) {
  private var this.x : Int = x
  private var this.y : Int = y

  //on utilise les getter pour avoir l'accès aux données
  def getPositionX(): Int = {
    return this.x
  }

  def getPositionY(): Int = {
    return this.y
  }

}