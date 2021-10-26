package com.amazon.ata.designcomposition;

public class ReadOnlyAlexaQAClient extends AlexaQAClient {
    @Override
    public void submitQuestionAnswerSuggestion(AlexaQuestion question, AlexaAnswer answer) {
        // Do nothing
    }
}
