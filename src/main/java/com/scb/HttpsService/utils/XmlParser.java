package com.scb.HttpsService.utils;

import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.lti.di.mbif.https.stub.model.ResponseMessage;

public class XmlParser implements RequestParser {
	@Override
	public ResponseMessage parse(Object request) {
		return null;
	}

	@Override
	public ResponseMessage parse(String request) {

		ResponseMessage responseMessage = null;

		try {
			// File inputFile = new File("input.txt");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;

			dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse(new InputSource(new StringReader(request)));

			doc.getDocumentElement().normalize();

			XPath xPath = XPathFactory.newInstance().newXPath();

			// get message id
			String messageIDExp = "//Document/FIToFICstmrCdtTrf/GrpHdr/MsgId";

			// extract message type
			NodeList msgTypeList = (NodeList) xPath.compile(messageIDExp).evaluate(doc, XPathConstants.NODESET);

			String messageID = null;

			if (msgTypeList.getLength() > 0) {
				Node nNode = msgTypeList.item(0);
				System.out.println("\n Message Type - Current Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("messageID [" + 0 + "] : " + nNode.getTextContent());
					messageID = nNode.getTextContent();
				}
			}

			// get source system
			String creditDateTimeExp = "//Document/FIToFICstmrCdtTrf/GrpHdr/CreDtTm";

			// extract creditDateTime list
			NodeList creditDateTimeList = (NodeList) xPath.compile(creditDateTimeExp).evaluate(doc,
					XPathConstants.NODESET);

			String creditDateTime = null;

			if (creditDateTimeList.getLength() > 0) {
				Node nNode = creditDateTimeList.item(0);
				System.out.println("\n creditDateTimeList - Current Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("CreditDateTime [" + 0 + "] : " + nNode.getTextContent());
					creditDateTime = nNode.getTextContent();
				}
			}

			// get instructionID
			String instructionIDExp = "//Document/FIToFICstmrCdtTrf/CdtTrfTxInf/PmtId/InstrId";

			// extract instructionIDExp
			NodeList instructionIDList = (NodeList) xPath.compile(instructionIDExp).evaluate(doc,
					XPathConstants.NODESET);
			String instructionID = null;

			if (instructionIDList.getLength() > 0) {
				Node nNode = instructionIDList.item(0);
				System.out.println("\n instructionIDList - Current Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("InstructionID [" + 0 + "] : " + nNode.getTextContent());
					instructionID = nNode.getTextContent();
				}
			}

			// get endToEndID
			String endToEndIDExp = "//Document/FIToFICstmrCdtTrf/CdtTrfTxInf/PmtId/EndToEndId";

			// extract endToEndIDExp
			NodeList endToEndIDList = (NodeList) xPath.compile(endToEndIDExp).evaluate(doc, XPathConstants.NODESET);
			String endToEndID = null;

			if (endToEndIDList.getLength() > 0) {
				Node nNode = endToEndIDList.item(0);
				System.out.println("\n endToEndIDList - Current Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("EndToEndID [" + 0 + "] : " + nNode.getTextContent());
					endToEndID = nNode.getTextContent();
				}
			}

			// get transactionID
			String transactionIDExp = "//Document/FIToFICstmrCdtTrf/CdtTrfTxInf/PmtId/TxId";

			// extract transactionIDExp
			NodeList transactionIDList = (NodeList) xPath.compile(transactionIDExp).evaluate(doc,
					XPathConstants.NODESET);
			String transactionID = null;

			if (transactionIDList.getLength() > 0) {
				Node nNode = transactionIDList.item(0);
				System.out.println("\n transactionIDList - Current Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("TransactionID [" + 0 + "] : " + nNode.getTextContent());
					transactionID = nNode.getTextContent();
				}
			}

			// get instructedParty
			String instructedPartyExp = "//Document/FIToFICstmrCdtTrf/CdtTrfTxInf/PmtTpInf/InstrPrty";

			// extract instructedPartyExp
			NodeList instructedPartyList = (NodeList) xPath.compile(instructedPartyExp).evaluate(doc,
					XPathConstants.NODESET);
			String instructedParty = null;

			if (instructedPartyList.getLength() > 0) {
				Node nNode = instructedPartyList.item(0);
				System.out.println("\n instructionIDList - Current Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("InstructedParty [" + 0 + "] : " + nNode.getTextContent());
					instructedParty = nNode.getTextContent();
				}
			}

			// get interbankSettlementAmount
			String interbankSettlementAmountExp = "//Document/FIToFICstmrCdtTrf/CdtTrfTxInf/IntrBkSttlmAmt";

			// extract instructionIDExp
			NodeList interbankSettlementAmountList = (NodeList) xPath.compile(interbankSettlementAmountExp)
					.evaluate(doc, XPathConstants.NODESET);
			String interbankSettlementAmount = null;
			String stlmtAmountCcy = null;
			
			if (interbankSettlementAmountList.getLength() > 0) {
				Node nNode = interbankSettlementAmountList.item(0);
				System.out.println("\n interbankSettlementAmountList - Current Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("InterbankSettlementAmount [" + 0 + "] : " + nNode.getTextContent());
					interbankSettlementAmount = nNode.getTextContent();
					stlmtAmountCcy = eElement.getAttribute("Ccy");
					System.out.println("SettlementAmountCurrency: " + stlmtAmountCcy);
				}
			}

			// get transactionDateTime
			String transactionDateTime = getCurrentDateTime();

			responseMessage = ResponseMessage.builder().messageID(messageID).creditDateTime(creditDateTime)
					.instructionID(instructionID).endToEndID(endToEndID).transactionID(transactionID)
					.interbankSettlementAmount(interbankSettlementAmount).settlementAmountCurrency(stlmtAmountCcy).status("SUCCESS")
					.instructedParty(instructedParty).transactionDateTime(transactionDateTime).build();

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return responseMessage;
	}

	public String getCurrentDateTime() {
		LocalDateTime localDateTime = LocalDateTime.now();
		return localDateTime.toString();
	}

	public String getFormattedDateTime() {
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date localDateTime = new Date();
		String formattedDate = outputFormat.format(localDateTime);
		return formattedDate;
	}

	public long getTransactionId() {
		Random random = new Random(System.nanoTime() % 100000);
		long uniqueTansactionId = random.nextInt(1000000000);
		return uniqueTansactionId;
	}

	public static void main(String arg[]) {
		XmlParser parser = new XmlParser();
		System.out.println("Formatted current date [yyyy-MM-dd'T'HH:mm:ss]: " + parser.getFormattedDateTime());
	}
}
