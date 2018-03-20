import java.util.Scanner;

public class MayorMenorIgual {
	
	public static void main( String[] args ) {
		Scanner scanner = new Scanner( System.in );
		int numberCouples = Integer.parseInt( scanner.nextLine() );
		if ( numberCouples > 0 ) {
			String[] inputRecords = new String[numberCouples];
			for ( int i = 0; i < numberCouples; i++ ) {
				inputRecords[i] = scanner.nextLine();
				
			}
			for ( int j = 0; j < numberCouples; j++ ) {
				inputRecords[j] = compareNumbers( inputRecords[j] ); 
			}
			printArray( inputRecords );
		}
	};
	
	public static String compareNumbers( String numbersCouple ) {
		String[] numbersArray = numbersCouple.split( " " );
		int n1 = Integer.parseInt( numbersArray[0] );
		int n2 = Integer.parseInt( numbersArray[1] );
		if (n1 < n2) {
			return "<";
		}
		else if (n1 == n2) {
			return "=";
		}
		else {
			return ">";
		}
	};
	
	public static void printArray( String[] array ) {
		for ( String item : array ) {
			System.out.println( item );
		}
	};

}
