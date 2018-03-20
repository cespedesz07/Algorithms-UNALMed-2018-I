import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UnoDosTres {
	
	public static void main( String[] args ) {
		List<char[]> stringNumbers = generateStringNumbers();
		Scanner scanner = new Scanner(System.in);
		int rowsCount = Integer.parseInt( scanner.nextLine() );
		if ( rowsCount > 0 && rowsCount <= 10 ) {
			int resultArray[] = new int[rowsCount];
			String number = "";
			for ( int i=0; i<rowsCount; i++ ) {
				number = scanner.nextLine();
				resultArray[i] = evaluateNumber( number.toCharArray(), stringNumbers );
			}
			
			for ( int result : resultArray ) {
				System.out.println( result );
			}
		}		
	}
	
	public static int evaluateNumber( char[] number, List<char[]> stringNumbers ) {
		for ( int i=0; i<stringNumbers.size(); i++ ) {
			char[] currentNumber = stringNumbers.get(i);
			if ( number.length == currentNumber.length ) {
				int matches = 0;
				for ( int j=0; j<number.length; j++ ) {
					if ( number[j] == currentNumber[j] ) {
						matches += 1;
					}
				}
				if ( matches >= currentNumber.length - 1 ) {
					return i + 1;
				}
			}
		}
		return -1;
	}
	
	public static List<char[]> generateStringNumbers() {
		List<char[]> stringNumbers = new ArrayList<char[]>();
		stringNumbers.add( "uno".toCharArray() );
		stringNumbers.add( "dos".toCharArray() );
		stringNumbers.add( "tres".toCharArray() );
		stringNumbers.add( "cuatro".toCharArray() );
		stringNumbers.add( "cinco".toCharArray() );
		stringNumbers.add( "seis".toCharArray() );
		stringNumbers.add( "siete".toCharArray() );
		stringNumbers.add( "ocho".toCharArray() );
		stringNumbers.add( "nueve".toCharArray() );
		stringNumbers.add( "diez".toCharArray() );
		return stringNumbers;
	}

}
