package org.example.services.xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DOMParser {

    private static final Logger logger = LogManager.getLogger(DOMParser.class);

    public static void main(String[] args) {
        try {
            File inputFile = new File("src/main/resources/structures/company.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputFile);

            document.getDocumentElement().normalize();

            System.out.println("Root Element: " + document.getDocumentElement().getNodeName());

            parseEmployees(document);
            parseClients(document);
            parseProjects(document);
            parseConsultants(document);
            parseManagers(document);

        } catch (Exception e) {
            logger.error("Exception occurred while parsing XML: ", e);
        }
    }

    private static void parseEmployees(Document document) {
        NodeList nodeList = document.getElementsByTagName("Employee");
        System.out.println("\nEmployees:");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("ID: " + element.getAttribute("id"));
                System.out.println("Name: " + getTextContent(element, "name"));
                System.out.println("Role: " + getTextContent(element, "role"));
                System.out.println("Salary: " + getTextContent(element, "salary"));
                System.out.println("Skills: " + getTextContent(element, "skills"));
            }
        }
    }

    private static void parseClients(Document document) {
        NodeList nodeList = document.getElementsByTagName("Client");
        System.out.println("\nClients:");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("ID: " + element.getAttribute("id"));
                System.out.println("Name: " + getTextContent(element, "name"));
                System.out.println("Contact Info: " + getTextContent(element, "contactInfo"));
            }
        }
    }

    private static void parseProjects(Document document) {
        NodeList nodeList = document.getElementsByTagName("Project");
        System.out.println("\nProjects:");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("ID: " + element.getAttribute("id"));
                System.out.println("Name: " + getTextContent(element, "name"));
                System.out.println("Deadline: " + getTextContent(element, "deadline"));
                System.out.println("Budget: " + getTextContent(element, "budget"));
            }
        }
    }

    private static void parseConsultants(Document document) {
        NodeList nodeList = document.getElementsByTagName("Consultant");
        System.out.println("\nConsultants:");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("ID: " + element.getAttribute("id"));
                System.out.println("Name: " + getTextContent(element, "name"));
                System.out.println("Industry: " + getTextContent(element, "industry"));
                System.out.println("Salary: " + getTextContent(element, "salary"));
            }
        }
    }

    private static void parseManagers(Document document) {
        NodeList nodeList = document.getElementsByTagName("Manager");
        System.out.println("\nManagers:");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("ID: " + element.getAttribute("id"));
                System.out.println("Name: " + getTextContent(element, "name"));
                System.out.println("Industry: " + getTextContent(element, "industry"));
                System.out.println("Salary: " + getTextContent(element, "salary"));
                System.out.println("Skills: " + getTextContent(element, "skills"));
            }
        }
    }

    private static String getTextContent(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return "";
    }
}

