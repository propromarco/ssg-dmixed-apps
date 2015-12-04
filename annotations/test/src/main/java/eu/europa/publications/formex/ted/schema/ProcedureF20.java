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
 * <p>Java class for procedure_f20 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="procedure_f20">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}NOTICE_NUMBER_OJ"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "procedure_f20", propOrder = {
    "noticenumberoj"
})
public class ProcedureF20
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "NOTICE_NUMBER_OJ", required = true)
    protected String noticenumberoj;

    /**
     * Gets the value of the noticenumberoj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOTICENUMBEROJ() {
        return noticenumberoj;
    }

    /**
     * Sets the value of the noticenumberoj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOTICENUMBEROJ(String value) {
        this.noticenumberoj = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ProcedureF20)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ProcedureF20 that = ((ProcedureF20) object);
        {
            String lhsNOTICENUMBEROJ;
            lhsNOTICENUMBEROJ = this.getNOTICENUMBEROJ();
            String rhsNOTICENUMBEROJ;
            rhsNOTICENUMBEROJ = that.getNOTICENUMBEROJ();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "noticenumberoj", lhsNOTICENUMBEROJ), LocatorUtils.property(thatLocator, "noticenumberoj", rhsNOTICENUMBEROJ), lhsNOTICENUMBEROJ, rhsNOTICENUMBEROJ)) {
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
            String theNOTICENUMBEROJ;
            theNOTICENUMBEROJ = this.getNOTICENUMBEROJ();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "noticenumberoj", theNOTICENUMBEROJ), currentHashCode, theNOTICENUMBEROJ);
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
            String theNOTICENUMBEROJ;
            theNOTICENUMBEROJ = this.getNOTICENUMBEROJ();
            strategy.appendField(locator, this, "noticenumberoj", buffer, theNOTICENUMBEROJ);
        }
        return buffer;
    }

}
