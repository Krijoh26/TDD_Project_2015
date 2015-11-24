import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IntToHexParameterizedTest {
	private Utility utility;
	private int intToConvert;
	private String expectedHex;

	@Before
	public void setUp() {
		utility = new Utility();
	}

	@Parameterized.Parameters
	public static List<Object[]> data(){
		return Arrays.asList(new Object [][] {
				{44403, "00AD73"},
				{2317551, "235CEF"},
				{214314, "03452A"},
				{90, "00005A"},
				{2748, "000ABC"},
				{847, "00034F"}
		});
	}

	public IntToHexParameterizedTest(int intToConvert, String expectedHex) {
		this.intToConvert = intToConvert;
		this.expectedHex = expectedHex;
	}

	@Test
	public void IntToBit() {
		assertEquals(expectedHex, utility.intToHex(intToConvert));
	}
}