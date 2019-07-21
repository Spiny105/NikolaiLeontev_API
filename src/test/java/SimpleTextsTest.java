import dto.SpellerDto;
import enums.Options;
import org.testng.annotations.Test;
import service.SpellerAssertions;
import service.SpellerSteps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SimpleTextsTest {

    @Test
    public void checkTextsCorrecton() {

        List<String> texts = Arrays.asList("Inglish", "Brohter");
        SpellerDto[][] result = SpellerSteps.getCheckTextsWithRequest(texts, Options.NO_OPTIONS);

        SpellerAssertions.assertText(result[0], "English");
        SpellerAssertions.assertText(result[1], "Brother");
    }

}





