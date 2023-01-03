package de.fitconnect.example.data;

import java.util.ArrayList;
import java.util.List;

public class SubmissionAnnouncement {

    private String destinationId;
    private List<String> announcedAttachments = new ArrayList<>();
    private ServiceType serviceType;

    public String getDestinationId() {
        return destinationId;
    }

    public SubmissionAnnouncement setDestinationId(String destinationId) {
        this.destinationId = destinationId;
        return this;
    }

    public List<String> getAnnouncedAttachments() {
        return announcedAttachments;
    }

    public SubmissionAnnouncement setAnnouncedAttachments(List<String> announcedAttachments) {
        this.announcedAttachments = announcedAttachments;
        return this;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public SubmissionAnnouncement setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
        return this;
    }
}
