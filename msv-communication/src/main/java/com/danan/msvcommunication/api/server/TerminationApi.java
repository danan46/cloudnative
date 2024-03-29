package com.danan.msvcommunication.api.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danan.msvcommunication.api.request.TerminationApprovalRequest;
import com.danan.msvcommunication.api.response.TerminationApprovalResponse;
import com.danan.msvcommunication.command.service.TerminationService;


@RestController
@RequestMapping("/api/termination")
public class TerminationApi {

	@Autowired
	private TerminationService terminationService;

	@PostMapping(value = "/{employee_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TerminationApprovalResponse> approveEmployeeTermination(
			@PathVariable(name = "employee_id", required = true) String employeeId,
			@RequestBody(required = true) TerminationApprovalRequest requestBody) {

		terminationService.approveTermination(employeeId, requestBody.getTerminationDate());

		// dummy response
		var responseBody = new TerminationApprovalResponse();
		responseBody.setEmployeeId(employeeId);
		responseBody.setMessage("Done simulating termination approval");

		return ResponseEntity.ok().body(responseBody);
	}

}
