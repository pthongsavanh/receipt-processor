package com.pthongsavanh.service.rules;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.pthongsavanh.data.Receipt;

public class AlphaNumericRetailNameTest {
	@Test
	public void testAlphaNumericCharacterCount() {
		AlphaNumericRetailName testRule = new AlphaNumericRetailName();
		assertEquals(6, testRule.evaluate(Receipt.builder().retailer("Target").build()));
		assertEquals(6,testRule.evaluate(Receipt.builder().retailer("Tar--get").build()));
		assertEquals(6,testRule.evaluate(Receipt.builder().retailer("T.a.r--g.e.t").build()));
	}
}
