package com.javafortesters.pulp.html.gui.entitycrud.viewPages;

import com.javafortesters.pulp.domain.objects.PulpPublisher;
import com.javafortesters.pulp.html.gui.snippets.AppPageBuilder;
import com.javafortesters.pulp.html.templates.MyTemplate;
import com.javafortesters.pulp.reader.ResourceReader;

public class ViewPublisherPage {
    private final PulpPublisher publisher;
    private final String appversion;

    public ViewPublisherPage(final PulpPublisher aPublisher, final String appversion) {
        this.publisher = aPublisher;
        this.appversion = appversion;
    }

    private String output="";

    public void setOutput(final String output) {
        this.output=output;
    }

    public String asHTMLString() {

        AppPageBuilder page = new AppPageBuilder("View Publisher", appversion);

        String pageToRender = new ResourceReader().asString("/web/apps/pulp/" + appversion + "/page-template/entity-crud/read/view-book-publisher-content.html");
        MyTemplate template = new MyTemplate(pageToRender);

        template.replace("!!ID!!", publisher.getId());
        template.replace("!!PUBLISHERNAME!!", publisher.getName());
        template.replace("<!-- OUTPUT GOES HERE -->", output);

        page.appendToBody(template.toString());
        return page.toString();
    }
}