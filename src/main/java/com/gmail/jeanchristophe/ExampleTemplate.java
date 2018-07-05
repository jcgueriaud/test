package com.gmail.jeanchristophe;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * Simple template example.
 */
@Tag("example-template")
@HtmlImport("src/example-template.html")
public class ExampleTemplate extends PolymerTemplate<TemplateModel> {


    public ExampleTemplate() {
    }

}
