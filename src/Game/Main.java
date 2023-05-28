package Game;
import java.util.Scanner;

public class Main extends Play_Friend, Play_Computer, Play_AI {
		
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int ch; 
		System.out.println("\n\n\t\t\t\t\t\tTic Tac Toe");
		System.out.println("\n\n\t\t\t\t\t\t1.Play with a Friend\n\t\t\t\t\t\t2.Play with a AI\n\t\t\t\t\t\t3.Play with Computer\n\t\t\t\t\t\t4.Exit");
		System.out.print("\t\t\t\t\tEnter your Choise : ");
		ch = scan.nextInt();
		switch(ch) {
		case 1: {
			Player_Friend friend = new Player_Friend();
			friend.Play();
			break;
		} 
		case 2: {
			Player_AI AI = new Player_AI();
			AI.Play();
			break;
		}
		case 3: {
			Player_Computer computer = new Player_Computer();
			computer.Play();
			break;
		}
		case 4: {
			System.out.println("\t\t\t\t\t\tThank You For Playing this Game.");
			break;
		} default:
			System.out.println("\t\t\t\t\t\tWrong Choise\n\t\t\t\t\tTo Enter into the Menu, Enter the Corresponding Number :) .");
		}
		
		scan.close();
	}
}
