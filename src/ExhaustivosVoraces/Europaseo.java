package ExhaustivosVoraces;

import java.util.Arrays;
import java.util.Scanner;

public class Europaseo {
	
	public static String NA = "n.a";
	public static boolean[] visited;
	public static int minPathCost;
	
	public static void main( String[] args ) {
		Scanner scanner = new Scanner( System.in ); 
		int n = Integer.parseInt( scanner.nextLine() );
		int[][] distanceMatrix = new int[n][n];
		for ( int i=0; i<n; i++ ) {
			distanceMatrix[i] = parseRow( scanner.nextLine().split("\t") );
		}
		visited = new boolean[n];
		minPathCost = 10000;
		int[] cities = createCities(n);
		int[] possiblePath = new int[n];
		
		getMinPath( distanceMatrix, cities, n, possiblePath, 0 );	
		if ( minPathCost == 10000 ) {
			System.out.println( "imposible" );
		}
		else {
			System.out.println( minPathCost );
		}		
	}
	
	public static void getMinPath( int[][] distanceMatrix, int[] cities, int n, 
			int[] possiblePath, int initialLength ) {
		if ( n == initialLength ) {
			int pathCost = getPathCost(possiblePath, distanceMatrix, n);
			if ( pathCost != 0 && pathCost < minPathCost ) {
				// System.out.printf( "%s - %d \n", Arrays.toString(possiblePath), pathCost );
				minPathCost = pathCost; 
			}	
		}
		else {
			for ( int i=0; i<n; i++ ) {
				if ( !visited[i] ) {
					visited[i] = true;
					possiblePath[i] = cities[initialLength];
					getMinPath( distanceMatrix, cities, n, possiblePath, initialLength + 1 );
					visited[i] = false;
				}
			}
		}
	}
	
	public static int getPathCost( int[] possiblePath, int[][] distanceMatrix, int n ) {
		int start = 0;
		int end = start + 1;
		int pathCost = 0;
		boolean invalidPath = false;
		while ( end < n && !invalidPath ) {
			int fromCity = possiblePath[start];
			int toCity = possiblePath[end];
			if ( distanceMatrix[fromCity][toCity] != -1 && distanceMatrix[fromCity][toCity] != 0 ) {
				pathCost += distanceMatrix[fromCity][toCity];
				start++;
				end++;
			}
			else {
				invalidPath = true;
				pathCost = 0;
			}
			
		}
		return pathCost;
	}
	
	public static int[] createCities( int n ) {
		int[] result = new int[n];
		for ( int i=0; i<n; i++ ) {
			result[i] = i;
		}
		return result;
	}
	
	public static int[] parseRow( String[] row ) {
		int[] result = new int[row.length];
		for ( int i=0; i<row.length; i++ ) {
			if ( row[i].equals(NA) ) {
				result[i] = -1;
			}
			else {
				result[i] = Integer.parseInt( row[i] );
			}
		}
		return result;
	}
	
	/*
	 * call: getMinPath( distanceMatrix, n, ci, 0, "", 0 );
	public static void getMinPath( int[][] distanceMatrix, int n, int ci, int minPath, String path, int pathLength ) {
		if ( n == pathLength ) {
			System.out.println( path );
		}
		else {
			for ( int j=0; j<n; j++ ) {
				if ( distanceMatrix[ci][j] != -1 && distanceMatrix[ci][j] != 0 ) {
					int distanceSaved = distanceMatrix[ci][j];
					distanceMatrix[j][ci] = distanceMatrix[ci][j] = -1;
					getMinPath( distanceMatrix, n, j, minPath + distanceSaved, path + j + " - ", pathLength + 1 );
					distanceMatrix[j][ci] = distanceMatrix[ci][j] = distanceSaved;
					
				}
			}
		}
	}
	*/
}
