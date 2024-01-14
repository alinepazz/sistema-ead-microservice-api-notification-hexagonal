package com.br.eadnotificationhexagonal.adapters.outbound.persistence.entities;

import com.br.eadnotificationhexagonal.core.domain.enums.NotificationSatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "TB_NOTIFICATIONS")
public class NotificationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID notificationId;
    @Column(nullable = false)
    private UUID userId;
    @Column(nullable = false, length = 150)
    private String title;
    @Column(nullable = false)
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime creationDate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
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
