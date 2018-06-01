package com.gmail.jeanchristophe;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;

/**
 * The main view contains a button and a template element.
 */
@BodySize(height = "100vh", width = "100vw")
@HtmlImport("styles/shared-styles.html")
@Route("date")
@Theme(Lumo.class)
public class DatePickerView extends VerticalLayout {

    private DatePicker dateDialog = new DatePicker("date Dialog");
    private DatePicker dateDialogToday = new DatePicker("date Dialog Today");

    public DatePickerView() {
        LocalDate date30May = LocalDate.of(2018, Month.MAY, 30);
        LocalDate date06May = LocalDate.of(2018, Month.MAY, 6);

        DateUtils.initDatePickerI18n(dateDialog);
        dateDialog.setValue(date06May);


        DateUtils.initDatePickerI18n(dateDialogToday);
        dateDialogToday.setValue(date30May);

        add(dateDialog,dateDialogToday);




        setClassName("main-layout");
    }

}
