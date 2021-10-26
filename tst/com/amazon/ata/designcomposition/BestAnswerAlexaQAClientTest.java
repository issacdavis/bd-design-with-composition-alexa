package com.amazon.ata.designcomposition;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class BestAnswerAlexaQAClientTest {

    // Introspective tests - YOU ARE NOT EXPECTED TO UNDERSTAND OR TOUCH THESE TESTS
    // AT THIS POINT, BUT THE OUTPUT PRODUCED WHEN RUNNING THESE TESTS CAN BE HELPFUL
    // TO UNDERSTAND IF THERE ARE ISSUES IN YOUR CODE.

    @Test
    public void introspection_bestAnswerAlexaQAClient_hasConstructorWithClient() {
        // GIVEN
        Class<?> bestAnswerAlexaQAClientClass = getClassForName(
                "com.amazon.ata.designcomposition.prework.BestAnswerAlexaQAClient");

        // WHEN
        Constructor<?> findBestAnswerMethod = null;
        try {
            findBestAnswerMethod = bestAnswerAlexaQAClientClass.getDeclaredConstructor(AlexaQA.class);
        } catch (NoSuchMethodException e) {
            try {
                findBestAnswerMethod = bestAnswerAlexaQAClientClass.getDeclaredConstructor(AlexaQAClient.class);
            } catch (NoSuchMethodException ex) {
                fail("Expected BestAnswerAlexaQAClient to have a constructor that accepts an AlexaQA object as its " +
                        "parameter. This is our best practice for composition. You'll learn more in mocking.");
            }
        }
    }

    @Test
    public void introspection_bestAnswerAlexaQAClient_hasFindBestAnswerMethod() {
        // GIVEN
        Class<?> bestAnswerAlexaQAClientClass = getClassForName(
            "com.amazon.ata.designcomposition.prework.BestAnswerAlexaQAClient");

        // WHEN
        Method findBestAnswerMethod = null;
        try {
            findBestAnswerMethod = bestAnswerAlexaQAClientClass.getDeclaredMethod(
                "findBestAnswer", AlexaQuestion.class);
        } catch (NoSuchMethodException e) {
            fail("Expected findBestAnswer method to exist in the BestAnswerAlexaQAClient class!");
        }

        // THEN
        Class<?> returnType = findBestAnswerMethod.getReturnType();
        assertTrue(returnType == AlexaAnswer.class,
            "Expected BestAnswerAlexaQAClient findBestAnswer method to have AlexaAnswer as return type!");
    }

    @Test
    public void introspection_bestAnswerAlexaQAClient_hasSubmitQuestionAnswerSuggestions() {
        // GIVEN
        Class<?> bestAnswerAlexaQAClientClass = getClassForName(
            "com.amazon.ata.designcomposition.prework.BestAnswerAlexaQAClient");

        // WHEN
        Method submitQuestionAnswerSuggestionsMethod = null;
        try {
            submitQuestionAnswerSuggestionsMethod = bestAnswerAlexaQAClientClass.getDeclaredMethod(
                "submitQuestionAnswerSuggestions", AlexaQuestion.class, List.class);
        } catch (NoSuchMethodException e) {
            fail("Expected submitQuestionAnswerSuggestions method to exist in the BestAnswerAlexaQAClient class!");
        }

        // THEN
        Class<?> returnType = submitQuestionAnswerSuggestionsMethod.getReturnType();
        assertTrue(returnType == void.class,
            "Expected BestAnswerAlexaQAClient submitQuestionAnswerSuggestions method to have void return type!");
    }

    @Test
    public void introspection_readOnlyAlexaQAClient_isNotAlexaQAClient() {
        // GIVEN
        Class<?> bestAnswerAlexaQAClientClass = getClassForName(
            "com.amazon.ata.designcomposition.prework.BestAnswerAlexaQAClient");

        // WHEN
        boolean isAlexaQAClient = AlexaQAClient.class.isAssignableFrom(bestAnswerAlexaQAClientClass);

        // THEN
        assertFalse(isAlexaQAClient, "Expected BestAnswerAlexaQAClient to not implement AlexaQAClient!");
    }

    private static Class<?> getClassForName(String fullyQualifiedClassName) {
        Class<?> classToReturn = null;
        try {
            classToReturn = Class.forName(fullyQualifiedClassName);
        } catch (ClassNotFoundException e) {
            fail("Expected " + fullyQualifiedClassName + " to exist in the project!");
        }
        return classToReturn;
    }

    // Actual test, uncomment after implementation of BestAnswerAlexaQAClient is done

//    @Test
//    public void findBestAnswer_anyQuestion_expectedAnswer() {
//        // GIVEN
//    AlexaQA alexaQa = new AlexaQAClient();
//        BestAnswerAlexaQAClient client = new BestAnswerAlexaQAClient(alexaQa);
//
//        // WHEN
//        AlexaAnswer answer = client.findBestAnswer(new AlexaQuestion("random question", 1L));
//
//        // THEN
//        assertEquals(0.18, answer.getAnswerQuality());
//        assertEquals("May the Force be with you.", answer.getContent());
//    }
}
