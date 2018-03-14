package com.ru.usty.scheduling;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.ru.usty.scheduling.process.ProcessExecution;

public class Scheduler {
	
	ProcessExecution processExecution;
	Policy policy;
	int quantum;
	
	Queue<Integer> processQueue;
	Map<Integer, Long> startTime;
	Map<Integer, Long> responseTime;
	Map<Integer, Long> finishTime;
	
	/**
	 * Add any objects and variables here (if needed)
	 */


	/**
	 * DO NOT CHANGE DEFINITION OF OPERATION
	 */
	public Scheduler(ProcessExecution processExecution) {
		this.processExecution = processExecution;

		/**
		 * Add general initialization code here (if needed)
		 */
	}

	/**
	 * DO NOT CHANGE DEFINITION OF OPERATION
	 */
	public void startScheduling(Policy policy, int quantum) {

		this.policy = policy;
		this.quantum = quantum;
		
		this.startTime = new HashMap<Integer, Long>();
		this.responseTime = new HashMap<Integer, Long>();
		this.finishTime = new HashMap<Integer, Long>();

		/**
		 * Add general initialization code here (if needed)
		 */

		switch(policy) {
		case FCFS:	//First-come-first-served
			this.processQueue = new LinkedList<Integer>();
			System.out.println("Starting new scheduling task: First-come-first-served");
			/**
			 * Add your policy specific initialization code here (if needed)
			 */
			break;
		case RR:	//Round robin
			System.out.println("Starting new scheduling task: Round robin, quantum = " + quantum);
			/**
			 * Add your policy specific initialization code here (if needed)
			 */
			break;
		case SPN:	//Shortest process next
			System.out.println("Starting new scheduling task: Shortest process next");
			/**
			 * Add your policy specific initialization code here (if needed)
			 */
			break;
		case SRT:	//Shortest remaining time
			System.out.println("Starting new scheduling task: Shortest remaining time");
			/**
			 * Add your policy specific initialization code here (if needed)
			 */
			break;
		case HRRN:	//Highest response ratio next
			System.out.println("Starting new scheduling task: Highest response ratio next");
			/**
			 * Add your policy specific initialization code here (if needed)
			 */
			break;
		case FB:	//Feedback
			System.out.println("Starting new scheduling task: Feedback, quantum = " + quantum);
			/**
			 * Add your policy specific initialization code here (if needed)
			 */
			break;
		}

		/**
		 * Add general scheduling or initialization code here (if needed)
		 */

	}

	/**
	 * DO NOT CHANGE DEFINITION OF OPERATION
	 */
	public void processAdded(int processID) {
		
		System.out.println("start!!");
		startTime.put(processID, System.currentTimeMillis());
		if(processQueue.isEmpty()) {
			processQueue.add(processID);
			processExecution.switchToProcess(processID);
			
			if(!responseTime.containsKey(processID) ) {
				responseTime.put(processID, System.currentTimeMillis());
			}
		}else {
			processQueue.add(processID);
		}
			
		/**
		 * Add scheduling code here
		 */

	}

	/**
	 * DO NOT CHANGE DEFINITION OF OPERATION
	 */
	public void processFinished(int processID) {
		finishTime.put(processID, System.currentTimeMillis());
		
		
		System.out.println("FINISH");
		processQueue.remove();
		if (!processQueue.isEmpty()) {
			processExecution.switchToProcess(processQueue.element()); 
			if(!responseTime.containsKey(processID) ) {
				responseTime.put(processQueue.element(), System.currentTimeMillis());
			}
		}
		/**
		 * Add scheduling code here
		 */

	}
}
