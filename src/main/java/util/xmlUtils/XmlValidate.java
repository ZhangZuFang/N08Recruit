package main.java.util.xmlUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XmlValidate {
	private String fineOrNot;
	private SAXBuilder saxBuilder;
	private InputStream in;
	private Document doc ;

	// 比较xml中元素格式是否有问题
	public String validateFormat(String xmlPath) {
		fineOrNot = "problem";
		return fineOrNot;
	}

	public List<String> readSpecElementsValue(String filePath ,String elementName) {
		saxBuilder = new SAXBuilder();

		try {
			in = new FileInputStream(filePath);
			doc = saxBuilder.build(in);
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Element rootElement = doc.getRootElement();
		
		List<Element> elementList = rootElement.getChildren(elementName);
		
		List<String> sqlFileNameList = new  ArrayList<String>();
		
	   for(int i = 0;i<elementList.size();i++){
		   sqlFileNameList.add( elementList.get(i).getValue()) ;
	   }
		
		return sqlFileNameList;
		

	}

}
