import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IntToBitParameterizedTest {
	private Utility utility;
	private int intToConvert;
	private String expectedBit;

	@Before
	public void setUp() {
		utility = new Utility();
	}

	@Parameterized.Parameters
	public static List<Object[]> data(){
		return Arrays.asList(new Object [][] {
				{6, "000000000000000000000110"},
				{454, "000000000000000111000110"},
				{341, "000000000000000101010101"},
				{2, "000000000000000000000010"},
				{9, "000000000000000000001001"},
				{15, "000000000000000000001111"}
		});
	}

	public IntToBitParameterizedTest(int intToConvert, String expectedBit) {
		this.intToConvert = intToConvert;
		this.expectedBit = expectedBit;
	}

	@Test
	public void IntToBit() {
		assertEquals(expectedBit, utility.intToBit(intToConvert));
	}
}