package ExhaustivosVoraces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JuegoCaballo {
	
	public static int[][] MOVEMENTS = new int[][] {
		{-2, +1},
		{-1, +2},
		{+1, +2},
		{+2, +1},
		{+2, -1},
		{+1, -2},
		{-1, -2},
		{-2, -1},
	};
	
	public static int[][] BOARD = new int[][] {
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0}
	};
	
	public static int minMovements;
	public static List<String> letters;
	
	
	
	public static void main( String[] args ) throws InterruptedException {
		letters = createLettersArray();
		Scanner scanner = new Scanner( System.in );
		int records = Integer.parseInt( scanner.nextLine() );
		for ( int i=0; i<records; i++ ) {
			int[] cell = transformToIntCell( letters, scanner.nextLine().split(" ") );
			System.out.println( "Starting from: " + Arrays.toString(cell) );
			minMovements = 9999;
			calculateMinMovements( cell[0], cell[1], BOARD.length, 0 );
			System.out.println( minMovements );
		}
	}
	
	public static void calculateMinMovements( int ci, int cj, int n, int movementsCounter ) throws InterruptedException {
		Thread.sleep(2000);
		if ( ci == n - 1  &&  cj == n - 1 ) {
			if ( movementsCounter < minMovements ) {
				minMovements = movementsCounter;
				System.out.println( minMovements );
			}
		}
		for ( int[] coord : MOVEMENTS ) {
			int nextI = ci + coord[0];
			int nextJ = cj + coord[1];
			if ( isValidMovement( n, nextI, nextJ ) ) {
				System.out.printf( "\tMoving from (%d, %d) to (%d, %d) \n", ci, cj, nextI, nextJ );
				BOARD[ci][cj] = -1;
				calculateMinMovements( nextI, nextJ, n, movementsCounter + 1 );
				BOARD[ci][cj] = 0;
			}
		}
	}
	
	public static boolean isValidMovement( int n, int nextI, int nextJ) {
		if (0 <= nextI && nextI < n  &&  0 <= nextJ && nextJ < n ) {
			if ( BOARD[nextI][nextJ] != -1 ) {
				System.out.printf( "VALID: (%d, %d)", nextI, nextJ );
				return true;
			}
		}
		return false;
			   
	}
	
	public static int[] transformToIntCell( List<String> letters, String[] cell ) {
		int[] result = new int[ cell.length ];
		result[0] = letters.indexOf( cell[0] );
		result[1] = Integer.parseInt( cell[1] ) - 1;
		return result;
	}
	
	public static List<String> createLettersArray(){
		List<String> letters = new ArrayList<String>();
		letters.add("A");
		letters.add("B");
		letters.add("C");
		letters.add("D");
		letters.add("E");
		letters.add("F");
		letters.add("G");
		letters.add("H");
		return letters;
	}

}
