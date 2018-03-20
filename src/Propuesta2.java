import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Propuesta2 {
	
	private final static String END_OF_INPUT ="#";
	
	public static void main(String[] args) {
		Map<String, String> map = completeMap();
		List<String> translatedWords = new ArrayList<String>();
		Scanner scanner = new Scanner( System.in );
		String word = scanner.nextLine().toUpperCase();
		while ( !word.equals( END_OF_INPUT ) ) {
			translatedWords.add(word);
			word = scanner.nextLine().toUpperCase();
		}
		
		for(int i=0; i<translatedWords.size(); i++) {
			if(map.containsKey(translatedWords.get(i))){
				System.out.printf( "Palabra %d: %s\n", i+1, map.get(translatedWords.get(i)).toUpperCase() );
			}else {
				System.out.printf( "Palabra %d: %s\n", i+1, "DESCONOCIDO");
			}
			
		}
	}
	
	private static Map<String, String> completeMap() {
		 Map<String, String> map = new HashMap<>();
		 map.put("HOLA", "ESPANOL");
		 map.put("HELLO", "INGLES" );
		 map.put("HALLO","ALEMAN");
		 map.put("BONJOUR","FRANCES");
		 return map;
		
	}

}
