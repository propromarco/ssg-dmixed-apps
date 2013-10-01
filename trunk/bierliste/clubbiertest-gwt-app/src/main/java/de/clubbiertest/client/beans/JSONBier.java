/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.client.beans;

import com.google.gwt.json.client.JSONObject;

import de.clubbiertest.liste.shared.Bier;

public class JSONBier extends JSONItem implements Bier
{
    private final Double note, design;
    private final String sorte, land;

    public JSONBier( final JSONObject object )
    {
        super(object);
        this.land = JSONUtils.getString(object.get("land"));
        this.sorte = JSONUtils.getString(object.get("sorte"));
        this.note = JSONUtils.getDouble(object.get("note"));
        this.design = JSONUtils.getDouble(object.get("design"));
    }

    @Override public Double getDesign()
    {
        return this.design;
    }

    @Override public Double getNote()
    {
        return this.note;
    }

    @Override public String getLand()
    {
        return this.land;
    }

    @Override public String getSorte()
    {
        return this.sorte;
    }
}
