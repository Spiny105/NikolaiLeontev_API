import enums.Options;
import org.testng.annotations.Test;
import service.SpellerService;

public class ConnectionTest {

    @Test
    void ConnectionTest() {

        SpellerService.checkText("lilt", Options.NO_OPTIONS)
                .then()
                .statusCode(200);
        ;

    }

}
