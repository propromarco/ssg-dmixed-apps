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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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
 * <p>Java class for no_award complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="no_award">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}PROCUREMENT_DISCONTINUED"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}PROCUREMENT_UNSUCCESSFUL"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "no_award", propOrder = {
    "procurementunsuccessful",
    "procurementdiscontinued"
})
@XmlRootElement(name = "NO_AWARDED_CONTRACT")
public class NOAWARDEDCONTRACT
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "PROCUREMENT_UNSUCCESSFUL")
    protected Empty procurementunsuccessful;
    @XmlElement(name = "PROCUREMENT_DISCONTINUED")
    protected PROCUREMENTDISCONTINUED procurementdiscontinued;

    /**
     * Gets the value of the procurementunsuccessful property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getPROCUREMENTUNSUCCESSFUL() {
        return procurementunsuccessful;
    }

    /**
     * Sets the value of the procurementunsuccessful property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setPROCUREMENTUNSUCCESSFUL(Empty value) {
        this.procurementunsuccessful = value;
    }

    /**
     * Gets the value of the procurementdiscontinued property.
     * 
     * @return
     *     possible object is
     *     {@link PROCUREMENTDISCONTINUED }
     *     
     */
    public PROCUREMENTDISCONTINUED getPROCUREMENTDISCONTINUED() {
        return procurementdiscontinued;
    }

    /**
     * Sets the value of the procurementdiscontinued property.
     * 
     * @param value
     *     allowed object is
     *     {@link PROCUREMENTDISCONTINUED }
     *     
     */
    public void setPROCUREMENTDISCONTINUED(PROCUREMENTDISCONTINUED value) {
        this.procurementdiscontinued = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof NOAWARDEDCONTRACT)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final NOAWARDEDCONTRACT that = ((NOAWARDEDCONTRACT) object);
        {
            Empty lhsPROCUREMENTUNSUCCESSFUL;
            lhsPROCUREMENTUNSUCCESSFUL = this.getPROCUREMENTUNSUCCESSFUL();
            Empty rhsPROCUREMENTUNSUCCESSFUL;
            rhsPROCUREMENTUNSUCCESSFUL = that.getPROCUREMENTUNSUCCESSFUL();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "procurementunsuccessful", lhsPROCUREMENTUNSUCCESSFUL), LocatorUtils.property(thatLocator, "procurementunsuccessful", rhsPROCUREMENTUNSUCCESSFUL), lhsPROCUREMENTUNSUCCESSFUL, rhsPROCUREMENTUNSUCCESSFUL)) {
                return false;
            }
        }
        {
            PROCUREMENTDISCONTINUED lhsPROCUREMENTDISCONTINUED;
            lhsPROCUREMENTDISCONTINUED = this.getPROCUREMENTDISCONTINUED();
            PROCUREMENTDISCONTINUED rhsPROCUREMENTDISCONTINUED;
            rhsPROCUREMENTDISCONTINUED = that.getPROCUREMENTDISCONTINUED();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "procurementdiscontinued", lhsPROCUREMENTDISCONTINUED), LocatorUtils.property(thatLocator, "procurementdiscontinued", rhsPROCUREMENTDISCONTINUED), lhsPROCUREMENTDISCONTINUED, rhsPROCUREMENTDISCONTINUED)) {
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
            Empty thePROCUREMENTUNSUCCESSFUL;
            thePROCUREMENTUNSUCCESSFUL = this.getPROCUREMENTUNSUCCESSFUL();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "procurementunsuccessful", thePROCUREMENTUNSUCCESSFUL), currentHashCode, thePROCUREMENTUNSUCCESSFUL);
        }
        {
            PROCUREMENTDISCONTINUED thePROCUREMENTDISCONTINUED;
            thePROCUREMENTDISCONTINUED = this.getPROCUREMENTDISCONTINUED();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "procurementdiscontinued", thePROCUREMENTDISCONTINUED), currentHashCode, thePROCUREMENTDISCONTINUED);
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
            Empty thePROCUREMENTUNSUCCESSFUL;
            thePROCUREMENTUNSUCCESSFUL = this.getPROCUREMENTUNSUCCESSFUL();
            strategy.appendField(locator, this, "procurementunsuccessful", buffer, thePROCUREMENTUNSUCCESSFUL);
        }
        {
            PROCUREMENTDISCONTINUED thePROCUREMENTDISCONTINUED;
            thePROCUREMENTDISCONTINUED = this.getPROCUREMENTDISCONTINUED();
            strategy.appendField(locator, this, "procurementdiscontinued", buffer, thePROCUREMENTDISCONTINUED);
        }
        return buffer;
    }

}