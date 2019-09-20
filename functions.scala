// from tu import display_board
object helpers{
  def stalemate(board : Array[String]) : Boolean={
    display_board(board)
    var again = readLine("Would you like to play again?\n")
    if (again == "yes" || again == "y"){
      return true
    }
    else if (again == "no" || again == "n"){
      println("K, bye.")
      return false
    }
    else{
      println("You messed up and don't get to play again.")
      return false
    }
  }

  def win_check(pos: Array[String], user: String): Boolean={
    // Checks to see if someone has won
    //   Args:
    //     pos = board position
    // user = user letter ('x' or 'o')
    if ((pos(0) == pos(1) == pos(2) == user) || (pos(3) == pos(4) == pos(5) == user) || (pos(6) == pos(7) == pos(8) == user) || (pos(0) == pos(3) == pos(6) == user) || (pos(1) == pos(4) == pos(7) == user) || (pos(2) == pos(5) == pos(8) == user) || (pos(0) == pos(4) == pos(8) == user) || (pos(2) == pos(4) == pos(6) == user)){
      return true
    }
    return false
  }

  def reset_board(board: Array[String]): Array[String]={
    var board = Array("1", "2", "3", "4", "5", "6", "7", "8", "9")
    return board
  }

}
