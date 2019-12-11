package com.scb.HttpsService.service;

import org.springframework.stereotype.Service;

import com.lti.di.mbif.https.stub.model.ResponseMessage;
import com.scb.HttpsService.utils.RequestParser;
import com.scb.HttpsService.utils.XmlParser;

import lombok.extern.log4j.Log4j2;
 
@Service
@Log4j2
public class HttpsRequestServiveImpl implements HttpsRequestService {

	@Override
	public String publishHttpsRequest(String contentType, String httpsServiceReqBody) {
		log.info("Request contentType received: " + contentType);
		log.info("Request Body received: " + httpsServiceReqBody);
		return getResponeMessage(httpsServiceReqBody);
	}

	private String getResponeMessage(String httpsServiceReqBody) {
		RequestParser parser = new XmlParser();
		ResponseMessage resMsg= (ResponseMessage) parser.parse(httpsServiceReqBody);
		
		String responseMessage = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" + 
				"<Document>" + 
				"<FIToFIPmtStsRpt>" + 
				" <GrpHdr>" + 
				"  <MsgId>" + resMsg.getMessageID() + "</MsgId>" + 
				"  <CreDtTm>" + resMsg.getCreditDateTime() + "</CreDtTm>" + 
				" </GrpHdr>" + 
				" <CdtTrfTxInf>" +
				"  <PmtId>" +
				"   <InstrId>" + resMsg.getInstructionID() + "</InstrId>" +
				"   <EndToEndId>" + resMsg.getEndToEndID() + "</EndToEndId>" +
				"   <TxId>" + resMsg.getTransactionID() + "</TxId>" +
				"  </PmtId>" + 
				"  <PmtTpInf>" +
				"   <InstrPrty>" + resMsg.getInstructedParty() + "</InstrPrty>" +
				"  </PmtTpInf>" +
				"  <IntrBkSttlmAmt Ccy=\"" + resMsg.getSettlementAmountCurrency() +"\">" + resMsg.getInterbankSettlementAmount() + "</IntrBkSttlmAmt>" +
				"  <TxnDtTm>" + resMsg.getTransactionDateTime() + "</TxnDtTm>" +
				"  <Status>" + resMsg.getStatus() + "</Status>" +
				" </CdtTrfTxInf>" +
				" </FIToFIPmtStsRpt>" + 
				"</Document>";
		return responseMessage;
	}
}
