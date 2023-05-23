package com.pthongsavanh.service.rules;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.pthongsavanh.data.Receipt;

public class RoundTotalAmountTest {
	@Test
	public void testAlphaNumericCharacterCount() {
		RoundTotalAmount testRule = new RoundTotalAmount();
		assertEquals(0, testRule.evaluate(Receipt.builder().retailer("t").total("1.25").build()));
		assertEquals(0, testRule.evaluate(Receipt.builder().retailer("t").total("3261.11").build()));
		assertEquals(50, testRule.evaluate(Receipt.builder().retailer("t").total("1.00").build()));
	}
}
