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
 * <p>Java class for cond_for_opening_tenders complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cond_for_opening_tenders">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DATE_OPENING_TENDERS" type="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}date_full"/>
 *         &lt;element name="TIME_OPENING_TENDERS" type="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}time"/>
 *         &lt;element name="PLACE" type="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}text_ft_multi_lines" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}INFO_ADD" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cond_for_opening_tenders", propOrder = {
    "dateopeningtenders",
    "timeopeningtenders",
    "place",
    "infoadd"
})
@XmlRootElement(name = "OPENING_CONDITION")
public class OPENINGCONDITION
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "DATE_OPENING_TENDERS", required = true)
    protected XMLGregorianCalendar dateopeningtenders;
    @XmlElement(name = "TIME_OPENING_TENDERS", required = true)
    protected String timeopeningtenders;
    @XmlElement(name = "PLACE")
    protected TextFtMultiLines place;
    @XmlElement(name = "INFO_ADD")
    protected TextFtMultiLines infoadd;

    /**
     * Gets the value of the dateopeningtenders property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDATEOPENINGTENDERS() {
        return dateopeningtenders;
    }

    /**
     * Sets the value of the dateopeningtenders property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDATEOPENINGTENDERS(XMLGregorianCalendar value) {
        this.dateopeningtenders = value;
    }

    /**
     * Gets the value of the timeopeningtenders property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIMEOPENINGTENDERS() {
        return timeopeningtenders;
    }

    /**
     * Sets the value of the timeopeningtenders property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIMEOPENINGTENDERS(String value) {
        this.timeopeningtenders = value;
    }

    /**
     * Gets the value of the place property.
     * 
     * @return
     *     possible object is
     *     {@link TextFtMultiLines }
     *     
     */
    public TextFtMultiLines getPLACE() {
        return place;
    }

    /**
     * Sets the value of the place property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextFtMultiLines }
     *     
     */
    public void setPLACE(TextFtMultiLines value) {
        this.place = value;
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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof OPENINGCONDITION)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final OPENINGCONDITION that = ((OPENINGCONDITION) object);
        {
            XMLGregorianCalendar lhsDATEOPENINGTENDERS;
            lhsDATEOPENINGTENDERS = this.getDATEOPENINGTENDERS();
            XMLGregorianCalendar rhsDATEOPENINGTENDERS;
            rhsDATEOPENINGTENDERS = that.getDATEOPENINGTENDERS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dateopeningtenders", lhsDATEOPENINGTENDERS), LocatorUtils.property(thatLocator, "dateopeningtenders", rhsDATEOPENINGTENDERS), lhsDATEOPENINGTENDERS, rhsDATEOPENINGTENDERS)) {
                return false;
            }
        }
        {
            String lhsTIMEOPENINGTENDERS;
            lhsTIMEOPENINGTENDERS = this.getTIMEOPENINGTENDERS();
            String rhsTIMEOPENINGTENDERS;
            rhsTIMEOPENINGTENDERS = that.getTIMEOPENINGTENDERS();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "timeopeningtenders", lhsTIMEOPENINGTENDERS), LocatorUtils.property(thatLocator, "timeopeningtenders", rhsTIMEOPENINGTENDERS), lhsTIMEOPENINGTENDERS, rhsTIMEOPENINGTENDERS)) {
                return false;
            }
        }
        {
            TextFtMultiLines lhsPLACE;
            lhsPLACE = this.getPLACE();
            TextFtMultiLines rhsPLACE;
            rhsPLACE = that.getPLACE();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "place", lhsPLACE), LocatorUtils.property(thatLocator, "place", rhsPLACE), lhsPLACE, rhsPLACE)) {
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
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            XMLGregorianCalendar theDATEOPENINGTENDERS;
            theDATEOPENINGTENDERS = this.getDATEOPENINGTENDERS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dateopeningtenders", theDATEOPENINGTENDERS), currentHashCode, theDATEOPENINGTENDERS);
        }
        {
            String theTIMEOPENINGTENDERS;
            theTIMEOPENINGTENDERS = this.getTIMEOPENINGTENDERS();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "timeopeningtenders", theTIMEOPENINGTENDERS), currentHashCode, theTIMEOPENINGTENDERS);
        }
        {
            TextFtMultiLines thePLACE;
            thePLACE = this.getPLACE();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "place", thePLACE), currentHashCode, thePLACE);
        }
        {
            TextFtMultiLines theINFOADD;
            theINFOADD = this.getINFOADD();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "infoadd", theINFOADD), currentHashCode, theINFOADD);
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
            XMLGregorianCalendar theDATEOPENINGTENDERS;
            theDATEOPENINGTENDERS = this.getDATEOPENINGTENDERS();
            strategy.appendField(locator, this, "dateopeningtenders", buffer, theDATEOPENINGTENDERS);
        }
        {
            String theTIMEOPENINGTENDERS;
            theTIMEOPENINGTENDERS = this.getTIMEOPENINGTENDERS();
            strategy.appendField(locator, this, "timeopeningtenders", buffer, theTIMEOPENINGTENDERS);
        }
        {
            TextFtMultiLines thePLACE;
            thePLACE = this.getPLACE();
            strategy.appendField(locator, this, "place", buffer, thePLACE);
        }
        {
            TextFtMultiLines theINFOADD;
            theINFOADD = this.getINFOADD();
            strategy.appendField(locator, this, "infoadd", buffer, theINFOADD);
        }
        return buffer;
    }

}
