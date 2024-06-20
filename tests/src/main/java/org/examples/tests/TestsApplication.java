package org.examples.tests;

import org.apache.commons.text.WordUtils;
import org.examples.collections.MoveProtonsNeutrons;
import org.examples.stream.CapitalizeWords;
import org.examples.stream.ReturnHighestValue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestsApplication {

	public static void main(String[] args) {

		SpringApplication.run(TestsApplication.class, args);

		CapitalizeWords capitalizeWords = new CapitalizeWords();

		String str = "logs the key, value, topic, partition, and offset of each consumed message.";
		System.out.println(capitalizeWords.capitalizeWords1("1. " + str));
		System.out.println(capitalizeWords.capitalizeWords2("2. " + str));
		System.out.println(WordUtils.capitalize("3. " + str));

		// ****************************
		MoveProtonsNeutrons moveProtonsNeutrons = new MoveProtonsNeutrons();

		System.out.println("Solve = " + moveProtonsNeutrons.solve(3, 4, 5, 2));

		// ****************************
		ReturnHighestValue returnHighestValue = new ReturnHighestValue();

		System.out.println("1.a Index With Higher Value (10, 20, 15) = " + returnHighestValue.getIndexWithHigherValue(10, 20, 15));
		System.out.println("1.b Index With Higher Value (11, 12, 15) = " + returnHighestValue.getIndexWithHigherValue(11, 12, 15));
		System.out.println("1.c Index With Higher Value (7, 5, 3 )   = " + returnHighestValue.getIndexWithHigherValue(11, 12, 15));
		System.out.println("2.a Index With Higher Value (10, 20, 15) = " + returnHighestValue.getIndexWithHigherValue1(10, 20, 15));
		System.out.println("2.b Index With Higher Value (11, 12, 15) = " + returnHighestValue.getIndexWithHigherValue1(11, 12, 15));
		System.out.println("2.c Index With Higher Value (7, 5, 3 )   = " + returnHighestValue.getIndexWithHigherValue1(11, 12, 15));


	}

}
