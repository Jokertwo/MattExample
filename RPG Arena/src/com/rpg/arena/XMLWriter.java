package com.rpg.arena;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLWriter {

    public static final String xmlFilePath = "./xmlfile.xml";

    public static void createXMLFile() {

        try {

            /*
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            // root element
            Element root = document.createElement("company");
            document.appendChild(root);

            // employee element
            Element employee = document.createElement("employee");

            root.appendChild(employee);

            // set an attribute to staff element
            Attr attr = document.createAttribute("id");
            attr.setValue("10");
            employee.setAttributeNode(attr);

            //you can also use staff.setAttribute("id", "1") for this

            // firstname element
            Element firstName = document.createElement("firstname");
            firstName.appendChild(document.createTextNode("James"));
            employee.appendChild(firstName);

            // lastname element
            Element lastname = document.createElement("lastname");
            lastname.appendChild(document.createTextNode("Harley"));
            employee.appendChild(lastname);

            // email element
            Element email = document.createElement("email");
            email.appendChild(document.createTextNode("james@example.org"));
            employee.appendChild(email);

            // department elements
            Element department = document.createElement("department");
            department.appendChild(document.createTextNode("Human Resources"));
            employee.appendChild(department);

            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating XML File");
            */

            //Initialize document instance
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document xmlFile = docBuilder.newDocument();

            //Create root
            Element root = xmlFile.createElement("gameData");
            xmlFile.appendChild(root);

            //Add characters to root
            Element characters = xmlFile.createElement("characters");
            root.appendChild(characters);

            //character1
            Element character1 = xmlFile.createElement("character1");
            characters.appendChild(character1);

            Element name1 = xmlFile.createElement("name");
            name1.appendChild(xmlFile.createTextNode("Spongebob"));
            character1.appendChild(name1);

            Element health1 = xmlFile.createElement("health");
            health1.appendChild(xmlFile.createTextNode("100"));
            character1.appendChild(health1);

            Element attackPower1 = xmlFile.createElement("attackPower");
            attackPower1.appendChild(xmlFile.createTextNode("5"));
            character1.appendChild(attackPower1);

            Element defense1 = xmlFile.createElement("defense");
            defense1.appendChild(xmlFile.createTextNode("2"));
            character1.appendChild(defense1);

            //character2
            Element character2 = xmlFile.createElement("character2");
            characters.appendChild(character2);

            Element name2 = xmlFile.createElement("name");
            name2.appendChild(xmlFile.createTextNode("Patrick"));
            character2.appendChild(name2);

            Element health2 = xmlFile.createElement("health");
            health2.appendChild(xmlFile.createTextNode("100"));
            character2.appendChild(health2);

            Element attackPower2 = xmlFile.createElement("attackPower");
            attackPower2.appendChild(xmlFile.createTextNode("5"));
            character2.appendChild(attackPower2);

            Element defense2 = xmlFile.createElement("defense");
            defense2.appendChild(xmlFile.createTextNode("2"));
            character2.appendChild(defense2);

            //Add weapons to root
            Element weapons = xmlFile.createElement("weapons");
            root.appendChild(weapons);

            Element weapon1 = xmlFile.createElement("weapon1");
            weapons.appendChild(weapon1);

            //weapon1
            Element wepName1 = xmlFile.createElement("name");
            wepName1.appendChild(xmlFile.createTextNode("stick"));
            weapon1.appendChild(wepName1);

            Element wepAttack1 = xmlFile.createElement("attack");
            wepAttack1.appendChild(xmlFile.createTextNode("1"));
            weapon1.appendChild(wepAttack1);

            Element wepDefense1 = xmlFile.createElement("defense");
            wepDefense1.appendChild(xmlFile.createTextNode("1"));
            weapon1.appendChild(wepDefense1);

            //weapon2
            Element weapon2 = xmlFile.createElement("weapon2");
            weapons.appendChild(weapon2);

            Element wepname1 = xmlFile.createElement("name");
            name1.appendChild(xmlFile.createTextNode("Spongebob"));
            character1.appendChild(name1);

            Element health1 = xmlFile.createElement("health");
            health1.appendChild(xmlFile.createTextNode("100"));
            character1.appendChild(health1);

            Element health1 = xmlFile.createElement("health");
            health1.appendChild(xmlFile.createTextNode("100"));
            character1.appendChild(health1);

            //weapon3
            Element weapon3 = xmlFile.createElement("net");
            characters.appendChild(character1);

            Element name1 = xmlFile.createElement("name");
            name1.appendChild(xmlFile.createTextNode("Spongebob"));
            character1.appendChild(name1);

            Element health1 = xmlFile.createElement("health");
            health1.appendChild(xmlFile.createTextNode("100"));
            character1.appendChild(health1);

            //weapon4
            Element weapon4 = xmlFile.createElement("gary");
            characters.appendChild(character1);

            Element name1 = xmlFile.createElement("name");
            name1.appendChild(xmlFile.createTextNode("Spongebob"));
            character1.appendChild(name1);

            Element health1 = xmlFile.createElement("health");
            health1.appendChild(xmlFile.createTextNode("100"));
            character1.appendChild(health1);

            //Create the xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(xmlFile);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            transformer.transform(domSource, streamResult);

            System.out.println("XML File Created!");

        } catch(ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch(TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

}
