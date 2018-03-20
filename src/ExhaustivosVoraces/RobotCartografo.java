package ExhaustivosVoraces;

import java.util.Scanner;
import java.util.Arrays;

public class RobotCartografo {
	
	public static void main( String[] args ) {
		Scanner scanner = new Scanner( System.in );
		int records = Integer.parseInt( scanner.nextLine() );
		for ( int r=0; r<records; r++ ) {
			int n = Integer.parseInt( scanner.nextLine() );
			int[][] matrix = new int[n][n];
			for ( int i=0; i<n; i++ ) {
				matrix[i] = toIntArray( scanner.nextLine().split(" ") );
			}
			System.out.println( getMinColors( matrix, n ) );
		}	
	}
	
	public static int[] toIntArray( String[] array ) {
		int[] result = new int[array.length];
		for ( int i=0; i<array.length; i++ ) {
			result[i] = Integer.parseInt( array[i] );
		}
		return result;
	}
	
	public static int getMinColors( int[][] matrix, int n ) {
		int[] colorsUsed = new int[n]; 
		int minColorsCount = 1;
		colorsUsed[0] = minColorsCount;
		for ( int i=1; i<n; i++ ) {
			int j = 0;
			boolean hasValidCombination = false;
			while ( j < i && !hasValidCombination ) {								
				if ( matrix[i][j] == 0 ) {						
					colorsUsed[i] = colorsUsed[j];
					hasValidCombination = invalidColorsCombination( colorsUsed, matrix, i );
					if ( !hasValidCombination ) {
						colorsUsed[i] = 0;
					}
				}				
				j += 1;
			}
			if ( colorsUsed[i] == 0 ) {
				minColorsCount += 1;
				colorsUsed[i] = minColorsCount;
			}
		}
		return minColorsCount;
	}
	
	public static boolean invalidColorsCombination( int[] colorsUsed, int[][] matrix, int limit ) {
		for ( int i=0; i<limit; i++ ) {
			for ( int j=i+1; j<=limit; j++ ) {
				if ( matrix[i][j] == 1 ) {
					if( colorsUsed[i] == colorsUsed[j] ) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
