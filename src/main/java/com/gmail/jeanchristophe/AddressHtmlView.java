package com.gmail.jeanchristophe;

import com.gmail.jeanchristophe.component.Address;
import com.gmail.jeanchristophe.component.CoordinatesField;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;


@BodySize(height = "100vh", width = "100vw")
@HtmlImport("styles/shared-styles.html")
@Route("address")
@Theme(Lumo.class)
public class AddressView extends VerticalLayout {

    private Binder<Address> binder = new Binder<>(Address.class);
    private TextField addressField = new TextField("Address");
    private CoordinatesField coordinatesField = new CoordinatesField();
    private Button readButton = new Button("READ DEFAULT BEAN");
    private Button writeButton = new Button("WRITE");


    private Button openButton = new Button("READ AND OPEN");

    private Div beanWritten = new Div();

    private Address address = new Address("test", 42.0,6.0);



    private Dialog dialog = new Dialog();

    public AddressView() {
        binder.forField(addressField).bind("address");
        binder.forField(coordinatesField).bind("coordinates");

        add(openButton);
        dialog.add(addressField,coordinatesField, readButton, writeButton, beanWritten);

        readButton.addClickListener(this::resetAndReadBean);
        writeButton.addClickListener(this::writeBean);

        openButton.addClickListener(this::readAndOpen);
        setClassName("main-layout");
    }

    private void readAndOpen(ClickEvent<Button> buttonClickEvent) {
        resetAndReadBean(buttonClickEvent);
        dialog.open();
    }


    private void resetAndReadBean(ClickEvent<Button> buttonClickEvent) {
        address = new Address("test", 42.0,6.0);
        binder.readBean(address);
    }

    private void writeBean(ClickEvent<Button> buttonClickEvent) {
        try {
            binder.writeBean(address);
            beanWritten.getElement().setText(address.toString());
        } catch (ValidationException e) {
            e.printStackTrace();
            beanWritten.getElement().setText("write error");
        }
    }

}
