
public class Utility {
		
	private final int MAXIMUM_LENGTH_OF_BIT_STRING = 24;
	private final int MAXIMUM_LENGTH_OF_HEX_STRING = 6;
	private final String LEGAL_NUMBERS_BIT = "[01]+";
	private final String LEGAL_NUMBERS_AND_LETTERS_HEX = "[0-9A-Fa-f]+";
	private final String HEX_DIGITS = "0123456789ABCDEF";

	public int bitToInt(String stringToConvert) {
		int intToReturn = 0;

		if (stringToConvert.length() == 0) {
			intToReturn = 0;
		} else {
			checkIfLegalLengthOfStrings(stringToConvert, MAXIMUM_LENGTH_OF_BIT_STRING);
			checkForLegalNumbersAndLetters(stringToConvert, LEGAL_NUMBERS_BIT);
			intToReturn = convertFromBitToInt(stringToConvert, intToReturn);
		}
		return intToReturn;
	}

	private int convertFromBitToInt(String stringToConvert, int intToReturn) {
		char[] numbers = stringToConvert.toCharArray();
		for(int i = numbers.length - 1; i >= 0; i--) {
			if(numbers[i] == '1') {
				intToReturn += Math.pow(2, numbers.length -i -1);
			}
		}
		return intToReturn;
	}

	private void checkIfLegalLengthOfStrings(String stringToCheck, int lengthOfString) {
		if(stringToCheck.length() > lengthOfString) {
			throw new IllegalArgumentException();
		}
	}

	private void checkForLegalNumbersAndLetters(String stringToCheck, String legalNumbersAndLetters) {
		if (!stringToCheck.matches(legalNumbersAndLetters)) {
			throw new IllegalArgumentException();
		}
	}

	public String intToBit(int intToConvert) {
		StringBuilder stringBuilderToReturnReversed = new StringBuilder("");
		for (int i = 0; i < MAXIMUM_LENGTH_OF_BIT_STRING; i++, intToConvert /= 2) {
			stringBuilderToReturnReversed.append(intToConvert % 2);
		}
			
		return stringBuilderToReturnReversed.reverse().toString();
	}

	public int hexToInt(String stringToConvert) {
		int intToReturn = 0;

		if (stringToConvert.length() == 0) {
			intToReturn = 0;
		} else {
			checkIfLegalLengthOfStrings(stringToConvert, MAXIMUM_LENGTH_OF_HEX_STRING );
			checkForLegalNumbersAndLetters(stringToConvert, LEGAL_NUMBERS_AND_LETTERS_HEX );
			intToReturn = convertFromHexToInt(stringToConvert, intToReturn);
		}
		return intToReturn;
	}

	private int convertFromHexToInt(String stringToConvert, int intToReturn) {
		char [] hexArray = stringToConvert.toUpperCase().toCharArray();
		for (char currentChar : hexArray) {
			intToReturn = intToReturn * 16 + HEX_DIGITS.indexOf(currentChar);
		}
		return intToReturn;
	}

	public String intToHex(int intToConvert) {
		StringBuilder stringBuilderToReturnReversed = new StringBuilder("");
		for (int i = 0; i < MAXIMUM_LENGTH_OF_HEX_STRING; i++, intToConvert /= 16) {
			stringBuilderToReturnReversed.append(HEX_DIGITS.charAt(intToConvert % 16));
		}
		return stringBuilderToReturnReversed.reverse().toString();
	}	 
}