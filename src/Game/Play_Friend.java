package Game;
import java.util.Scanner;

public class Play_Friend {
	public char FindWinner(char [][] Game_Board) { // Finds the Winner.
		char player = 'D';
		// For Player - O
		for(int i = 1;i < 6;i += 2) {
			if((Game_Board[i][1] == 'O') && (Game_Board[i][3] == 'O') && (Game_Board[i][5] == 'O')) {
				player = 'O';
				break;
			}
			if((Game_Board[1][i] == 'O') && (Game_Board[3][i] == 'O') && (Game_Board[5][i]) == 'O') {
				player = 'O';
				break;
			}
		}
		if((Game_Board[1][1] == 'O') && (Game_Board[3][3] == 'O') && (Game_Board[5][5] == 'O')) {
			player = 'O'; 
		} 
		if((Game_Board[1][5] == 'O') && (Game_Board[3][3] == 'O') && (Game_Board[5][1] == 'O')) {
			player = 'O';
		}
		
		// For Player - X
		for(int i = 1;i < 6;i += 2) {
			if((Game_Board[i][1] == 'X') && (Game_Board[i][3] == 'X') && (Game_Board[i][5] == 'X')) {
				player = 'X';
				break;
			}
			if((Game_Board[1][i] == 'X') && (Game_Board[3][i] == 'X') && (Game_Board[5][i]) == 'X') {
				player = 'X';
				break;
			}
		}
		if((Game_Board[1][1] == 'X') && (Game_Board[3][3] == 'X') && (Game_Board[5][5] == 'X')) {
			player = 'X'; 
		} 
		if((Game_Board[1][5] == 'X') && (Game_Board[3][3] == 'X') && (Game_Board[5][1] == 'X')) {
			player = 'X';
		}
		
		return player;
	}
	public boolean CheckWinner(char[][] Game_Board) {
		// Decides whether game need to Continue or End.
	
		for(int i = 1;i < 6;i += 2) {
			if((Game_Board[i][1] == Game_Board[i][3]) && (Game_Board[i][3] == Game_Board[i][5])) {
				return true;
			}
			if((Game_Board[1][i] == Game_Board[3][i]) && (Game_Board[3][i] == Game_Board[5][i])) {
				return true;
			}
		}
		if((Game_Board[1][1] == Game_Board[3][3]) && (Game_Board[3][3] == Game_Board[5][5])) {
			return true;
		} 
		if((Game_Board[1][5] == Game_Board[3][3]) && (Game_Board[3][3] == Game_Board[5][1])) {
			return true;
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
		Print_Board(Game_Board);
		char Player_1 = 0;
		char Player_2 = 0;
		do {
			System.out.print("\n\t\t\t\t\tPlayer 1 Choise your Token From[X O] : ");
			Player_1 = Character.toUpperCase(scan.next().charAt(0));
			if(Player_1 != 'X' && Player_1 != 'O') {
				System.out.println("\n\t\t\t\t\tEnter the Correct Character.");
			}
		}while(Player_1 != 'X' && Player_1 != 'O');
		
		System.out.println("\n\t\t\t\t\tOther Token has been taken by default");
				
		if(Player_1 == 'X')Player_2 = 'O';
		else if(Player_1 == 'O') Player_2 = 'X';
			
		System.out.println("\t\t\t\t\tPlayer 1 : " + Player_1);
		System.out.println("\t\t\t\t\tPlayer 2 : " + Player_2);
		
		System.out.println("\n\n\n\t\t\t\t\tLets start the Game : ");
		Print_Board(Game_Board);
		System.out.println("\n\t\t\t\t\tEnter the Corresponding number for giving your tokan input\n\t\t\t\t\tinto your desired Shell");
		
		boolean gameOver = false;
		int cnt_valid_input = 0;// This Variables helps to check if the entire board if completed filled or not.
		while(!gameOver) {
			Print_Board(Game_Board); // Print the Game Board
			gameOver = CheckWinner(Game_Board); // Check : Game_contiue
			if(gameOver != false) {
				break;
			}
			
			int index = 0;
			do {
				System.out.print("\n\t\t\t\t\tPlayer - 1 Turn : \n\t\t\t\t\tEnter the position  number :    Player Token -> " + Player_1 + " : ");
				index = scan.nextInt();
				if(index != 1 && index != 2 && index != 3 && index != 4 && index != 5 && index != 6 && index != 7 && index != 8 && index != 9) {
					System.out.println("\n\t\t\t\t\tEnter the Correct index.");
				}
			}while(index != 1 && index != 2 && index != 3 && index != 4 && index != 5 && index != 6 && index != 7 && index != 8 && index != 9);
			
			Game_Board = player_moves(index,Game_Board,Player_1); // Input into the Board.
			cnt_valid_input++;
			if(cnt_valid_input == 9) {
				break; // Moves out of the while Loop as all the shells are filled by token values.
			}
			Print_Board(Game_Board); // Print the Game Board
			gameOver = CheckWinner(Game_Board);
			if(gameOver != false) {
				Print_Board(Game_Board); // Printing Board For last time.
				break;
			}
			
			do {
				System.out.print("\n\t\t\t\t\tPlayer - 2 Turn : \n\t\t\t\t\tEnter the Postion number :      Player Token -> " + Player_2 + " : ");
				index = scan.nextInt();
				if(index != 1 && index != 2 && index != 3 && index != 4 && index != 5 && index != 6 && index != 7 && index != 8 && index != 9) {
					System.out.println("\n\t\t\t\t\tEnter the Correct index.");
				}
			} while(index != 1 && index != 2 && index != 3 && index != 4 && index != 5 && index != 6 && index != 7 && index != 8 && index != 9);
			Game_Board = player_moves(index, Game_Board, Player_2); // Input into the Board.
			cnt_valid_input++;
			if(cnt_valid_input == 9) {
				Print_Board(Game_Board); // Printing Board for Last time.
				break; // Moves out of the while Loop as all the shells are filled by token values.
			}
			Print_Board(Game_Board);
			gameOver = CheckWinner(Game_Board);
			
			
		}
		if(FindWinner(Game_Board) == 'D') {
			System.out.println("\n\n\t\t\t\t\t\tGame Over \n\t\t\t\t\t\tDraw Game.");
		} else {
			System.out.print("\n\n\t\t\t\t\t\tGame Over \n\t\t\t\t\t\tThe WInner is : ");
			System.out.println("Player - " + FindWinner(Game_Board));			
		}
		scan.close();
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
}
