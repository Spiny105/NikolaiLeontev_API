import dto.SpellerDto;
import enums.ErrorCodes;
import enums.Options;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.SpellerAssertions;
import service.SpellerSteps;

public class IgnoreDigitsOptionTest {

    @DataProvider
    public Object[][] optionActiveDataProvider() {
        return new Object[][]{
                {"sworde12", null},
                {"sworde", ErrorCodes.ERROR_UNKNOWN_WORD},
                {"breaa", ErrorCodes.ERROR_UNKNOWN_WORD},
                {"132bread", null}
        };
    }

    @DataProvider
    public Object[][] optionInActiveDataProvider() {
        return new Object[][]{
                {"sword12", ErrorCodes.ERROR_UNKNOWN_WORD},
                {"sworde", ErrorCodes.ERROR_UNKNOWN_WORD},
                {"breaa", ErrorCodes.ERROR_UNKNOWN_WORD},
                {"132bread", ErrorCodes.ERROR_UNKNOWN_WORD},
                {"sword", null}
        };
    }

    @Test(dataProvider = "optionActiveDataProvider")
    public void optionActiveTest(String input, ErrorCodes expectedErrorCode) {
        SpellerDto[] result = SpellerSteps.getCheckTextWithRequest(input, Options.IGNORE_DIGITS);
        SpellerAssertions.assertErrorCode(result, expectedErrorCode);
    }

    @Test(dataProvider = "optionInActiveDataProvider")
    public void optionInActiveTest(String input, ErrorCodes expectedErrorCode) {
        SpellerDto[] result = SpellerSteps.getCheckTextWithRequest(input, Options.NO_OPTIONS);
        SpellerAssertions.assertErrorCode(result, expectedErrorCode);
    }

}
