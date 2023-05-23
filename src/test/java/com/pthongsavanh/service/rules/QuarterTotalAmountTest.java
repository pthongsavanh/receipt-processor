package com.pthongsavanh.service.rules;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.pthongsavanh.data.Receipt;

public class QuarterTotalAmountTest {
	@Test
	public void testAlphaNumericCharacterCount() {
		QuarterTotalAmount testRule = new QuarterTotalAmount();
		assertEquals(25, testRule.evaluate(Receipt.builder().retailer("t").total("1.25").build()));
		assertEquals(0, testRule.evaluate(Receipt.builder().retailer("t").total("3261.11").build()));
		assertEquals(0, testRule.evaluate(Receipt.builder().retailer("t").total("9.99").build()));
		assertEquals(25, testRule.evaluate(Receipt.builder().retailer("t").total("1.00").build()));
		assertEquals(25, testRule.evaluate(Receipt.builder().retailer("t").total("1.50").build()));
		assertEquals(25, testRule.evaluate(Receipt.builder().retailer("t").total("8.75").build()));
	}
}
