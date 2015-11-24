import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BitToIntParameterizedTest {
	private Utility utility;
	private int expectedInteger;
	private String bitString;
	
	@Before
	public void setUp() {
		utility = new Utility();
	}

	@Parameterized.Parameters
	public static List<Object[]> data(){
		return Arrays.asList(new Object [][] {
				{"110", 6},
				{"111000110", 454},
				{"101010101", 341},
				{"00000010", 2},
				{"1001", 9},
				{"1111", 15}
		});
	}
	
	public BitToIntParameterizedTest(String bitString, int expectedInteger) {
		this.bitString = bitString;
		this.expectedInteger = expectedInteger;
	}

	@Test
	public void bitToInt() {
		assertEquals(expectedInteger, utility.bitToInt(bitString));
	}
}