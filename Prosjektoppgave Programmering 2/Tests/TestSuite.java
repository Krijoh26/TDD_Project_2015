import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({UtilityTest.class, BitToIntParameterizedTest.class, HexToIntParameterizedTest.class, IntToBitParameterizedTest.class, IntToHexParameterizedTest.class})
public class TestSuite {
}