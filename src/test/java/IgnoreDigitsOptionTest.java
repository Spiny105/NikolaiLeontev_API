import dto.SpellerDto;
import enums.ErrorCodes;
import enums.Options;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.SpellerAssertions;
import service.SpellerSteps;

public class IgnoreDigitsOptionTest {

    @DataProvider
    public Object[][] optionActiveDataProviderWithMistakes() {
        return new Object[][]{
                {"sworde", ErrorCodes.ERROR_UNKNOWN_WORD},
                {"breaa", ErrorCodes.ERROR_UNKNOWN_WORD}
        };
    }

    @DataProvider
    public Object[] optionActiveDataProviderNoMistakes() {
        return new Object[]{
                "sworde12",
                "132bread"
        };
    }

    @DataProvider
    public Object[][] optionInActiveDataProviderWithMistakes() {
        return new Object[][]{
                {"sword12", ErrorCodes.ERROR_UNKNOWN_WORD},
                {"sworde", ErrorCodes.ERROR_UNKNOWN_WORD},
                {"breaa", ErrorCodes.ERROR_UNKNOWN_WORD},
                {"132bread", ErrorCodes.ERROR_UNKNOWN_WORD}
        };
    }

    @DataProvider
    public Object[] optionInActiveDataProviderNoMistakes() {
        return new Object[]{
                "bread",
                "sword"
        };
    }

    @Test(dataProvider = "optionActiveDataProviderWithMistakes")
    public void optionActiveTest(String input, ErrorCodes expectedErrorCode) {
        SpellerDto[] result = SpellerSteps.getCheckTextWithRequest(input, Options.IGNORE_DIGITS);
        SpellerAssertions.assertErrorCode(result, expectedErrorCode);
    }

    @Test(dataProvider = "optionInActiveDataProviderNoMistakes")
    public void optionActiveTest(String input) {
        SpellerDto[] result = SpellerSteps.getCheckTextWithRequest(input, Options.IGNORE_DIGITS);
        SpellerAssertions.assertResponceWithCorrectTextInRequest(result);
    }

    @Test(dataProvider = "optionInActiveDataProviderWithMistakes")
    public void optionInActiveTest(String input, ErrorCodes expectedErrorCode) {
        SpellerDto[] result = SpellerSteps.getCheckTextWithRequest(input, Options.NO_OPTIONS);
        SpellerAssertions.assertErrorCode(result, expectedErrorCode);
    }

    @Test(dataProvider = "optionInActiveDataProviderNoMistakes")
    public void optionInActiveTest(String input) {
        SpellerDto[] result = SpellerSteps.getCheckTextWithRequest(input, Options.NO_OPTIONS);
        SpellerAssertions.assertResponceWithCorrectTextInRequest(result);
    }

}
