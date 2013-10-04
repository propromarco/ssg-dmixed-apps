package com.sksamuel.jqm4gwt.button;

/**
 * @author Stephen K Samuel samspade79@gmail.com 11 Jul 2011 22:07:28
 * 
 *         Interface for elements that are able to be rendered either
 *         horizontally or vertically.
 * 
 */
public interface HasOrientation {

	boolean isHorizontal();

	boolean isVertical();

	void setHorizontal();

	void setVertical();
}
