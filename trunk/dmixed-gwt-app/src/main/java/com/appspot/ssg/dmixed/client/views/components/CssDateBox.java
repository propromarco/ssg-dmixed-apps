package com.appspot.ssg.dmixed.client.views.components;

import java.util.Date;

import com.appspot.ssg.dmixed.client.components.DatePicker;
import com.appspot.ssg.dmixed.client.components.IDatePickerDesign;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

public class CssDateBox extends Composite implements HasValue<Date>, ClickHandler {

    private final TextBox container = new TextBox();
    private Date value;
    private DefaultFormat format;
    private final IDatePickerDesign dateboxcss;

    public CssDateBox( final IDatePickerDesign dateboxcss) {
	this.dateboxcss = dateboxcss;
	container.setReadOnly(true);
	container.addClickHandler(this);
	initWidget(container);
	setStyleName("datebox");
	setFormat(new DefaultFormat(DateTimeFormat.getFormat("dd.MM.yyyy")));
	setValue(new Date());
    }

    public void setFormat(final DefaultFormat defaultFormat) {
	this.format = defaultFormat;
    }

    public DefaultFormat getFormat() {
	return format;
    }

    @Override
    public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<Date> handler) {
	return addHandler(handler, ValueChangeEvent.getType());
    }

    @Override
    public Date getValue() {
	return value;
    }

    @Override
    public void setValue(final Date value) {
	this.value = value;
	container.setValue(format.getDateTimeFormat().format(value));
    }

    @Override
    public void setValue(final Date value, final boolean fireEvents) {
	setValue(value);
    }

    @Override
    public void onClick(final ClickEvent event) {
	final DialogBox box = new DialogBox(true, true);
	box.getElement().setId("datebox");
	final DatePicker dateSwitchContainer = new DatePicker(dateboxcss);
	dateSwitchContainer.setValue(value);
	dateSwitchContainer.addValueChangeHandler(new ValueChangeHandler<Date>() {
	    @Override
	    public void onValueChange(final ValueChangeEvent<Date> event) {
		final Date v = event.getValue();
		if (v != null)
		    setValue(v);
		box.hide();
	    }
	});
	box.add(dateSwitchContainer);
	box.center();
    }

}
