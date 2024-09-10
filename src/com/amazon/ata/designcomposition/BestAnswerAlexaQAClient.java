package com.amazon.ata.designcomposition;

import java.util.ArrayList;
import java.util.List;

public class BestAnswerAlexaQAClient {
    private AlexaQA alexaQA;

    public BestAnswerAlexaQAClient(AlexaQA alexaQA) {
        this.alexaQA = alexaQA;
    }

    public AlexaAnswer findBestAnswer(AlexaQuestion question) {
        AlexaAnswer maxAnswer = new AlexaAnswer("", 0);
        for (AlexaAnswer answer : alexaQA.findAnswers(question)) {
            if (answer.getAnswerQuality() > maxAnswer.getAnswerQuality()) {
                maxAnswer = answer;
            }
        }
        return maxAnswer;
    }

    void submitQuestionAnswerSuggestions(AlexaQuestion question, List<AlexaAnswer> answers) {

    }
}
