package com.danan.msvcommunication.command.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danan.msvcommunication.api.request.AddFundRequest;
import com.danan.msvcommunication.api.request.CreateFundRequest;
import com.danan.msvcommunication.api.request.DeductFundRequest;
import com.danan.msvcommunication.command.action.ClubFundAction;
import com.danan.msvcommunication.eventsourcing.command.AddFundCommand;
import com.danan.msvcommunication.eventsourcing.command.CreateFundCommand;
import com.danan.msvcommunication.eventsourcing.command.DeductFundCommand;


@Service
public class ClubFundService {

	@Autowired
	private ClubFundAction action;

	public CompletableFuture<String> addFundTo(String clubId, AddFundRequest request) {
		var addFundCommand = new AddFundCommand(clubId, request.getAddAmount());
		return action.sendCommand(addFundCommand);
	}

	public CompletableFuture<String> createFund(CreateFundRequest request) {
		var createFundCommand = new CreateFundCommand(action.generateClubId(), request.getFundInitialBalance());
		return action.sendCommand(createFundCommand);
	}

	public CompletableFuture<String> deductFundFrom(String clubId, DeductFundRequest request) {
		var deductFundCommand = new DeductFundCommand(clubId, request.getDeductAmount());
		return action.sendCommand(deductFundCommand);
	}

}
