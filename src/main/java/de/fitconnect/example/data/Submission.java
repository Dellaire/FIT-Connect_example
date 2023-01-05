package de.fitconnect.example.data;

public class Submission {

    private String encryptedMetadata;
    private String encryptedData;

    public String getEncryptedMetadata() {
        return encryptedMetadata;
    }

    public Submission setEncryptedMetadata(String encryptedMetadata) {
        this.encryptedMetadata = encryptedMetadata;
        return this;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public Submission setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
        return this;
    }
}
