package com.gmail.jeanchristophe.component;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.PropertyChangeEvent;


@Tag("coordinates-field")
@HtmlImport("src/component/coordinates-field.html")
public class CoordinatesField extends AbstractField<CoordinatesField,MyCoordinates> {

    public CoordinatesField() {
        this(new MyCoordinates(0.0,0.0));
    }

    public CoordinatesField(MyCoordinates defaultValue) {
        super(defaultValue);
        setupProperty("latitude", "latitude-changed");
        setupProperty("longitude", "longitude-changed");
    }

    @Override
    protected void setPresentationValue(MyCoordinates myCoordinates) {

        Element element = getElement();

        if (myCoordinates == null) {
            element.removeProperty("latitude");
            element.removeProperty("longitude");
        } else {
            element.setProperty("latitude", myCoordinates.getLatitude());
            element.setProperty("longitude", myCoordinates.getLongitude());
        }

    }

    private void setupProperty(String name, String event) {
        Element element = getElement();

        element.synchronizeProperty(name, event);
        element.addPropertyChangeListener(name, this::propertyUpdated);
    }

    private void propertyUpdated(PropertyChangeEvent event) {

        Element element = getElement();

        double latitude = element.getProperty("latitude", 0.0);
        double longitude = element.getProperty("longitude", 0.0);

        System.out.println("propertyUpdated (" + latitude + ", "+longitude +")");
        MyCoordinates value = new MyCoordinates(latitude,longitude);
        setModelValue(value, event.isUserOriginated());
    }

}
