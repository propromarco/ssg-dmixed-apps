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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
 * Section II: OBJECT OF THE CONTRACT
 * 
 * <p>Java class for object_contract_f04 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="object_contract_f04">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}TITLE"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}REFERENCE_NUMBER" minOccurs="0"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}CPV_MAIN"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}TYPE_CONTRACT"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}SHORT_DESCR"/>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}VAL_ESTIMATED_TOTAL" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="LOT_DIVISION" type="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}lot_division_f04"/>
 *             &lt;element name="OBJECT_DESCR" type="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}object_f04" maxOccurs="1000"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}NO_LOT_DIVISION"/>
 *             &lt;element name="OBJECT_DESCR" type="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}object_f04"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;element ref="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}DATE_PUBLICATION_NOTICE" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ITEM" use="required" type="{http://formex.publications.europa.eu/ted/schema/reception/R2.0.9.S01}nb_object_contract" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "object_contract_f04", propOrder = {
    "title",
    "referencenumber",
    "cpvmain",
    "typecontract",
    "shortdescr",
    "valestimatedtotal",
    "nolotdivision",
    "lotdivision",
    "objectdescrs",
    "datepublicationnotice"
})
public class ObjectContractF04
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
    @XmlElement(name = "VAL_ESTIMATED_TOTAL")
    protected Val valestimatedtotal;
    @XmlElement(name = "NO_LOT_DIVISION")
    protected Empty nolotdivision;
    @XmlElement(name = "LOT_DIVISION")
    protected LotDivisionF04 lotdivision;
    @XmlElement(name = "OBJECT_DESCR")
    protected List<ObjectF04> objectdescrs;
    @XmlElement(name = "DATE_PUBLICATION_NOTICE")
    protected XMLGregorianCalendar datepublicationnotice;
    @XmlAttribute(name = "ITEM", required = true)
    protected int item;

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
     * Gets the value of the valestimatedtotal property.
     * 
     * @return
     *     possible object is
     *     {@link Val }
     *     
     */
    public Val getVALESTIMATEDTOTAL() {
        return valestimatedtotal;
    }

    /**
     * Sets the value of the valestimatedtotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Val }
     *     
     */
    public void setVALESTIMATEDTOTAL(Val value) {
        this.valestimatedtotal = value;
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
     *     {@link LotDivisionF04 }
     *     
     */
    public LotDivisionF04 getLOTDIVISION() {
        return lotdivision;
    }

    /**
     * Sets the value of the lotdivision property.
     * 
     * @param value
     *     allowed object is
     *     {@link LotDivisionF04 }
     *     
     */
    public void setLOTDIVISION(LotDivisionF04 value) {
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
     * {@link ObjectF04 }
     * 
     * 
     */
    public List<ObjectF04> getOBJECTDESCRS() {
        if (objectdescrs == null) {
            objectdescrs = new ArrayList<ObjectF04>();
        }
        return this.objectdescrs;
    }

    /**
     * Gets the value of the datepublicationnotice property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDATEPUBLICATIONNOTICE() {
        return datepublicationnotice;
    }

    /**
     * Sets the value of the datepublicationnotice property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDATEPUBLICATIONNOTICE(XMLGregorianCalendar value) {
        this.datepublicationnotice = value;
    }

    /**
     * Gets the value of the item property.
     * 
     */
    public int getITEM() {
        return item;
    }

    /**
     * Sets the value of the item property.
     * 
     */
    public void setITEM(int value) {
        this.item = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ObjectContractF04)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ObjectContractF04 that = ((ObjectContractF04) object);
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
            Val lhsVALESTIMATEDTOTAL;
            lhsVALESTIMATEDTOTAL = this.getVALESTIMATEDTOTAL();
            Val rhsVALESTIMATEDTOTAL;
            rhsVALESTIMATEDTOTAL = that.getVALESTIMATEDTOTAL();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "valestimatedtotal", lhsVALESTIMATEDTOTAL), LocatorUtils.property(thatLocator, "valestimatedtotal", rhsVALESTIMATEDTOTAL), lhsVALESTIMATEDTOTAL, rhsVALESTIMATEDTOTAL)) {
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
            LotDivisionF04 lhsLOTDIVISION;
            lhsLOTDIVISION = this.getLOTDIVISION();
            LotDivisionF04 rhsLOTDIVISION;
            rhsLOTDIVISION = that.getLOTDIVISION();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lotdivision", lhsLOTDIVISION), LocatorUtils.property(thatLocator, "lotdivision", rhsLOTDIVISION), lhsLOTDIVISION, rhsLOTDIVISION)) {
                return false;
            }
        }
        {
            List<ObjectF04> lhsOBJECTDESCRS;
            lhsOBJECTDESCRS = (((this.objectdescrs!= null)&&(!this.objectdescrs.isEmpty()))?this.getOBJECTDESCRS():null);
            List<ObjectF04> rhsOBJECTDESCRS;
            rhsOBJECTDESCRS = (((that.objectdescrs!= null)&&(!that.objectdescrs.isEmpty()))?that.getOBJECTDESCRS():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "objectdescrs", lhsOBJECTDESCRS), LocatorUtils.property(thatLocator, "objectdescrs", rhsOBJECTDESCRS), lhsOBJECTDESCRS, rhsOBJECTDESCRS)) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsDATEPUBLICATIONNOTICE;
            lhsDATEPUBLICATIONNOTICE = this.getDATEPUBLICATIONNOTICE();
            XMLGregorianCalendar rhsDATEPUBLICATIONNOTICE;
            rhsDATEPUBLICATIONNOTICE = that.getDATEPUBLICATIONNOTICE();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "datepublicationnotice", lhsDATEPUBLICATIONNOTICE), LocatorUtils.property(thatLocator, "datepublicationnotice", rhsDATEPUBLICATIONNOTICE), lhsDATEPUBLICATIONNOTICE, rhsDATEPUBLICATIONNOTICE)) {
                return false;
            }
        }
        {
            int lhsITEM;
            lhsITEM = (true?this.getITEM(): 0);
            int rhsITEM;
            rhsITEM = (true?that.getITEM(): 0);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "item", lhsITEM), LocatorUtils.property(thatLocator, "item", rhsITEM), lhsITEM, rhsITEM)) {
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
            Val theVALESTIMATEDTOTAL;
            theVALESTIMATEDTOTAL = this.getVALESTIMATEDTOTAL();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "valestimatedtotal", theVALESTIMATEDTOTAL), currentHashCode, theVALESTIMATEDTOTAL);
        }
        {
            Empty theNOLOTDIVISION;
            theNOLOTDIVISION = this.getNOLOTDIVISION();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nolotdivision", theNOLOTDIVISION), currentHashCode, theNOLOTDIVISION);
        }
        {
            LotDivisionF04 theLOTDIVISION;
            theLOTDIVISION = this.getLOTDIVISION();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lotdivision", theLOTDIVISION), currentHashCode, theLOTDIVISION);
        }
        {
            List<ObjectF04> theOBJECTDESCRS;
            theOBJECTDESCRS = (((this.objectdescrs!= null)&&(!this.objectdescrs.isEmpty()))?this.getOBJECTDESCRS():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "objectdescrs", theOBJECTDESCRS), currentHashCode, theOBJECTDESCRS);
        }
        {
            XMLGregorianCalendar theDATEPUBLICATIONNOTICE;
            theDATEPUBLICATIONNOTICE = this.getDATEPUBLICATIONNOTICE();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "datepublicationnotice", theDATEPUBLICATIONNOTICE), currentHashCode, theDATEPUBLICATIONNOTICE);
        }
        {
            int theITEM;
            theITEM = (true?this.getITEM(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "item", theITEM), currentHashCode, theITEM);
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
            Val theVALESTIMATEDTOTAL;
            theVALESTIMATEDTOTAL = this.getVALESTIMATEDTOTAL();
            strategy.appendField(locator, this, "valestimatedtotal", buffer, theVALESTIMATEDTOTAL);
        }
        {
            Empty theNOLOTDIVISION;
            theNOLOTDIVISION = this.getNOLOTDIVISION();
            strategy.appendField(locator, this, "nolotdivision", buffer, theNOLOTDIVISION);
        }
        {
            LotDivisionF04 theLOTDIVISION;
            theLOTDIVISION = this.getLOTDIVISION();
            strategy.appendField(locator, this, "lotdivision", buffer, theLOTDIVISION);
        }
        {
            List<ObjectF04> theOBJECTDESCRS;
            theOBJECTDESCRS = (((this.objectdescrs!= null)&&(!this.objectdescrs.isEmpty()))?this.getOBJECTDESCRS():null);
            strategy.appendField(locator, this, "objectdescrs", buffer, theOBJECTDESCRS);
        }
        {
            XMLGregorianCalendar theDATEPUBLICATIONNOTICE;
            theDATEPUBLICATIONNOTICE = this.getDATEPUBLICATIONNOTICE();
            strategy.appendField(locator, this, "datepublicationnotice", buffer, theDATEPUBLICATIONNOTICE);
        }
        {
            int theITEM;
            theITEM = (true?this.getITEM(): 0);
            strategy.appendField(locator, this, "item", buffer, theITEM);
        }
        return buffer;
    }

}
