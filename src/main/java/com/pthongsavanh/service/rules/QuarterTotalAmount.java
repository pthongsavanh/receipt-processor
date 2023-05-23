package com.pthongsavanh.service.rules;

import com.pthongsavanh.data.Receipt;

import io.micrometer.common.util.StringUtils;

/**
 * This rule assumes that the total price has been validated 
 * @author pthon
 *
 */
public class QuarterTotalAmount implements RuleInterface {

	@Override
	public int evaluate(Receipt receipt) {
		String totalPrice = receipt.getTotal();
		if (!StringUtils.isBlank(totalPrice)) {
			return totalPrice.endsWith(".00")|| totalPrice.endsWith(".25") || totalPrice.endsWith(".50") || totalPrice.endsWith(".75") ?
					25 : 0;
		}
		return 0;
	}
}
