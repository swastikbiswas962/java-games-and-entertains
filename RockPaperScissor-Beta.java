import java.util.Scanner;

public class truthfulRPSgame_ftSwarnim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the truthful and fair Rock Paper Scissor game!");
        System.out.println("Here you can trust the computer; he's trustworthy...");
        System.out.println("");
        int myScore = 0;
        int compScore = 0;
        int attempt = 1;
        while (attempt <= 5)
        {
        	//User input and classification
        	System.out.println("Enter '1' for Rock, '2' for Paper, '3' for Scissors: ");
            int y = sc.nextInt();
            String myAttempt = null;
            switch (y)
            {
            case 1: myAttempt = "Rock";
            break;
            case 2: myAttempt = "Paper";
            break;
            case 3: myAttempt = "Scissor";
            break;
            default: System.out.println("Error; your choice doesnt match. \nCarefully hear our words next time...");
            		 System.out.println("Due to this error, we request you to start the game once over.\nWe know its a bug, so we'll try to fix it. Thanks for your cooperation.");
            		 System.out.println("Also ignore the remarks just after this. Another bug.");
            		 attempt += 5;
            break;
            }
            int x = (int)(Math.random()*3);
            String compAttempt = null;
            {
            switch (x)
            {
            case 0: ++x;
            	compAttempt = "Rock";
            break;
            case 1: ++x;
            	compAttempt = "Paper";
            break;
            case 2: ++x;
            	compAttempt = "Scissor";
            break;
            default: System.out.println("Computer Error! Plz terminate the program...");
            break;
            }
            
            if (x == 3 && y == 1)
            {
            	y += 3;
            }
            else if (y == 3 && x == 1)
            {
            	x += 3;
            }
            else
            {}
            
            //main program
            if (x > y)
            {
            	System.out.println("Your move: " + myAttempt + ". Computer's move: " + compAttempt + ".");
            	System.out.println("Oops! You lost. Better luck next time... 3(");
            	++compScore;
            }
            else if (x < y)
            {
            	System.out.println("Your move: " + myAttempt + ". Computer's move: " + compAttempt + ".");
            	System.out.println("Yay! You won. Bad luck computer :(");
            	++myScore;
            	++attempt;
            }
            else if (x == y)
            {
            	System.out.println("Your move: " + myAttempt + ". Computer's move: " + compAttempt + ".");
            	System.out.println("Good try. It's a draw. But the computer didn't give up...");
            }
            
            //Trying to calculate if anyone already won...
            if (compScore >= 5)
            {
            	System.out.println("You lost the game. Bad luck.");
            	attempt += 5;
            }
            else if (myScore >= 5)
            {
            	System.out.println("Congrats on winning the game!");
            }
            else {}
        }
        
        }
	}
	

}
