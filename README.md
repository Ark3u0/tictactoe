Tic-tac-toe

Create a console program that plays Tic-tac-toe. TDD all of your work. Ask for help if you are stuck for more than 5 minutes. Do the stories in order and only work on one story at a time. More details about Tic-tac-toe.

Stories

Draw the board
When the game starts, draw a board that looks like this:

Make a move
Prompt player 1 to enter a number between 1 and 9 to indicate where they wish to move. Redraw the board with an ‘X’ in that location. It doesn’t matter what happens if they enter anything besides a number from 1 to 9.

Player 2 move
Prompt player 2 to enter a number between 1 and 9 to indicate where they wish to move. Redraw the board with an ‘O’ in that location (and still draw player 1’s ‘X’). It doesn’t matter what you do if they enter the same location that player 1 did.

Location already taken
If either player moves into a cell that is already used, display the message, “Location already taken” and prompt them to try again (repeat this until they make a valid move).

Repeat until the board is filled
Alternate player turns until the board is filled. Draw the board once it is full and display the message, “Game is a draw”.

Winner!
After each move if that player has three in a row, end the game and display the message, “Player <#> Wins!”

Computer Player
Replace one of the players with a computer player that chooses an empty location using whatever strategy to prefer.

Go for the win
The computer player should first choose an empty location if it allows them to win the game.

Block
After trying to win, the computer player should always block their opponent when they can win on their next move.

Fork
After checking for a block, the computer player should create an opportunity where they have two threats to win (two non-blocked lines of 2).

Block Fork
After trying to fork, the computer player should choose any location where the opponent could create a fork on their next turn.

Center
After trying to block a fork, the computer player should move in the center location if it is empty.

Opposite Corner
If the opponent has played in a corner, the computer player should play in the opposite corner.

Corner
The computer player should play in an empty corner location.

Side
The computer player should play in an empty side location.

Fight!
Replace the human player with a computer player and have the computer players play 100 games. Then report the number of games that each player won.
