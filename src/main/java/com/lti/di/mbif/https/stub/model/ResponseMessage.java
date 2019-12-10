package com.lti.di.mbif.https.stub.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
 
@Getter @Setter @Builder @AllArgsConstructor @ToString @XmlRootElement @XmlAccessorType(XmlAccessType.FIELD) 
public class ResponseMessage {
	private String messageID;
	private String creditDateTime;
	private String instructionID;
	private String endToEndID;
	private String transactionID;
	private String instructedParty;
	private String interbankSettlementAmount;
	private String settlementAmountCurrency;
	private String status;
	private String transactionDateTime;
}
