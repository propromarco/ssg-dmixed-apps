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
 * Section IV: PROCEDURE
 * 
 * <p>Java class for procedure_f04 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="procedure_f04">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}PT_RESTRICTED"/>
 *           &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}PT_NEGOTIATED_WITH_PRIOR_CALL"/>
 *         &lt;/choice>
 *         &lt;element name="FRAMEWORK" type="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}framework_info" minOccurs="0"/>
 *         &lt;group ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}dps_purchasers" minOccurs="0"/>
 *         &lt;group ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}eauction" minOccurs="0"/>
 *         &lt;group ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}gpa"/>
 *         &lt;group ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}receipt_tenders" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}LANGUAGES" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}DATE_AWARD_SCHEDULED" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "procedure_f04", propOrder = {
    "ptnegotiatedwithpriorcall",
    "ptrestricted",
    "framework",
    "dps",
    "dpsadditionalpurchasers",
    "eauctionused",
    "infoaddeauction",
    "nocontractcoveredgpa",
    "contractcoveredgpa",
    "datereceipttenders",
    "timereceipttenders",
    "languages",
    "dateawardscheduled"
})
public class ProcedureF04
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "PT_NEGOTIATED_WITH_PRIOR_CALL")
    protected Empty ptnegotiatedwithpriorcall;
    @XmlElement(name = "PT_RESTRICTED")
    protected Empty ptrestricted;
    @XmlElement(name = "FRAMEWORK")
    protected FrameworkInfo framework;
    @XmlElement(name = "DPS")
    protected Empty dps;
    @XmlElement(name = "DPS_ADDITIONAL_PURCHASERS")
    protected Empty dpsadditionalpurchasers;
    @XmlElement(name = "EAUCTION_USED")
    protected Empty eauctionused;
    @XmlElement(name = "INFO_ADD_EAUCTION")
    protected TextFtMultiLines infoaddeauction;
    @XmlElement(name = "NO_CONTRACT_COVERED_GPA")
    protected Empty nocontractcoveredgpa;
    @XmlElement(name = "CONTRACT_COVERED_GPA")
    protected Empty contractcoveredgpa;
    @XmlElement(name = "DATE_RECEIPT_TENDERS")
    protected XMLGregorianCalendar datereceipttenders;
    @XmlElement(name = "TIME_RECEIPT_TENDERS")
    protected String timereceipttenders;
    @XmlElement(name = "LANGUAGES")
    protected LANGUAGES languages;
    @XmlElement(name = "DATE_AWARD_SCHEDULED")
    protected XMLGregorianCalendar dateawardscheduled;

    /**
     * Gets the value of the ptnegotiatedwithpriorcall property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getPTNEGOTIATEDWITHPRIORCALL() {
        return ptnegotiatedwithpriorcall;
    }

    /**
     * Sets the value of the ptnegotiatedwithpriorcall property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setPTNEGOTIATEDWITHPRIORCALL(Empty value) {
        this.ptnegotiatedwithpriorcall = value;
    }

    /**
     * Gets the value of the ptrestricted property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getPTRESTRICTED() {
        return ptrestricted;
    }

    /**
     * Sets the value of the ptrestricted property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setPTRESTRICTED(Empty value) {
        this.ptrestricted = value;
    }

    /**
     * Gets the value of the framework property.
     * 
     * @return
     *     possible object is
     *     {@link FrameworkInfo }
     *     
     */
    public FrameworkInfo getFRAMEWORK() {
        return framework;
    }

    /**
     * Sets the value of the framework property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrameworkInfo }
     *     
     */
    public void setFRAMEWORK(FrameworkInfo value) {
        this.framework = value;
    }

    /**
     * Gets the value of the dps property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getDPS() {
        return dps;
    }

    /**
     * Sets the value of the dps property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setDPS(Empty value) {
        this.dps = value;
    }

    /**
     * Gets the value of the dpsadditionalpurchasers property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getDPSADDITIONALPURCHASERS() {
        return dpsadditionalpurchasers;
    }

    /**
     * Sets the value of the dpsadditionalpurchasers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setDPSADDITIONALPURCHASERS(Empty value) {
        this.dpsadditionalpurchasers = value;
    }

    /**
     * Gets the value of the eauctionused property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getEAUCTIONUSED() {
        return eauctionused;
    }

    /**
     * Sets the value of the eauctionused property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setEAUCTIONUSED(Empty value) {
        this.eauctionused = value;
    }

    /**
     * Gets the value of the infoaddeauction property.
     * 
     * @return
     *     possible object is
     *     {@link TextFtMultiLines }
     *     
     */
    public TextFtMultiLines getINFOADDEAUCTION() {
        return infoaddeauction;
    }

    /**
     * Sets the value of the infoaddeauction property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextFtMultiLines }
     *     
     */
    public void setINFOADDEAUCTION(TextFtMultiLines value) {
        this.infoaddeauction = value;
    }

    /**
     * Gets the value of the nocontractcoveredgpa property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getNOCONTRACTCOVEREDGPA() {
        return nocontractcoveredgpa;
    }

    /**
     * Sets the value of the nocontractcoveredgpa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setNOCONTRACTCOVEREDGPA(Empty value) {
        this.nocontractcoveredgpa = value;
    }

    /**
     * Gets the value of the contractcoveredgpa property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getCONTRACTCOVEREDGPA() {
        return contractcoveredgpa;
    }

    /**
     * Sets the value of the contractcoveredgpa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setCONTRACTCOVEREDGPA(Empty value) {
        this.contractcoveredgpa = value;
    }

    /**
     * Gets the value of the datereceipttenders property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDATERECEIPTTENDERS() {
        return datereceipttenders;
    }

    /**
     * Sets the value of the datereceipttenders property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDATERECEIPTTENDERS(XMLGregorianCalendar value) {
        this.datereceipttenders = value;
    }

    /**
     * Gets the value of the timereceipttenders property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIMERECEIPTTENDERS() {
        return timereceipttenders;
    }

    /**
     * Sets the value of the timereceipttenders property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIMERECEIPTTENDERS(String value) {
        this.timereceipttenders = value;
    }

    /**
     * Gets the value of the languages property.
     * 
     * @return
     *     possible object is
     *     {@link LANGUAGES }
     *     
     */
    public LANGUAGES getLANGUAGES() {
        return languages;
    }

    /**
     * Sets the value of the languages property.
     * 
     * @param value
     *     allowed object is
     *     {@link LANGUAGES }
     *     
     */
    public void setLANGUAGES(LANGUAGES value) {
        this.languages = value;
    }

    /**
     * Gets the value of the dateawardscheduled property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDATEAWARDSCHEDULED() {
        return dateawardscheduled;
    }

    /**
     * Sets the value of the dateawardscheduled property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDATEAWARDSCHEDULED(XMLGregorianCalendar value) {
        this.dateawardscheduled = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ProcedureF04)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ProcedureF04 that = ((ProcedureF04) object);
        {
            Empty lhsPTNEGOTIATEDWITHPRIORCALL;
            lhsPTNEGOTIATEDWITHPRIORCALL = this.getPTNEGOTIATEDWITHPRIORCALL();
            Empty rhsPTNEGOTIATEDWITHPRIORCALL;
            rhsPTNEGOTIATEDWITHPRIORCALL = that.getPTNEGOTIATEDWITHPRIORCALL();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ptnegotiatedwithpriorcall", lhsPTNEGOTIATEDWITHPRIORCALL), LocatorUtils.property(thatLocator, "ptnegotiatedwithpriorcall", rhsPTNEGOTIATEDWITHPRIORCALL), lhsPTNEGOTIATEDWITHPRIORCALL, rhsPTNEGOTIATEDWITHPRIORCALL)) {
                return false;
            }
        }
        {
            Empty lhsPTRESTRICTED;
            lhsPTRESTRICTED = this.getPTRESTRICTED();
            Empty rhsPTRESTRICTED;
            rhsPTRESTRICTED = that.getPTRESTRICTED();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ptrestricted", lhsPTRESTRICTED), LocatorUtils.property(thatLocator, "ptrestricted", rhsPTRESTRICTED), lhsPTRESTRICTED, rhsPTRESTRICTED)) {
                return false;
            }
        }
        {
            FrameworkInfo lhsFRAMEWORK;
            lhsFRAMEWORK = this.getFRAMEWORK();
            FrameworkInfo rhsFRAMEWORK;
            rhsFRAMEWORK = that.getFRAMEWORK();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "framework", lhsFRAMEWORK), LocatorUtils.property(thatLocator, "framework", rhsFRAMEWORK), lhsFRAMEWORK, rhsFRAMEWORK)) {
                return false;
            }
        }
        {
            Empty lhsDPS;
            lhsDPS = this.getDPS();
            Empty rhsDPS;
            rhsDPS = that.getDPS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dps", lhsDPS), LocatorUtils.property(thatLocator, "dps", rhsDPS), lhsDPS, rhsDPS)) {
                return false;
            }
        }
        {
            Empty lhsDPSADDITIONALPURCHASERS;
            lhsDPSADDITIONALPURCHASERS = this.getDPSADDITIONALPURCHASERS();
            Empty rhsDPSADDITIONALPURCHASERS;
            rhsDPSADDITIONALPURCHASERS = that.getDPSADDITIONALPURCHASERS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dpsadditionalpurchasers", lhsDPSADDITIONALPURCHASERS), LocatorUtils.property(thatLocator, "dpsadditionalpurchasers", rhsDPSADDITIONALPURCHASERS), lhsDPSADDITIONALPURCHASERS, rhsDPSADDITIONALPURCHASERS)) {
                return false;
            }
        }
        {
            Empty lhsEAUCTIONUSED;
            lhsEAUCTIONUSED = this.getEAUCTIONUSED();
            Empty rhsEAUCTIONUSED;
            rhsEAUCTIONUSED = that.getEAUCTIONUSED();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "eauctionused", lhsEAUCTIONUSED), LocatorUtils.property(thatLocator, "eauctionused", rhsEAUCTIONUSED), lhsEAUCTIONUSED, rhsEAUCTIONUSED)) {
                return false;
            }
        }
        {
            TextFtMultiLines lhsINFOADDEAUCTION;
            lhsINFOADDEAUCTION = this.getINFOADDEAUCTION();
            TextFtMultiLines rhsINFOADDEAUCTION;
            rhsINFOADDEAUCTION = that.getINFOADDEAUCTION();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "infoaddeauction", lhsINFOADDEAUCTION), LocatorUtils.property(thatLocator, "infoaddeauction", rhsINFOADDEAUCTION), lhsINFOADDEAUCTION, rhsINFOADDEAUCTION)) {
                return false;
            }
        }
        {
            Empty lhsNOCONTRACTCOVEREDGPA;
            lhsNOCONTRACTCOVEREDGPA = this.getNOCONTRACTCOVEREDGPA();
            Empty rhsNOCONTRACTCOVEREDGPA;
            rhsNOCONTRACTCOVEREDGPA = that.getNOCONTRACTCOVEREDGPA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nocontractcoveredgpa", lhsNOCONTRACTCOVEREDGPA), LocatorUtils.property(thatLocator, "nocontractcoveredgpa", rhsNOCONTRACTCOVEREDGPA), lhsNOCONTRACTCOVEREDGPA, rhsNOCONTRACTCOVEREDGPA)) {
                return false;
            }
        }
        {
            Empty lhsCONTRACTCOVEREDGPA;
            lhsCONTRACTCOVEREDGPA = this.getCONTRACTCOVEREDGPA();
            Empty rhsCONTRACTCOVEREDGPA;
            rhsCONTRACTCOVEREDGPA = that.getCONTRACTCOVEREDGPA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contractcoveredgpa", lhsCONTRACTCOVEREDGPA), LocatorUtils.property(thatLocator, "contractcoveredgpa", rhsCONTRACTCOVEREDGPA), lhsCONTRACTCOVEREDGPA, rhsCONTRACTCOVEREDGPA)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsDATERECEIPTTENDERS;
            lhsDATERECEIPTTENDERS = this.getDATERECEIPTTENDERS();
            XMLGregorianCalendar rhsDATERECEIPTTENDERS;
            rhsDATERECEIPTTENDERS = that.getDATERECEIPTTENDERS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "datereceipttenders", lhsDATERECEIPTTENDERS), LocatorUtils.property(thatLocator, "datereceipttenders", rhsDATERECEIPTTENDERS), lhsDATERECEIPTTENDERS, rhsDATERECEIPTTENDERS)) {
                return false;
            }
        }
        {
            String lhsTIMERECEIPTTENDERS;
            lhsTIMERECEIPTTENDERS = this.getTIMERECEIPTTENDERS();
            String rhsTIMERECEIPTTENDERS;
            rhsTIMERECEIPTTENDERS = that.getTIMERECEIPTTENDERS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "timereceipttenders", lhsTIMERECEIPTTENDERS), LocatorUtils.property(thatLocator, "timereceipttenders", rhsTIMERECEIPTTENDERS), lhsTIMERECEIPTTENDERS, rhsTIMERECEIPTTENDERS)) {
                return false;
            }
        }
        {
            LANGUAGES lhsLANGUAGES;
            lhsLANGUAGES = this.getLANGUAGES();
            LANGUAGES rhsLANGUAGES;
            rhsLANGUAGES = that.getLANGUAGES();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "languages", lhsLANGUAGES), LocatorUtils.property(thatLocator, "languages", rhsLANGUAGES), lhsLANGUAGES, rhsLANGUAGES)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsDATEAWARDSCHEDULED;
            lhsDATEAWARDSCHEDULED = this.getDATEAWARDSCHEDULED();
            XMLGregorianCalendar rhsDATEAWARDSCHEDULED;
            rhsDATEAWARDSCHEDULED = that.getDATEAWARDSCHEDULED();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dateawardscheduled", lhsDATEAWARDSCHEDULED), LocatorUtils.property(thatLocator, "dateawardscheduled", rhsDATEAWARDSCHEDULED), lhsDATEAWARDSCHEDULED, rhsDATEAWARDSCHEDULED)) {
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
            Empty thePTNEGOTIATEDWITHPRIORCALL;
            thePTNEGOTIATEDWITHPRIORCALL = this.getPTNEGOTIATEDWITHPRIORCALL();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ptnegotiatedwithpriorcall", thePTNEGOTIATEDWITHPRIORCALL), currentHashCode, thePTNEGOTIATEDWITHPRIORCALL);
        }
        {
            Empty thePTRESTRICTED;
            thePTRESTRICTED = this.getPTRESTRICTED();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ptrestricted", thePTRESTRICTED), currentHashCode, thePTRESTRICTED);
        }
        {
            FrameworkInfo theFRAMEWORK;
            theFRAMEWORK = this.getFRAMEWORK();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "framework", theFRAMEWORK), currentHashCode, theFRAMEWORK);
        }
        {
            Empty theDPS;
            theDPS = this.getDPS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dps", theDPS), currentHashCode, theDPS);
        }
        {
            Empty theDPSADDITIONALPURCHASERS;
            theDPSADDITIONALPURCHASERS = this.getDPSADDITIONALPURCHASERS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dpsadditionalpurchasers", theDPSADDITIONALPURCHASERS), currentHashCode, theDPSADDITIONALPURCHASERS);
        }
        {
            Empty theEAUCTIONUSED;
            theEAUCTIONUSED = this.getEAUCTIONUSED();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "eauctionused", theEAUCTIONUSED), currentHashCode, theEAUCTIONUSED);
        }
        {
            TextFtMultiLines theINFOADDEAUCTION;
            theINFOADDEAUCTION = this.getINFOADDEAUCTION();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "infoaddeauction", theINFOADDEAUCTION), currentHashCode, theINFOADDEAUCTION);
        }
        {
            Empty theNOCONTRACTCOVEREDGPA;
            theNOCONTRACTCOVEREDGPA = this.getNOCONTRACTCOVEREDGPA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nocontractcoveredgpa", theNOCONTRACTCOVEREDGPA), currentHashCode, theNOCONTRACTCOVEREDGPA);
        }
        {
            Empty theCONTRACTCOVEREDGPA;
            theCONTRACTCOVEREDGPA = this.getCONTRACTCOVEREDGPA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contractcoveredgpa", theCONTRACTCOVEREDGPA), currentHashCode, theCONTRACTCOVEREDGPA);
        }
        {
            XMLGregorianCalendar theDATERECEIPTTENDERS;
            theDATERECEIPTTENDERS = this.getDATERECEIPTTENDERS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "datereceipttenders", theDATERECEIPTTENDERS), currentHashCode, theDATERECEIPTTENDERS);
        }
        {
            String theTIMERECEIPTTENDERS;
            theTIMERECEIPTTENDERS = this.getTIMERECEIPTTENDERS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "timereceipttenders", theTIMERECEIPTTENDERS), currentHashCode, theTIMERECEIPTTENDERS);
        }
        {
            LANGUAGES theLANGUAGES;
            theLANGUAGES = this.getLANGUAGES();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "languages", theLANGUAGES), currentHashCode, theLANGUAGES);
        }
        {
            XMLGregorianCalendar theDATEAWARDSCHEDULED;
            theDATEAWARDSCHEDULED = this.getDATEAWARDSCHEDULED();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dateawardscheduled", theDATEAWARDSCHEDULED), currentHashCode, theDATEAWARDSCHEDULED);
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
            Empty thePTNEGOTIATEDWITHPRIORCALL;
            thePTNEGOTIATEDWITHPRIORCALL = this.getPTNEGOTIATEDWITHPRIORCALL();
            strategy.appendField(locator, this, "ptnegotiatedwithpriorcall", buffer, thePTNEGOTIATEDWITHPRIORCALL);
        }
        {
            Empty thePTRESTRICTED;
            thePTRESTRICTED = this.getPTRESTRICTED();
            strategy.appendField(locator, this, "ptrestricted", buffer, thePTRESTRICTED);
        }
        {
            FrameworkInfo theFRAMEWORK;
            theFRAMEWORK = this.getFRAMEWORK();
            strategy.appendField(locator, this, "framework", buffer, theFRAMEWORK);
        }
        {
            Empty theDPS;
            theDPS = this.getDPS();
            strategy.appendField(locator, this, "dps", buffer, theDPS);
        }
        {
            Empty theDPSADDITIONALPURCHASERS;
            theDPSADDITIONALPURCHASERS = this.getDPSADDITIONALPURCHASERS();
            strategy.appendField(locator, this, "dpsadditionalpurchasers", buffer, theDPSADDITIONALPURCHASERS);
        }
        {
            Empty theEAUCTIONUSED;
            theEAUCTIONUSED = this.getEAUCTIONUSED();
            strategy.appendField(locator, this, "eauctionused", buffer, theEAUCTIONUSED);
        }
        {
            TextFtMultiLines theINFOADDEAUCTION;
            theINFOADDEAUCTION = this.getINFOADDEAUCTION();
            strategy.appendField(locator, this, "infoaddeauction", buffer, theINFOADDEAUCTION);
        }
        {
            Empty theNOCONTRACTCOVEREDGPA;
            theNOCONTRACTCOVEREDGPA = this.getNOCONTRACTCOVEREDGPA();
            strategy.appendField(locator, this, "nocontractcoveredgpa", buffer, theNOCONTRACTCOVEREDGPA);
        }
        {
            Empty theCONTRACTCOVEREDGPA;
            theCONTRACTCOVEREDGPA = this.getCONTRACTCOVEREDGPA();
            strategy.appendField(locator, this, "contractcoveredgpa", buffer, theCONTRACTCOVEREDGPA);
        }
        {
            XMLGregorianCalendar theDATERECEIPTTENDERS;
            theDATERECEIPTTENDERS = this.getDATERECEIPTTENDERS();
            strategy.appendField(locator, this, "datereceipttenders", buffer, theDATERECEIPTTENDERS);
        }
        {
            String theTIMERECEIPTTENDERS;
            theTIMERECEIPTTENDERS = this.getTIMERECEIPTTENDERS();
            strategy.appendField(locator, this, "timereceipttenders", buffer, theTIMERECEIPTTENDERS);
        }
        {
            LANGUAGES theLANGUAGES;
            theLANGUAGES = this.getLANGUAGES();
            strategy.appendField(locator, this, "languages", buffer, theLANGUAGES);
        }
        {
            XMLGregorianCalendar theDATEAWARDSCHEDULED;
            theDATEAWARDSCHEDULED = this.getDATEAWARDSCHEDULED();
            strategy.appendField(locator, this, "dateawardscheduled", buffer, theDATEAWARDSCHEDULED);
        }
        return buffer;
    }

}
