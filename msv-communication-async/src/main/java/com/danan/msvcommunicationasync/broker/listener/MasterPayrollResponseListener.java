package com.danan.msvcommunicationasync.broker.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.danan.msvcommunicationasync.broker.message.MasterPayrollMessage;
import com.danan.msvcommunicationasync.broker.message.MasterPayrollResponseMessage;
import com.danan.msvcommunicationasync.command.service.TerminationAsyncService;

@Component
public class MasterPayrollResponseListener {

	private static final Logger LOG = LoggerFactory.getLogger(MasterPayrollResponseListener.class);

	@Autowired
	private TerminationAsyncService masterPayrollService;

	@KafkaListener(topics = "admintome-test-resp")
	public void listenMasterPayrollResponse(MasterPayrollResponseMessage message) {
		LOG.debug("[Async-listen] Start listening from message broker, response from disabling master payroll");

		masterPayrollService.finalizeEmployeeTerminationApproval(message);

		LOG.debug("[Async-listen] Finish listening from message broker, response from disabling master payroll");
	}
	
	// container factory is for dead letter topic (Lecture : Error handling)
	// Comment either listenMasterPayroll or listenMasterPayrollWithException to
	// avoid confusion
//	@KafkaListener(topics = "t.masterpayroll.response", containerFactory = "deadLetterContainerFactory")
//	@SendTo(value = "t.masterpayroll.response")
//	public void listenMasterPayrollWithException(MasterPayrollResponseMessage message) {
//		LOG.debug("[Async] Start listening from message broker, disabling master payroll");
//
//		// hardcoded to simulate message processing failure (wrong data)
//		if (false) {
//			throw new IllegalArgumentException("Invalid employee (hardcoded) : " + message.getMessage());
//		}
//
//		masterPayrollService.finalizeEmployeeTerminationApproval(message);
//
//		LOG.debug("[Async] Finish listening from message broker, disabling master payroll");
//
//	}

}
