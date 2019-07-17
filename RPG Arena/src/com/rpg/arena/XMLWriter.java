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
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLWriter {

    public static final String xmlFilePath = "./xmlfile.xml";

    public static void createXMLFile() {

        try {

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

            //weapon1
            Element weapon1 = xmlFile.createElement("weapon1");
            weapons.appendChild(weapon1);

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

            Element wepName2 = xmlFile.createElement("name");
            wepName2.appendChild(xmlFile.createTextNode("rock"));
            weapon2.appendChild(wepName2);

            Element wepAttack2 = xmlFile.createElement("attack");
            wepAttack2.appendChild(xmlFile.createTextNode("1"));
            weapon2.appendChild(wepAttack2);

            Element wepDefense2 = xmlFile.createElement("defense");
            wepDefense2.appendChild(xmlFile.createTextNode("1"));
            weapon2.appendChild(wepDefense2);

            //weapon3
            Element weapon3 = xmlFile.createElement("weapon3");
            weapons.appendChild(weapon3);

            Element wepName3 = xmlFile.createElement("name");
            wepName3.appendChild(xmlFile.createTextNode("net"));
            weapon3.appendChild(wepName3);

            Element wepAttack3 = xmlFile.createElement("attack");
            wepAttack3.appendChild(xmlFile.createTextNode("1"));
            weapon3.appendChild(wepAttack3);

            Element wepDefense3 = xmlFile.createElement("defense");
            wepDefense3.appendChild(xmlFile.createTextNode("1"));
            weapon3.appendChild(wepDefense3);

            //weapon4
            Element weapon4 = xmlFile.createElement("weapon4");
            weapons.appendChild(weapon4);

            Element wepName4 = xmlFile.createElement("name");
            wepName4.appendChild(xmlFile.createTextNode("gary"));
            weapon4.appendChild(wepName4);

            Element wepAttack4 = xmlFile.createElement("attack");
            wepAttack4.appendChild(xmlFile.createTextNode("1"));
            weapon4.appendChild(wepAttack4);

            Element wepDefense4 = xmlFile.createElement("defense");
            wepDefense4.appendChild(xmlFile.createTextNode("1"));
            weapon4.appendChild(wepDefense4);

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
