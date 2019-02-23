package main.java.util.xmlUtils;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JaxbXmlTransfer<T> {

	JAXBContext context = null;
	T t = null;
	Marshaller marshaller = null;
	FileWriter fw = null;

	public JaxbXmlTransfer(T t) {
		this.t = t;
	}

	private void initJaxbContext() {
		try {
			this.context = JAXBContext.newInstance(t.getClass());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public FileWriter clazzToXml(String path) {
		initJaxbContext();

		try {
			marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			fw = new FileWriter(path);
			marshaller.marshal(t, fw);

		} catch (JAXBException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
