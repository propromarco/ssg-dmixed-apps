/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.liste.server.jaxb;

import javax.xml.bind.annotation.XmlRootElement;

import de.clubbiertest.liste.shared.Bier;

import org.w3c.dom.Element;

@XmlRootElement ( name = "bier" )
public class BierImpl implements Bier
{
    private String name;
    private Double note;
    private Double design;
    private String uri;
    private String land;
    private String id;
    private String sorte;

    public BierImpl()
    {
    }

    public BierImpl( final Element element )
    {
        this.name = element.getAttribute("name");
        final String note = element.getAttribute("note");
        this.note = Double.valueOf(note.replace(',', '.'));
        final String design = element.getAttribute("design");
        this.design = Double.valueOf(design.replace(',', '.'));
        final Element parentNode = (Element) element.getParentNode();
        if ( parentNode.getNodeName().equals("sorte") )
        {
            sorte = parentNode.getAttribute("name");
            final Element parentNode2 = (Element) parentNode.getParentNode();
            land = parentNode2.getAttribute("name");
        }
        else
        {
            land = parentNode.getAttribute("name");
        }
    }

    /**
     * Getter for property id.
     * @return the value of property id
     */
    public String getId()
    {
        return id;
    }

    /**
     * Setter for property id
     * @param id the new value for property id to set.
     */
    public void setId( final String id )
    {
        this.id = id;
    }

    /**
     * Getter for property land.
     * @return the value of property land
     */
    public String getLand()
    {
        return land;
    }

    /**
     * Setter for property land
     * @param land the new value for property land to set.
     */
    public void setLand( final String land )
    {
        this.land = land;
    }

    /**
     * Getter for property sorte.
     * @return the value of property sorte
     */
    public String getSorte()
    {
        return sorte;
    }

    /**
     * Setter for property sorte
     * @param sorte the new value for property sorte to set.
     */
    public void setSorte( final String sorte )
    {
        this.sorte = sorte;
    }

    /**
     * Getter for property name.
     * @return the value of property name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Setter for property name
     * @param name the new value for property name to set.
     */
    public void setName( final String name )
    {
        this.name = name;
    }

    /**
     * Getter for property note.
     * @return the value of property note
     */
    public Double getNote()
    {
        return note;
    }

    /**
     * Setter for property note
     * @param note the new value for property note to set.
     */
    public void setNote( final Double note )
    {
        this.note = note;
    }

    /**
     * Getter for property design.
     * @return the value of property design
     */
    public Double getDesign()
    {
        return design;
    }

    /**
     * Setter for property design
     * @param design the new value for property design to set.
     */
    public void setDesign( final Double design )
    {
        this.design = design;
    }

    /**
     * Getter for property uri.
     * @return the value of property uri
     */
    public String getUri()
    {
        return uri;
    }

    /**
     * Setter for property uri
     * @param uri the new value for property uri to set.
     */
    public void setUri( final String uri )
    {
        this.uri = uri;
    }

    public boolean isBier()
    {
        return true;
    }

    public void setBier( final boolean b )
    {
    }
}
