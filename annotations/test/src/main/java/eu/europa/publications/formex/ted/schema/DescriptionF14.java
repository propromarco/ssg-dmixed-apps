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
 * <p>Java class for description_f14 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="description_f14">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}CPV"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}NUTS" maxOccurs="20"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}MAIN_SITE" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "description_f14", propOrder = {
    "cpv",
    "nuts",
    "mainsite"
})
public class DescriptionF14
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "CPV", required = true)
    protected CPV cpv;
    @XmlElement(name = "NUTS", required = true)
    protected List<NUTS> nuts;
    @XmlElement(name = "MAIN_SITE")
    protected TextFtMultiLines mainsite;

    /**
     * Gets the value of the cpv property.
     * 
     * @return
     *     possible object is
     *     {@link CPV }
     *     
     */
    public CPV getCPV() {
        return cpv;
    }

    /**
     * Sets the value of the cpv property.
     * 
     * @param value
     *     allowed object is
     *     {@link CPV }
     *     
     */
    public void setCPV(CPV value) {
        this.cpv = value;
    }

    /**
     * Gets the value of the nuts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nuts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNUTS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NUTS }
     * 
     * 
     */
    public List<NUTS> getNUTS() {
        if (nuts == null) {
            nuts = new ArrayList<NUTS>();
        }
        return this.nuts;
    }

    /**
     * Gets the value of the mainsite property.
     * 
     * @return
     *     possible object is
     *     {@link TextFtMultiLines }
     *     
     */
    public TextFtMultiLines getMAINSITE() {
        return mainsite;
    }

    /**
     * Sets the value of the mainsite property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextFtMultiLines }
     *     
     */
    public void setMAINSITE(TextFtMultiLines value) {
        this.mainsite = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof DescriptionF14)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final DescriptionF14 that = ((DescriptionF14) object);
        {
            CPV lhsCPV;
            lhsCPV = this.getCPV();
            CPV rhsCPV;
            rhsCPV = that.getCPV();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cpv", lhsCPV), LocatorUtils.property(thatLocator, "cpv", rhsCPV), lhsCPV, rhsCPV)) {
                return false;
            }
        }
        {
            List<NUTS> lhsNUTS;
            lhsNUTS = (((this.nuts!= null)&&(!this.nuts.isEmpty()))?this.getNUTS():null);
            List<NUTS> rhsNUTS;
            rhsNUTS = (((that.nuts!= null)&&(!that.nuts.isEmpty()))?that.getNUTS():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nuts", lhsNUTS), LocatorUtils.property(thatLocator, "nuts", rhsNUTS), lhsNUTS, rhsNUTS)) {
                return false;
            }
        }
        {
            TextFtMultiLines lhsMAINSITE;
            lhsMAINSITE = this.getMAINSITE();
            TextFtMultiLines rhsMAINSITE;
            rhsMAINSITE = that.getMAINSITE();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "mainsite", lhsMAINSITE), LocatorUtils.property(thatLocator, "mainsite", rhsMAINSITE), lhsMAINSITE, rhsMAINSITE)) {
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
            CPV theCPV;
            theCPV = this.getCPV();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cpv", theCPV), currentHashCode, theCPV);
        }
        {
            List<NUTS> theNUTS;
            theNUTS = (((this.nuts!= null)&&(!this.nuts.isEmpty()))?this.getNUTS():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nuts", theNUTS), currentHashCode, theNUTS);
        }
        {
            TextFtMultiLines theMAINSITE;
            theMAINSITE = this.getMAINSITE();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "mainsite", theMAINSITE), currentHashCode, theMAINSITE);
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
            CPV theCPV;
            theCPV = this.getCPV();
            strategy.appendField(locator, this, "cpv", buffer, theCPV);
        }
        {
            List<NUTS> theNUTS;
            theNUTS = (((this.nuts!= null)&&(!this.nuts.isEmpty()))?this.getNUTS():null);
            strategy.appendField(locator, this, "nuts", buffer, theNUTS);
        }
        {
            TextFtMultiLines theMAINSITE;
            theMAINSITE = this.getMAINSITE();
            strategy.appendField(locator, this, "mainsite", buffer, theMAINSITE);
        }
        return buffer;
    }

}
