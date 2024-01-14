package com.br.eadnotificationhexagonal.core.domain;


import com.br.eadnotificationhexagonal.core.domain.enums.NotificationSatus;
import java.time.LocalDateTime;
import java.util.UUID;

public class NotificationDomain {

    private UUID notificationId;
    private UUID userId;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private NotificationSatus notificationSatus;

    public UUID getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(UUID notificationId) {
        this.notificationId = notificationId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public NotificationSatus getNotificationSatus() {
        return notificationSatus;
    }

    public void setNotificationSatus(NotificationSatus notificationSatus) {
        this.notificationSatus = notificationSatus;
    }
}
