package service;

import dto.SpellerDto;
import enums.ErrorCodes;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class SpellerAssertions {

    public static void assertCorrectedTextInResponce(SpellerDto[] result, String correctString) {

        if (result.length == 0) {
            fail("Corrected text not received from server");
        } else {
            assertTrue(result[0].getS().contains(correctString));
        }
    }

    public static void assertErrorCode(SpellerDto[] result, ErrorCodes expectedErrorCode) {

        if (result.length == 0) {
            fail("Corrected text not received from server");
        } else {
            assertEquals(result[0].getCode(), expectedErrorCode.getItem().intValue());
        }
    }

    public static void assertResponceWithCorrectTextInRequest(SpellerDto[] result){
        assertTrue(result.length == 0);
    }
}
