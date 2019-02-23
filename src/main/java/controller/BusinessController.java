package main.java.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import main.java.dao.imple.SqlInterfaceImple;
import main.java.dto.FullSinfor;
import main.java.util.xmlUtils.JaxbXmlTransfer;

@Controller
public class BusinessController {
	
	
	  SqlInterfaceImple sqlImple = new SqlInterfaceImple();
	  JaxbXmlTransfer<FullSinfor> jaxbXmlTransfer = null ;
	  String xmlFolder = "G://xmlFolder";

	@RequestMapping("/generateXmls.do")
	public void generateXml(HttpServletRequest request, HttpServletResponse response) {

		String d_id = request.getParameter("d_id");
		String p_id = request.getParameter("p_id");
		
		ArrayList studentsList = sqlImple.getBS_infor(d_id, p_id);
		
		for(int i = 0 ;i<studentsList.size();i++) {
			FullSinfor fullSinfor = (FullSinfor) studentsList.get(i);
			jaxbXmlTransfer = new JaxbXmlTransfer<FullSinfor>(fullSinfor);
			String xmlPath = xmlFolder+"//"+fullSinfor.getName()+".xml";
			jaxbXmlTransfer.clazzToXml(xmlPath);
			
			
		}
		
		

	}

}
