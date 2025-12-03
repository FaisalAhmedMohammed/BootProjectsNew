package com.ahmed.generator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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
