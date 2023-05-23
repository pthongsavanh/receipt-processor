package com.pthongsavanh.service.rules;

import org.springframework.stereotype.Component;

import com.pthongsavanh.data.Receipt;

import io.micrometer.common.util.StringUtils;

@Component
public class AlphaNumericRetailName implements RuleInterface {
	@Override
	public int evaluate(Receipt receipt) {
		int result = 0;
		
		if (StringUtils.isBlank(receipt.getRetailer())) {
			return result;
		}
		
		for(Character c : receipt.getRetailer().toCharArray()) {
			if (Character.isLetterOrDigit(c)) result++;
		}
		
		return result;
	}
}
