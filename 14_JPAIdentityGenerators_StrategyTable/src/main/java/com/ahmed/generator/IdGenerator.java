package com.ahmed.generator;

import java.util.Random;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IdGenerator implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {

		int l1 = new Random().nextInt(10);
		int l2 = new Random().nextInt(10);
		int l3 = new Random().nextInt(10);
		int l4 = new Random().nextInt(10);

		String str = l1 + "" + l2 + "" + l3 + "" + l4;
		Long value = Long.parseLong(str);

		return value;
	}

}
