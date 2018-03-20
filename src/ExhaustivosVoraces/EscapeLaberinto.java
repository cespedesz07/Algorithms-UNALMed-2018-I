package ExhaustivosVoraces;

import java.util.Scanner;

public class EscapeLaberinto {
	
	private static int minPathLength;
	
	public static void main( String[] args ) {
		Scanner scanner = new Scanner(System.in);
		int recordsCount = Integer.parseInt( scanner.nextLine() );
		if ( 1 <= recordsCount && recordsCount <= 100 ) {
			int[] resultArray = new int[recordsCount];
			for ( int i=0; i<recordsCount; i++ ) {
				String dimensions = scanner.nextLine();
				String[] dimensionsArray = dimensions.split(" ");
				String[][] maze = new String[Integer.parseInt( dimensionsArray[0])][Integer.parseInt( dimensionsArray[1])];
				for ( int rows=0; rows<Integer.parseInt(dimensionsArray[0]); rows++ ) {
					String row = scanner.nextLine();
					maze[rows] = row.split(" ");
				}
				minPathLength = Integer.parseInt( dimensionsArray[0]) * Integer.parseInt( dimensionsArray[1]);
				maze[0][0] = "-1";
				// System.out.println( "Generated Maze:" );
				// printMaze( maze );
				// System.out.println( "_______________ \n" );
				calculateMinPath( maze, 0, 0, 
						Integer.parseInt( dimensionsArray[0]), Integer.parseInt( dimensionsArray[1]), 0 );
				if ( minPathLength == Integer.parseInt( dimensionsArray[0]) * Integer.parseInt( dimensionsArray[1]) ) {
					System.out.println( -1 );
				}
				else {
					System.out.println( minPathLength );
				}
			}
		}
	}
	
	public static void calculateMinPath( String[][] maze, int i, int j, int rows, int cols, int counter ) {
		int[][] movements = new int[][] {
			{-1, 0}, {1, 0}, //up-down movements
			{0, -1}, {0, 1}, //left-right movements
		};
		if ( i == rows - 1 && j == cols - 1 ) {
			if ( counter < minPathLength )
				minPathLength = counter;
		}
		else {
			for ( int[] coord : movements ) {
				if ( isMovementInMazeArea( i, j, coord, rows, cols ) ) {
					if ( maze[i + coord[0]][j + coord[1]].equals(".") ) {
						/*
						System.out.printf( "Navigating (%s, %s): %s - %d\n", i + coord[0], j + coord[1], 
								maze[i + coord[0]][j + coord[1]], counter + 1 );
						*/
						
						maze[i + coord[0]][j + coord[1]] = "-1";
						// printMaze( maze );
						// System.out.println("-------------------------- \n");
						calculateMinPath( maze, i + coord[0], j + coord[1], rows, cols, counter + 1 );
						maze[i + coord[0]][j + coord[1]] = ".";
					}
				}
			}
		}
	}
	
	public static boolean isMovementInMazeArea( int i, int j, int[] coord, int rows, int cols ) {
		return 0 <= i + coord[0] && i + coord[0] < rows &&
				0 <= j + coord[1] && j + coord[1] < cols;
				
	}
	
	public static void printMaze( String[][] maze ) {
		for (String[] row : maze) {
			for ( String cell : row ) {
				System.out.printf("%s ", cell);
			}
			System.out.println();
		}
	}

}
