# Design with Composition

### Introduction

Alexa is Amazon's cloud-based voice service available on millions of devices. It is used for many different things such
as question answering, translation, task scheduling, playing music etc. In this activity we will focus on the question
answering functionality provided by Alexa. This functionality allows you to get factual answers to many different
questions e.g. "Alexa, what is the weather like outside?" or "Alexa, what is the tallest mountain?". While the actual
process involves many steps and queries a knowledge base built from multiple sources, this exercise will use a
predefined set of answers.

### Scenario: Using Alexa question answering client.

Our Alexa question answering interface is defined in the `AlexaQA` interface. Take a look at the methods defined in that
interface, and at the related `AlexaQuestion` and `AlexaAnswer` classes. 

The `AlexaQA` interface defines the method `findAnswers` that allows us to retrieve all possible answers for the given
question. It also contains a method `submitQuestionAnswerSuggestion` that allows us to submit an answer proposal for a
given question. `AlexaQuestion` and `AlexaAnswer` classes contain the data relevant for questions and answers in our
model.

Finally, `AlexaQAClient` is the implementation of the `AlexaQA` interface. As mentioned, this implementation has a
finite number of predefined answers and those will be provided back regardless of the question. These are answers that
can be used when Alexa doesn't have a good answer for a question. Suggested questions and
answers are stored in the instance but are not processed in any other way.

### Try (10 min) - Expose a subset of functionality from a contained class

The first thing we will look at is reducing the functionality provided by the `AlexaQAClient`. We want to have a version
of that client that doesn't allow submission of question/answer suggestions. This helps us prevent an undesired answer
entering the system in the first place, which saves us from having to clean up the knowledge base. An attempt to
implement this client with reduced functionality has been made in `ReadOnlyAlexaQAClient`.

Do you agree with this approach? What happens in the code consuming `ReadOnlyAlexaQAClient` if a change is made to
`AlexaQAClient` methods? If the `AlexaQAClient` adds a new write method, `ReadOnlyAlexaQAClient` will inherit it and
provide write access to its consumers. We can avoid this situation with composition. What happens if someone starts to
use this class thinking it actually stores the suggestions? This expectation will probably lead them to incorrectly
depending on the functionality that isn't there. Is there a better way to implement this functionality? The answer is
yes and that's where composition comes to play.

Make the necessary changes to the `ReadOnlyAlexaQAClient` to make it better for its consumers. Once you have implemented
the functionality run the `ReadOnlyAlexaQAClientTest` through Intellij to verify your solution. You will need to
uncomment the tests that are currently commented out to prevent compilation errors. You're not expected to write any new
tests.

### Try (15 min) - Expose a superset of functionality from a contained class

The functionality provided by the `AlexaQAClient` allows us to find answers to our questions and to add desired
suggestions but there are two additional methods that we would like to add which would save us some time. Those methods
are:

* `AlexaAnswer findBestAnswer(AlexaQuestion question)` - finds the best answer for a given question based on the answer
  quality.
* `void submitQuestionAnswerSuggestions(AlexaQuestion question, List<AlexaAnswer> answers)` - allows submission of
  multiple answers for a single question.
  
You can now go ahead and implement this functionality in a new class called `BestAnswerAlexaQAClient`. Once you have
implemented the functionality run the `BestAnswerAlexaQAClientTest` through Intellij to verify your solution. You will 
need to uncomment the tests that are currently commented out to prevent compilation errors. You're not expected to write
any new tests.

## Try (10 min) - Expose a contract that differs from the contract defined in the contained class

The last thing we will look into is related to transformation of the data provided by the Alexa question answering
service. Before we dive into the problem in this try, lets take a look at the `AlexaTranslator` class. You can see that
the class provides a single method to retrieve a translation for a given answer (for every answer provided in the
`AlexaQAClient` class).

In this Try we want to add a functionality that will return a translation for the best answer to the given question.
Additionally we don't care about any of the `AlexaAnswer` data apart from the actual content. So the method that we will
implement in the new class called `TranslatedAlexaQAClient` is:

* `String findBestAnswerAndTranslate(AlexaQuestion question)`

Which class should you use as a dependency in this case? You can assume that the consumers of the
`TranslatedAlexaQAClient` will be using the method `findBestAnswerAndTranslate` exclusively.

Implement the `TranslatedAlexaQAClient` class and run the `TranslatedAlexaQAClientTest` through Intellij. You will need
to uncomment the tests that are currently commented out to prevent compilation errors.

Finally, run the `./gradlew -q clean test` command from your workspace. If everything passes, your job
here is done!
