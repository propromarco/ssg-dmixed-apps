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
 * Section II: OBJECT OF THE CONTRACT
 * 
 * <p>Java class for object_contract_f15 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="object_contract_f15">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}TITLE"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}REFERENCE_NUMBER" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}CPV_MAIN"/>
 *         &lt;element name="TYPE_CONTRACT" type="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}type_contract"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}SHORT_DESCR"/>
 *         &lt;choice>
 *           &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}VAL_TOTAL"/>
 *           &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}VAL_RANGE_TOTAL"/>
 *         &lt;/choice>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}LOT_DIVISION"/>
 *             &lt;element name="OBJECT_DESCR" type="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}object_f15" maxOccurs="1000"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}NO_LOT_DIVISION"/>
 *             &lt;element name="OBJECT_DESCR" type="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}object_f15"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "object_contract_f15", propOrder = {
    "title",
    "referencenumber",
    "cpvmain",
    "typecontract",
    "shortdescr",
    "valrangetotal",
    "valtotal",
    "nolotdivision",
    "lotdivision",
    "objectdescrs"
})
public class ObjectContractF15
    implements Equals, HashCode, ToString
{

    @XmlElement(name = "TITLE", required = true)
    protected TITLE title;
    @XmlElement(name = "REFERENCE_NUMBER")
    protected String referencenumber;
    @XmlElement(name = "CPV_MAIN", required = true)
    protected CpvSet cpvmain;
    @XmlElement(name = "TYPE_CONTRACT", required = true)
    protected TYPECONTRACT typecontract;
    @XmlElement(name = "SHORT_DESCR", required = true)
    protected TextFtMultiLines shortdescr;
    @XmlElement(name = "VAL_RANGE_TOTAL")
    protected ValRange valrangetotal;
    @XmlElement(name = "VAL_TOTAL")
    protected Val valtotal;
    @XmlElement(name = "NO_LOT_DIVISION")
    protected Empty nolotdivision;
    @XmlElement(name = "LOT_DIVISION")
    protected Empty lotdivision;
    @XmlElement(name = "OBJECT_DESCR")
    protected List<ObjectF15> objectdescrs;

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link TITLE }
     *     
     */
    public TITLE getTITLE() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link TITLE }
     *     
     */
    public void setTITLE(TITLE value) {
        this.title = value;
    }

    /**
     * Gets the value of the referencenumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFERENCENUMBER() {
        return referencenumber;
    }

    /**
     * Sets the value of the referencenumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFERENCENUMBER(String value) {
        this.referencenumber = value;
    }

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
     * Gets the value of the typecontract property.
     * 
     * @return
     *     possible object is
     *     {@link TYPECONTRACT }
     *     
     */
    public TYPECONTRACT getTYPECONTRACT() {
        return typecontract;
    }

    /**
     * Sets the value of the typecontract property.
     * 
     * @param value
     *     allowed object is
     *     {@link TYPECONTRACT }
     *     
     */
    public void setTYPECONTRACT(TYPECONTRACT value) {
        this.typecontract = value;
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
     * Gets the value of the valrangetotal property.
     * 
     * @return
     *     possible object is
     *     {@link ValRange }
     *     
     */
    public ValRange getVALRANGETOTAL() {
        return valrangetotal;
    }

    /**
     * Sets the value of the valrangetotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValRange }
     *     
     */
    public void setVALRANGETOTAL(ValRange value) {
        this.valrangetotal = value;
    }

    /**
     * Gets the value of the valtotal property.
     * 
     * @return
     *     possible object is
     *     {@link Val }
     *     
     */
    public Val getVALTOTAL() {
        return valtotal;
    }

    /**
     * Sets the value of the valtotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Val }
     *     
     */
    public void setVALTOTAL(Val value) {
        this.valtotal = value;
    }

    /**
     * Gets the value of the nolotdivision property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getNOLOTDIVISION() {
        return nolotdivision;
    }

    /**
     * Sets the value of the nolotdivision property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setNOLOTDIVISION(Empty value) {
        this.nolotdivision = value;
    }

    /**
     * Gets the value of the lotdivision property.
     * 
     * @return
     *     possible object is
     *     {@link Empty }
     *     
     */
    public Empty getLOTDIVISION() {
        return lotdivision;
    }

    /**
     * Sets the value of the lotdivision property.
     * 
     * @param value
     *     allowed object is
     *     {@link Empty }
     *     
     */
    public void setLOTDIVISION(Empty value) {
        this.lotdivision = value;
    }

    /**
     * Gets the value of the objectdescrs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objectdescrs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOBJECTDESCRS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObjectF15 }
     * 
     * 
     */
    public List<ObjectF15> getOBJECTDESCRS() {
        if (objectdescrs == null) {
            objectdescrs = new ArrayList<ObjectF15>();
        }
        return this.objectdescrs;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ObjectContractF15)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ObjectContractF15 that = ((ObjectContractF15) object);
        {
            TITLE lhsTITLE;
            lhsTITLE = this.getTITLE();
            TITLE rhsTITLE;
            rhsTITLE = that.getTITLE();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "title", lhsTITLE), LocatorUtils.property(thatLocator, "title", rhsTITLE), lhsTITLE, rhsTITLE)) {
                return false;
            }
        }
        {
            String lhsREFERENCENUMBER;
            lhsREFERENCENUMBER = this.getREFERENCENUMBER();
            String rhsREFERENCENUMBER;
            rhsREFERENCENUMBER = that.getREFERENCENUMBER();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "referencenumber", lhsREFERENCENUMBER), LocatorUtils.property(thatLocator, "referencenumber", rhsREFERENCENUMBER), lhsREFERENCENUMBER, rhsREFERENCENUMBER)) {
                return false;
            }
        }
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
            TYPECONTRACT lhsTYPECONTRACT;
            lhsTYPECONTRACT = this.getTYPECONTRACT();
            TYPECONTRACT rhsTYPECONTRACT;
            rhsTYPECONTRACT = that.getTYPECONTRACT();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "typecontract", lhsTYPECONTRACT), LocatorUtils.property(thatLocator, "typecontract", rhsTYPECONTRACT), lhsTYPECONTRACT, rhsTYPECONTRACT)) {
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
            ValRange lhsVALRANGETOTAL;
            lhsVALRANGETOTAL = this.getVALRANGETOTAL();
            ValRange rhsVALRANGETOTAL;
            rhsVALRANGETOTAL = that.getVALRANGETOTAL();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "valrangetotal", lhsVALRANGETOTAL), LocatorUtils.property(thatLocator, "valrangetotal", rhsVALRANGETOTAL), lhsVALRANGETOTAL, rhsVALRANGETOTAL)) {
                return false;
            }
        }
        {
            Val lhsVALTOTAL;
            lhsVALTOTAL = this.getVALTOTAL();
            Val rhsVALTOTAL;
            rhsVALTOTAL = that.getVALTOTAL();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "valtotal", lhsVALTOTAL), LocatorUtils.property(thatLocator, "valtotal", rhsVALTOTAL), lhsVALTOTAL, rhsVALTOTAL)) {
                return false;
            }
        }
        {
            Empty lhsNOLOTDIVISION;
            lhsNOLOTDIVISION = this.getNOLOTDIVISION();
            Empty rhsNOLOTDIVISION;
            rhsNOLOTDIVISION = that.getNOLOTDIVISION();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nolotdivision", lhsNOLOTDIVISION), LocatorUtils.property(thatLocator, "nolotdivision", rhsNOLOTDIVISION), lhsNOLOTDIVISION, rhsNOLOTDIVISION)) {
                return false;
            }
        }
        {
            Empty lhsLOTDIVISION;
            lhsLOTDIVISION = this.getLOTDIVISION();
            Empty rhsLOTDIVISION;
            rhsLOTDIVISION = that.getLOTDIVISION();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lotdivision", lhsLOTDIVISION), LocatorUtils.property(thatLocator, "lotdivision", rhsLOTDIVISION), lhsLOTDIVISION, rhsLOTDIVISION)) {
                return false;
            }
        }
        {
            List<ObjectF15> lhsOBJECTDESCRS;
            lhsOBJECTDESCRS = (((this.objectdescrs!= null)&&(!this.objectdescrs.isEmpty()))?this.getOBJECTDESCRS():null);
            List<ObjectF15> rhsOBJECTDESCRS;
            rhsOBJECTDESCRS = (((that.objectdescrs!= null)&&(!that.objectdescrs.isEmpty()))?that.getOBJECTDESCRS():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "objectdescrs", lhsOBJECTDESCRS), LocatorUtils.property(thatLocator, "objectdescrs", rhsOBJECTDESCRS), lhsOBJECTDESCRS, rhsOBJECTDESCRS)) {
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
            TITLE theTITLE;
            theTITLE = this.getTITLE();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "title", theTITLE), currentHashCode, theTITLE);
        }
        {
            String theREFERENCENUMBER;
            theREFERENCENUMBER = this.getREFERENCENUMBER();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "referencenumber", theREFERENCENUMBER), currentHashCode, theREFERENCENUMBER);
        }
        {
            CpvSet theCPVMAIN;
            theCPVMAIN = this.getCPVMAIN();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cpvmain", theCPVMAIN), currentHashCode, theCPVMAIN);
        }
        {
            TYPECONTRACT theTYPECONTRACT;
            theTYPECONTRACT = this.getTYPECONTRACT();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "typecontract", theTYPECONTRACT), currentHashCode, theTYPECONTRACT);
        }
        {
            TextFtMultiLines theSHORTDESCR;
            theSHORTDESCR = this.getSHORTDESCR();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "shortdescr", theSHORTDESCR), currentHashCode, theSHORTDESCR);
        }
        {
            ValRange theVALRANGETOTAL;
            theVALRANGETOTAL = this.getVALRANGETOTAL();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "valrangetotal", theVALRANGETOTAL), currentHashCode, theVALRANGETOTAL);
        }
        {
            Val theVALTOTAL;
            theVALTOTAL = this.getVALTOTAL();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "valtotal", theVALTOTAL), currentHashCode, theVALTOTAL);
        }
        {
            Empty theNOLOTDIVISION;
            theNOLOTDIVISION = this.getNOLOTDIVISION();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nolotdivision", theNOLOTDIVISION), currentHashCode, theNOLOTDIVISION);
        }
        {
            Empty theLOTDIVISION;
            theLOTDIVISION = this.getLOTDIVISION();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lotdivision", theLOTDIVISION), currentHashCode, theLOTDIVISION);
        }
        {
            List<ObjectF15> theOBJECTDESCRS;
            theOBJECTDESCRS = (((this.objectdescrs!= null)&&(!this.objectdescrs.isEmpty()))?this.getOBJECTDESCRS():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "objectdescrs", theOBJECTDESCRS), currentHashCode, theOBJECTDESCRS);
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
            TITLE theTITLE;
            theTITLE = this.getTITLE();
            strategy.appendField(locator, this, "title", buffer, theTITLE);
        }
        {
            String theREFERENCENUMBER;
            theREFERENCENUMBER = this.getREFERENCENUMBER();
            strategy.appendField(locator, this, "referencenumber", buffer, theREFERENCENUMBER);
        }
        {
            CpvSet theCPVMAIN;
            theCPVMAIN = this.getCPVMAIN();
            strategy.appendField(locator, this, "cpvmain", buffer, theCPVMAIN);
        }
        {
            TYPECONTRACT theTYPECONTRACT;
            theTYPECONTRACT = this.getTYPECONTRACT();
            strategy.appendField(locator, this, "typecontract", buffer, theTYPECONTRACT);
        }
        {
            TextFtMultiLines theSHORTDESCR;
            theSHORTDESCR = this.getSHORTDESCR();
            strategy.appendField(locator, this, "shortdescr", buffer, theSHORTDESCR);
        }
        {
            ValRange theVALRANGETOTAL;
            theVALRANGETOTAL = this.getVALRANGETOTAL();
            strategy.appendField(locator, this, "valrangetotal", buffer, theVALRANGETOTAL);
        }
        {
            Val theVALTOTAL;
            theVALTOTAL = this.getVALTOTAL();
            strategy.appendField(locator, this, "valtotal", buffer, theVALTOTAL);
        }
        {
            Empty theNOLOTDIVISION;
            theNOLOTDIVISION = this.getNOLOTDIVISION();
            strategy.appendField(locator, this, "nolotdivision", buffer, theNOLOTDIVISION);
        }
        {
            Empty theLOTDIVISION;
            theLOTDIVISION = this.getLOTDIVISION();
            strategy.appendField(locator, this, "lotdivision", buffer, theLOTDIVISION);
        }
        {
            List<ObjectF15> theOBJECTDESCRS;
            theOBJECTDESCRS = (((this.objectdescrs!= null)&&(!this.objectdescrs.isEmpty()))?this.getOBJECTDESCRS():null);
            strategy.appendField(locator, this, "objectdescrs", buffer, theOBJECTDESCRS);
        }
        return buffer;
    }

}
