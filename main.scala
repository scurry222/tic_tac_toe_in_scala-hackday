import util.control.Breaks._

object ticTacToe {

  def full_board(board: Array[String]): Boolean = {
    for (b <- board){
      if ("123456789".contains(b)) {
        return false
      }
    }
    return true
  }

  def get_move(board: Array[String], player: String) : Array[String] = {
    var move = ""
    breakable {
      while (true) {
        if (player == 1){
          println("Player 1 - enter move:")
        }
        else {
          println("Player 2 - enter move:")
        }
        move = readLine()
        if ("xo".contains(move) || !board.contains(move)){
          println("invalid move")
        }
        else{
          break
        }
      }
    }
    if (player == 1){
      board(move.toInt - 1) = "x"
    }
    else{
      board(move.toInt - 1) = "o"
    }
    return board
  }
def display_board(a: Array[String]) {
  //apprently print("\u001b[2J") will clear the screen
  //not sure if it can be called like this
  // object Cls extends App {print("\u001b[2J")}
  // Thread.sleep(5000)
  println("\u001b[2J");
  println("   |   |   ");
  println(" "+a(0)+" | "+a(1)+" | "+a(2)+" ");
  println("---|---|---");
  println("   |   |   ");
  println(" "+a(3)+" | "+a(4)+" | "+a(5)+" ");
  println("---|---|---");
  println("   |   |   ");
  println(" "+a(6)+" | "+a(7)+" | "+a(8)+" ");
  println("   |   |   ");
}

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

def reset_board(): Array[String]={
  var board = Array("1", "2", "3", "4", "5", "6", "7", "8", "9")
  return board
}

def main(args: Array[String]): Unit = {
  var board = reset_board()
  var gameOn = true

  breakable {
    while (gameOn)
    {
      display_board(board)
      board = get_move(board, "1")
      if (win_check(board, "x")) {
        display_board(board)
        println("Congrats player 1!")
        break
      }

      if (full_board(board)) {
        if (stalemate(board)) {
          board = reset_board()
          break//continue
        } else {
          break
        }
      }
      display_board(board)
      board = get_move(board, "2")
      if (win_check(board, "o"))
      {
        display_board(board)
        println("Congrats player 2!")
        break
      }
    }
  }
}
}
