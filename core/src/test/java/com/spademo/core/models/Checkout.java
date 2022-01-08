package com.spademo.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class, adapters = { Checkout.class,
        ComponentExporter.class }, resourceType = Checkout.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class Checkout implements ComponentExporter {

    public static final String RESOURCE_TYPE="spademo/components/checkout";

    @ValueMapValue
    String title;

    public String getTitle(){
        return this.title;
    }

    @Override
    public String getExportedType() {
        return Checkout.RESOURCE_TYPE;
    }
}
