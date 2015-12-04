package de.subreport.elvis.server.ws.ted;

import eu.europa.publications.formex.ted.schema.Category;
import eu.europa.publications.formex.ted.schema.TCeLanguageList;

public interface TEDFormular {

	public String getFORM();

	public void setFORM(String value);

	public TCeLanguageList getLG();

	public void setLG(TCeLanguageList value);

	public Category getCATEGORY();

	public void setCATEGORY(Category value);

}
