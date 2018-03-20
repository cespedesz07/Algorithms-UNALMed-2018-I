import java.util.Scanner;

public class NumerosMagicos {
	
	public static void main( String[] args ) {
		Scanner scanner = new Scanner(System.in);
		int recordsCount = Integer.parseInt( scanner.nextLine() );
		if ( 1 <= recordsCount && recordsCount <= 100 ) {
			int[] resultArray = new int[recordsCount];
			for ( int i=0; i<recordsCount; i++ ) {
				String record = scanner.nextLine();
				String[] splitedRecords = record.split(" ");
				resultArray[i] = countMagicNumbers( 
						Integer.parseInt( splitedRecords[0] ), 
						Integer.parseInt( splitedRecords[1] )  
				);
				
			}
			for ( int result : resultArray ) {
				System.out.println( result );
			}
		}
	}
	
	public static int countMagicNumbers( int a, int b ) {
		if ( 0 < a && a <= b ) {
			int count = 0;
			for ( int i=a; i<=b; i++ ) {
				if ( isMagicNumber( i ) ) {
					count++;
				}
			}
			return count;
		}
		return -1;
	}
	
	public static boolean isMagicNumber( int number ) {
		int limit = (number + 1) / 2;
		int sum = 1;
		for ( int i=2; i<=limit; i++ ) {
			if ( number % i == 0 ) {
				sum += number / i;
			}
		}
		return sum == number;
	}	

}
