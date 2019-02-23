package test.java.controller;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.dao.imple.SqlInterfaceImple;
import main.java.dto.FullSinfor;
import main.java.util.xmlUtils.JaxbXmlTransfer;
import test.java.H2Test;

public class BusinessControllerTest extends H2Test {

	SqlInterfaceImple sqlImple = new SqlInterfaceImple();
	JaxbXmlTransfer<FullSinfor> jaxbXmlTransfer = null;
	String xmlFolder = "G://xmlFolder";

	@Before
	public void initDb() {
		initDBDataTest();

	}

	@After
	public void destoryDb() {
		shutDown();
	}

	@Test
	public void testGenerateXml() {

		String d_id = "4";
		String p_id = "12";

		ArrayList studentsList = sqlImple.getBS_infor(d_id, p_id);

		for (int i = 0; i < studentsList.size(); i++) {
			FullSinfor fullSinfor = (FullSinfor) studentsList.get(i);
			jaxbXmlTransfer = new JaxbXmlTransfer<FullSinfor>(fullSinfor);
			String xmlPath = xmlFolder + "//" + fullSinfor.getS_id()+"-"+fullSinfor.getName() + ".xml";
			jaxbXmlTransfer.clazzToXml(xmlPath);

		}

	}

}
