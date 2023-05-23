package com.pthongsavanh.data.persistence;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.pthongsavanh.data.EvaluationResults;

/**
 * Data storage functions are encapsulated in this class so that we
 * can swap out the implementation in the future if needed. This implemenation
 * simply uses an in-memory HashMap (Dictionary) to store the data.
 * @author pthon
 *
 */
@Service
public class EvaluationResultsDataStore {
	
	/**
	 * In-memory map of results by ID
	 */
	private HashMap<UUID, EvaluationResults> inMemoryStore = new HashMap<>();
	
	public EvaluationResults storeResults(UUID id, EvaluationResults results) {
		inMemoryStore.put(id, results);
		return results;
	}
	
	public EvaluationResults getResults(UUID id) {
		return inMemoryStore.get(id);
	}
}
