//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.24 at 06:00:31 PM IST 
//


package home.javaproject.investment.pojo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the home.javaproject.investment.pojo package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Investments_QNAME = new QName("http://www.example.org/investment", "investments");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: home.javaproject.investment.pojo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Investments }
     * 
     */
    public Investments createInvestments() {
        return new Investments();
    }

    /**
     * Create an instance of {@link Transaction }
     * 
     */
    public Transaction createTransaction() {
        return new Transaction();
    }

    /**
     * Create an instance of {@link Investment }
     * 
     */
    public Investment createInvestment() {
        return new Investment();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Investments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/investment", name = "investments")
    public JAXBElement<Investments> createInvestments(Investments value) {
        return new JAXBElement<Investments>(_Investments_QNAME, Investments.class, null, value);
    }

}
