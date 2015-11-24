import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UtilityTest {
	
	private Utility utility;
	
	@Before
	public void setUp() {
		utility = new Utility();
	}

	@Test
	public void bitToInt_0_returns0() {
		assertEquals(0, utility.bitToInt("0"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void bitToInt_1010101010101010101010101_throwsIllegalArgument() {
		utility.bitToInt("1010101010101010101010101");
	}
	
	@Test
	public void bitToInt_emptyString_returns0() {
		assertEquals(0, utility.bitToInt(""));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void bitToInt_withNumber2_throwsIllegalArgument() {
		utility.bitToInt("2");
	}
	
	@Test
	public void bitToInt_110_returns6() {
		assertEquals(6, utility.bitToInt("0110"));
	}
	
	@Test
	public void bitToInt_101010101_returns341() {
		assertEquals(341, utility.bitToInt("101010101"));
	}
	
	@Test
	public void intToBit_13_returns000000000000000000001101() {
		assertEquals("000000000000000000000110", utility.intToBit(6));
	}
	
	@Test
	public void intToBit_341_returns000000000000000101010101() {
		assertEquals("000000000000000101010101", utility.intToBit(341));
	}
	
	@Test
	public void hexToInt_0_returns0() {
		assertEquals(0, utility.hexToInt("0"));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void hexToInt_1234567_throwsIllegalArgument() {
		utility.hexToInt("1234567");
	}
	
	@Test
	public void hexToInt_emptyString_returns0() {
		assertEquals(0, utility.hexToInt(""));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void hexToInt_12GM_throwsIllegalArgument() {
		utility.hexToInt("12GM");
	}
	
	@Test
	public void hexToInt_5A_returns90() {
		assertEquals(90, utility.hexToInt("5A"));
	}
	
	@Test
	public void hexToInt_93ACF2_returns9678066() {
		assertEquals(9678066, utility.hexToInt("93ACF2"));
	}
	
	@Test
	public void intToHex_90_returns00005A() {
		assertEquals("00005A", utility.intToHex(90));
	}
	
	@Test
	public void intToHex_9678066_returns93ACF2() {
		assertEquals("93ACF2", utility.intToHex(9678066));
	}
}