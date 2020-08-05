package org.ansel.springmongo.utils;

import java.time.LocalDateTime;
import java.util.UUID;
import org.ansel.springmongo.model.QuizQuestion;
import org.ansel.springmongo.model.SimpleQuestion;

public class QuestionUtils {

    public static QuizQuestion generateRandomQuestion() {
        QuizQuestion question = QuizQuestion.builder().status("Ready")
            .questionAlias(UUID.randomUUID().toString())
            .question(generateSimplePlusQuestion().getQuestion())
            .questionDescription("").type("Multiple Choice").createAt(LocalDateTime.now())
            .lastUpdateAt(LocalDateTime.now())
            .build();

        return null;
    }

    private static SimpleQuestion generateSimplePlusQuestion() {
        double a = (Math.random() * 999 + 1) + 1;
        double b = (Math.random() * 999 + 1) + 1;
        String question =
            "What is the answer of number " + String.format("%.3f", a) + " + " + String
                .format("%.3f", b) + " ?";
        String answer = String.format("%.3f", a + b);
        return SimpleQuestion.builder().question(question).answer(answer).build();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(generateSimplePlusQuestion());
        }
    }
}
