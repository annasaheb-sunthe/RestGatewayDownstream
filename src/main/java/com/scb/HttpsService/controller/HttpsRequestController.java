package com.scb.HttpsService.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scb.HttpsService.service.HttpsRequestService;
import com.scb.HttpsService.utils.HttpsServiceConstant;

import lombok.extern.log4j.Log4j2;

@Component
@RestController
@Log4j2
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HttpsRequestController {
	@Autowired
	HttpsRequestService httpsRequestService;

	@RequestMapping(value = HttpsServiceConstant.HTTPS_REQUEST_URL, method = RequestMethod.POST, produces = {"application/xml", "application/json" })
	public String publishHttpsRequest(@RequestHeader Map<String, String> requestMap, @RequestBody String httpsServiceReqBody) {
		log.info("Request Header received: " + requestMap);
		log.info("Request Body received: " + httpsServiceReqBody);
		return httpsRequestService.publishHttpsRequest(requestMap.get("Content-Type"), httpsServiceReqBody);
	}
}
