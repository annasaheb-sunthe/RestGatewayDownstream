package com.scb.HttpsService.utils;

public interface RequestParser {
	//public Object parseXML(Object request);
	//public Object parseXMLString(String request);
	public Object parse(Object request);
	public Object parse(String request);
}
