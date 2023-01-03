package de.fitconnect.example.clients;

import de.fitconnect.example.configuration.FitConnectProperties;
import de.fitconnect.example.data.PublicKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PublicKeyClient {

    @Autowired
    private FitConnectProperties fitConnectProperties;

    @Autowired
    private RestTemplate restTemplate;

    public PublicKey getPublicKey(String destinationId, String publikKeyId) {

        return this.restTemplate.exchange(this.fitConnectProperties.getPublicKeyUrl().formatted(destinationId, publikKeyId),
                HttpMethod.GET, null, PublicKey.class).getBody();
    }
}
