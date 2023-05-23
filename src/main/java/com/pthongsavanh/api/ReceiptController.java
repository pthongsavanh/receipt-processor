package com.pthongsavanh.api;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pthongsavanh.data.EvaluationResults;
import com.pthongsavanh.data.Receipt;
import com.pthongsavanh.service.ReceiptProcessor;

@RestController
public class ReceiptController {

	@Autowired
	ReceiptProcessor receiptProcessor;
	
	@PostMapping("/receipts/process")
    public ResponseEntity<Receipt> processReceipt(@RequestBody Receipt receipt) {
		Receipt processed = receiptProcessor.processReceipt(receipt);
        return ResponseEntity.ok().body(processed);
	}
	
	@GetMapping("/receipts/{id}/points")
    public ResponseEntity<EvaluationResults> getPoints(@PathVariable UUID id) {
		EvaluationResults points = receiptProcessor.getResults(id);
		
		if (points != null) {
			return ResponseEntity.ok().body(points);
		} else {
	        return ResponseEntity.notFound().build();	
		}
    }
}
