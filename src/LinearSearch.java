import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LinearSearch {
	
	public static void main(String[] args) {

		char ALPHABETLIST[] = {' ', '!', '.', 'a', 'b', 'c', 'd', 'e' , 'f', 'g', 'h', 
				'i', 'j' , 'k' , 'l', 'm' , 'n', 'o', 'p', 'q' , 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		
		List<Character> resultedWord = addCharactersToList(ALPHABETLIST);
		
		System.out.println("You typed:");
		printWordCaptured(resultedWord);
	}


	private static List<Character> addCharactersToList(char[] ALPHABETLIST) {
		List<Character> resultedWord = new ArrayList<>();
		char capturedLetter = returnTheLetter(ALPHABETLIST, 0);
		while (capturedLetter != '!') {
			resultedWord.add(capturedLetter);
			capturedLetter = returnTheLetter(ALPHABETLIST, 0);
		}
		return resultedWord;
	}
	
	
	public static char returnTheLetter(char[] alphabetList, int start) {
		
		for (int counter=start; counter < alphabetList.length; counter++) {
			if (isThisTheLetter(alphabetList[counter])) {
				return alphabetList[counter];
			}
		}
		return returnTheLetter(alphabetList, start);
	}
	
	public static boolean isThisTheLetter(char letterToCheck) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Are you thinking of the letter '" + letterToCheck + "'?");
		char capteredAnswer = 'n';
		String capturedWord = scan.next();
		capturedWord = capturedWord.toLowerCase();
		capteredAnswer = capturedWord.charAt(0);
		
		if (capteredAnswer == 'y') {
			return true;
		}else {
			while(capteredAnswer != 'n') {
				System.out.println("Are you thinking of the letter '" + letterToCheck + "'?");
				capturedWord = scan.next();
				capturedWord = capturedWord.toLowerCase();
				capteredAnswer = capturedWord.charAt(0);
			}
			return false;
		}
	}
	
//	public static List<Character> checkLetter(char[] alphabetList, int start) {
//		
//		List<Character> resultedWord = new ArrayList<Character>();
//		Scanner scan = new Scanner(System.in);
//		
//		for (int counter=start; counter < alphabetList.length; counter++) {
//			System.out.println("Are you thinking of the letter '" + alphabetList[counter] + "'?");
//			char capteredAnswer = 'n';
//			String capturedWord = scan.next();
//			capturedWord = capturedWord.toLowerCase();
//			capteredAnswer = capturedWord.charAt(0);
//			
//			if(capteredAnswer == 'y') {
//				if (alphabetList[counter] == '!') {
//					return resultedWord;
//				}else {
//					resultedWord.add(alphabetList[counter]);
//					checkLetter(alphabetList, start);
//				}
//			}else {
//				while(capteredAnswer != 'n') {
//					System.out.println("Are you thinking of the letter '" + alphabetList[counter] + "'?");
//					capturedWord = scan.next();
//					capturedWord = capturedWord.toLowerCase();
//					capteredAnswer = capturedWord.charAt(0);
//				}
//			}
//		}
//		return resultedWord;
//	}
	
	public static void printWordCaptured(List<Character> list) {
		
		for (Character character : list) {
			System.out.print(character);
		}
	}
}
