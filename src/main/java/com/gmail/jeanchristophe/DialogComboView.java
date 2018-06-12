package com.gmail.jeanchristophe;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import java.time.LocalDate;

/**
 * The main view contains a button and a template element.
 */
@BodySize(height = "100vh", width = "100vw")
@HtmlImport("styles/shared-styles.html")
@Route("dialogcombo")
@Theme(Lumo.class)
public class DialogComboView extends VerticalLayout {

    private ComboBox<String> comboBox = new ComboBox("combo");
    private DatePicker datePicker = new DatePicker("datepicker");
    private Button openDialogButton = new Button("Open dialog");
    private Dialog dialog = new Dialog();

    private final String[] dataLabel = {"Label 1","Label 2","Label 3","Label 4"};

    public DialogComboView() {
        comboBox.setItems(dataLabel);
        comboBox.setValue(dataLabel[1]);
        openDialogButton.addClickListener(event -> dialog.open());
        datePicker.setValue(LocalDate.now());
        dialog.add(comboBox, datePicker);

        add(openDialogButton);


        setClassName("main-layout");
    }

}
