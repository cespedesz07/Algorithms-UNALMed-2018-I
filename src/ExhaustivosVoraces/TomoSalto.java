package ExhaustivosVoraces;

import java.util.Scanner;

public class TomoSalto {
	
	public static void main( String[] args ) {
		Scanner scanner = new Scanner(System.in);
		int recordsCount = Integer.parseInt( scanner.nextLine() );
		if ( 1 <= recordsCount && recordsCount <= 20 ) {
			String numbers = scanner.nextLine();
			System.out.println(  getMaxValue( numbers.split(" ") )  );
			
		}
	}
	
	public static int getMaxValue( String[] numbersArray ) {
		int currentAcum = Integer.parseInt( numbersArray[0] );
		int i = 0;
		while ( i <= numbersArray.length - 2 ) {
			if ( i == numbersArray.length - 2 ){
				int valueTakeLast = currentAcum + Integer.parseInt( numbersArray[i + 1] ) - Integer.parseInt( numbersArray[i] );
				int valueNotTakeLast = currentAcum;
				currentAcum = getMax( -1, valueTakeLast, valueNotTakeLast );
				i += 1;
				System.out.printf( "%d, %d, %d - max: %d - current: %d, %d\n", -1, valueTakeLast, valueNotTakeLast,
						getMax( -1, valueTakeLast, valueNotTakeLast ), currentAcum, i);
			}
			else {
				int valueTakeBoth = currentAcum - Integer.parseInt( numbersArray[i] ) + Integer.parseInt( numbersArray[i + 2] );
				int valueTakeFirst = currentAcum + Integer.parseInt( numbersArray[i + 1] ) - Integer.parseInt( numbersArray[i] );
				int valueTakeSecond = currentAcum + Integer.parseInt( numbersArray[i + 2] );
				currentAcum = getMax( valueTakeBoth, valueTakeFirst, valueTakeSecond );
				if( currentAcum == valueTakeFirst ) {
					i += 1;
				} 
				else {
					i += 2;
				}
				System.out.printf( "%d, %d, %d - max: %d - current: %d, %d\n", valueTakeBoth, valueTakeFirst, valueTakeSecond,
						getMax( valueTakeBoth, valueTakeFirst, valueTakeSecond ), currentAcum, i);
			} 
			
		}
		return currentAcum;
	}
	
	public static int getMax( int a, int b, int c ) {
		if (a < b) {
			if (b < c) {
				return c;
			}
			else {
				return b;
			}
		}
		else {
			if (a < c) {
				return c;
			}
			else {
				return a;
			}
		}
	}

}
