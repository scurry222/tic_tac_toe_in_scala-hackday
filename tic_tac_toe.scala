var board = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
var gameOn = true
var player1 = true
var player2 = true
/* game is on */

while (gameOn)
{
    /* display_board(board) */
    if (player1) 
    {
        player2 = false
        while (true) {
          println("Player 1 - enter move:")
          move = input()
          if (move == "x" or move == "o" or move not in board) {
            println("invalid move")
            }
          else {
            break
            }
          }
        if (move in board) {
          board(move.toInt - 1) = "x"
          }
        if (win_check(board, "x")) {
            println("player 1 has won")
            break
          }
        if (full_board(board)) {
            display_board(board)
            print("Would you like to play again?")
            again = input()
            if (again == "yes" or again == "y") {
              board = reset_board(board)
              continue
              }
            else if (again == "no" or again == "n") {
              println("K, bye.")
              break
              }
            else {
              println("You messed up and don't get to play again.")
              break
             }
          }
    }
    player1 = false
    player2 = true
    display_board(board)
    if (player2) {
        player1 = false
        while (true) {
          println("Player 2 - enter move:")
          move = input()
          if (move == "x" or move == "o" or move not in board) {
            println("invalid move")
            }
          else {
            break
            }
          }
        }
        if (move in board) {
          board(move.toInt - 1) = "o"
        }
        if (win_check(board, "o")) {
          println("player 2 has won")
          break
          }
        if (full_board(board)) {
            display_board(board)
            println("Would you like to play again?")
            again = input()
            if (again == "yes" or again == "y") {
              board = reset_board(board)
              continue
              }
            else if (again == "no" or again == "n") {
              println("K, bye.")
              break
              }
            else {
              println("You messed up and don't get to play again.")
              break
              }
            }
    player2 = false
    player1 = true
}
