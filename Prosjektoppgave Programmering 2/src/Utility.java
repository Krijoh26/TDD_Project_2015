
public class Utility {

	private final String LEGAL_NUMBERS_BIT = "[01]+";	
	private final int MAXIMUM_LENGTH_OF_BIT_STRING = 24;

	public int bitToInt(String stringToConvert) {
		int intToReturn = 0;

		if (stringToConvert.length() == 0) {
			intToReturn = 0;
		} else {
			checkIfLegalLengthBitString(stringToConvert, MAXIMUM_LENGTH_OF_BIT_STRING);
			checkForLegalNumbers(stringToConvert, LEGAL_NUMBERS_BIT);
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

	private void checkIfLegalLengthBitString(String stringToCheck, int typeLength) {
		if(stringToCheck.length() > typeLength) {
			throw new IllegalArgumentException();
		}
	}

	private static void checkForLegalNumbers(String stringToCheck, String legalNumbers) {
		if (!stringToCheck.matches(legalNumbers)) {
			throw new IllegalArgumentException();
		}
	}

	public String intToBit(int intToConvert) {
		StringBuilder stringBuilder = new StringBuilder("");
		for (int i = 0; i < MAXIMUM_LENGTH_OF_BIT_STRING; i++, intToConvert /= 2) 
			stringBuilder.append(intToConvert % 2);
			
		return stringBuilder.reverse().toString();
	}
}