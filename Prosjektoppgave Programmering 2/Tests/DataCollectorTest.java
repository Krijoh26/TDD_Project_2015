import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class DataCollectorTest {
	private DataCollector dataCollector;
	private FileReader fileReader;
	private String fullInputString = "03AC0F 1 110101000000110111001101 001000011110011101001111";
	private String keyId = "03AC0F";
	private String firstString = "110101000000110111001101";
	private String secondString = "001000011110011101001111";
	private String bitwiseAndResult = "000000000000010101001101";
	private String bitwiseOrResult = "111101011110111111001111";


	@Before
	public void setUp() {
		fileReader = mock(FileReader.class);
		dataCollector = new DataCollector(fileReader);
	}

	@Test
	public void openFile_filetxt_returnsTrue() {
		when(fileReader.openFile("file.txt")).thenReturn(true);
		assertTrue(dataCollector.openFile("file.txt"));
		verify(fileReader, times(1)).openFile("file.txt");
	}

	@Test
	public void readLine_001000011110011101001111_returnsTheSameString() {
		String expectedString = "001000011110011101001111";
		when(fileReader.readLine()).thenReturn(expectedString);
		assertEquals(expectedString, dataCollector.readFile("file.txt"));
		verify(fileReader, times(1)).readLine();
	}

	@Test
	public void hasMore_returnsFalse() {
		when(fileReader.hasMore()).thenReturn(false);
		assertEquals(false, dataCollector.hasMore());
		verify(fileReader, times(1)).hasMore();
	}
	
	@Test
	public void getInformation_keyId_returnsValueFromKey() {
		dataCollector.saveInformation(fullInputString);
		assertEquals("1", dataCollector.getInformation(keyId).getOperator());
		assertEquals(firstString, dataCollector.getInformation(keyId).getFirstString());
		assertEquals(secondString, dataCollector.getInformation(keyId).getSecondString());
		assertEquals(bitwiseAndResult, dataCollector.getInformation(keyId).getBitResult());
		assertEquals(1357, dataCollector.getInformation(keyId).getIntResult());
	}

	@Test (expected = IllegalArgumentException.class)
	public void checkArguments_keyId_throwsIllegalArgument() {
		dataCollector.checkArguments(keyId);
	}
	
	@Test
	public void checkArguments_string_runsWithoutProblems() {
		dataCollector.checkArguments(fullInputString);
	}
	
	@Test
	public void calculateBitwise_And_returnsBitwiseAndResult() {
		assertEquals(bitwiseAndResult, dataCollector.calculateBitwise("1", firstString, secondString));
	}
	
	@Test
	public void calculateBitwise_Or_returnsBitwiseOrResult() {
		assertEquals(bitwiseOrResult, dataCollector.calculateBitwise("2", firstString, secondString));
	}
	
	@Test
	public void saveInformation_duplicateKeys_returnsValueFromDuplicate() {
		dataCollector.saveInformation(fullInputString);
		dataCollector.saveInformation(fullInputString);
		assertEquals("1", dataCollector.getDuplicates().get(0).getOperator());
		assertEquals(firstString, dataCollector.getDuplicates().get(0).getFirstString());
		assertEquals(secondString, dataCollector.getDuplicates().get(0).getSecondString());
		assertEquals(bitwiseAndResult, dataCollector.getDuplicates().get(0).getBitResult());
		assertEquals(1357, dataCollector.getDuplicates().get(0).getIntResult());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void checkOperators_operator3_throwsIllegalArgument() {
		String string = "03AC0F 3 110101000000110111001101 001000011110011101001111";
		dataCollector.saveInformation(string);
	}
}