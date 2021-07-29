import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {
	
	private static int countCharacterPromptCalls = 0;

	public static void main(String[] args) {

		List<Character> resultedWord = addCharactersToList();
		
		System.out.println("You typed:");
		printWordCaptured(resultedWord);
		System.out.println("Number of questions typed is: " + countCharacterPromptCalls);
	}


	private static List<Character> addCharactersToList() {
		List<Character> resultedWord = new ArrayList<>();
		char capturedLetter = binaryLetter();
		while (capturedLetter != '!') {
			resultedWord.add(capturedLetter);
			capturedLetter = binaryLetter();
		}
		return resultedWord;
	}

	public static char binaryLetter() {
		
		char ALPHABETLIST[] = {' ', '!', '.', 'a', 'b', 'c', 'd', 'e' , 'f', 'g', 'h', 
				'i', 'j' , 'k' , 'l', 'm' , 'n', 'o', 'p', 'q' , 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		return checkCharacterRange(ALPHABETLIST, 0, ALPHABETLIST.length - 1);
	}
	
	public static char checkCharacterRange(char[] alphabetList, int startValue, int endValue) {
		int middleCharacter = extractMiddleValue(startValue, endValue);
		boolean answerCaptured = false;
		
		if (startValue == endValue) {
			answerCaptured = isThisTheLetter(alphabetList[startValue], alphabetList[endValue]);
			if (answerCaptured) {
				return alphabetList[startValue];
			}else {
				binaryLetter();
			}
		}
		
		answerCaptured = isThisTheLetter(alphabetList[startValue], alphabetList[middleCharacter]);
		if (answerCaptured && (startValue == middleCharacter)) {
			return alphabetList[startValue];
		}else {
			if (answerCaptured) {
				return checkCharacterRange(alphabetList, startValue, middleCharacter);
			}
		}
		
		return checkCharacterRange(alphabetList, middleCharacter + 1, endValue);
	}


	private static int extractMiddleValue(int startCharacter, int endCharacter) {
		int middleCharacter = startCharacter + (endCharacter - startCharacter) / 2;
		return middleCharacter;
	}
	
	public static boolean isThisTheLetter(char startCharcter, char endCharacter) {
		Scanner scan = new Scanner(System.in);
		validateStartAndEndCharacterNotMatched(startCharcter, endCharacter);
		char capteredAnswer = 'n';
		String capturedWord = scan.next();
		capturedWord = capturedWord.toLowerCase();
		capteredAnswer = capturedWord.charAt(0);
		
		if (capteredAnswer == 'y') {
			return true;
		}else {
			while(capteredAnswer != 'n') {
				validateStartAndEndCharacterNotMatched(startCharcter, endCharacter);
				capturedWord = scan.next();
				capturedWord = capturedWord.toLowerCase();
				capteredAnswer = capturedWord.charAt(0);
			}
			return false;
		}
	}

	private static void validateStartAndEndCharacterNotMatched(char startCharcter, char endCharacter) {
		countCharacterPromptCalls++;

		if (startCharcter != endCharacter) {
			System.out.println("Is your letter between '" + startCharcter + "' and '" + endCharacter + "'?");
		}else {
			System.out.println("Is your letter '" + startCharcter + "'?");
		}
	}
	
	public static void printWordCaptured(List<Character> list) {
		
		for (Character character : list) {
			System.out.print(character);
		}
		System.out.println("\n");
	}

}
