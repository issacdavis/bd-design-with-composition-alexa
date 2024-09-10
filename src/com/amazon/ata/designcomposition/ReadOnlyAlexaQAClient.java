package com.amazon.ata.designcomposition;

import java.util.ArrayList;
import java.util.List;

public class ReadOnlyAlexaQAClient {
    private final AlexaQAClient alexaQAClient;

    public ReadOnlyAlexaQAClient(AlexaQAClient alexaQAClient) {
        this.alexaQAClient = alexaQAClient;
    }

    public List<AlexaAnswer> findAnswers(AlexaQuestion question) {
        return alexaQAClient.findAnswers(question);
    }

    void submitQuestionAnswerSuggestion(AlexaQuestion question, AlexaAnswer answer) {
        // Do nothing
    }
}
