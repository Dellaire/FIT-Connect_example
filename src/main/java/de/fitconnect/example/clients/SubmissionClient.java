package de.fitconnect.example.clients;

import de.fitconnect.example.configuration.FitConnectProperties;
import de.fitconnect.example.data.SubmissionAnnouncement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SubmissionClient {

    @Autowired
    private FitConnectProperties fitConnectProperties;

    @Autowired
    private RestTemplate restTemplate;

    public void announceSubmission(SubmissionAnnouncement submissionAnnouncement) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<SubmissionAnnouncement> httpEntity = new HttpEntity<>(submissionAnnouncement, httpHeaders);

        this.restTemplate.exchange(this.fitConnectProperties.getSubmissionUrl(), HttpMethod.POST, httpEntity, String.class);
    }
}
