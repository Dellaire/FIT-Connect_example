package de.fitconnect.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jose.jwk.RSAKey;
import de.fitconnect.example.clients.PublicKeyClient;
import de.fitconnect.example.clients.SubmissionClient;
import de.fitconnect.example.configuration.FitConnectProperties;
import de.fitconnect.example.data.PublicKey;
import de.fitconnect.example.data.ServiceType;
import de.fitconnect.example.data.SubmissionAnnouncement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private FitConnectProperties fitConnectProperties;

    @Autowired
    private SubmissionClient submissionClient;

    @Autowired
    private PublicKeyClient publicKeyClient;

    @Override
    public void run(String... args) throws Exception {

        String messageToSend = """
                {
                    "content": "Hello my dear receiver <3"
                }
                """;
        String destinationId = "destinationId";
        String publicKeyId = "publicKeyId";

        SubmissionAnnouncement submissionAnnouncement = new SubmissionAnnouncement().setDestinationId(destinationId).setServiceType(
                new ServiceType().setName("serviceTypeName").setIdentifier("urn:de:fim:leika:leistung:"));
        this.submissionClient.announceSubmission(submissionAnnouncement);

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        messageDigest.update(salt);
        byte[] payloadHash = messageDigest.digest(messageToSend.getBytes(StandardCharsets.UTF_8));

        // TODO hash attachments

        PublicKey publicKeyResponse = this.publicKeyClient.getPublicKey(destinationId, publicKeyId);
        // TODO validate key

        String publicKeyAsString = new ObjectMapper().writeValueAsString(publicKeyResponse);
        RSAPublicKey publicKey = RSAKey.parse(publicKeyAsString).toRSAPublicKey();
        JWEHeader jweHeader = new JWEHeader.Builder(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A256GCM).build();
        JWEObject jweObject = new JWEObject(jweHeader, new Payload(messageToSend));
        jweObject.encrypt(new RSAEncrypter(publicKey));
        String encryptedPayload = jweObject.serialize();

        // TODO upload attachments
    }
}
