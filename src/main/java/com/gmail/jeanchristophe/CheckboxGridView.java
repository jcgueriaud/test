package com.gmail.jeanchristophe;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import java.util.*;

/**
 * The main view contains a button and a template element.
 */
@BodySize(height = "100vh", width = "100vw")
@HtmlImport("styles/shared-styles.html")
@Route("checkboxgrid")
@Theme(Lumo.class)
public class CheckboxGridView extends VerticalLayout {

    private List<MyItem> items;
    private Grid<MyItem> grid;
    private Button simulationButton;
    private Button check1Button;

    private boolean check = true;
    private int generation = 1;

    public CheckboxGridView() {
        grid = new Grid<>();
        grid.addColumn(MyItem::getId).setHeader("ID");
        grid.addColumn(MyItem::getValue).setHeader("Value");
        for(int i=1;i<= 8;i++) {
            addCheckbox(i);
        }
        simulationButton = new Button("Add items");
        simulationButton.addClickListener(e -> {grid.setItems(items);});

        check1Button = new Button("Check column 1");
        check1Button.addClickListener(e -> {
            items.forEach(item -> item.getChecks().put(1,check));
            check = !check;grid.getDataProvider().refreshAll();});

        generateItems();


        add(grid,simulationButton, check1Button);

        setClassName("main-layout");
    }

    private void addCheckbox(int i) {
        grid.addComponentColumn(myItem -> {
            Checkbox check = new Checkbox();
            check.setValue(myItem.getChecks().get(i));
            return check;
        }).setHeader(i+"");
    }

    private void generateItems() {
        items = new ArrayList<>();
        for(int i=0;i< 40000;i++){
            items.add(new MyItem(i));
        }
    }

    private class MyItem {
        private Integer id;
        private String value;
        private Map<Integer,Boolean> checks = new HashMap<>();

        private Random random;

        public MyItem(Integer id) {
            this(id, id.toString());
        }

        public MyItem(Integer id, String value) {
            this.id = id;
            this.value = value;
            random = new Random();
            generateChecks();
        }

        private void generateChecks() {
            checks.put(1,random.nextBoolean());
            checks.put(2,random.nextBoolean());
            checks.put(3,random.nextBoolean());
            checks.put(4,random.nextBoolean());
            checks.put(5,random.nextBoolean());
            checks.put(6,random.nextBoolean());
            checks.put(7,random.nextBoolean());
            checks.put(8,random.nextBoolean());
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

        public Map<Integer, Boolean> getChecks() {
            return checks;
        }

        public void setChecks(Map<Integer, Boolean> checks) {
            this.checks = checks;
        }



        @Override
        public int hashCode() {

            return Objects.hash(id);
        }

    }
}
