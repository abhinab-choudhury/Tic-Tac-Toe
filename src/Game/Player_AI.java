package Game;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Player_AI {
	int depth = 0;
	char Player_1 = ' '; // You.
	char Player_2 = ' '; // CPU/AI
	
	
	/*////////////////////// Minimax Algorithm ///////////////////////////////////////*/
	public int minimax(char[][] Game_Board, int depth, boolean isMaximizing) {
		if(CheckWin(Game_Board) || depth == 0) {
			return evaluate(Game_Board);
		}
		return 0;
	}
	public char[][] AI_Move(char[][] Game_Board) { // Minimax Algorithm
		return Game_Board;
	}
	
	public int evaluate(char[][] Game_Board) {
		// if AI wins Return +10
		// if Human-Player wins Return -10
		return 0; // if no winner return 0
	}
	
	
	/*//////////////////////////////////////////////////////////////////////////////*/
	
	
	public char FindWinner(char [][] Game_Board, char PlayerToken) {
		/*..................... Finds  the Winner of the Game else returns D for Draw ...........................*/
		char player = ' '; // Initialization of character variable player
		
		// checking Horizontal cases 
		for(int i = 1;i < 6;i += 2) { 
			if((Game_Board[i][1] == PlayerToken) && (Game_Board[i][3] == PlayerToken) && (Game_Board[i][5] == PlayerToken)) {
				player =  PlayerToken;
				break;
			}
		}
		
		// Checking Vertical cases
		for(int i = 1;i < 6;i += 2) { 
			if((Game_Board[1][i] == PlayerToken) && (Game_Board[3][i] == PlayerToken) && (Game_Board[5][i]) == PlayerToken) {
				player = PlayerToken;
				break;
			}
		}
		
		/* Diagonal ways of winning the game*/
		if((Game_Board[1][1] == PlayerToken) && (Game_Board[3][3] == PlayerToken) && (Game_Board[5][5] == PlayerToken)) {
			player = PlayerToken; 
		} 
		if((Game_Board[1][5] == PlayerToken) && (Game_Board[3][3] == PlayerToken) && (Game_Board[5][1] == PlayerToken)) {
			player = PlayerToken;
		}
		
		// Calling the open spots in the Game Board
		// as this helps in determining whether the game need to continue of the Game is Draw
		int openSpots = 0;
		for(int i = 1;i < 6;i++) {
			for(int j = 1;j < 6;j++) {
				if(Character.isDigit(Game_Board[i][j])) {
					openSpots++;
				}
			}
		}
		if(Character.isWhitespace(player) && openSpots == 0) {
			player = 'D';
		}
		return player;
	}
	public boolean CheckWin(char[][] Game_Board) {
		// Decides whether game need to Continue or End.
		// basically it check if any of the player won the game or not
	
		for(int i = 1;i < 6;i += 2) {
			// Horizontal and Vertical ways of wins.
			if((Game_Board[i][1] == Game_Board[i][3]) && (Game_Board[i][3] == Game_Board[i][5])) {
				return true;
			}
			if((Game_Board[1][i] == Game_Board[3][i]) && (Game_Board[3][i] == Game_Board[5][i])) {
				return true;
			}
		}
		// Diagonal Way of wins 
		if((Game_Board[1][1] == Game_Board[3][3]) && (Game_Board[3][3] == Game_Board[5][5])) {
			return true;
		} 
		if((Game_Board[1][5] == Game_Board[3][3]) && (Game_Board[3][3] == Game_Board[5][1])) {
			return true;
		}
		
		return false;
	}
	
	
	public boolean checkInput(char[][] Game_Board, int input_index) {
		
		/* 
		 * 	 User input to the array of chars we need to check of the Input Space is already
		 *   occupied or not :-
		 *   As the Array is 7 x 7 so we only are concerned
		 *   about elements at odd Index.
		 * 
		 * */
		if(input_index >= 1 && input_index <= 9) {
			if(input_index >= 1 && input_index <= 3) {
				input_index -= 1;
				// Checks Input in First Row of the GameBoard
				if(Game_Board[1][2 * input_index + 1] == 'X' || Game_Board[1][2 * input_index + 1] == 'O') {
					return false;
				} else {
					return true;
				}
			}
			else if(input_index >= 4 && input_index <= 6) {
				input_index -= 4;
				// Checks inputs in second row of the GameBoard
				if (Game_Board[3][2*input_index + 1] == 'X' || Game_Board[3][2 * input_index + 1] == 'O') {
					return false;
				} else {
					return true;
				}
			}else{ 
				// Checks Input in Third row of the GameBoard
				input_index -= 7;
				if(Game_Board[5][2*input_index + 1] == 'X' || Game_Board[5][2 * input_index + 1] == 'O') {
					return false;
				} else {
					return true;
				}
			}
		} 
		return false;
	}
	public char[][] player_moves(int index,char [][] Game_Board,char Player_token ) {
		
		// Input into the Game_Board
		if(index >= 1 && index <= 3) {
			index -= 1;
			Game_Board[1][2*index + 1] = Player_token;
		}
		else if(index >= 4 && index <= 6) {
			index -= 4;
			Game_Board[3][2*index + 1] = Player_token;
		}
		else { 
			index -= 7;
			Game_Board[5][2*index + 1] = Player_token;
		}
		
		return Game_Board;
		
	}
	public void Print_Board(char[][] Game_Board) {
		
		// Prints the Game_Board.
		System.out.println("\n\n\t\t\t\t\t\tGame Board\n");
		for(char[] rows:Game_Board) {
			System.out.print("\t\t\t\t\t\t");
			for(char ch:rows) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}
	public void Play() {
		
		// Main Function which keeps  a track of Progress of Game.
		Scanner scan = new Scanner(System.in);
		char Game_Board[][] = {{'+','-','+','-','+','-','+'},
							   {'|','1','|','2','|','3','|'},
							   {'|','-','+','-','+','-','|'},
							   {'|','4','|','5','|','6','|'},
							   {'|','-','+','-','+','-','|'},
							   {'|','7','|','8','|','9','|'},
							   {'+','-','+','-','+','-','+'}};
		
		//Display Game-Board
		Print_Board(Game_Board);
		
		
		/* 
		 * True Loop till the correct Input of the Player-Token
		 * */
		do {
			System.out.print("\n\t\t\t\t\tPlayer 1 Choise your Token From[X O] : ");
			Player_1 = Character.toUpperCase(scan.next().charAt(0));
			if(Player_1 != 'X' && Player_1 != 'O') {
				System.out.println("\n\t\t\t\t\tEnter the Correct Character.");
			}
		}while(Player_1 != 'X' && Player_1 != 'O');
		
		// Choosing Token for AI by Default
		System.out.println("\n\t\t\t\t\tOther Token has been taken by default");		
		if(Player_1 == 'X')Player_2 = 'O';
		else if(Player_1 == 'O') Player_2 = 'X';
			
		System.out.println("\t\t\t\t\tYour's Token : " + Player_1);
		System.out.println("\t\t\t\t\tCPU's Token : " + Player_2);
		
		System.out.println("\n\n\n\t\t\t\t\tLets start the Game : ");
		System.out.println("\n\t\t\t\t\tEnter the Corresponding number for giving your tokan input\n\t\t\t\t\tinto your desired Shell");
		
		
		// Game Running................
		boolean gameOver = false;
		int cnt_valid_input = 0;
		// This Variables helps to check if the entire board if completed filled or not.
		
		while(!gameOver) {
			int index = 0;
			Print_Board(Game_Board); // Print the Game Board
			gameOver = CheckWin(Game_Board); // Check : is any player won the game or not
			if(gameOver != false) {
				Print_Board(Game_Board);
				break;
			}
			
			// Input by Human.....................................................
			do { 
				// Take correct Input from user and checks if that input must not be Overwritten.
				System.out.print("\n\t\t\t\t\tYour Turn : \n\t\t\t\t\tEnter the position  number :    Player Token -> " + Player_1 + " : ");
				index = scan.nextInt();
				if(!checkInput(Game_Board, index)) { // Wrong Input is Given
					System.out.println("\n\t\t\t\t\tEnter the Correct index.");
				}
			}while(!checkInput(Game_Board, index));
			
			Game_Board = player_moves(index,Game_Board,Player_1); // Input into the Board.
			cnt_valid_input++;
			if(cnt_valid_input == 9) {
				break; // Moves out of the while Loop as all the shells are filled by token values.
			}
			Print_Board(Game_Board); // Print the Game Board
			gameOver = CheckWin(Game_Board);
			if(gameOver) {
				Print_Board(Game_Board); // Printing Board For last time.
				break;
			}
			//..............................................................................
			
			
			// AI/CPU's Turn................................................................
			System.out.print("\n\t\t\t\t\tCPU's Turn :  Player Token -> " + Player_2 + " : ");
			
			System.out.print("\n\t\t\t\t\tCPU's Turn :  Player Token -> " + Player_2 + " : ");
			
			int depth = 3; // Desired Depth of the Game is 3
			int bestScore = Integer.MIN_VALUE;
			int bestMoveX = -1; // i-th index of the input from AI
			int bestMoveY = -1; // i-th index of the input from AI
				
			for(int i = 0;i < Game_Board.length; i++) {
				for(int j = 0;j < Game_Board[0].length; j++) {
					char temp = Game_Board[i][j];
					if(Character.isDigit(Game_Board[i][j])) {
						Game_Board[i][j] = Player_2; 
						int score = minimax(Game_Board,depth,false); 
						// For AI we need to Minimize the score
						Game_Board[i][j] = temp;
							
						if(score > bestScore) {
							bestScore = score;
							bestMoveX = i;
							bestMoveY = j;
						}
					}
				}
			}
				
			Game_Board[bestMoveX][bestMoveY] = Player_2;
				
//			Game_Board = player_moves(index, Game_Board, Player_2);
//			Game_Board = AI_Move(Game_Board);  // Input into the Board.
			/*...............................................................................*/
			
			
			cnt_valid_input++;
			if(cnt_valid_input == 9) {
				Print_Board(Game_Board); // Printing Board for Last time.
				break; // Moves out of the while Loop as all the shells are filled by token values.
			}
			Print_Board(Game_Board);
			gameOver = CheckWin(Game_Board);			
			
		}
		
		if(FindWinner(Game_Board,Player_1) == 'D' && FindWinner(Game_Board, Player_2) == 'D') {
			System.out.println("\n\n\t\t\t\t\t\tGame Over \n\t\t\t\t\t\tDraw Game.");
		}
		else if (FindWinner(Game_Board,Player_1) == Player_1) {
			System.out.print("\n\n\t\t\t\t\t\tGame Over \n");
			System.out.println("\t\t\t\t\tYou Won!!!!");
		}
		else {
			System.out.println("\t\t\t\t\tYou Lost ):\n\t\t\t\t\t\tBetter Luck Next Time.");
		}
		scan.close();
	}

}
