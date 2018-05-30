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

    /**
     * The main view contains a button and a template element.
     */
    @BodySize(height = "100vh", width = "100vw")
    @HtmlImport("styles/shared-styles.html")
    @Route("")
    @Theme(Lumo.class)
    public class MainView extends VerticalLayout {


        private ComboBox<Integer> comboBox;

        private RadioButtonGroup<Integer> radioButtonGroup;

        private Dialog dialog;
        private Button openButton;
        private Button bindButton1;
        private Button bindButton2;

        private final Integer[] data = {0,1,2,3};
        private final String[] dataLabel = {"Label 1","Label 2","Label 3","Label 4"};
        private MyItem item1 = new MyItem(0,0);
        private MyItem item2= new MyItem(1,1);

        private Binder<MyItem> binder = new Binder<>();

        public MainView() {
            dialog = new Dialog();


            radioButtonGroup = new RadioButtonGroup<>();
            radioButtonGroup.setItems(data);
            radioButtonGroup.setRenderer(new ComponentRenderer<>(integer -> new Text(dataLabel[integer])));
            comboBox = new ComboBox<>("Test");
            comboBox.setItems(data);
            comboBox.setItemLabelGenerator(integer -> dataLabel[integer]);
            bindButton1 = new Button("Bind 1");
            bindButton1.addClickListener(event -> {binder.setBean(item1);});

            bindButton2 = new Button("Bind 2");
            bindButton2.addClickListener(event -> {binder.setBean(item2);});

            dialog.add(radioButtonGroup, comboBox);
            openButton = new Button("Open");
            openButton.addClickListener(e -> dialog.open());
            add(bindButton1, bindButton2,openButton);

            binder.bind(comboBox,MyItem::getCombobox,MyItem::setCombobox);
            binder.bind(radioButtonGroup,MyItem::getRadioButtonGroup,MyItem::setRadioButtonGroup);
            setClassName("main-layout");
        }

        private class MyItem {
            private Integer combobox;
            private Integer radioButtonGroup;

            public MyItem(Integer combobox, Integer radioButtonGroup) {
                this.combobox = combobox;
                this.radioButtonGroup = radioButtonGroup;
            }

            public Integer getCombobox() {
                return combobox;
            }

            public void setCombobox(Integer combobox) {
                this.combobox = combobox;
            }

            public Integer getRadioButtonGroup() {
                return radioButtonGroup;
            }

            public void setRadioButtonGroup(Integer radioButtonGroup) {
                this.radioButtonGroup = radioButtonGroup;
            }
        }
    }
