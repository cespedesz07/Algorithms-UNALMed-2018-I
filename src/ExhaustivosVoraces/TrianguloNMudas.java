package ExhaustivosVoraces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TrianguloNMudas {
	
	private static boolean[] visited;
	private static int count;
	
	public static void main( String[] args ) {
		/*
		Scanner scanner = new Scanner(System.in);
		int recordsCount = Integer.parseInt( scanner.nextLine() );
		if ( 1 <= recordsCount && recordsCount <= 100 ) {
			int[] resultArray = new int[recordsCount];
			for ( int i=0; i<recordsCount; i++ ) {
				String record = scanner.nextLine();
				String[] splittedRecord = record.split(" ");
				int edgesSum = Integer.parseInt( splittedRecord[0] );				
			}
		}
		*/
		int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int maxSum = 20;
		List<Integer> resultArray = new ArrayList<Integer>(); 
		visited = new boolean[array.length];
		count = 0;
		permuteArray(array, array.length, "", 0, maxSum);
		System.out.println( count );
	}
	
	public static void permuteArray( int[] array, int n, String result, int initialLength, int maxSum ) {
		if ( initialLength == n ) {
			String[] resultArray = result.split(" ");
			if ( validCombination(resultArray, maxSum) ) {
				System.out.println( Arrays.toString( resultArray ) );
				count += 1;
			}
		}
		else {
			for ( int i=0; i<array.length; i++ ) {
				if ( !visited[i] ) {
					visited[i] = true;
					permuteArray(array, array.length, result + array[i] + " ", initialLength + 1, maxSum );
					visited[i] = false;
				}							
			}
		}
	}
	
	public static boolean validCombination( String[] resultArray, int maxSum ) {
		int[] edgesSum = new int[] {0, 0, 0};
		int sumIndex = 0;
		int i = 0;
		while (i < resultArray.length) {
			edgesSum[ sumIndex ] += Integer.parseInt( resultArray[i] );
			if ( i / 3 != sumIndex ) {
				sumIndex = i / 3;
			}
			else {
				i += 1;
			}			
		}
		edgesSum[ sumIndex ] += Integer.parseInt( resultArray[0] );
		return edgesSum[0] == maxSum && edgesSum[2] == maxSum && edgesSum[2] == maxSum;
	}
	
}
