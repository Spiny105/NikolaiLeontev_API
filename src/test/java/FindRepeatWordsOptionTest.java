import dto.SpellerDto;
import enums.ErrorCodes;
import enums.Options;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.SpellerAssertions;
import service.SpellerSteps;

/*
 * Some tests are failing now. Maybe something is't working fine on speller.yandex.net?
 * */
public class FindRepeatWordsOptionTest {

    @DataProvider
    public Object[][] optionActiveDataProvider() {
        return new Object[][]{
                {"sworde sworde", ErrorCodes.ERROR_UNKNOWN_WORD},
                {"sword sword", ErrorCodes.ERROR_REPEAT_WORD},
                {"sworde", ErrorCodes.ERROR_UNKNOWN_WORD},
                {"bread bread", ErrorCodes.ERROR_REPEAT_WORD}
        };
    }

    @DataProvider
    public Object[][] optionInActiveDataProviderWithMistakes() {
        return new Object[][]{
                {"sworde sworde", ErrorCodes.ERROR_UNKNOWN_WORD},
                {"sworde", ErrorCodes.ERROR_UNKNOWN_WORD}
        };
    }

    @DataProvider
    public Object[] optionInActiveDataProviderNoMistakes() {
        return new Object[]{
                "sword sword",
                "bread bread"
        };
    }

    @Test(dataProvider = "optionActiveDataProvider")
    public void optionActiveTest(String input, ErrorCodes expectedErrorCode) {
        SpellerDto[] result = SpellerSteps.getCheckTextWithRequest(input, Options.FIND_REPEAT_WORDS);
        SpellerAssertions.assertErrorCode(result, expectedErrorCode);
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
