//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.04 at 01:40:50 PM MEZ 
//


package eu.europa.publications.formex.ted.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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


/**
 * Section III: LEFTI
 * 
 * <p>Java class for lefti_f21 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="lefti_f21">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}lefti">
 *       &lt;sequence>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}RULES_CRITERIA" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}RESTRICTED_SHELTERED_WORKSHOP" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}RESTRICTED_SHELTERED_PROGRAM" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}RESERVED_ORGANISATIONS_SERVICE_MISSION" minOccurs="0"/>
 *         &lt;sequence minOccurs="0">
 *           &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}PARTICULAR_PROFESSION"/>
 *           &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}REFERENCE_TO_LAW" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}PERFORMANCE_CONDITIONS" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}PERFORMANCE_STAFF_QUALIFICATION" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lefti_f21")
public class LeftiF21
    extends Lefti
    implements Equals, HashCode, ToString
{


    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof LeftiF21)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
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
        return buffer;
    }

}
