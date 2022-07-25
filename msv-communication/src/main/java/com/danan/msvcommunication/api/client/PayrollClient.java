package com.danan.msvcommunication.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.danan.msvcommunication.api.request.MasterPayrollRequest;
import com.danan.msvcommunication.api.response.MasterPayrollResponse;

@FeignClient(name = "payrollClient", url = "${app.api.client.payroll.url}")
public interface PayrollClient {

	@DeleteMapping(value = "/api/payroll/master/{employee_id}")
	ResponseEntity<MasterPayrollResponse> disableMasterPayroll(@PathVariable(name = "employee_id") String employeeId,
			@RequestBody MasterPayrollRequest requestBody);

}
