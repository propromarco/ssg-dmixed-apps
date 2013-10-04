package com.sksamuel.jqm4gwt.form;

/**
 * @author Stephen K Samuel samspade79@gmail.com 12 Jul 2011 21:54:36
 * 
 *         A submission handler is invoked when a form is submitted after
 *         validation has succeeded.
 * 
 */
public interface SubmissionHandler<T extends JQMForm> {

	void onSubmit(T form);
}
