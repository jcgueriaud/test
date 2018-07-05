package com.gmail.jeanchristophe;

import com.gmail.jeanchristophe.component.Address;
import com.gmail.jeanchristophe.component.CoordinatesField;
import com.gmail.jeanchristophe.component.CoordinatesMapField;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import java.time.LocalDate;


@Tag("popup-map-view")
@Route("popupMap")
@HtmlImport("src/popup-map-view.html")
public class PopupMapView extends PolymerTemplate<TemplateModel> {

    @Id("button")
    private Button button;
    @Id("button2")
    private Button button2;


    @Id("dialog")
    private Dialog dialog;

    private Dialog dialog2 = new Dialog();

    public PopupMapView() {
        dialog2.add(new ExampleTemplate());
        button.addClickListener(e -> dialog.setOpened(true));
        button2.addClickListener(e -> dialog2.setOpened(true));
    }

}
/*
@Tag("popup-map-view")
@Route("popupMap")
@Theme(Lumo.class)
public class PopupMapView extends VerticalLayout {

    private CoordinatesMapField coordinatesMapField = new CoordinatesMapField();
    private Button openDialogButton = new Button("Open dialog");
    private Dialog dialog = new Dialog();

    public PopupMapView() {
        openDialogButton.addClickListener(event -> dialog.open());
        dialog.add(coordinatesMapField);

        add(openDialogButton);


        setClassName("main-layout");
    }

}
*/