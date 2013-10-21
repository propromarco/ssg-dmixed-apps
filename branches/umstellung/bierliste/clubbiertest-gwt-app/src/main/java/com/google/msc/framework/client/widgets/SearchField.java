package com.google.msc.framework.client.widgets;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextBox;

public class SearchField extends Composite implements HasChangeHandlers {

    public interface ISearchFieldDesign extends CssResource {

        String searchMain();

        String textbox();

        String button();

    }

    private final FlowPanel mainWidget = new FlowPanel();
    private final TextBox text;
    private final Anchor button;
    private final List<HandlerRegistration> l = new ArrayList<HandlerRegistration>();

    public SearchField(final ISearchFieldDesign design) {
        text = new TextBox();
        text.setStyleName(design.textbox());
        mainWidget.add(text);
        button = new Anchor();
        button.setStyleName(design.button());
        mainWidget.add(button);
        mainWidget.setStyleName(design.searchMain());
        initWidget(mainWidget);
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        l.add(text.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(final ChangeEvent event) {
                fireEvent(new ChangeEvent() {
                });
            }
        }));
        button.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                fireEvent(new ChangeEvent() {
                });
            }
        });
    }

    @Override
    protected void onDetach() {
        super.onDetach();
        for (final HandlerRegistration registration : l) {
            registration.removeHandler();
        }
        l.clear();
    }

    @Override
    public HandlerRegistration addChangeHandler(final ChangeHandler handler) {
        return addDomHandler(handler, ChangeEvent.getType());
    }

    public String getSearchText() {
        return text.getText();
    }

}
