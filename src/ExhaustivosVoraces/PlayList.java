package ExhaustivosVoraces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlayList {
	
	public static void main( String[] args ) {
		Scanner scanner = new Scanner( System.in );
		int numRows = Integer.parseInt( scanner.nextLine() );
		if ( 1 <= numRows && numRows <= 10 ) {
			for ( int i=0; i<numRows; i++ ) {
				String songsList = scanner.nextLine();
				String[] songsArray = songsList.split( " " );
				int limitTime = Integer.parseInt( songsArray[0] );
				int[] songsTimes = getSongsTimes( songsArray );
				int[] permutationsArray = new int[songsTimes.length];
				List<Integer> differencesList = new ArrayList<Integer>();
				calculateMinTime( 2, songsTimes.length, permutationsArray, 0, songsTimes, limitTime, differencesList );
				System.out.println( getClosestMaxTime(differencesList, limitTime) );
			}
		}
	}
	
	public static int getClosestMaxTime( List<Integer> differencesList, int limitTime ) {
		Arrays.sort( differencesList.toArray() );
		int minDifference = limitTime;
		for ( int value : differencesList ) {
			if ( limitTime - value < minDifference  &&  limitTime - value >= 0 ) {
				minDifference = limitTime - value;
			}
		}
		return minDifference;
	}
	
	public static int[] getSongsTimes( String[] songsArray ) {
		int[] songsTimes = new int[songsArray.length - 2];
		for ( int i=2; i<songsArray.length; i++ ) {
			songsTimes[i - 2] = Integer.parseInt( songsArray[i] );
		}
		return songsTimes;
	}
	
	public static void calculateMinTime( int options, int n, int[] optionsArray, 
			int currentLength, int[] auxiliarArray, int limitTime, List<Integer> differencesList ) {
		if (currentLength == n) {
			differencesList.add( getSum(auxiliarArray, optionsArray) );
			
		}
		else {
			for (int i = 0; i < options; i++) {
				optionsArray[currentLength] = i;
				calculateMinTime( options, n, optionsArray, currentLength + 1, auxiliarArray, limitTime, differencesList );
			}
		}
	}
	
	public static int getSum( int[] numArray, int[] bitsArray ) {
		int result = 0;
		for ( int i=0; i<numArray.length; i++ ) {
			if ( bitsArray[i] == 1 ) {
				result += numArray[i];
			}			
		}
		return result;
	}

}
