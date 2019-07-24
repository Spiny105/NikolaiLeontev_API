import dto.SpellerDto;
import enums.Options;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.SpellerAssertions;
import service.SpellerSteps;

public class CorrectionWordTest {

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                {"sworde", "sword"},
                {"brohter", "brother"},
                {"Inglish", "English"},
                {"breadf", "bread"}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void chechWordTest(String input, String correctWord) {
        SpellerDto[] result = SpellerSteps.getCheckTextWithRequest(input, Options.NO_OPTIONS);
        SpellerAssertions.assertCorrectedTextInResponce(result, correctWord);
    }

}
