//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.04 at 01:40:50 PM MEZ 
//


package eu.europa.publications.formex.ted.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import de.subreport.elvis.server.ws.ted.TEDFormular;
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
 * ROOT element F12
 * 
 * <p>Java class for F12_2014 element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="F12_2014">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element name="DIRECTIVE" type="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}directive_f12"/>
 *           &lt;element name="CONTRACTING_BODY" type="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}body_f12"/>
 *           &lt;element name="OBJECT_CONTRACT" type="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}object_contract_f12"/>
 *           &lt;element name="LEFTI" type="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}lefti_f12"/>
 *           &lt;element name="PROCEDURE" type="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}procedure_f12"/>
 *           &lt;element name="COMPLEMENTARY_INFO" type="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}ci_f12"/>
 *         &lt;/sequence>
 *         &lt;attribute name="LG" use="required" type="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}t_ce_language_list" />
 *         &lt;attribute name="CATEGORY" use="required" type="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}category" />
 *         &lt;attribute name="FORM" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="F12" />
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "directive",
    "contractingbody",
    "objectcontract",
    "lefti",
    "procedure",
    "complementaryinfo"
})
@XmlRootElement(name = "F12_2014")
public class F122014
    implements TEDFormular, Equals, HashCode, ToString
{

    @XmlElement(name = "DIRECTIVE", required = true)
    protected DirectiveF12 directive;
    @XmlElement(name = "CONTRACTING_BODY", required = true)
    protected BodyF12 contractingbody;
    @XmlElement(name = "OBJECT_CONTRACT", required = true)
    protected ObjectContractF12 objectcontract;
    @XmlElement(name = "LEFTI", required = true)
    protected LeftiF12 lefti;
    @XmlElement(name = "PROCEDURE", required = true)
    protected ProcedureF12 procedure;
    @XmlElement(name = "COMPLEMENTARY_INFO", required = true)
    protected CiF12 complementaryinfo;
    @XmlAttribute(name = "LG", required = true)
    protected TCeLanguageList lg;
    @XmlAttribute(name = "CATEGORY", required = true)
    protected Category category;
    @XmlAttribute(name = "FORM", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String form;

    /**
     * Gets the value of the directive property.
     * 
     * @return
     *     possible object is
     *     {@link DirectiveF12 }
     *     
     */
    public DirectiveF12 getDIRECTIVE() {
        return directive;
    }

    /**
     * Sets the value of the directive property.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectiveF12 }
     *     
     */
    public void setDIRECTIVE(DirectiveF12 value) {
        this.directive = value;
    }

    /**
     * Gets the value of the contractingbody property.
     * 
     * @return
     *     possible object is
     *     {@link BodyF12 }
     *     
     */
    public BodyF12 getCONTRACTINGBODY() {
        return contractingbody;
    }

    /**
     * Sets the value of the contractingbody property.
     * 
     * @param value
     *     allowed object is
     *     {@link BodyF12 }
     *     
     */
    public void setCONTRACTINGBODY(BodyF12 value) {
        this.contractingbody = value;
    }

    /**
     * Gets the value of the objectcontract property.
     * 
     * @return
     *     possible object is
     *     {@link ObjectContractF12 }
     *     
     */
    public ObjectContractF12 getOBJECTCONTRACT() {
        return objectcontract;
    }

    /**
     * Sets the value of the objectcontract property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectContractF12 }
     *     
     */
    public void setOBJECTCONTRACT(ObjectContractF12 value) {
        this.objectcontract = value;
    }

    /**
     * Gets the value of the lefti property.
     * 
     * @return
     *     possible object is
     *     {@link LeftiF12 }
     *     
     */
    public LeftiF12 getLEFTI() {
        return lefti;
    }

    /**
     * Sets the value of the lefti property.
     * 
     * @param value
     *     allowed object is
     *     {@link LeftiF12 }
     *     
     */
    public void setLEFTI(LeftiF12 value) {
        this.lefti = value;
    }

    /**
     * Gets the value of the procedure property.
     * 
     * @return
     *     possible object is
     *     {@link ProcedureF12 }
     *     
     */
    public ProcedureF12 getPROCEDURE() {
        return procedure;
    }

    /**
     * Sets the value of the procedure property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcedureF12 }
     *     
     */
    public void setPROCEDURE(ProcedureF12 value) {
        this.procedure = value;
    }

    /**
     * Gets the value of the complementaryinfo property.
     * 
     * @return
     *     possible object is
     *     {@link CiF12 }
     *     
     */
    public CiF12 getCOMPLEMENTARYINFO() {
        return complementaryinfo;
    }

    /**
     * Sets the value of the complementaryinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CiF12 }
     *     
     */
    public void setCOMPLEMENTARYINFO(CiF12 value) {
        this.complementaryinfo = value;
    }

    /**
     * Gets the value of the lg property.
     * 
     * @return
     *     possible object is
     *     {@link TCeLanguageList }
     *     
     */
    public TCeLanguageList getLG() {
        return lg;
    }

    /**
     * Sets the value of the lg property.
     * 
     * @param value
     *     allowed object is
     *     {@link TCeLanguageList }
     *     
     */
    public void setLG(TCeLanguageList value) {
        this.lg = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link Category }
     *     
     */
    public Category getCATEGORY() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link Category }
     *     
     */
    public void setCATEGORY(Category value) {
        this.category = value;
    }

    /**
     * Gets the value of the form property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFORM() {
        if (form == null) {
            return "F12";
        } else {
            return form;
        }
    }

    /**
     * Sets the value of the form property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFORM(String value) {
        this.form = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof F122014)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final F122014 that = ((F122014) object);
        {
            DirectiveF12 lhsDIRECTIVE;
            lhsDIRECTIVE = this.getDIRECTIVE();
            DirectiveF12 rhsDIRECTIVE;
            rhsDIRECTIVE = that.getDIRECTIVE();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "directive", lhsDIRECTIVE), LocatorUtils.property(thatLocator, "directive", rhsDIRECTIVE), lhsDIRECTIVE, rhsDIRECTIVE)) {
                return false;
            }
        }
        {
            BodyF12 lhsCONTRACTINGBODY;
            lhsCONTRACTINGBODY = this.getCONTRACTINGBODY();
            BodyF12 rhsCONTRACTINGBODY;
            rhsCONTRACTINGBODY = that.getCONTRACTINGBODY();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contractingbody", lhsCONTRACTINGBODY), LocatorUtils.property(thatLocator, "contractingbody", rhsCONTRACTINGBODY), lhsCONTRACTINGBODY, rhsCONTRACTINGBODY)) {
                return false;
            }
        }
        {
            ObjectContractF12 lhsOBJECTCONTRACT;
            lhsOBJECTCONTRACT = this.getOBJECTCONTRACT();
            ObjectContractF12 rhsOBJECTCONTRACT;
            rhsOBJECTCONTRACT = that.getOBJECTCONTRACT();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "objectcontract", lhsOBJECTCONTRACT), LocatorUtils.property(thatLocator, "objectcontract", rhsOBJECTCONTRACT), lhsOBJECTCONTRACT, rhsOBJECTCONTRACT)) {
                return false;
            }
        }
        {
            LeftiF12 lhsLEFTI;
            lhsLEFTI = this.getLEFTI();
            LeftiF12 rhsLEFTI;
            rhsLEFTI = that.getLEFTI();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lefti", lhsLEFTI), LocatorUtils.property(thatLocator, "lefti", rhsLEFTI), lhsLEFTI, rhsLEFTI)) {
                return false;
            }
        }
        {
            ProcedureF12 lhsPROCEDURE;
            lhsPROCEDURE = this.getPROCEDURE();
            ProcedureF12 rhsPROCEDURE;
            rhsPROCEDURE = that.getPROCEDURE();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "procedure", lhsPROCEDURE), LocatorUtils.property(thatLocator, "procedure", rhsPROCEDURE), lhsPROCEDURE, rhsPROCEDURE)) {
                return false;
            }
        }
        {
            CiF12 lhsCOMPLEMENTARYINFO;
            lhsCOMPLEMENTARYINFO = this.getCOMPLEMENTARYINFO();
            CiF12 rhsCOMPLEMENTARYINFO;
            rhsCOMPLEMENTARYINFO = that.getCOMPLEMENTARYINFO();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "complementaryinfo", lhsCOMPLEMENTARYINFO), LocatorUtils.property(thatLocator, "complementaryinfo", rhsCOMPLEMENTARYINFO), lhsCOMPLEMENTARYINFO, rhsCOMPLEMENTARYINFO)) {
                return false;
            }
        }
        {
            TCeLanguageList lhsLG;
            lhsLG = this.getLG();
            TCeLanguageList rhsLG;
            rhsLG = that.getLG();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lg", lhsLG), LocatorUtils.property(thatLocator, "lg", rhsLG), lhsLG, rhsLG)) {
                return false;
            }
        }
        {
            Category lhsCATEGORY;
            lhsCATEGORY = this.getCATEGORY();
            Category rhsCATEGORY;
            rhsCATEGORY = that.getCATEGORY();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "category", lhsCATEGORY), LocatorUtils.property(thatLocator, "category", rhsCATEGORY), lhsCATEGORY, rhsCATEGORY)) {
                return false;
            }
        }
        {
            String lhsFORM;
            lhsFORM = this.getFORM();
            String rhsFORM;
            rhsFORM = that.getFORM();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "form", lhsFORM), LocatorUtils.property(thatLocator, "form", rhsFORM), lhsFORM, rhsFORM)) {
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
            DirectiveF12 theDIRECTIVE;
            theDIRECTIVE = this.getDIRECTIVE();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "directive", theDIRECTIVE), currentHashCode, theDIRECTIVE);
        }
        {
            BodyF12 theCONTRACTINGBODY;
            theCONTRACTINGBODY = this.getCONTRACTINGBODY();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contractingbody", theCONTRACTINGBODY), currentHashCode, theCONTRACTINGBODY);
        }
        {
            ObjectContractF12 theOBJECTCONTRACT;
            theOBJECTCONTRACT = this.getOBJECTCONTRACT();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "objectcontract", theOBJECTCONTRACT), currentHashCode, theOBJECTCONTRACT);
        }
        {
            LeftiF12 theLEFTI;
            theLEFTI = this.getLEFTI();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lefti", theLEFTI), currentHashCode, theLEFTI);
        }
        {
            ProcedureF12 thePROCEDURE;
            thePROCEDURE = this.getPROCEDURE();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "procedure", thePROCEDURE), currentHashCode, thePROCEDURE);
        }
        {
            CiF12 theCOMPLEMENTARYINFO;
            theCOMPLEMENTARYINFO = this.getCOMPLEMENTARYINFO();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "complementaryinfo", theCOMPLEMENTARYINFO), currentHashCode, theCOMPLEMENTARYINFO);
        }
        {
            TCeLanguageList theLG;
            theLG = this.getLG();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lg", theLG), currentHashCode, theLG);
        }
        {
            Category theCATEGORY;
            theCATEGORY = this.getCATEGORY();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "category", theCATEGORY), currentHashCode, theCATEGORY);
        }
        {
            String theFORM;
            theFORM = this.getFORM();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "form", theFORM), currentHashCode, theFORM);
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
            DirectiveF12 theDIRECTIVE;
            theDIRECTIVE = this.getDIRECTIVE();
            strategy.appendField(locator, this, "directive", buffer, theDIRECTIVE);
        }
        {
            BodyF12 theCONTRACTINGBODY;
            theCONTRACTINGBODY = this.getCONTRACTINGBODY();
            strategy.appendField(locator, this, "contractingbody", buffer, theCONTRACTINGBODY);
        }
        {
            ObjectContractF12 theOBJECTCONTRACT;
            theOBJECTCONTRACT = this.getOBJECTCONTRACT();
            strategy.appendField(locator, this, "objectcontract", buffer, theOBJECTCONTRACT);
        }
        {
            LeftiF12 theLEFTI;
            theLEFTI = this.getLEFTI();
            strategy.appendField(locator, this, "lefti", buffer, theLEFTI);
        }
        {
            ProcedureF12 thePROCEDURE;
            thePROCEDURE = this.getPROCEDURE();
            strategy.appendField(locator, this, "procedure", buffer, thePROCEDURE);
        }
        {
            CiF12 theCOMPLEMENTARYINFO;
            theCOMPLEMENTARYINFO = this.getCOMPLEMENTARYINFO();
            strategy.appendField(locator, this, "complementaryinfo", buffer, theCOMPLEMENTARYINFO);
        }
        {
            TCeLanguageList theLG;
            theLG = this.getLG();
            strategy.appendField(locator, this, "lg", buffer, theLG);
        }
        {
            Category theCATEGORY;
            theCATEGORY = this.getCATEGORY();
            strategy.appendField(locator, this, "category", buffer, theCATEGORY);
        }
        {
            String theFORM;
            theFORM = this.getFORM();
            strategy.appendField(locator, this, "form", buffer, theFORM);
        }
        return buffer;
    }

}