package com.scb.HttpsService.utils;

public interface RequestParser {
	public Object parse(Object request); 
	public Object parse(String request);
}
