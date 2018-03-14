package com.ru.usty.scheduling;

import java.util.HashMap;
import java.util.Map;

public class ProcessData {
	
	int processID;
	Map<Integer, Long> startTime;
	Map<Integer, Long> responseTime;
	Map<Integer, Long> finishTime;
	
	public ProcessData(int processID) {
		this.processID = processID;
		
		this.startTime = new HashMap<Integer, Long>();
		this.responseTime = new HashMap<Integer, Long>();
		this.finishTime = new HashMap<Integer, Long>();
	}
	
	public void ResponseTimeAdded(Integer processID, Long time) {
		if(!responseTime.containsKey(processID)) {
			responseTime.put(processID, time);
		}
	}
}


