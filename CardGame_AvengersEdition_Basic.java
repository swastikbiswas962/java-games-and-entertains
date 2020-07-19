import java.util.Scanner;

public class Avengers_cardGame1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		cardGame_Functions func = new cardGame_Functions();//Delete this line
		
		int attempt = 1;
		int powerStone_Thanos = 0;
		
		
		//Welcome Screen
		{
			System.out.println("Swastik Biswas presents...");
			try
			{
				Thread.sleep(5000);
			}
			catch (Exception e)
			{
				System.out.println("Error occured in starting the program.");
				System.out.println("Error: " + e);
				System.out.println("Restart for smoother performance.");
				System.exit(0);
			}
			System.out.println("");
			System.out.println(" ___     ___     ___   ___    ___   _");
			System.out.println("/ __|   / _ \\   | _ \\ | _ \\  / __| | |");
			System.out.println("| |_   / /_\\ \\  | | / ||_| | \\__ \\ \\_/");
			System.out.println("\\___| /_/   \\_\\ |_|_\\ |___/  /___/  o");
			System.out.println(""); 
			System.out.println("== Avengers Edition (Early Access) ==");
			System.out.println("");
		}
		
		System.out.println("");
		System.out.println("   ___________");
		System.out.println("  |           |");
		System.out.println("  |  (1)PLAY  |");
		System.out.println("  |___________|");
		System.out.println("     (2)EXIT    ");
		System.out.println(" (3)Version Info");
		System.out.println("  (4)What's New ");
		System.out.println("");
		int in = sc.nextInt();
		
		if (in == 1)
		{
			//Gameplay
			System.out.println("");
			System.out.println("Great job. Here are the rules.");
			System.out.println("#You've five options for choosing cards:");
			System.out.println("   (1) Iron Man");
			System.out.println("   (2) Captain America");
			System.out.println("   (3) Thor");
			System.out.println("   (4) Hulk");
			System.out.println("   (5) Thanos");
			System.out.println("   (6) Power Stone [Power-up]");
			System.out.println("   (7) Black Widow [NEW!]");
			System.out.println("#Both you and the computer will give one move.");
			System.out.println("#The card with more power wins the round. (With a few exceptions)");
			System.out.println("#Until now, this early access version runs infinte no. of rounds.");
			System.out.println(" So to quit any time, input zero (0).");
			System.out.println("So, get playin'!");
			System.out.println("");
			
			while (attempt == 1)
			{
				System.out.println("Input any card no. : ");
				int input = sc.nextInt();
				
				if (input == 0)
				{
					System.out.println("");
					System.out.println("Game stopped.");
					System.exit(0);
				}
				
				//Powers of all cards using arrays
				int[] powers = 
					{
					(int)(func.randomRange(75, 88)), //Iron Man
					(int)(func.randomRange(75, 90)), //Captain America
					(int)(func.randomRange(76, 93)), //Thor
					(int)(func.randomRange(67, 87)), //Hulk
					(int)(func.randomRange(89, 97)), //Thanos
					500, //Power Stone
					(int)(func.randomRange(65, 87)) //Black Widow
					};
				//Here, instead of func, type your class name.
				
				int userIn = input - 1;
				int qw = (int)(Math.random()*2);
				int as = (int)(Math.random()*5);
				int compIn = (int)(Math.random()*6);
				
				if (userIn == compIn)
				{
					if (as == 5)
					{
						if (qw == 0)
						{
							++compIn;
						}
						else if (qw == 1)
						{
							--compIn;
						}
					}
				}
				
				System.out.println("");
				System.out.println("Your Card:");
				
				switch (userIn)
				{
				case 0: int easter1 = (int)(Math.random()*10);
				if (easter1 == 4)
				{
					IronMan_easter();
				}
				else
				{
					IronMan();
				}
				break;
				case 1: CaptainAmerica();
				break;
				case 2: Thor();
				break;
				case 3: Hulk();
				break;
				case 4: Thanos();
				break;
				case 5: PowerStone();
				break;
				case 6: BlackWidow();
				break;
				default: System.out.println("Error...");
				System.exit(0);
				break;
				}
				
				System.out.println("");
				System.out.println("Power: " + powers[userIn]);
				System.out.println("");
				
				System.out.println("Computer's Card: ");
				
				switch (compIn)
				{
				case 0: IronMan();
				break;
				case 1: CaptainAmerica();
				break;
				case 2: Thor();
				break;
				case 3: Hulk();
				break;
				case 4: if (userIn == 5 || powerStone_Thanos == 2)
				{
					++powerStone_Thanos;
					Thanos_powerStone();
				}
				else
				{
					Thanos();
				}
				break;
				case 5: BlackWidow();
				break;
				default: System.out.println("Error...");
				System.exit(0);
				break;
				}
				
				System.out.println("");
				System.out.println("Power: " + powers[compIn]);
				System.out.println("");
				

				if (userIn == 5 && compIn == 4)
				{
					if (powerStone_Thanos == 1)
					{
						powerStone_Thanos += 1;
						System.out.println("\"Power makes us blind to realise the true reality.\"");
						System.out.println("The power stone is captured by Thanos.");
					}
					else
					{
						System.out.println("The power stone is already captured by Thanos.");
					}
				}
				else if ((userIn == 1 && compIn == 2) || (userIn == 2 && compIn == 1))
				{
					System.out.println("Captain wins! He's worthy of the power of Thor...");
				}
				else if (powers[userIn] > powers[compIn])
				{
					int x = (int)(Math.random()*4);
					
					switch (x)
					{
					case 0: System.out.println("Kuddos! You beat the computer!");
					break;
					case 1: System.out.println("Give yourself a pat on the back...");
					break;
					case 2: System.out.println("Well done, user. Perfect timing for the card.");
					break;
					case 3: System.out.println("Bravo fella! When you got time to master this?");
					break;
					default: System.out.println("Hmm.... good. Not that pleased though.");
					break;
					}
				}
				else if (powers[userIn] > powers[compIn] && powers[userIn]-powers[compIn] == 1)
				{
					int x = (int)(Math.random()*3);
					
					switch (x)
					{
					case 0: System.out.println("Ooh! That was close...");
					break;
					case 1: System.out.println("OMG! Just an inch and the round would've been a draw.");
					break;
					case 2: System.out.println("So close! Better watch out.");
					}
				}
				else if (powers[userIn] < powers[compIn])
				{
                    int x = (int)(Math.random()*4);
					
					switch (x)
					{
					case 0: System.out.println("Hahaha! Oh, you lost!");
					break;
					case 1: System.out.println("And this round goes to.... oh, didn't expect that.");
					break;
					case 2: System.out.println("Take time, dude. There's no timer in this game.");
					break;
					case 3: System.out.println("Try to invest some time in learning this.");
					break;
					default: System.out.println("Damn! Why I'm supporting you? You don't even play well!");
					break;
					}
				}
				else if (powers[userIn] == powers[compIn])
				{
					System.out.println("Hmm... that's a draw.");
				}
				System.out.println("");
			}
		}
		else if (in == 2)
		{
			System.out.println("");
			System.out.println("Game stopped.");
			System.exit(0);
		}
		else if (in == 3)
		{
			System.out.println("");
			System.out.println("Early Access v 0.01.4");
			System.out.println("[A]B Original.");
			System.out.println("");
			System.out.println("All versions:");
			System.out.println("");
			System.out.println("# Early Access:");
			System.out.println("  This version of the game is official but unreleased to the public.");
			System.out.println("  Can be unstable and buggy.");
			System.out.println("  Available for everyone until the Bedrock version releases.");
			System.out.println("");
			System.out.println("# Bedrock:");
			System.out.println("  This version of the game is official and released to the public.");
			System.out.println("  Stable. But can contain undetected bugs.");
			System.out.println("  Unavailable currently.");
			System.out.println("");
			System.out.println("# Developer:");
			System.out.println("  This version of the game is official and for developers specifically.");
			System.out.println("  Highly unstable.");
			System.out.println("  Requires a Developer ID.");
			System.out.println("");
			System.out.println("(1)Getting other versions");
			System.out.println("(2)<--Back");
			System.out.println("");
			int in2 = sc.nextInt();
			
			if (in2 == 1)
			{
				System.out.println("");
				System.out.println("Ask the provider for different versions.");
				System.out.println("");
				System.out.println("Early Access [Latest v 0.01.6]");
				System.out.println("Bedrock [Unavailable]");
				System.out.println("Developer [Latest v 0.02.1]");
				System.out.println("");
				System.out.println("Re-run the program to go to the home lobby.");
			}
			else if (in2 == 2)
			{
				System.out.println("Re-run the program to go to the home lobby.");
			}
			else
			{
				System.out.println("Re-run the program to go to the home lobby.");
			}
		}
		else if (in == 4)
		{
			System.out.println("");
			System.out.println("What's New in v 0.01.6?");
			System.out.println("");
			System.out.println("The play's got BIGGER! Big play button.");
			System.out.println("");
			System.out.println("(1) New Card : Black Widow");
			System.out.println("");
			System.out.println("(2) New Strategy : Thor Card ");
			System.out.println("    Anyone worthy of the Mjolnir will beat Thor.");
			System.out.println("");
			System.out.println("(3) Iron Man Easter : See if you've already spoted it or not...");
			System.out.println("");
			System.out.println("Re-run the program to get back to the home screen.");
		}
		
	}
	protected static void IronMan ()
	{
		System.out.println(" ____________");
		System.out.println("/            |");
		System.out.println("|    ____    |");
		System.out.println("|   /_  _\\   |");
		System.out.println("|  // \\/ \\\\  |");
		System.out.println("|  \\\\=  =//  |");
		System.out.println("|   \\\\__//   |");
		System.out.println("|    \\__/    |");
		System.out.println("|            |");
		System.out.println("|  IRON MAN  |");
		System.out.println("|____________/");
	}
	protected static void IronMan_easter ()
	{
		System.out.println(" ____________");
		System.out.println("/            |");
		System.out.println("|    ____    |");
		System.out.println("|   /_  _\\   |");
		System.out.println("|  // \\/ \\\\  |");
		System.out.println("|  \\\\X  X//  |");
		System.out.println("|   \\\\__//   |");
		System.out.println("|    \\__/    |");
		System.out.println("|            |");
		System.out.println("|  IRON MAN  |");
		System.out.println("|____________/");
	}
	protected static void CaptainAmerica ()
	{
		System.out.println(" ____________");
		System.out.println("/            |");
		System.out.println("|            |");
		System.out.println("|    _/\\_    |");
		System.out.println("|    \\  /    |");
		System.out.println("|    //\\\\    |");
		System.out.println("|            |");
		System.out.println("|            |");
		System.out.println("|  CAPTAIN-  |");
		System.out.println("|  -AMERICA  |");
		System.out.println("|____________/");
	}
	protected static void Thor ()
	{
		System.out.println(" ____________");
		System.out.println("/            |");
		System.out.println("|    ____    |");
		System.out.println("|   |    |   |");
		System.out.println("|   |____|   |");
		System.out.println("|     ||     |");
		System.out.println("|     ||     |");
		System.out.println("|     ||     |");
		System.out.println("|            |");
		System.out.println("|    THOR    |");
		System.out.println("|____________/");
	}
	protected static void Hulk ()
	{
		System.out.println(" ____________");
		System.out.println("/            |");
		System.out.println("|   _ _ _    |");
		System.out.println("|  | | | |_  |");
		System.out.println("|  |     | | |");
		System.out.println("|  \\      /  |");
		System.out.println("|   \\____/   |");
		System.out.println("|   |____|   |");
		System.out.println("|            |");
		System.out.println("|    HULK    |");
		System.out.println("|____________/");
	}
	protected static void Thanos ()
	{
		System.out.println(" ____________");
		System.out.println("/      *_*   |");
		System.out.println("|   _ _|_|*  |");
		System.out.println("|  |_|_|_|_  |");
		System.out.println("|  |O|O|O|_| |");
		System.out.println("|  \\ (O) (O  |");
		System.out.println("|   \\____/   |");
		System.out.println("|   ||_|_|   |");
		System.out.println("|            |");
		System.out.println("|   THANOS   |");
		System.out.println("|____________/");
	}
	protected static void Thanos_twoStones ()
	{
		System.out.println(" ____________");
		System.out.println("/      *_*   |");
		System.out.println("|   _ _|_|*  |");
		System.out.println("|  |_|_|_|_  |");
		System.out.println("|  |O|0|0|_| |");
		System.out.println("|  \\ (O) (O  |");
		System.out.println("|   \\____/   |");
		System.out.println("|   ||_|_|   |");
		System.out.println("|            |");
		System.out.println("|   THANOS   |");
		System.out.println("|____________/");
	}
	protected static void Thanos_powerStone ()
	{
		System.out.println(" ____________");
		System.out.println("/      *_*   |");
		System.out.println("|   _ _|_|*  |");
		System.out.println("|  |_|_|_|_  |");
		System.out.println("|  |O|O|0|_| |");
		System.out.println("|  \\ (O) (O  |");
		System.out.println("|   \\____/   |");
		System.out.println("|   ||_|_|   |");
		System.out.println("|            |");
		System.out.println("|   THANOS   |");
		System.out.println("|____________/");
	}
	protected static void BlackWidow ()
	{
		System.out.println(" ____________");
		System.out.println("/    ____   |");
		System.out.println("|   \\    /   |");
		System.out.println("|    \\  /    |");
		System.out.println("|     \\/     |");
		System.out.println("|     /\\     |");
		System.out.println("|    /  \\    |");
		System.out.println("|   /____\\   |");
		System.out.println("|            |");
		System.out.println("|BLACK  WIDOW|");
		System.out.println("|____________/");
	}
	protected static void DocStrange ()
	{
		System.out.println(" ____________");
		System.out.println("/            |");
		System.out.println("|            |");
		System.out.println("|  \\ \\/ /     |");
		System.out.println("|   \\/\\/     |");
		System.out.println("|   /\\()\\    |");
		System.out.println("|  / /\\  \\   |");
		System.out.println("|            |");
		System.out.println("|   DOCTOR   |");
		System.out.println("|  -STRANGE  |");
		System.out.println("|____________/");
	}
	protected static void PowerStone ()
	{
		System.out.println(" ____________");
		System.out.println("/            |");
		System.out.println("|  Increase  |");
		System.out.println("| card-power |");
		System.out.println("|     __     |");
		System.out.println("|    |  |    |");
		System.out.println("|    |__|    |");
		System.out.println("|            |");
		System.out.println("|            |");
		System.out.println("|POWER  STONE|");
		System.out.println("|____________/");
	}
	protected static void MindStone ()
	{
		System.out.println(" ____________");
		System.out.println("/            |");
		System.out.println("|  Predicts  |");
		System.out.println("| next  card |");
		System.out.println("|     __     |");
		System.out.println("|    |  |    |");
		System.out.println("|    |__|    |");
		System.out.println("|            |");
		System.out.println("|            |");
		System.out.println("| MIND STONE |");
		System.out.println("|____________/");
	}

}
