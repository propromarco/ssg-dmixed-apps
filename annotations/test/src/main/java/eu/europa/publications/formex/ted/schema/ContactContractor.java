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
 * <p>Java class for contact_contractor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contact_contractor">
 *   &lt;complexContent>
 *     &lt;extension base="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}org_id_new">
 *       &lt;sequence>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}ADDRESS" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}TOWN"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}POSTAL_CODE" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}COUNTRY"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}PHONE" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}E_MAIL" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}FAX" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}NUTS"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}URL" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contact_contractor", propOrder = {
    "address",
    "town",
    "postalcode",
    "country",
    "phone",
    "email",
    "fax",
    "nuts",
    "url"
})
@XmlSeeAlso({
    eu.europa.publications.formex.ted.schema.ResultsF13 .AWARDEDPRIZE.WINNER.ADDRESSWINNER.class
})
public class ContactContractor
    extends OrgIdNew
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "ADDRESS")
    protected String address;
    @XmlElement(name = "TOWN", required = true)
    protected String town;
    @XmlElement(name = "POSTAL_CODE")
    protected String postalcode;
    @XmlElement(name = "COUNTRY", required = true)
    protected COUNTRY country;
    @XmlElement(name = "PHONE")
    protected String phone;
    @XmlElement(name = "E_MAIL")
    protected String email;
    @XmlElement(name = "FAX")
    protected String fax;
    @XmlElement(name = "NUTS", required = true)
    protected NUTS nuts;
    @XmlElement(name = "URL")
    protected String url;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADDRESS() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADDRESS(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the town property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOWN() {
        return town;
    }

    /**
     * Sets the value of the town property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOWN(String value) {
        this.town = value;
    }

    /**
     * Gets the value of the postalcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOSTALCODE() {
        return postalcode;
    }

    /**
     * Sets the value of the postalcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOSTALCODE(String value) {
        this.postalcode = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link COUNTRY }
     *     
     */
    public COUNTRY getCOUNTRY() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link COUNTRY }
     *     
     */
    public void setCOUNTRY(COUNTRY value) {
        this.country = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPHONE() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPHONE(String value) {
        this.phone = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMAIL() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEMAIL(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFAX() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFAX(String value) {
        this.fax = value;
    }

    /**
     * Gets the value of the nuts property.
     * 
     * @return
     *     possible object is
     *     {@link NUTS }
     *     
     */
    public NUTS getNUTS() {
        return nuts;
    }

    /**
     * Sets the value of the nuts property.
     * 
     * @param value
     *     allowed object is
     *     {@link NUTS }
     *     
     */
    public void setNUTS(NUTS value) {
        this.nuts = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURL() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURL(String value) {
        this.url = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ContactContractor)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final ContactContractor that = ((ContactContractor) object);
        {
            String lhsADDRESS;
            lhsADDRESS = this.getADDRESS();
            String rhsADDRESS;
            rhsADDRESS = that.getADDRESS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "address", lhsADDRESS), LocatorUtils.property(thatLocator, "address", rhsADDRESS), lhsADDRESS, rhsADDRESS)) {
                return false;
            }
        }
        {
            String lhsTOWN;
            lhsTOWN = this.getTOWN();
            String rhsTOWN;
            rhsTOWN = that.getTOWN();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "town", lhsTOWN), LocatorUtils.property(thatLocator, "town", rhsTOWN), lhsTOWN, rhsTOWN)) {
                return false;
            }
        }
        {
            String lhsPOSTALCODE;
            lhsPOSTALCODE = this.getPOSTALCODE();
            String rhsPOSTALCODE;
            rhsPOSTALCODE = that.getPOSTALCODE();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "postalcode", lhsPOSTALCODE), LocatorUtils.property(thatLocator, "postalcode", rhsPOSTALCODE), lhsPOSTALCODE, rhsPOSTALCODE)) {
                return false;
            }
        }
        {
            COUNTRY lhsCOUNTRY;
            lhsCOUNTRY = this.getCOUNTRY();
            COUNTRY rhsCOUNTRY;
            rhsCOUNTRY = that.getCOUNTRY();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "country", lhsCOUNTRY), LocatorUtils.property(thatLocator, "country", rhsCOUNTRY), lhsCOUNTRY, rhsCOUNTRY)) {
                return false;
            }
        }
        {
            String lhsPHONE;
            lhsPHONE = this.getPHONE();
            String rhsPHONE;
            rhsPHONE = that.getPHONE();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "phone", lhsPHONE), LocatorUtils.property(thatLocator, "phone", rhsPHONE), lhsPHONE, rhsPHONE)) {
                return false;
            }
        }
        {
            String lhsEMAIL;
            lhsEMAIL = this.getEMAIL();
            String rhsEMAIL;
            rhsEMAIL = that.getEMAIL();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "email", lhsEMAIL), LocatorUtils.property(thatLocator, "email", rhsEMAIL), lhsEMAIL, rhsEMAIL)) {
                return false;
            }
        }
        {
            String lhsFAX;
            lhsFAX = this.getFAX();
            String rhsFAX;
            rhsFAX = that.getFAX();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fax", lhsFAX), LocatorUtils.property(thatLocator, "fax", rhsFAX), lhsFAX, rhsFAX)) {
                return false;
            }
        }
        {
            NUTS lhsNUTS;
            lhsNUTS = this.getNUTS();
            NUTS rhsNUTS;
            rhsNUTS = that.getNUTS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nuts", lhsNUTS), LocatorUtils.property(thatLocator, "nuts", rhsNUTS), lhsNUTS, rhsNUTS)) {
                return false;
            }
        }
        {
            String lhsURL;
            lhsURL = this.getURL();
            String rhsURL;
            rhsURL = that.getURL();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "url", lhsURL), LocatorUtils.property(thatLocator, "url", rhsURL), lhsURL, rhsURL)) {
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
        int currentHashCode = super.hashCode(locator, strategy);
        {
            String theADDRESS;
            theADDRESS = this.getADDRESS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "address", theADDRESS), currentHashCode, theADDRESS);
        }
        {
            String theTOWN;
            theTOWN = this.getTOWN();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "town", theTOWN), currentHashCode, theTOWN);
        }
        {
            String thePOSTALCODE;
            thePOSTALCODE = this.getPOSTALCODE();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "postalcode", thePOSTALCODE), currentHashCode, thePOSTALCODE);
        }
        {
            COUNTRY theCOUNTRY;
            theCOUNTRY = this.getCOUNTRY();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "country", theCOUNTRY), currentHashCode, theCOUNTRY);
        }
        {
            String thePHONE;
            thePHONE = this.getPHONE();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "phone", thePHONE), currentHashCode, thePHONE);
        }
        {
            String theEMAIL;
            theEMAIL = this.getEMAIL();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "email", theEMAIL), currentHashCode, theEMAIL);
        }
        {
            String theFAX;
            theFAX = this.getFAX();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fax", theFAX), currentHashCode, theFAX);
        }
        {
            NUTS theNUTS;
            theNUTS = this.getNUTS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nuts", theNUTS), currentHashCode, theNUTS);
        }
        {
            String theURL;
            theURL = this.getURL();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "url", theURL), currentHashCode, theURL);
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
        super.appendFields(locator, buffer, strategy);
        {
            String theADDRESS;
            theADDRESS = this.getADDRESS();
            strategy.appendField(locator, this, "address", buffer, theADDRESS);
        }
        {
            String theTOWN;
            theTOWN = this.getTOWN();
            strategy.appendField(locator, this, "town", buffer, theTOWN);
        }
        {
            String thePOSTALCODE;
            thePOSTALCODE = this.getPOSTALCODE();
            strategy.appendField(locator, this, "postalcode", buffer, thePOSTALCODE);
        }
        {
            COUNTRY theCOUNTRY;
            theCOUNTRY = this.getCOUNTRY();
            strategy.appendField(locator, this, "country", buffer, theCOUNTRY);
        }
        {
            String thePHONE;
            thePHONE = this.getPHONE();
            strategy.appendField(locator, this, "phone", buffer, thePHONE);
        }
        {
            String theEMAIL;
            theEMAIL = this.getEMAIL();
            strategy.appendField(locator, this, "email", buffer, theEMAIL);
        }
        {
            String theFAX;
            theFAX = this.getFAX();
            strategy.appendField(locator, this, "fax", buffer, theFAX);
        }
        {
            NUTS theNUTS;
            theNUTS = this.getNUTS();
            strategy.appendField(locator, this, "nuts", buffer, theNUTS);
        }
        {
            String theURL;
            theURL = this.getURL();
            strategy.appendField(locator, this, "url", buffer, theURL);
        }
        return buffer;
    }

}