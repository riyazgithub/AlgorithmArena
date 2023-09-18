package com.tools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class compareXMLDiff {

    public static void main(String[] args) {
        File file1 = new File("res/ws2.xml");
        File file2 = new File("res/ws1.xml");

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse XML files into Document objects
            Document doc1 = builder.parse(file1);
            Document doc2 = builder.parse(file2);

            // Compare the documents and find the differences
            List<String> differences = new ArrayList<>();
            compareDocuments(doc1.getDocumentElement(), doc2.getDocumentElement(), "", differences);

            // Print the differences
            for (String diff : differences) {
                System.out.println(diff);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void compareDocuments(Element elem1, Element elem2, String path, List<String> differences) {
        if (!elem1.getTagName().equals(elem2.getTagName())) {
            differences.add("Tags are different at path: " + path + " -> " + elem1.getTagName() + ", " + elem2.getTagName());
            return;
        }

        NodeList children1 = elem1.getChildNodes();
        NodeList children2 = elem2.getChildNodes();

        if (children1.getLength() != children2.getLength()) {
            differences.add("Number of child elements is different for tag at path: " + path + " -> " + elem1.getTagName());
            return;
        }

        for (int i = 0; i < children1.getLength(); i++) {
            Node child1 = children1.item(i);
            Node child2 = children2.item(i);

            if (child1.getNodeType() == Node.ELEMENT_NODE && child2.getNodeType() == Node.ELEMENT_NODE) {
                compareDocuments((Element) child1, (Element) child2, path + " -> " + elem1.getTagName(), differences);
            } else if (!child1.getNodeValue().equals(child2.getNodeValue())) {
                differences.add("Tag values are different at path: " + path + " -> " + elem1.getTagName() + ", " + child1.getNodeValue() + ", " + child2.getNodeValue());
            }
        }
    }
}