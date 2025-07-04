import com.stringcalctdd.StrCalc;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StrCalcTest {

    @Test
    public void testEmptyString() {
        StrCalc calculator = new StrCalc();
        int result = calculator.add("");
        assertEquals(0, result);
    }

    @Test
    public void testNonEmptyString() {
        StrCalc calculator = new StrCalc();
        int result = calculator.add("3,5");
        assertEquals(8, result);
    }
    @Test
    public void testNewLineDelimiter() {
        StrCalc calculator = new StrCalc();
        int result = calculator.add("1\n2,3");
        assertEquals(6, result);
    }


}
