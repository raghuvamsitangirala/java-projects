package PracticePrograms;

import java.util.Random;
import java.util.Scanner;

public class Dice {

	static int win = 0;
	static int loss = 0;
	static int balance = 500;
	static int betAmount = 0;
	static int rollValue = 0;

	static void getRollValue() {
		Random r = new Random();
		int low = 1;
		int high = 7;
		int d1 = (int) (r.nextInt(high - low) + low);
		int d2 = (int) (r.nextInt(high - low) + low);
		rollValue = d1 + d2;
		System.out.println("Your roll: d1: last roll: " + d1 + "; d2 last roll: " + d2 + "; rollValue: " + rollValue);
	}

	static void rollDice() {
		getRollValue();
		winnerLoser();
	}

	static void betAmount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your bet: ");
		betAmount = sc.nextInt();
		if (betAmount >= 10) {
			System.out.println("Place your bet: " + betAmount);
			if (balance - betAmount < 0) {
				System.out.println("Bet Amount is Invalid, Enter the Bet Amount Again");
				betAmount();
			} else {
				balance = balance - betAmount;
				rollDice();
			}
		} else {
			System.out.println("Minimum bet Amount is 10$.");
			betAmount();
		}

		sc.close();
	}

	static void balance() {
		System.out.println("Your Balance is: " + balance);
		if (balance >= 10) {
			betAmount();
		} else {
			System.out.println("Sorry, You ran out of Balance!");
		}
	}

	static void winnerLoser() {
		if (rollValue == 7 || rollValue == 11) {
			System.out.println("A Winner!");
			win++;
			balance = balance + (3 * betAmount);

		}
		if (rollValue == 2 || rollValue == 3 || rollValue == 12) {
			System.out.println("Oh, I'm sorry, you lost.");
			loss++;
			int prob = (win / (win + loss));
			System.out.println("Your Winning probability: " + prob);

		}

		if (rollValue == 4 || rollValue == 5 || rollValue == 6 || rollValue == 8 || rollValue == 9 || rollValue == 10) {
			System.out.println("You point value is: " + rollValue);

			rollWithPoint(rollValue);

		}
		wantToPlay();
	}

	static void wantToPlay() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Keep playing (y/Y or n/N)?");
		char play = sc.next().charAt(0);
		if (play == 'y' || play == 'Y') {
			balance();
		} else if (play == 'n' || play == 'N') {
			int prob = (win / (win + loss));
			System.out.println("Your Winning probability: " + prob);
		}

		sc.close();
	}

	static boolean rollWithPoint(int point) {
		Boolean result;
		while (true) {
			getRollValue();
			if (rollValue == point) {
				System.out.println("A winner");
				balance = balance + (2 * betAmount);
				result = true;
				break;
			} else if (rollValue == 7) {
				System.out.println("Oh, I'm sorry, you lost.");
				result = false;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the game: ");
		System.out.println("\n\nThe house has given you a starting balance of $500\r\n"
				+ "On each round, you make a (whole number) wager.\r\n"
				+ "The minimum wager is $10, and the maximum wager is your remaining balance.\r\n" + "\r\n"
				+ "You make keep playing until you decide to cash in, or\r\n" + "you can't cover the minimum wager.\r\n"
				+ "Good Luck!");

		balance();
	}
}
