import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class DataCollector {

	private FileReader fileReader;
	private Map<String, Information> information = new HashMap<>();
	private Utility utility = new Utility();
	private List<Information> duplicates = new ArrayList<>();
	private List<String []> errorLog = new ArrayList<>();

	public DataCollector(FileReader fileReader) {
		this.fileReader = fileReader;
	}

	public boolean openFile(String fileName) {
		return fileReader.openFile(fileName);
	}

	public String readFile(String textToRead) {
		return fileReader.readLine();
	}

	public boolean hasMore() {
		return fileReader.hasMore();
	}

	public Information getInformation(String keyId) {
		return information.get(keyId);
	}

	public void saveInformation(String informationToSave){	
		String[] tokens = splitLine(informationToSave);

		checkOperators(tokens);
		String bitResult = calculateBitwise(tokens[1], tokens[2], tokens[3]);

		if(information.containsKey(tokens[0])) {
			duplicates.add(newInformation(tokens, bitResult));
		}

		information.put(tokens[0], newInformation(tokens, bitResult));	
	}

	private void checkOperators(String [] tokens) {
		if (!tokens[1].matches("[12]+")) {
			errorLog.add(tokens);
			throw new IllegalArgumentException();
		}
	}

	private String[] splitLine(String informationToSave) {
		StringTokenizer tokenizer = new StringTokenizer(informationToSave);
		String [] tokens = new String[4];

		for (int i = 0; tokenizer.hasMoreElements(); i++)
			tokens[i] = tokenizer.nextToken();
		return tokens;
	} 

	public void checkArguments(String string) {
		if (string.length() != 58) {
			throw new IllegalArgumentException();
		}
	}

	public String calculateBitwise(String operator, String first, String second) {
		String stringToReturn = "";
		if(operator.equals("1")) {
			stringToReturn = utility.bitwiseAnd(first, second);
		}

		else if(operator.equals("2")) {
			stringToReturn = utility.bitwiseOr(first, second);
		}
		return stringToReturn;
	}

	private Information newInformation(String[] tokens, String bitResult) {
		int intResult = utility.bitToInt(bitResult);
		return new Information(tokens[1], tokens[2], tokens[3], bitResult, intResult);
	}

	public List<Information> getDuplicates() {
		return duplicates;
	}

	class Information {
		private String operator, firstString, secondString, bitResult;
		private int intResult;

		public Information(String operator, String firstString, String secondString, String bitResult, int intResult) {
			this.operator = operator;
			this.firstString = firstString;
			this.secondString = secondString;
			this.bitResult = bitResult;
			this.intResult = intResult;
		}

		public String getOperator() {
			return operator;
		}

		public String getFirstString() {
			return firstString;
		}

		public String getSecondString() {
			return secondString;
		}

		public String getBitResult() {
			return bitResult;
		}

		public int getIntResult() {
			return intResult;
		}
	}
}