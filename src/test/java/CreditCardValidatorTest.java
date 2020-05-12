import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardValidatorTest {
    CreditCardValidator cut = new CreditCardValidator();

    @Test
    public void positiveTests() {
        assertTrue(cut.validate("4242424242424242"));
        assertTrue(cut.validate("4000056655665556"));
        assertTrue(cut.validate("5555555555554444"));
        assertTrue(cut.validate("5200828282828210"));
        assertTrue(cut.validate("5105105105105100"));
        assertTrue(cut.validate("378282246310005"));
        assertTrue(cut.validate("371449635398431"));
        assertTrue(cut.validate("6011111111111117"));
        assertTrue(cut.validate("6011000990139424"));
        assertTrue(cut.validate("6200000000000005"));
    }

    @Test
    public void wrongCharacters() {
        assertFalse(cut.validate("4242424242424asd"));
        assertFalse(cut.validate("!§$%&/()=?`´^#'*"));
    }

    @Test
    public void wrongLength() {
        assertFalse(cut.validate("799273987132"));
        assertFalse(cut.validate("79927398713646322"));
    }

    @Test
    public void wrongPrefix() {
        assertFalse(cut.validate("2223003122003222"));
        assertFalse(cut.validate("3056930009020004"));
        assertFalse(cut.validate("36227206271667"));
        assertFalse(cut.validate("3566002020360505"));
    }

    @Test
    public void failedLuhnTest() {
        assertFalse(cut.validate("4242424242424252"));
        assertFalse(cut.validate("4000056655665576"));
        assertFalse(cut.validate("5555555555554424"));
        assertFalse(cut.validate("5200828282833310"));
        assertFalse(cut.validate("5105105105115100"));
        assertFalse(cut.validate("378282246318005"));
        assertFalse(cut.validate("371449635392431"));
        assertFalse(cut.validate("6011111111191117"));
        assertFalse(cut.validate("6011000990129424"));
        assertFalse(cut.validate("6200000000010005"));
    }
}