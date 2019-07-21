package service;

import enums.Options;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

public class SpellerService {

    private static RequestSpecification requestSpecification;

    static {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(SpellerParams.getSpellerJsonInterfaceString())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter()).build();
    }

    public static Response checkText(String text) {
        return checkText(text, Options.NO_OPTIONS);
    }

    public static Response checkText(String text, Options options) {
        return RestAssured.given(requestSpecification)
                .param("text", text)
                .param("options", options.getItem())
                .get(SpellerParams.CHECK_TEXT_URI);
    }

    public static Response checkTexts(List<String> text, Options options) {

        return RestAssured.given(requestSpecification)
                .param("text", text)
                .param("options", options.getItem())
                .get(SpellerParams.CHECK_TEXTS_URI);
    }

}
