package com.br.eadnotificationhexagonal.adapters.dtos;

import com.br.eadnotificationhexagonal.core.domain.enums.NotificationStatus;
import javax.validation.constraints.NotNull;

public class NotificationDto {

    @NotNull
    private NotificationStatus notificationStatus;

    public NotificationStatus getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(NotificationStatus notificationStatus) {
        this.notificationStatus = notificationStatus;
    }
}
