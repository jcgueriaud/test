package com.gmail.jeanchristophe;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The main view contains a button and a template element.
 */
@BodySize(height = "100vh", width = "100vw")
@HtmlImport("styles/shared-styles.html")
@Route("grid")
@Theme(Lumo.class)
public class GridView extends VerticalLayout {

    private List<MyItem> items;
    private Grid<MyItem> grid;
    private Text textGeneration = new Text("Init");
    private Text textSelected = new Text("Init");
    private Button simulationButton;

    private int generation = 1;

    public GridView() {
        grid = new Grid<>();
        grid.addColumn(MyItem::getId).setHeader("ID");
        grid.addColumn(MyItem::getValue).setHeader("Value");
        simulationButton = new Button("Simulation");
        simulationButton.addClickListener(e -> {generateItems();});

        grid.addSelectionListener(e -> {
            if( e.getFirstSelectedItem().isPresent()){
                textSelected.setText(e.getFirstSelectedItem().get().toString());
            } else {
                textSelected.setText("No selection");
            }
        });
        generateItems();


        add(grid,simulationButton,textGeneration,textSelected);

        setClassName("main-layout");
    }

    private void generateItems() {
        items = new ArrayList<>();
        items.add(new MyItem(1,"value1 V"+generation));
        items.add(new MyItem(2,"value2 V"+generation));
        grid.setItems(items);
        textGeneration.setText("generated "+generation);
        generation++;
        // does nothing
        grid.getDataProvider().refreshAll();
        grid.getDataProvider().refreshItem(items.get(0));
    }

    private class MyItem {
        private Integer id;
        private String value;

        public MyItem(Integer id, String value) {
            this.id = id;
            this.value = value;
        }

        @Override
        public String toString() {
            return "MyItem{" +
                    "id=" + id +
                    ", value='" + value + '\'' +
                    '}';
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyItem myItem = (MyItem) o;
            return Objects.equals(id, myItem.id);
        }

        @Override
        public int hashCode() {

            return Objects.hash(id);
        }

    }
}
