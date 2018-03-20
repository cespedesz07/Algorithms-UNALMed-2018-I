package ExhaustivosVoraces;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReaprendiendoSumar {
	
	public static boolean[] visited;
	public static int minCost;
	// private static final Logger LOGGER = Logger.getLogger("ExhaustivosVoraces.ReaprendiendoSumar");
	
	public static void main(String[] args) {		
		Scanner scanner = new Scanner( System.in );
		int input = Integer.parseInt( scanner.nextLine() );
		while ( input > 0 ) {
			visited = new boolean[input];
			minCost = (int) Math.pow(input, input*1000);
			int[] numbers = new int[input];
			int[] currentCombination = new int[input];
			for ( int i=0; i<input; i++ ) {
				numbers[i] = Integer.parseInt( scanner.nextLine() );
			}
			// LOGGER.log(Level.INFO, Arrays.toString(numbers));
			// getCombinations( numbers, numbers.length, currentCombination, 0 );
			Arrays.sort( numbers );
			System.out.println( getCost(numbers) );
			input = Integer.parseInt( scanner.nextLine() );
		}
	}
	
	public static void getCombinations( int[] numbers, int n, int[] currentCombination, int initialLength ) {
		if ( n == initialLength ) {
			int currentCombinationCost = getCost(currentCombination);
			// System.out.printf( "%s: %d vs %d \n", Arrays.toString(currentCombination), currentCombinationCost, minCost );
			if ( currentCombinationCost < minCost ) {
				// System.out.printf( "%s: %d \n", Arrays.toString(currentCombination), currentCombinationCost );
				minCost = currentCombinationCost;
			}
		}
		else {
			for ( int i=0; i<numbers.length; i++ ) {
				if ( !visited[i] ) {
					visited[i] = true;
					currentCombination[i] = numbers[initialLength];
					getCombinations(numbers, numbers.length, currentCombination, initialLength + 1 );
					visited[i] = false;
				}
			}
		}
	}
	
	public static int getCost( int[] numbers ) {
		int costSum = 0;
		int numbersSum = numbers[0];
		for ( int i=1; i<numbers.length; i++ ) {
			numbersSum += numbers[i];
			costSum += numbersSum;
		}
		return costSum;
	}

}
