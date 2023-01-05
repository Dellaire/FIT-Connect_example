package de.fitconnect.example.data.metadata;

public class MetadataContentStructureDataHash {

    public String type = "sha512";
    private String content;

    public String getType() {
        return type;
    }

    public MetadataContentStructureDataHash setType(String type) {
        this.type = type;
        return this;
    }

    public String getContent() {
        return content;
    }

    public MetadataContentStructureDataHash setContent(String content) {
        this.content = content;
        return this;
    }
}
