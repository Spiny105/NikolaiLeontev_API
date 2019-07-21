package service;

import dto.SpellerDto;
import enums.ErrorCodes;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SpellerAssertions {

    public static void assertText(SpellerDto[] result, String correctString) {

        if (correctString == null) {
            assertTrue(result.length == 0);
        } else {
            assertTrue(result[0].getS().contains(correctString));
        }
    }

    public static void assertErrorCode(SpellerDto[] result, ErrorCodes expectedErrorCode) {

        if (expectedErrorCode == null) {
            assertTrue(result.length == 0);
        } else {
            assertEquals(result[0].getCode(), expectedErrorCode.getItem().intValue());
        }

    }

}
