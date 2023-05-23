package com.pthongsavanh.service.rules;

import com.pthongsavanh.data.Receipt;

public interface RuleInterface {
	public int evaluate(Receipt receipt);
}
