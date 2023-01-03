package de.fitconnect.example.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("fitconnect")
public class FitConnectProperties {

    private String submissionUrl;
    private String publicKeyUrl;
    private String schemaServiceUrl;

    public String getSubmissionUrl() {
        return submissionUrl;
    }

    public void setSubmissionUrl(String submissionUrl) {
        this.submissionUrl = submissionUrl;
    }

    public String getPublicKeyUrl() {
        return publicKeyUrl;
    }

    public void setPublicKeyUrl(String publicKeyUrl) {
        this.publicKeyUrl = publicKeyUrl;
    }

    public String getSchemaServiceUrl() {
        return schemaServiceUrl;
    }

    public void setSchemaServiceUrl(String schemaServiceUrl) {
        this.schemaServiceUrl = schemaServiceUrl;
    }
}
