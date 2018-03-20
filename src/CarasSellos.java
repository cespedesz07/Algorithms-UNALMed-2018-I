import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;

public class CarasSellos {
	
	public static void main( String[] args ) {
		Scanner scanner = new Scanner(System.in);
		int numThrows = Integer.parseInt( scanner.nextLine() );
		if ( numThrows > 0 && numThrows <= 1000 ) {
			String [] resultArray = new String[numThrows];
			int pos = 0;
			
			for ( int i=0; i<numThrows; i++ ) {
				Map<String, Integer> combinationsCountMap = generateCombinationsCount();
				pos = Integer.parseInt( scanner.nextLine() );
				String throwsString = scanner.nextLine().toUpperCase();
				countSequences(throwsString, combinationsCountMap);
				resultArray[pos - 1] = pos + " " + Arrays.toString( combinationsCountMap.values().toArray() )
					.replaceAll("\\[", "")
					.replaceAll("\\]", "")
					.replaceAll("\\,", "");
			}
			
			for ( String result : resultArray ) {
				System.out.println( result );
			}
		}
	}
	
	public static void countSequences( String throwsString, Map<String, Integer> combinationsCountMap ) {
		int start = 0, end = 3;
		while ( end <= throwsString.length() ) {
			String subset = throwsString.substring(start, end);
			if ( combinationsCountMap.containsKey( subset ) ) {
				combinationsCountMap.put( subset, combinationsCountMap.get( subset ) + 1 );
			}
			start += 1; end += 1;
		}
	}
	
	public static Map<String, Integer> generateCombinationsCount() {
		Map<String, Integer> combinationsCountMap = new HashMap<>();
		combinationsCountMap.put( "SSS", 0 );
		combinationsCountMap.put( "SSC", 0 );
		combinationsCountMap.put( "SCS", 0 );
		combinationsCountMap.put( "SCC", 0 );
		combinationsCountMap.put( "CSS", 0 );
		combinationsCountMap.put( "CSC", 0 );
		combinationsCountMap.put( "CCS", 0 );
		combinationsCountMap.put( "CCC", 0 );
		return combinationsCountMap;
	}

}
