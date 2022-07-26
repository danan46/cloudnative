package com.danan.msvcommunication.api.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.danan.msvcommunication.api.request.MasterPayrollRequest;
import com.danan.msvcommunication.api.response.PlainMessage;

@Component
public class PayrollClientCircuitBreaker implements PayrollClient{

	@Override
	public ResponseEntity disableMasterPayroll(String employeeId,
			MasterPayrollRequest requestBody) {
		var cbMessage = "This is a Circuit Breaker event message";
		var responseBody = new PlainMessage(cbMessage);
		
		return ResponseEntity.ok().body(responseBody);
	}

}
