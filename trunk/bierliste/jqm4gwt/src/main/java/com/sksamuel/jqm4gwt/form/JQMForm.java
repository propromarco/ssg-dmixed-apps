package com.sksamuel.jqm4gwt.form;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Label;
import com.sksamuel.jqm4gwt.Mobile;
import com.sksamuel.jqm4gwt.form.elements.JQMFormWidget;
import com.sksamuel.jqm4gwt.form.validators.NotNullOrEmptyValidator;
import com.sksamuel.jqm4gwt.form.validators.Validator;

/**
 * @author Stephen K Samuel samspade79@gmail.com 12 Jul 2011 21:36:02
 * 
 *         A {@link JQMForm} is a standard GWT panel that offers extra
 *         functionality for quick building of input forms. The framework offers
 *         built in validation and error reporting and simplified submission
 *         processing.<br/>
 * <br/>
 * 
 *         All widgets for the form should be added in the implementing classes
 *         implementation of fieldAttach();<br/>
 * <br/>
 * 
 *         Any {@link JQMSubmit} widgets that are added will be automatically
 *         wired to submit this form. Alternatively, any widget can be set to
 *         programatically submit the form by invoking submit();
 * 
 */
public abstract class JQMForm extends FlowPanel {

	/**
	 * Associates a validator and the label to which it will publish the error
	 * message.
	 * 
	 */
	class ValidationTuple {

		Validator	validator;
		Label		label;
	}

	private List<ValidationTuple>		widgetValidators	= new ArrayList();
	private FlowPanel				errors		= new FlowPanel();

	/**
	 * The SubmissionHandler is invoked when the form is successfully
	 * submitted.
	 */
	private final SubmissionHandler	handler;

	protected JQMForm(SubmissionHandler handler) {
		add(errors);
		this.handler = handler;
	}

	/**
	 * Add the given submit button to the form and automatically have it set
	 * to submit the form on a click event.
	 */
	protected void add(JQMSubmit submit) {
		super.add(submit);
		submit.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				submit();
			}
		});
	}

	/**
	 * Adds the given widget and sets it to be required. Then this field will
	 * be checked to ensure it has a value set before the form will be
	 * submitted. In effect, setting a field to required adds an implicit
	 * "not null or empty" validator.
	 */
	public void addRequired(JQMFormWidget widget) {
		addRequired(widget, "This field cannot be empty");
	}

	public void addRequired(JQMFormWidget widget, String msg) {
		add(widget);
		setRequired(widget, msg);
	}

	/**
	 * 
	 * This method will automatically add a label element which will be made
	 * visible with an error message when validate is called on this field and
	 * fails.
	 * 
	 * The label element will be located immediately after the supplied widget
	 * (as first sibling).
	 * 
	 * If the widget is not null then the an onBlur handler will be registered
	 * that will trigger validation for this validator only.
	 * 
	 * @param widget
	 *              the element to which the error message should be
	 *              associated with. If this param is null then the label will
	 *              be added at the end of the current list of widgets.
	 * 
	 * @param validator
	 *              the validator that will perform the validation
	 */
	public void addValidator(final JQMFormWidget widget, Validator validator) {

		final ValidationTuple tuple = new ValidationTuple();
		tuple.label = new InlineLabel();
		tuple.label.setStyleName("jqm4gwt-error");
		tuple.validator = validator;
		widgetValidators.add(tuple);

		// hide and attach the label to the appropriate place
		tuple.label.setVisible(false);

		add(tuple.label);

		// int indexOf = getChildren().indexOf(widget.asWidget());
		// System.out.println("msg:" + indexOf);
		// insert(tuple.label, indexOf + 1);

		if (widget != null) {
			widget.addBlurHandler(new BlurHandler() {

				@Override
				public void onBlur(BlurEvent event) {
					System.out.println("blurring");
					// on a blur we only want to validate if the user
					// entered info
					if (widget.getValue() == null || widget.getValue().trim().length() == 0)
						tuple.label.setVisible(false);
					else
						validate(tuple);
				}
			});
		}
	}

	/**
	 * @see addValidator(null, validator);
	 */
	public void addValidator(Validator validator) {
		addValidator(null, validator);
	}

	public void hideFormProcessingDialog() {
		Mobile.hideLoadingDialog();
	}

	/**
	 * Set a general error on the form.
	 */
	public void setError(String string) {
		errors.add(new Label(string));
		Window.scrollTo(0, 0);
	}

	/**
	 * Sets the given widget to be required with a custom message. Then this
	 * field will be checked to ensure it has a value set before the form will
	 * be submitted. In effect, setting a field to required adds an implicit
	 * "not null or empty" validator.
	 */
	public void setRequired(JQMFormWidget widget, String msg) {
		addValidator(widget, new NotNullOrEmptyValidator(widget, msg));
	}

	public void showFormProcessingDialog(String msg) {
		Mobile.showLoadingDialog(msg);
	}

	/**
	 * This method is invoked when the form is ready for submission. Typically
	 * this method would be called from one of your submission buttons
	 * automatically but it is possible to invoke it programatically.
	 * 
	 * Before validation, the general errors are cleared.
	 * 
	 * If the validation phase is passed the the submission handler will be
	 * invoked. Before the handler is invoked, the page loading dialog will be
	 * shown so that async requests can complete in the background.
	 * 
	 * The {@link SubmissionHandler} must hide the loading dialog by calling
	 * hideFormProcessingDialog() on the form or by calling
	 * Mobile.hideLoadingDialog()
	 */
	public void submit() {
		System.out.println("processing submission");
		errors.clear();
		boolean validated = validate();
		if (validated) {
			showFormProcessingDialog("Submitting form");
			handler.onSubmit(this);
		} else {
			Window.scrollTo(0, 0);
		}
	}

	/**
	 * Perform validation for all validators, setting error messages where
	 * appropriate.
	 * 
	 * 
	 * @return true if validation was successful for all validators, otherwise
	 *         false.
	 * 
	 */
	public boolean validate() {
		boolean validated = true;
		for (ValidationTuple tuple : widgetValidators) {
			if (!validate(tuple))
				validated = false;
		}
		return validated;
	}

	protected boolean validate(ValidationTuple tuple) {
		String msg = tuple.validator.validate();
		if (msg == null || msg.length() == 0) {
			tuple.label.setVisible(false);
			tuple.label.setText(null);
			return true;
		} else {
			tuple.label.setVisible(true);
			tuple.label.setText(msg);
			return false;
		}
	}
}
