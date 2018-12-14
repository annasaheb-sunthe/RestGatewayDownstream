package com.scb.HttpsService.service;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class HttpsRequestServiveImpl implements HttpsRequestService {

	@Override
	public String publishHttpsRequest(String contentType, String httpsServiceReqBody) {
		log.info("Request contentType received: " + contentType);
		log.info("Request Body received: " + httpsServiceReqBody);
		return getResponeMessage();
	}

	private String getResponeMessage() {
		String responseMessage = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" + 
				"<Document>" + 
				"  <FIToFIPmtStsRpt>" + 
				"    <GrpHdr>" + 
				"      <MsgId>EEEE/120929-EUR/059</MsgId>" + 
				"      <CreDtTm>2012-09-29T09:00:05</CreDtTm>" + 
				"    </GrpHdr>" + 
				"	 <CdtTrfTxInf>" +
				"	 	<PmtId>" +
				"	 		<InstrId>EEEE/120929-EUR/059/1</InstrId>" +
				"	 		<EndToEndId>ABC/ABC-13679/2012-09-15</EndToEndId>" +
				"	 		<TxId>BBBB/120928-CCT/EUR/912/1</TxId>" +
				"	 	</PmtId>" +
				"	 	<PmtTpInf>" +
				"  </FIToFIPmtStsRpt>" + 
				"</Document>";
		return responseMessage;
	}
}
