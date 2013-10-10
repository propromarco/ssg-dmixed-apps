/* Copyright, (c) 2011 Suretec GmbH  */

package de.clubbiertest.client.beans;

import com.google.gwt.json.client.JSONObject;

import de.clubbiertest.liste.shared.ListItem;

public class JSONItem implements ListItem {
    private final String id, name, uri;
    private final boolean bier;

    public JSONItem(final JSONObject object) {
        this.id = JSONUtils.getString(object.get("id"));
        this.name = JSONUtils.getString(object.get("name"));
        this.uri = JSONUtils.getString(object.get("uri"));
        this.bier = JSONUtils.getBoolean(object.get("bier"));
    }

    public JSONItem(final String name, final String url) {
        this.id = null;
        this.name = name;
        this.uri = url;
        this.bier = false;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getUri() {
        return this.uri;
    }

    @Override
    public boolean isBier() {
        return this.bier;
    }
}
