package dkeep.cli;

import java.util.Scanner;

public class UserInput {

	public static void main(String[] args) {
		
		System.out.println("Use:	 'w' 'a' 's' 'd' para se mover.\n");
		Scanner sc = new Scanner(System.in); 
		char direction = sc.next().charAt(0);
		//sc.close();
		
		

	}

}
