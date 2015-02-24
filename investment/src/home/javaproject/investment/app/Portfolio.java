package home.javaproject.investment.app;

import home.javaproject.investment.pojo.Investment;
import home.javaproject.investment.pojo.Investments;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Portfolio {
	
	Investments _investments;
	public void init(String fileName) {
		try {

			JAXBContext jaxbContext = JAXBContext
					.newInstance("home.javaproject.investment.pojo");
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			JAXBElement data = (JAXBElement) unmarshaller
					.unmarshal(new FileInputStream(fileName));
			
			_investments = (Investments) data.getValue();
			//List<Investment> iList = investments.getInvestment();
		}
		catch (JAXBException je) {
			je.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}		
	}
	
	List<Investment> getList() {
		return _investments.getInvestment();
	}
}
