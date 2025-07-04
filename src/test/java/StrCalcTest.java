import com.stringcalctdd.StrCalc;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

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
    @Test
    public void testCustomDelimiter() {
        StrCalc calculator = new StrCalc();
        int result = calculator.add("//;\n1;2");
        assertEquals(3, result);
    }
    @Test
    public void testCustomDelimiterWithSpaces() {
        StrCalc calculator = new StrCalc();
        int result = calculator.add("//;\n10;20");
        assertEquals(30, result);
    }

    @Test
    public void testCustomDelimiterWithSingleNumber() {
        StrCalc calculator = new StrCalc();
        int result = calculator.add("//#\n5");
        assertEquals(5, result);
    }

    @Test
    public void testCustomDelimiterMixedWithInvalid() {
        StrCalc calculator = new StrCalc();
        int result = calculator.add("//:\n1:2:3");
        assertEquals(6, result);
    }
    @Test
    public void testNegativeNumbers() {
        StrCalc calculator = new StrCalc();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3,-4");
        });

        assertTrue(exception.getMessage().contains("Negatives not allowed: [-2, -4]"));
    }


}
