package com.gmail.jeanchristophe;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import java.awt.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * The main view contains a button and a template element.
 */
@BodySize(height = "100vh", width = "100vw")
@HtmlImport("styles/shared-styles.html")
@Route("combo")
@Theme(Lumo.class)
public class ComboView extends VerticalLayout {

    private ComboBox<String> comboBox = new ComboBox("combo");
    private Button checkButton = new Button("Check value");

    private final String[] dataLabel = {"Label 1","Label 2","Label 3","Label 4"};

    public ComboView() {
        comboBox.setItems(dataLabel);
        comboBox.setValue(dataLabel[1]);
        checkButton.addClickListener(event -> Notification.show("Value "+ comboBox.getValue()));
        add(comboBox,checkButton);

        setClassName("main-layout");
    }

}
