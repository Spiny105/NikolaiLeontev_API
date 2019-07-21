import dto.SpellerDto;
import enums.ErrorCodes;
import enums.Options;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.SpellerAssertions;
import service.SpellerSteps;

/*
 * Some tests are falling now. Maybe something is't working fine on speller.yandex.net?
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
    public Object[][] optionInActiveDataProvider() {
        return new Object[][]{
                {"sworde sworde", ErrorCodes.ERROR_UNKNOWN_WORD},
                {"sword sword", null},
                {"sworde", ErrorCodes.ERROR_UNKNOWN_WORD},
                {"bread bread", null}
        };
    }

    @Test(dataProvider = "optionActiveDataProvider")
    public void optionActiveTest(String input, ErrorCodes expectedErrorCode) {
        SpellerDto[] result = SpellerSteps.getCheckTextWithRequest(input, Options.FIND_REPEAT_WORDS);
        SpellerAssertions.assertErrorCode(result, expectedErrorCode);
    }

    @Test(dataProvider = "optionInActiveDataProvider")
    public void optionInActiveTest(String input, ErrorCodes expectedErrorCode) {
        SpellerDto[] result = SpellerSteps.getCheckTextWithRequest(input, Options.NO_OPTIONS);
        SpellerAssertions.assertErrorCode(result, expectedErrorCode);
    }

}
