package org.ansel.springmongo.utils;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import org.ansel.springmongo.model.McqDetail;
import org.ansel.springmongo.model.Option;
import org.ansel.springmongo.model.QuizQuestion;
import org.ansel.springmongo.model.SimpleQuestion;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class QuestionUtils {

	private static int sequenceNumber = 1;

	public static QuizQuestion generateRandomQuestion() {

		SimpleQuestion simpleQuestion = generateSimplePlusQuestion();

		Set<Option> options = generateOptionsWithRightAnswer(simpleQuestion.getAnswer());

		QuizQuestion question = QuizQuestion.builder().status("Ready").questionAlias("Random" + sequenceNumber++)
				.question(simpleQuestion.getQuestion()).questionDescription("").type("Multiple Choice")
				.mcqDetail(McqDetail.builder().option(Lists.newArrayList(options)).build())
				.createAt(LocalDateTime.now()).lastUpdateAt(LocalDateTime.now()).build();

		return question;
	}

	private static Set<Option> generateOptionsWithRightAnswer(String answer) {
		Set<Option> result = Sets.newHashSet();
		result.add(Option.builder().isAnswer(true).status("Ready").text(answer).build());
		for (int i = 0; i < 4; i++) {
			String randomAnswer = generateRandomWrongAnswer(answer);
			result.add(Option.builder().isAnswer(false).status("Ready").text(randomAnswer).build());

		}
		return result;
	}

	private static String generateRandomWrongAnswer(String answer) {
		String a = String.format("%.3f", (Math.random() * 999 + 1) + 1);
		while (answer.equals(a)) {
			a = String.format("%.3f", (Math.random() * 999 + 1) + 1);
		}
		return a;
	}

	private static SimpleQuestion generateSimplePlusQuestion() {
		double a = (Math.random() * 999 + 1) + 1;
		double b = (Math.random() * 999 + 1) + 1;
		String question = "What is the answer of number " + String.format("%.3f", a) + " + " + String.format("%.3f", b)
				+ " ?";
		String answer = String.format("%.3f", a + b);
		return SimpleQuestion.builder().question(question).answer(answer).build();
	}

	public static void main(String[] args) {
		for (int i=0; i<100; i++) {
			System.out.println(generateRandomQuestion().toString());
		}
	}
}
