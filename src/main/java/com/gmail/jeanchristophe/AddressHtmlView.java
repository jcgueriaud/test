package com.gmail.jeanchristophe;

import com.gmail.jeanchristophe.component.Address;
import com.gmail.jeanchristophe.component.CoordinatesField;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;


@Tag("address-html-view")
@Route("addressHtml")
@Theme(Lumo.class)
@HtmlImport("src/address-html-view.html")
public class AddressHtmlView extends PolymerTemplate<TemplateModel> {

    private Binder<Address> binder = new Binder<>(Address.class);
    @Id("address")
    private TextField addressField;

    @Id("coordinates")
    private CoordinatesField coordinatesField;

    @Id("readButton")
    private Button readButton;

    @Id("writeButton")
    private Button writeButton;


    @Id("beanWritten")
    private Div beanWritten;

    private Address address = new Address("test", 42.0,6.0);

    public AddressHtmlView() {
        binder.forField(addressField).bind("address");
        binder.forField(coordinatesField).bind("coordinates");

        readButton.addClickListener(this::resetAndReadBean);
        writeButton.addClickListener(this::writeBean);

        binder.readBean(new Address("test", 43.0,7.0));
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
