from tu import display_board, full_board, get_move
from marc import win_check, reset_board, stalemate

var board = reset_board()
var gameOn = True

while (gameOn)
{
    display_board(board)
    board = get_move(board, 1)
    if (win_check(board, "x")):
        display_board(board)
        println("Congrats player 1!")
        break
    if full_board(board)
    {
      if stalemate(board) {
        board = reset_board(board)
        continue
      } else {
        break
      }
    }
    display_board(board)
    board = get_move(board, 2)
    if (win_check(board, "o"))
    {
        display_board(board)
        println("Congrats player 2!")
        break
    }
}
