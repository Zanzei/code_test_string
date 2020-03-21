package code_test_fpt_string;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input : ");
		String input = sc.nextLine();
		
		System.out.print("\nOutput (Manual Sort) : " + AlphabetSoup_ManualSort(input));
		System.out.print("\nOutput (Stream Sort) : " + AlphabetSoup_StreamSort(input));
	}
	
	private static String AlphabetSoup_ManualSort(String input) {
		char[] arr = input.toCharArray();
		char res;
	    for (int i = 0; i < arr.length; i++ ) {
	       for (int j = (i + 1); j < arr.length; j++) {
	          if (Character.toLowerCase(arr[i]) > Character.toLowerCase(arr[j])) {
	        	 res = arr[i];
	             arr[i] = arr[j];
	             arr[j] = (char) res;
	          }
	       }
	    }

		return String.valueOf(arr);
	}
	
	private static String AlphabetSoup_StreamSort(String input) {
		return Stream.of(input.split(""))
				.sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
				.collect(Collectors.joining());
	}

}
