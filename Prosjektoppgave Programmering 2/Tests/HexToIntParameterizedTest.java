import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class HexToIntParameterizedTest {
	private Utility utility;
	private int expectedInteger;
	private String hexString;
	
	@Before
	public void setUp() {
		utility = new Utility();
	}

	@Parameterized.Parameters
	public static List<Object[]> data(){
		return Arrays.asList(new Object [][] {
				{"AD73", 44403},
				{"235CEF", 2317551},
				{"3452A", 214314},
				{"5A", 90},
				{"ABC", 2748},
				{"34F", 847}
		});
	}
	
	public HexToIntParameterizedTest(String hexString, int expectedInteger) {
		this.hexString = hexString;
		this.expectedInteger = expectedInteger;
	}

	@Test
	public void hexToInt() {
		assertEquals(expectedInteger, utility.hexToInt(hexString));
	}
}