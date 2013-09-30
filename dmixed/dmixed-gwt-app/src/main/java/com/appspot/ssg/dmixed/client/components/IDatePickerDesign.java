package com.appspot.ssg.dmixed.client.components;

import com.google.gwt.resources.client.ClientBundle;

public interface IDatePickerDesign extends ClientBundle {

    public interface ITwoIntegerPickerCss extends IIntegerPickerCss {

    }

    public interface IFourIntegerPickerCss extends IIntegerPickerCss {

    }

    @Source("twointegerpicker.css")
    ITwoIntegerPickerCss getTwoIntegerPickerCss();

    @Source("fourintegerpicker.css")
    IFourIntegerPickerCss getFourIntegerPickerCss();

    @Source("datepicker.css")
    IDatePickerCss getDatePickerCss();

}
