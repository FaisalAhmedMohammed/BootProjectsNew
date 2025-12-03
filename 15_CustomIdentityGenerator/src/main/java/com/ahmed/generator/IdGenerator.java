package com.ahmed.generator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
/* •	If the pre-defined id generators of JPA are not suitable for your 
 * application’s requirement then you can create a custom ID Generator and
 *  you can use it to generate the primary key values for the entity class objects.
   
 
•	The below are the steps to use a Custom ID Generator in application.

1. Create a class by implementing IdentifierGenerator interface, define the custom logic.
2. Use @GenericGenerator to integrate it with JPA.
3. Use @GeneratedValue, to add this custom strategy to the primary key.

EX:
The IdGenerator creates a 4-digit random number by generating four random digits (0–9),
 concatenating them into a string, converting that string into a Long, and returning it as the ID.
*/
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IdGenerator implements IdentifierGenerator {

	private static Set<Long> generatedIds = new HashSet<>();
	public static final Random random = new Random();

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {

		Long value;

		while (true) {
			int l1 = new Random().nextInt(10);
			int l2 = new Random().nextInt(10);
			int l3 = new Random().nextInt(10);
			int l4 = new Random().nextInt(10);

			String str = l1 + "" + l2 + "" + l3 + "" + l4;
			value = Long.parseLong(str);

			if (!generatedIds.contains(value)) {
				generatedIds.add(value);
				break;

			}

			/*
			 * 1. if (!generatedIds.contains(value)) {
			 * 
			 * 👉 "Check if this number is NOT already present in the HashSet."
			 * 
			 * generatedIds = list of all numbers we already used
			 * 
			 * contains(value) = check if this number exists
			 * 
			 * ! means "NOT"
			 * 
			 * So the line means:
			 * 
			 * 🔹 If the newly generated ID is not already used…
			 */

		}
		return value;

	}

}
