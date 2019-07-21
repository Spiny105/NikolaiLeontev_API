package service;

import com.google.gson.Gson;
import dto.SpellerDto;
import enums.Options;

import java.util.List;

public class SpellerSteps {

    public static SpellerDto[] getCheckTextWithRequest(String textToCheck, Options option) {

        String response = SpellerService
                .checkText(textToCheck, option)
                .getBody().asString();

        return new Gson().fromJson(response, SpellerDto[].class);
    }

    public static SpellerDto[][] getCheckTextsWithRequest(List<String> textsToCheck, Options option) {

        String response = SpellerService
                .checkTexts(textsToCheck, option)
                .getBody().asString();

        return new Gson().fromJson(response, SpellerDto[][].class);
    }
}
