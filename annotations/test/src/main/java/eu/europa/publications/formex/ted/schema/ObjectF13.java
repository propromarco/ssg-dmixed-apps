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
 * <p>Java class for object_f13 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="object_f13">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}CPV_ADDITIONAL" maxOccurs="99" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}SHORT_DESCR"/>
 *         &lt;group ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}eu_union_funds"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "object_f13", propOrder = {
    "cpvadditionals",
    "shortdescr",
    "noeuprogrrelated",
    "euprogrrelated"
})
public class ObjectF13
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "CPV_ADDITIONAL")
    protected List<CpvSet> cpvadditionals;
    @XmlElement(name = "SHORT_DESCR", required = true)
    protected TextFtMultiLines shortdescr;
    @XmlElement(name = "NO_EU_PROGR_RELATED")
    protected Empty noeuprogrrelated;
    @XmlElement(name = "EU_PROGR_RELATED")
    protected String euprogrrelated;

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

    /**
     * Gets the value of the shortdescr property.
     * 
     * @return
     *     possible object is
     *     {@link TextFtMultiLines }
     *     
     */
    public TextFtMultiLines getSHORTDESCR() {
        return shortdescr;
    }

    /**
     * Sets the value of the shortdescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextFtMultiLines }
     *     
     */
    public void setSHORTDESCR(TextFtMultiLines value) {
        this.shortdescr = value;
    }

    /**
     * Gets the value of the noeuprogrrelated property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getNOEUPROGRRELATED() {
        return noeuprogrrelated;
    }

    /**
     * Sets the value of the noeuprogrrelated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setNOEUPROGRRELATED(Empty value) {
        this.noeuprogrrelated = value;
    }

    /**
     * Gets the value of the euprogrrelated property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEUPROGRRELATED() {
        return euprogrrelated;
    }

    /**
     * Sets the value of the euprogrrelated property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEUPROGRRELATED(String value) {
        this.euprogrrelated = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ObjectF13)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ObjectF13 that = ((ObjectF13) object);
        {
            List<CpvSet> lhsCPVADDITIONALS;
            lhsCPVADDITIONALS = (((this.cpvadditionals!= null)&&(!this.cpvadditionals.isEmpty()))?this.getCPVADDITIONALS():null);
            List<CpvSet> rhsCPVADDITIONALS;
            rhsCPVADDITIONALS = (((that.cpvadditionals!= null)&&(!that.cpvadditionals.isEmpty()))?that.getCPVADDITIONALS():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cpvadditionals", lhsCPVADDITIONALS), LocatorUtils.property(thatLocator, "cpvadditionals", rhsCPVADDITIONALS), lhsCPVADDITIONALS, rhsCPVADDITIONALS)) {
                return false;
            }
        }
        {
            TextFtMultiLines lhsSHORTDESCR;
            lhsSHORTDESCR = this.getSHORTDESCR();
            TextFtMultiLines rhsSHORTDESCR;
            rhsSHORTDESCR = that.getSHORTDESCR();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "shortdescr", lhsSHORTDESCR), LocatorUtils.property(thatLocator, "shortdescr", rhsSHORTDESCR), lhsSHORTDESCR, rhsSHORTDESCR)) {
                return false;
            }
        }
        {
            Empty lhsNOEUPROGRRELATED;
            lhsNOEUPROGRRELATED = this.getNOEUPROGRRELATED();
            Empty rhsNOEUPROGRRELATED;
            rhsNOEUPROGRRELATED = that.getNOEUPROGRRELATED();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "noeuprogrrelated", lhsNOEUPROGRRELATED), LocatorUtils.property(thatLocator, "noeuprogrrelated", rhsNOEUPROGRRELATED), lhsNOEUPROGRRELATED, rhsNOEUPROGRRELATED)) {
                return false;
            }
        }
        {
            String lhsEUPROGRRELATED;
            lhsEUPROGRRELATED = this.getEUPROGRRELATED();
            String rhsEUPROGRRELATED;
            rhsEUPROGRRELATED = that.getEUPROGRRELATED();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "euprogrrelated", lhsEUPROGRRELATED), LocatorUtils.property(thatLocator, "euprogrrelated", rhsEUPROGRRELATED), lhsEUPROGRRELATED, rhsEUPROGRRELATED)) {
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
            List<CpvSet> theCPVADDITIONALS;
            theCPVADDITIONALS = (((this.cpvadditionals!= null)&&(!this.cpvadditionals.isEmpty()))?this.getCPVADDITIONALS():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cpvadditionals", theCPVADDITIONALS), currentHashCode, theCPVADDITIONALS);
        }
        {
            TextFtMultiLines theSHORTDESCR;
            theSHORTDESCR = this.getSHORTDESCR();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "shortdescr", theSHORTDESCR), currentHashCode, theSHORTDESCR);
        }
        {
            Empty theNOEUPROGRRELATED;
            theNOEUPROGRRELATED = this.getNOEUPROGRRELATED();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "noeuprogrrelated", theNOEUPROGRRELATED), currentHashCode, theNOEUPROGRRELATED);
        }
        {
            String theEUPROGRRELATED;
            theEUPROGRRELATED = this.getEUPROGRRELATED();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "euprogrrelated", theEUPROGRRELATED), currentHashCode, theEUPROGRRELATED);
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
            List<CpvSet> theCPVADDITIONALS;
            theCPVADDITIONALS = (((this.cpvadditionals!= null)&&(!this.cpvadditionals.isEmpty()))?this.getCPVADDITIONALS():null);
            strategy.appendField(locator, this, "cpvadditionals", buffer, theCPVADDITIONALS);
        }
        {
            TextFtMultiLines theSHORTDESCR;
            theSHORTDESCR = this.getSHORTDESCR();
            strategy.appendField(locator, this, "shortdescr", buffer, theSHORTDESCR);
        }
        {
            Empty theNOEUPROGRRELATED;
            theNOEUPROGRRELATED = this.getNOEUPROGRRELATED();
            strategy.appendField(locator, this, "noeuprogrrelated", buffer, theNOEUPROGRRELATED);
        }
        {
            String theEUPROGRRELATED;
            theEUPROGRRELATED = this.getEUPROGRRELATED();
            strategy.appendField(locator, this, "euprogrrelated", buffer, theEUPROGRRELATED);
        }
        return buffer;
    }

}