package com.javarush.test.level33.lesson10.bonus01;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.regex.Pattern;

/* Комментарий внутри xml
Реализовать метод toXmlWithComment, который должен возвращать строку - xml представление объекта obj.
В строке перед каждым тэгом tagName должен быть вставлен комментарий comment.
Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно.
Пример вызова:  toXmlWithComment(firstSecondObject, "second", "it's a comment")
Пример результата:
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<first>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second><![CDATA[need CDATA because of < and >]]></second>
    <!--it's a comment-->
    <second/>
</first>
*/
public class Solution
{

    public static void main(String[] args)
    {
        First first = new First();
        first.second = new LinkedList<>();
        first.second.add("hello");
        first.second.add("need CDATA because of < and >");
        first.second.add("hello1");
        first.second.add("hello2");
        first.second.add("hello3");
        System.out.println(toXmlWithComment(first, "second", "it's a comment"));

    }

    public static String toXmlWithComment(Object obj, String tagName, String comment)
    {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try
        {
            Document document = documentBuilderFactory.newDocumentBuilder().newDocument();
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(obj, document);
            NodeList nodeList = document.getElementsByTagName("*");

            for (int i = 0; i < nodeList.getLength(); i++)
            {
                Node node = nodeList.item(i);
                if (node.getNodeName().equals(tagName))
                {
                    Comment newComment = document.createComment(comment);
                    node.getParentNode().insertBefore(newComment,node);
                }
                transformToCDATA(node, document);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
            StringWriter result = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(result));
            return result.toString();
        }
        catch (ParserConfigurationException | JAXBException | TransformerException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void transformToCDATA(Node node, Document document){
        if ((node.getNodeType() == 3) && (Pattern.compile("[<>&'\"]").matcher(node.getTextContent()).find()))
        {
            Node newNode = document.createCDATASection(node.getNodeValue());
            node.getParentNode().replaceChild(newNode, node);
        }
        if (node.hasChildNodes()){
            NodeList nodeList = node.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++){
                transformToCDATA(nodeList.item(i), document);
            }
        }
    }
}