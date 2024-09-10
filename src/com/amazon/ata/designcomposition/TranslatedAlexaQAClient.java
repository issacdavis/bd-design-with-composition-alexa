package com.amazon.ata.designcomposition;

public class TranslatedAlexaQAClient {

    private BestAnswerAlexaQAClient bestAnswerAlexaQAClient;
    private AlexaTranslator alexaTranslator;

    public TranslatedAlexaQAClient(BestAnswerAlexaQAClient bestAnswerAlexaQAClient, AlexaTranslator alexaTranslator) {
        this.bestAnswerAlexaQAClient = bestAnswerAlexaQAClient;
        this.alexaTranslator = alexaTranslator;
    }

    public String findBestAnswerAndTranslate(AlexaQuestion question) {
        return alexaTranslator.getTranslation(bestAnswerAlexaQAClient.findBestAnswer(question).getContent());
    }
}
