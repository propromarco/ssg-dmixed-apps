//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.04 at 01:40:50 PM MEZ 
//


package eu.europa.publications.formex.ted.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * Section VI: COMPLEMENTARY INFORMATION
 * 
 * <p>Java class for complement_info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="complement_info">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;sequence>
 *             &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}RECURRENT_PROCUREMENT"/>
 *             &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}ESTIMATED_TIMING" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}NO_RECURRENT_PROCUREMENT"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}EORDERING" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}EINVOICING" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}EPAYMENT" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}INFO_ADD" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}ADDRESS_REVIEW_BODY" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}ADDRESS_MEDIATION_BODY" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}REVIEW_PROCEDURE" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}ADDRESS_REVIEW_INFO" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}DATE_DISPATCH_NOTICE"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "complement_info", propOrder = {
    "norecurrentprocurement",
    "recurrentprocurement",
    "estimatedtiming",
    "eordering",
    "einvoicing",
    "epayment",
    "infoadd",
    "addressreviewbody",
    "addressmediationbody",
    "reviewprocedure",
    "addressreviewinfo",
    "datedispatchnotice"
})
@XmlSeeAlso({
    CiF20 .class,
    CiF24 .class,
    CiF23 .class,
    CiF22 .class,
    CiF21 .class,
    CiF25 .class,
    CiF02 .class,
    CiF01 .class,
    CiF07 .class,
    CiF08 .class,
    CiF05 .class,
    CiF06 .class,
    CiF03 .class,
    CiF04 .class,
    CiF13 .class,
    CiF12 .class,
    CiF15 .class
})
public class ComplementInfo
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "NO_RECURRENT_PROCUREMENT")
    protected Empty norecurrentprocurement;
    @XmlElement(name = "RECURRENT_PROCUREMENT")
    protected Empty recurrentprocurement;
    @XmlElement(name = "ESTIMATED_TIMING")
    protected TextFtMultiLines estimatedtiming;
    @XmlElement(name = "EORDERING")
    protected Empty eordering;
    @XmlElement(name = "EINVOICING")
    protected Empty einvoicing;
    @XmlElement(name = "EPAYMENT")
    protected Empty epayment;
    @XmlElement(name = "INFO_ADD")
    protected TextFtMultiLines infoadd;
    @XmlElement(name = "ADDRESS_REVIEW_BODY")
    protected ContactReview addressreviewbody;
    @XmlElement(name = "ADDRESS_MEDIATION_BODY")
    protected ContactReview addressmediationbody;
    @XmlElement(name = "REVIEW_PROCEDURE")
    protected TextFtMultiLines reviewprocedure;
    @XmlElement(name = "ADDRESS_REVIEW_INFO")
    protected ContactReview addressreviewinfo;
    @XmlElement(name = "DATE_DISPATCH_NOTICE", required = true)
    protected XMLGregorianCalendar datedispatchnotice;

    /**
     * Gets the value of the norecurrentprocurement property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getNORECURRENTPROCUREMENT() {
        return norecurrentprocurement;
    }

    /**
     * Sets the value of the norecurrentprocurement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setNORECURRENTPROCUREMENT(Empty value) {
        this.norecurrentprocurement = value;
    }

    /**
     * Gets the value of the recurrentprocurement property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getRECURRENTPROCUREMENT() {
        return recurrentprocurement;
    }

    /**
     * Sets the value of the recurrentprocurement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setRECURRENTPROCUREMENT(Empty value) {
        this.recurrentprocurement = value;
    }

    /**
     * Gets the value of the estimatedtiming property.
     * 
     * @return
     *     possible object is
     *     {@link TextFtMultiLines }
     *     
     */
    public TextFtMultiLines getESTIMATEDTIMING() {
        return estimatedtiming;
    }

    /**
     * Sets the value of the estimatedtiming property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextFtMultiLines }
     *     
     */
    public void setESTIMATEDTIMING(TextFtMultiLines value) {
        this.estimatedtiming = value;
    }

    /**
     * Gets the value of the eordering property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getEORDERING() {
        return eordering;
    }

    /**
     * Sets the value of the eordering property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setEORDERING(Empty value) {
        this.eordering = value;
    }

    /**
     * Gets the value of the einvoicing property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getEINVOICING() {
        return einvoicing;
    }

    /**
     * Sets the value of the einvoicing property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setEINVOICING(Empty value) {
        this.einvoicing = value;
    }

    /**
     * Gets the value of the epayment property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getEPAYMENT() {
        return epayment;
    }

    /**
     * Sets the value of the epayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setEPAYMENT(Empty value) {
        this.epayment = value;
    }

    /**
     * Gets the value of the infoadd property.
     * 
     * @return
     *     possible object is
     *     {@link TextFtMultiLines }
     *     
     */
    public TextFtMultiLines getINFOADD() {
        return infoadd;
    }

    /**
     * Sets the value of the infoadd property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextFtMultiLines }
     *     
     */
    public void setINFOADD(TextFtMultiLines value) {
        this.infoadd = value;
    }

    /**
     * Gets the value of the addressreviewbody property.
     * 
     * @return
     *     possible object is
     *     {@link ContactReview }
     *     
     */
    public ContactReview getADDRESSREVIEWBODY() {
        return addressreviewbody;
    }

    /**
     * Sets the value of the addressreviewbody property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactReview }
     *     
     */
    public void setADDRESSREVIEWBODY(ContactReview value) {
        this.addressreviewbody = value;
    }

    /**
     * Gets the value of the addressmediationbody property.
     * 
     * @return
     *     possible object is
     *     {@link ContactReview }
     *     
     */
    public ContactReview getADDRESSMEDIATIONBODY() {
        return addressmediationbody;
    }

    /**
     * Sets the value of the addressmediationbody property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactReview }
     *     
     */
    public void setADDRESSMEDIATIONBODY(ContactReview value) {
        this.addressmediationbody = value;
    }

    /**
     * Gets the value of the reviewprocedure property.
     * 
     * @return
     *     possible object is
     *     {@link TextFtMultiLines }
     *     
     */
    public TextFtMultiLines getREVIEWPROCEDURE() {
        return reviewprocedure;
    }

    /**
     * Sets the value of the reviewprocedure property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextFtMultiLines }
     *     
     */
    public void setREVIEWPROCEDURE(TextFtMultiLines value) {
        this.reviewprocedure = value;
    }

    /**
     * Gets the value of the addressreviewinfo property.
     * 
     * @return
     *     possible object is
     *     {@link ContactReview }
     *     
     */
    public ContactReview getADDRESSREVIEWINFO() {
        return addressreviewinfo;
    }

    /**
     * Sets the value of the addressreviewinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactReview }
     *     
     */
    public void setADDRESSREVIEWINFO(ContactReview value) {
        this.addressreviewinfo = value;
    }

    /**
     * Gets the value of the datedispatchnotice property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDATEDISPATCHNOTICE() {
        return datedispatchnotice;
    }

    /**
     * Sets the value of the datedispatchnotice property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDATEDISPATCHNOTICE(XMLGregorianCalendar value) {
        this.datedispatchnotice = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ComplementInfo)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ComplementInfo that = ((ComplementInfo) object);
        {
            Empty lhsNORECURRENTPROCUREMENT;
            lhsNORECURRENTPROCUREMENT = this.getNORECURRENTPROCUREMENT();
            Empty rhsNORECURRENTPROCUREMENT;
            rhsNORECURRENTPROCUREMENT = that.getNORECURRENTPROCUREMENT();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "norecurrentprocurement", lhsNORECURRENTPROCUREMENT), LocatorUtils.property(thatLocator, "norecurrentprocurement", rhsNORECURRENTPROCUREMENT), lhsNORECURRENTPROCUREMENT, rhsNORECURRENTPROCUREMENT)) {
                return false;
            }
        }
        {
            Empty lhsRECURRENTPROCUREMENT;
            lhsRECURRENTPROCUREMENT = this.getRECURRENTPROCUREMENT();
            Empty rhsRECURRENTPROCUREMENT;
            rhsRECURRENTPROCUREMENT = that.getRECURRENTPROCUREMENT();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "recurrentprocurement", lhsRECURRENTPROCUREMENT), LocatorUtils.property(thatLocator, "recurrentprocurement", rhsRECURRENTPROCUREMENT), lhsRECURRENTPROCUREMENT, rhsRECURRENTPROCUREMENT)) {
                return false;
            }
        }
        {
            TextFtMultiLines lhsESTIMATEDTIMING;
            lhsESTIMATEDTIMING = this.getESTIMATEDTIMING();
            TextFtMultiLines rhsESTIMATEDTIMING;
            rhsESTIMATEDTIMING = that.getESTIMATEDTIMING();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "estimatedtiming", lhsESTIMATEDTIMING), LocatorUtils.property(thatLocator, "estimatedtiming", rhsESTIMATEDTIMING), lhsESTIMATEDTIMING, rhsESTIMATEDTIMING)) {
                return false;
            }
        }
        {
            Empty lhsEORDERING;
            lhsEORDERING = this.getEORDERING();
            Empty rhsEORDERING;
            rhsEORDERING = that.getEORDERING();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "eordering", lhsEORDERING), LocatorUtils.property(thatLocator, "eordering", rhsEORDERING), lhsEORDERING, rhsEORDERING)) {
                return false;
            }
        }
        {
            Empty lhsEINVOICING;
            lhsEINVOICING = this.getEINVOICING();
            Empty rhsEINVOICING;
            rhsEINVOICING = that.getEINVOICING();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "einvoicing", lhsEINVOICING), LocatorUtils.property(thatLocator, "einvoicing", rhsEINVOICING), lhsEINVOICING, rhsEINVOICING)) {
                return false;
            }
        }
        {
            Empty lhsEPAYMENT;
            lhsEPAYMENT = this.getEPAYMENT();
            Empty rhsEPAYMENT;
            rhsEPAYMENT = that.getEPAYMENT();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "epayment", lhsEPAYMENT), LocatorUtils.property(thatLocator, "epayment", rhsEPAYMENT), lhsEPAYMENT, rhsEPAYMENT)) {
                return false;
            }
        }
        {
            TextFtMultiLines lhsINFOADD;
            lhsINFOADD = this.getINFOADD();
            TextFtMultiLines rhsINFOADD;
            rhsINFOADD = that.getINFOADD();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "infoadd", lhsINFOADD), LocatorUtils.property(thatLocator, "infoadd", rhsINFOADD), lhsINFOADD, rhsINFOADD)) {
                return false;
            }
        }
        {
            ContactReview lhsADDRESSREVIEWBODY;
            lhsADDRESSREVIEWBODY = this.getADDRESSREVIEWBODY();
            ContactReview rhsADDRESSREVIEWBODY;
            rhsADDRESSREVIEWBODY = that.getADDRESSREVIEWBODY();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "addressreviewbody", lhsADDRESSREVIEWBODY), LocatorUtils.property(thatLocator, "addressreviewbody", rhsADDRESSREVIEWBODY), lhsADDRESSREVIEWBODY, rhsADDRESSREVIEWBODY)) {
                return false;
            }
        }
        {
            ContactReview lhsADDRESSMEDIATIONBODY;
            lhsADDRESSMEDIATIONBODY = this.getADDRESSMEDIATIONBODY();
            ContactReview rhsADDRESSMEDIATIONBODY;
            rhsADDRESSMEDIATIONBODY = that.getADDRESSMEDIATIONBODY();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "addressmediationbody", lhsADDRESSMEDIATIONBODY), LocatorUtils.property(thatLocator, "addressmediationbody", rhsADDRESSMEDIATIONBODY), lhsADDRESSMEDIATIONBODY, rhsADDRESSMEDIATIONBODY)) {
                return false;
            }
        }
        {
            TextFtMultiLines lhsREVIEWPROCEDURE;
            lhsREVIEWPROCEDURE = this.getREVIEWPROCEDURE();
            TextFtMultiLines rhsREVIEWPROCEDURE;
            rhsREVIEWPROCEDURE = that.getREVIEWPROCEDURE();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "reviewprocedure", lhsREVIEWPROCEDURE), LocatorUtils.property(thatLocator, "reviewprocedure", rhsREVIEWPROCEDURE), lhsREVIEWPROCEDURE, rhsREVIEWPROCEDURE)) {
                return false;
            }
        }
        {
            ContactReview lhsADDRESSREVIEWINFO;
            lhsADDRESSREVIEWINFO = this.getADDRESSREVIEWINFO();
            ContactReview rhsADDRESSREVIEWINFO;
            rhsADDRESSREVIEWINFO = that.getADDRESSREVIEWINFO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "addressreviewinfo", lhsADDRESSREVIEWINFO), LocatorUtils.property(thatLocator, "addressreviewinfo", rhsADDRESSREVIEWINFO), lhsADDRESSREVIEWINFO, rhsADDRESSREVIEWINFO)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsDATEDISPATCHNOTICE;
            lhsDATEDISPATCHNOTICE = this.getDATEDISPATCHNOTICE();
            XMLGregorianCalendar rhsDATEDISPATCHNOTICE;
            rhsDATEDISPATCHNOTICE = that.getDATEDISPATCHNOTICE();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "datedispatchnotice", lhsDATEDISPATCHNOTICE), LocatorUtils.property(thatLocator, "datedispatchnotice", rhsDATEDISPATCHNOTICE), lhsDATEDISPATCHNOTICE, rhsDATEDISPATCHNOTICE)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            Empty theNORECURRENTPROCUREMENT;
            theNORECURRENTPROCUREMENT = this.getNORECURRENTPROCUREMENT();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "norecurrentprocurement", theNORECURRENTPROCUREMENT), currentHashCode, theNORECURRENTPROCUREMENT);
        }
        {
            Empty theRECURRENTPROCUREMENT;
            theRECURRENTPROCUREMENT = this.getRECURRENTPROCUREMENT();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recurrentprocurement", theRECURRENTPROCUREMENT), currentHashCode, theRECURRENTPROCUREMENT);
        }
        {
            TextFtMultiLines theESTIMATEDTIMING;
            theESTIMATEDTIMING = this.getESTIMATEDTIMING();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "estimatedtiming", theESTIMATEDTIMING), currentHashCode, theESTIMATEDTIMING);
        }
        {
            Empty theEORDERING;
            theEORDERING = this.getEORDERING();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "eordering", theEORDERING), currentHashCode, theEORDERING);
        }
        {
            Empty theEINVOICING;
            theEINVOICING = this.getEINVOICING();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "einvoicing", theEINVOICING), currentHashCode, theEINVOICING);
        }
        {
            Empty theEPAYMENT;
            theEPAYMENT = this.getEPAYMENT();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "epayment", theEPAYMENT), currentHashCode, theEPAYMENT);
        }
        {
            TextFtMultiLines theINFOADD;
            theINFOADD = this.getINFOADD();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "infoadd", theINFOADD), currentHashCode, theINFOADD);
        }
        {
            ContactReview theADDRESSREVIEWBODY;
            theADDRESSREVIEWBODY = this.getADDRESSREVIEWBODY();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "addressreviewbody", theADDRESSREVIEWBODY), currentHashCode, theADDRESSREVIEWBODY);
        }
        {
            ContactReview theADDRESSMEDIATIONBODY;
            theADDRESSMEDIATIONBODY = this.getADDRESSMEDIATIONBODY();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "addressmediationbody", theADDRESSMEDIATIONBODY), currentHashCode, theADDRESSMEDIATIONBODY);
        }
        {
            TextFtMultiLines theREVIEWPROCEDURE;
            theREVIEWPROCEDURE = this.getREVIEWPROCEDURE();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "reviewprocedure", theREVIEWPROCEDURE), currentHashCode, theREVIEWPROCEDURE);
        }
        {
            ContactReview theADDRESSREVIEWINFO;
            theADDRESSREVIEWINFO = this.getADDRESSREVIEWINFO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "addressreviewinfo", theADDRESSREVIEWINFO), currentHashCode, theADDRESSREVIEWINFO);
        }
        {
            XMLGregorianCalendar theDATEDISPATCHNOTICE;
            theDATEDISPATCHNOTICE = this.getDATEDISPATCHNOTICE();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "datedispatchnotice", theDATEDISPATCHNOTICE), currentHashCode, theDATEDISPATCHNOTICE);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            Empty theNORECURRENTPROCUREMENT;
            theNORECURRENTPROCUREMENT = this.getNORECURRENTPROCUREMENT();
            strategy.appendField(locator, this, "norecurrentprocurement", buffer, theNORECURRENTPROCUREMENT);
        }
        {
            Empty theRECURRENTPROCUREMENT;
            theRECURRENTPROCUREMENT = this.getRECURRENTPROCUREMENT();
            strategy.appendField(locator, this, "recurrentprocurement", buffer, theRECURRENTPROCUREMENT);
        }
        {
            TextFtMultiLines theESTIMATEDTIMING;
            theESTIMATEDTIMING = this.getESTIMATEDTIMING();
            strategy.appendField(locator, this, "estimatedtiming", buffer, theESTIMATEDTIMING);
        }
        {
            Empty theEORDERING;
            theEORDERING = this.getEORDERING();
            strategy.appendField(locator, this, "eordering", buffer, theEORDERING);
        }
        {
            Empty theEINVOICING;
            theEINVOICING = this.getEINVOICING();
            strategy.appendField(locator, this, "einvoicing", buffer, theEINVOICING);
        }
        {
            Empty theEPAYMENT;
            theEPAYMENT = this.getEPAYMENT();
            strategy.appendField(locator, this, "epayment", buffer, theEPAYMENT);
        }
        {
            TextFtMultiLines theINFOADD;
            theINFOADD = this.getINFOADD();
            strategy.appendField(locator, this, "infoadd", buffer, theINFOADD);
        }
        {
            ContactReview theADDRESSREVIEWBODY;
            theADDRESSREVIEWBODY = this.getADDRESSREVIEWBODY();
            strategy.appendField(locator, this, "addressreviewbody", buffer, theADDRESSREVIEWBODY);
        }
        {
            ContactReview theADDRESSMEDIATIONBODY;
            theADDRESSMEDIATIONBODY = this.getADDRESSMEDIATIONBODY();
            strategy.appendField(locator, this, "addressmediationbody", buffer, theADDRESSMEDIATIONBODY);
        }
        {
            TextFtMultiLines theREVIEWPROCEDURE;
            theREVIEWPROCEDURE = this.getREVIEWPROCEDURE();
            strategy.appendField(locator, this, "reviewprocedure", buffer, theREVIEWPROCEDURE);
        }
        {
            ContactReview theADDRESSREVIEWINFO;
            theADDRESSREVIEWINFO = this.getADDRESSREVIEWINFO();
            strategy.appendField(locator, this, "addressreviewinfo", buffer, theADDRESSREVIEWINFO);
        }
        {
            XMLGregorianCalendar theDATEDISPATCHNOTICE;
            theDATEDISPATCHNOTICE = this.getDATEDISPATCHNOTICE();
            strategy.appendField(locator, this, "datedispatchnotice", buffer, theDATEDISPATCHNOTICE);
        }
        return buffer;
    }

}
