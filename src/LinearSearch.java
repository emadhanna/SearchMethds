import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LinearSearch {
	
	private static int countCharacterPromptCalls = 0;
	
	public static void main(String[] args) {

		char ALPHABETLIST[] = {' ', '!', '.', 'a', 'b', 'c', 'd', 'e' , 'f', 'g', 'h', 
				'i', 'j' , 'k' , 'l', 'm' , 'n', 'o', 'p', 'q' , 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		
		List<Character> resultedWord = addCharactersToList(ALPHABETLIST);
		
		System.out.println("You typed:");
		printWordCaptured(resultedWord);
		System.out.println("Number of prompts for checking character: " + countCharacterPromptCalls);
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
		countCharacterPromptCalls++;
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
	
	public static void printWordCaptured(List<Character> list) {
		
		for (Character character : list) {
			System.out.print(character);
		}
		System.out.println("\n");
	}
}
