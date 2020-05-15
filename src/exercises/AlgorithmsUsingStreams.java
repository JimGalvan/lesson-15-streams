package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AlgorithmsUsingStreams {

	public static long countGoodEggs(List<String> eggs) {
		return eggs.stream() // 1. create stream
				.filter(egg -> egg.equals("whole")) // 2. intermediate filter operation
				.count(); // 3. terminal operation: reduce to an int
	}

	public static Object findTallest(List<Double> peeps) {
//		return Collections.max(peeps);
		return peeps.stream().sorted(Comparator.reverseOrder()).findFirst().get();
	}

	public static long addStringOfNumbers(String numbers) {
		return numbers.chars().mapToObj(c -> Character.toString(c)).mapToInt(num -> Integer.parseInt(num)).sum();
	}

	public static long countPearls(List<Boolean> oysters) {
//	    oysters.stream().filter(o -> o.booleanValue()).forEach(System.out::println);
		return oysters.stream().filter(o -> o.booleanValue()).count();
	}

	public static String findLongestWord(List<String> words) {

		return words.stream().max((w1, w2) -> w1.length() - w2.length()).get();
	}

	public static List<Double> sortScores(List<Double> results) {

		results.sort((n1, n2) -> n1.intValue() - n2.intValue());

		return results;
	}

	public static Object sortDNA(List<String> unsortedSequences) {

		unsortedSequences.sort((s1, s2) -> s1.length() - s2.length());

		return unsortedSequences;
	}

	public static List<String> sortWords(List<String> words) {
		words.sort((w1, w2) -> w1.compareTo(w2)); // compare in alphabetical order

		return words;
	}

	public static List<String> getDistinctSpellsInAlphabeticalOrder(List<String> spellsCastThisWeek) {
	 		List<String> listWithoutDuplicates = spellsCastThisWeek.stream().distinct().collect(Collectors.toList());
	 		listWithoutDuplicates.sort((w1, w2) -> w1.compareTo(w2));
	 		
	 		return listWithoutDuplicates;

	}

	public static ArrayList<String> getBatPhrases(String[] batmanScript) {

		Stream<String> myStream = Arrays.stream(batmanScript);

		Stream<String> myNewStream = myStream.map(s -> s.toUpperCase());

		Stream<String> myNewStream1 = myNewStream.map(s -> s.replace(" ", ""));

		String[] myNewArray = myNewStream1.filter((String f) -> f.contains("BAM") || f.equalsIgnoreCase("POW"))
				.toArray(String[]::new);

		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(myNewArray));
		System.out.println(arrayList.toString());

		return arrayList;
	}

	public static Long countXs(String xString) {
			
		Stream<Character> characterStream = xString.chars()
				  .mapToObj(c -> (char) c);	
//		return 		characterStream.filter(o -> o == 'x').count();
		return 		characterStream.filter(o -> o == 'o').count();
		
	}

	public static Integer addEven(String numbers) {
		return numbers.chars().mapToObj(c -> Character.toString(c))
				.mapToInt(num -> Integer.parseInt(num))
				.filter(n -> n % 2 == 0).sum();
	}

	public static Double getAverage(int[] numbers) {

		IntStream myStream = Arrays.stream(numbers);

		return 	myStream.average().getAsDouble();

	}

	public static long countOccurrences(String[] strArr, String string) {

		Stream<String> myStream = Arrays.stream(strArr);
		
		return 		myStream.filter(n -> n.equalsIgnoreCase(string)).count();
	}

}




















