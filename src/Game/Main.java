package Game;
import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int ch; 
		
			System.out.println("\n\n\t\t\t\t\t\t1.Play with a Friend\n\t\t\t\t\t\t2.Play with a AI\n\t\t\t\t\t\t3.Exit");
			System.out.print("\t\t\t\t\tEnter your Choise : ");
			ch = scan.nextInt();
			switch(ch) {
			case 1: {
				Play_Friend friend = new Play_Friend();
				friend.Play();
				break;
			} 
			case 2: {
				Player_AI AI = new Player_AI();
				AI.Play();
				break;
			}
			case 3: {
				System.out.println("\t\t\t\t\t\tThank You For Playing this Game.");
				break;
			} default:
				System.out.println("\t\t\t\t\t\tWrong Choise\n\t\t\t\t\tTo Enter into the Menu Enter the Corresponding Number :) .");
			}
		
		scan.close();
	}
}
