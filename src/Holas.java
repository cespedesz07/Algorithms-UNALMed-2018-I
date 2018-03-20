import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Holas {
	
	final static String[] IDIOM = new String[] { 
			"ESPANOL", "INGLES", "ALEMAN", "FRANCES", "ITALIANO", "RUSO"
	};
	final static String[] HELLO_TRANSLATED = new String[] { 
			"HOLA", "HELLO", "HALLO", "BONJOUR", "CIAO", "ZDRAVSTVUJTE" 
	};
	final static String END_OF_INPUT = "#";
	
	public static void main( String[] args ) {		
		List<String> translatedWords = new ArrayList<String>();
		Scanner scanner = new Scanner( System.in );
		String word = scanner.nextLine().toUpperCase();
		while ( !word.equals( END_OF_INPUT ) ) {
			translatedWords.add( translateWord( word ) );
			word = scanner.nextLine().toUpperCase();
		}
		printArray( translatedWords );
		
	}
	
	public static String translateWord( String word ) { 
		for ( int i=0; i<HELLO_TRANSLATED.length; i++ ) {
			if ( HELLO_TRANSLATED[i].equals( word ) ) {
				return IDIOM[i];
			}
		}
		return "DESCONOCIDO";
	}
	
	public static void printArray( List<String> array ) {
		for ( int i=0; i<array.size(); i++ ) {
			System.out.printf( "Palabra %d: %s\n", i+1, array.get(i) );
		}
	};

}
