package test.java.util.xmlUtils;

import org.junit.Test;

import main.java.dto.FullSinfor;
import main.java.util.xmlUtils.JaxbXmlTransfer;

public class JaxbXmlTransferTest {

	@Test
	public void testClazzToXml() {

		FullSinfor info = new FullSinfor();
		info.setName("shange");
		info.setAddress("dagudian");

		JaxbXmlTransfer<FullSinfor> target = new JaxbXmlTransfer<FullSinfor>(info);
	//	target.clazzToXml();
	}

}
