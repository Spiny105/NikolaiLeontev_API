import dto.SpellerDto;
import enums.Options;
import org.testng.annotations.Test;
import service.SpellerAssertions;
import service.SpellerSteps;

import java.util.Arrays;
import java.util.List;

public class SimpleTextsTest {

    @Test
    public void checkTextsCorrecton() {

        List<String> texts = Arrays.asList("Inglish", "Brohter");
        SpellerDto[][] result = SpellerSteps.getCheckTextsWithRequest(texts, Options.NO_OPTIONS);

        SpellerAssertions.assertCorrectedTextInResponce(result[0], "English");
        SpellerAssertions.assertCorrectedTextInResponce(result[1], "Brother");
    }

}





