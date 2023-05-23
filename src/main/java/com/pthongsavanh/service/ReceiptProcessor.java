package com.pthongsavanh.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pthongsavanh.data.EvaluationResults;
import com.pthongsavanh.data.Receipt;
import com.pthongsavanh.data.persistence.EvaluationResultsDataStore;
import com.pthongsavanh.service.rules.RuleInterface;

@Service
public class ReceiptProcessor {
	
	/**
	 * Spring collects our rule implementations for us
	 */
	@Autowired
	List<RuleInterface> rules;
	
	@Autowired
	EvaluationResultsDataStore evaluationResultsDataStore;
	
	public Receipt processReceipt(Receipt receipt) {
		UUID id = UUID.randomUUID(); // new receiptID
		
		int result = rules.stream()
				.map(r -> r.evaluate(receipt))
		  		.reduce(0, Integer::sum);
		
		evaluationResultsDataStore.storeResults(id, EvaluationResults.builder().points(result).build());
		
		return Receipt.builder().id(id).build();
	}
	
	public EvaluationResults getResults(UUID id) {
		return evaluationResultsDataStore.getResults(id);
	}
}
