package com.appspot.ssg.dmixed.client.components;

import java.util.ArrayList;
import java.util.Date;

import com.appspot.ssg.dmixed.client.components.IDatePickerDesign.IFourIntegerPickerCss;
import com.appspot.ssg.dmixed.client.components.IDatePickerDesign.ITwoIntegerPickerCss;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasValue;

public class DatePicker extends Composite implements HasValue<Date> {

    private class DateValueChangeEvent extends ValueChangeEvent<Date> {
	protected DateValueChangeEvent(final Date value) {
	    super(value);
	}
    }

    private final FlowPanel container = new FlowPanel();
    private final IntegerPicker _day, _month, _year;
    private Date _value;
    private final ArrayList<HandlerRegistration> handlers = new ArrayList<HandlerRegistration>();

    public DatePicker(final IDatePickerDesign datePickerDesign) {
	final IDatePickerCss datePickerCss = datePickerDesign.getDatePickerCss();
	final ITwoIntegerPickerCss twoIntegerPickerCss = datePickerDesign.getTwoIntegerPickerCss();
	final IFourIntegerPickerCss fourIntegerPickerCss = datePickerDesign.getFourIntegerPickerCss();
	container.setStyleName(datePickerCss.container());
	_day = new IntegerPicker(twoIntegerPickerCss, 2);
	final ArrayList<Integer> days = new ArrayList<Integer>();
	for (int i = 1; i <= 31; i++)
	    days.add(i);
	_day.setValues(days.toArray(new Integer[0]));
	container.add(_day);
	_month = new IntegerPicker(twoIntegerPickerCss, 2);
	final ArrayList<Integer> months = new ArrayList<Integer>();
	for (int i = 1; i <= 12; i++)
	    months.add(i);
	_month.setValues(months.toArray(new Integer[0]));
	container.add(_month);
	_year = new IntegerPicker(fourIntegerPickerCss, 4);
	final ArrayList<Integer> years = new ArrayList<Integer>();
	for (int i = 1900; i <= 2014; i++)
	    years.add(i);
	_year.setValues(years.toArray(new Integer[0]));
	container.add(_year);
	final Button uebernehmen = new Button("OK");
	uebernehmen.setStyleName(datePickerCss.uebernehmen());
	uebernehmen.addClickHandler(new ClickHandler() {
	    @Override
	    public void onClick(final ClickEvent event) {
		setValue(_value, true);
	    }
	});
	container.add(uebernehmen);
	final Button abbrechen = new Button("Cancel");
	abbrechen.setStyleName(datePickerCss.abbrechen());
	abbrechen.addClickHandler(new ClickHandler() {
	    @Override
	    public void onClick(final ClickEvent event) {
		setValue(null, true);
	    }
	});
	container.add(abbrechen);
	initWidget(container);
    }

    @Override
    protected void onAttach() {
	super.onAttach();
	handlers.add(_day.addValueChangeHandler(new ValueChangeHandler<Integer>() {
	    @Override
	    public void onValueChange(final ValueChangeEvent<Integer> event) {
		onDayChanged(event.getValue());
	    }
	}));
	handlers.add(_month.addValueChangeHandler(new ValueChangeHandler<Integer>() {
	    @Override
	    public void onValueChange(final ValueChangeEvent<Integer> event) {
		onMonthChanged(event.getValue());
	    }
	}));
	handlers.add(_year.addValueChangeHandler(new ValueChangeHandler<Integer>() {
	    @Override
	    public void onValueChange(final ValueChangeEvent<Integer> event) {
		onYearChanged(event.getValue());
	    }
	}));
    }

    @SuppressWarnings("deprecation")
    protected void onDayChanged(final Integer day) {
	try {
	    final Date newDate = new Date(_value.getYear(), _value.getMonth(), day);
	    setValue(newDate, false);
	} catch (final Exception e) {
	}
    }

    @SuppressWarnings("deprecation")
    protected void onMonthChanged(final Integer month) {
	try {
	    final Date newDate = new Date(_value.getYear(), month - 1, _value.getDate());
	    setValue(newDate, false);
	} catch (final Exception e) {
	}
    }

    @SuppressWarnings("deprecation")
    protected void onYearChanged(final Integer year) {
	try {
	    final Date newDate = new Date(year - 1900, _value.getMonth(), _value.getDate());
	    setValue(newDate, false);
	} catch (final Exception e) {
	}
    }

    @Override
    protected void onDetach() {
	super.onDetach();
	for (final HandlerRegistration handler : handlers) {
	    handler.removeHandler();
	}
	handlers.clear();
    }

    @Override
    public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<Date> handler) {
	return addHandler(handler, ValueChangeEvent.getType());
    }

    @Override
    public Date getValue() {
	return _value;
    }

    @Override
    public void setValue(final Date value) {
	setValue(value, true);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void setValue(final Date value, final boolean fireEvents) {
	if (value != null) {
	    _value = value;
	    final int day = _value.getDate();
	    _day.setValue(day, fireEvents);
	    final int month = _value.getMonth() + 1;
	    _month.setValue(month, fireEvents);
	    final int year = _value.getYear() + 1900;
	    _year.setValue(year, fireEvents);
	}
	if (fireEvents) {
	    fireEvent(new DateValueChangeEvent(value));
	}
    }

}
