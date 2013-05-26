package com.appspot.ssg.dmixed.client.components;

import java.util.Arrays;

import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class IntegerPicker extends Composite implements HasValues<Integer> {
    private class IntegerEvent extends ValueChangeEvent<Integer> {

	protected IntegerEvent(final Integer value) {
	    super(value);
	}

    }

    public interface IClick {
	void onClick(int absoluteTop, int absoluteLeft);
    }

    private static class ClickableAnchor implements EventListener {
	private final Element _element;
	private final IClick _click;

	public ClickableAnchor(final IClick click, final String text) {
	    _click = click;
	    _element = DOM.createAnchor();
	    final Element innerText = DOM.createSpan();
	    innerText.setInnerHTML(text);
	    _element.appendChild(innerText);
	    DOM.sinkEvents(_element, Event.ONCLICK);
	    DOM.setEventListener(_element, this);
	}

	@Override
	public void onBrowserEvent(final Event event) {
	    event.stopPropagation();
	    final int absoluteLeft = _element.getAbsoluteLeft();
	    final int absoluteTop = _element.getAbsoluteTop();
	    _click.onClick(absoluteTop, absoluteLeft);
	}

	public void setStyleName(final String stylename) {
	    _element.setClassName(stylename);
	}
    }

    private final IIntegerPickerCss _css;
    private final FlowPanel container;
    private final ClickableAnchor upButton, downButton;
    private final Element intContainer;
    private int position = 0;
    private final int _length;
    private Integer[] _values;

    public IntegerPicker(final IIntegerPickerCss css, final int length) {
	_css = css;
	_length = length;
	container = new FlowPanel();
	container.setStyleName(css.container());
	initWidget(container);
	upButton = new ClickableAnchor(new IClick() {

	    @Override
	    public void onClick(final int absoluteTop, final int absoluteLeft) {
		goUp();
	    }
	}, "up");
	upButton.setStyleName(css.upbutton());
	container.getElement().appendChild(upButton._element);
	final Element intHolder = DOM.createDiv();
	intHolder.setClassName(css.intholder());
	container.getElement().appendChild(intHolder);
	intContainer = DOM.createDiv();
	intContainer.setClassName(css.intcontainer());
	intHolder.appendChild(intContainer);
	downButton = new ClickableAnchor(new IClick() {

	    @Override
	    public void onClick(final int absoluteTop, final int absoluteLeft) {
		goDown();
	    }
	}, "down");
	downButton.setStyleName(css.downbutton());
	container.getElement().appendChild(downButton._element);
    }

    private String toText(final Integer i, final int length) {
	String back = i.toString();
	while (back.length() < length)
	    back = "0" + back;
	return back;
    }

    private void goUp() {
	if (position < (_values.length - 1)) {
	    position += 1;
	    setPosition(position, true);
	}
    }

    private void goDown() {
	if (position > 0) {
	    position -= 1;
	    setPosition(position, true);
	}
    }

    private void setPosition(final int position, final boolean fireEvent) {
	this.position = position;
	this.intContainer.getStyle().setTop(-position, Unit.EM);
	if (fireEvent) {
	    fireEvent(new IntegerEvent(getValue()));
	}
    }

    @Override
    public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<Integer> handler) {
	return addHandler(handler, ValueChangeEvent.getType());
    }

    @Override
    public Integer getValue() {
	return _values[position];
    }

    @Override
    public void setValue(final Integer value) {
	setValue(value, true);
    }

    @Override
    public void setValue(final Integer value, final boolean fireEvents) {
	final int position = Arrays.binarySearch(_values, value);
	setPosition(position, fireEvents);
    }

    @Override
    public void setValues(final Integer... ts) {
	_values = ts;
	clearElement(intContainer);
	for (final int i : ts) {
	    final Element item = DOM.createDiv();
	    item.setInnerHTML(toText(i, _length));
	    item.setClassName(_css.intitem());
	    intContainer.appendChild(item);
	}
    }

    public static void clearElement(final Element element) {
	Node child = element.getFirstChild();
	while (child != null) {
	    element.removeChild(child);
	    child = element.getFirstChild();

	}
    }

}
