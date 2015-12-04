//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.04 at 01:40:50 PM MEZ 
//


package eu.europa.publications.formex.ted.schema;

import java.util.ArrayList;
import java.util.List;
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
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}CPV_MAIN"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}CPV_ADDITIONAL" maxOccurs="99" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cpvmain",
    "cpvadditionals"
})
@XmlRootElement(name = "CPV")
public class CPV
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "CPV_MAIN", required = true)
    protected CpvSet cpvmain;
    @XmlElement(name = "CPV_ADDITIONAL")
    protected List<CpvSet> cpvadditionals;

    /**
     * Gets the value of the cpvmain property.
     * 
     * @return
     *     possible object is
     *     {@link CpvSet }
     *     
     */
    public CpvSet getCPVMAIN() {
        return cpvmain;
    }

    /**
     * Sets the value of the cpvmain property.
     * 
     * @param value
     *     allowed object is
     *     {@link CpvSet }
     *     
     */
    public void setCPVMAIN(CpvSet value) {
        this.cpvmain = value;
    }

    /**
     * Gets the value of the cpvadditionals property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cpvadditionals property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCPVADDITIONALS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CpvSet }
     * 
     * 
     */
    public List<CpvSet> getCPVADDITIONALS() {
        if (cpvadditionals == null) {
            cpvadditionals = new ArrayList<CpvSet>();
        }
        return this.cpvadditionals;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CPV)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CPV that = ((CPV) object);
        {
            CpvSet lhsCPVMAIN;
            lhsCPVMAIN = this.getCPVMAIN();
            CpvSet rhsCPVMAIN;
            rhsCPVMAIN = that.getCPVMAIN();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cpvmain", lhsCPVMAIN), LocatorUtils.property(thatLocator, "cpvmain", rhsCPVMAIN), lhsCPVMAIN, rhsCPVMAIN)) {
                return false;
            }
        }
        {
            List<CpvSet> lhsCPVADDITIONALS;
            lhsCPVADDITIONALS = (((this.cpvadditionals!= null)&&(!this.cpvadditionals.isEmpty()))?this.getCPVADDITIONALS():null);
            List<CpvSet> rhsCPVADDITIONALS;
            rhsCPVADDITIONALS = (((that.cpvadditionals!= null)&&(!that.cpvadditionals.isEmpty()))?that.getCPVADDITIONALS():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cpvadditionals", lhsCPVADDITIONALS), LocatorUtils.property(thatLocator, "cpvadditionals", rhsCPVADDITIONALS), lhsCPVADDITIONALS, rhsCPVADDITIONALS)) {
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
            CpvSet theCPVMAIN;
            theCPVMAIN = this.getCPVMAIN();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cpvmain", theCPVMAIN), currentHashCode, theCPVMAIN);
        }
        {
            List<CpvSet> theCPVADDITIONALS;
            theCPVADDITIONALS = (((this.cpvadditionals!= null)&&(!this.cpvadditionals.isEmpty()))?this.getCPVADDITIONALS():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cpvadditionals", theCPVADDITIONALS), currentHashCode, theCPVADDITIONALS);
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
            CpvSet theCPVMAIN;
            theCPVMAIN = this.getCPVMAIN();
            strategy.appendField(locator, this, "cpvmain", buffer, theCPVMAIN);
        }
        {
            List<CpvSet> theCPVADDITIONALS;
            theCPVADDITIONALS = (((this.cpvadditionals!= null)&&(!this.cpvadditionals.isEmpty()))?this.getCPVADDITIONALS():null);
            strategy.appendField(locator, this, "cpvadditionals", buffer, theCPVADDITIONALS);
        }
        return buffer;
    }

}
