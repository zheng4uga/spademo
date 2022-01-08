
package com.spademo.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

@Model(adaptables = SlingHttpServletRequest.class, adapters = { Checkout.class,
        ComponentExporter.class }, resourceType = Checkout.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class Checkout implements ComponentExporter {

    public static final String RESOURCE_TYPE="spademo/components/checkout";
    boolean shouldRender=false;

    @ValueMapValue
    @Default(values = "Shopping Cart")
    String title;

    @ValueMapValue
    @Default(values = "Order Summary")
    String summaryTitle;

    @ValueMapValue
    String helpText;

    @PostConstruct
    void initModel() {
        shouldRender = StringUtils.isNotBlank(title);
    }

    public boolean getShouldRender(){
        return this.shouldRender;
    }

    public String getTitle(){
        return this.title;
    }

    public String getSummaryTitle() {
        return summaryTitle;
    }

    public String getHelpText() {
        return helpText;
    }

    @Override
    public String getExportedType() {
        return Checkout.RESOURCE_TYPE;
    }


}
