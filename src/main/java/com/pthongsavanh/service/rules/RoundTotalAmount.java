package com.pthongsavanh.service.rules;

import com.pthongsavanh.data.Receipt;

import io.micrometer.common.util.StringUtils;

/**
 * This rule assumes that the total price has been validated 
 * @author pthon
 *
 */
public class RoundTotalAmount implements RuleInterface {

	@Override
	public int evaluate(Receipt receipt) {
		String totalPrice = receipt.getTotal();
		if (!StringUtils.isBlank(totalPrice)) {
			return totalPrice.endsWith(".00")? 50 : 0;
		}
		return 0;
	}
}
