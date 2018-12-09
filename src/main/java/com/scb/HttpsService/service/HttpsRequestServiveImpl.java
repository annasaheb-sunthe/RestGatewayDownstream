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
		String responseMessage = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n" + 
				"<Document>\r\n" + 
				"  <FIToFIPmtStsRpt>\r\n" + 
				"    <GrpHdr>\r\n" + 
				"      <MsgId>EEEE/120929-EUR/059</MsgId>\r\n" + 
				"      <CreDtTm>2012-09-29T09:00:05</CreDtTm>\r\n" + 
				"    </GrpHdr>\r\n" + 
				"	 <CdtTrfTxInf>\n" +
				"	 	<PmtId>\r\n" +
				"	 		<InstrId>EEEE/120929-EUR/059/1</InstrId>\r\n" +
				"	 		<EndToEndId>ABC/ABC-13679/2012-09-15</EndToEndId>\r\n" +
				"	 		<TxId>BBBB/120928-CCT/EUR/912/1</TxId>\r\n" +
				"	 	</PmtId>\r\n" +
				"	 	<PmtTpInf>\r\n" +
				"  </FIToFIPmtStsRpt>\r\n" + 
				"</Document>";
		return responseMessage;
	}
}
