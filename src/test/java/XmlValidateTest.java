package test.java;

import static org.junit.Assert.assertEquals;

import java.util.List;

import main.java.util.xmlUtils.XmlValidate;

import org.junit.Test;

public class XmlValidateTest {
	
	XmlValidate xmlValidate = new XmlValidate();

	@Test
	public void testReadSpecElements() {
		//URL url = XmlValidateTest.class.getClassLoader().getResource("sqlFileLists.xml");
		String filePath = XmlValidateTest.class.getResource("sqlFileLists.xml").getPath();
		List spcElementList = xmlValidate.readSpecElementsValue(filePath, "sqlfile");
		assertEquals(4,spcElementList.size());
		
	}

}
