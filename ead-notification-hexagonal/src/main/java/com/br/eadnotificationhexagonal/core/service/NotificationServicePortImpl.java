package com.br.eadnotificationhexagonal.core.service;

import com.br.eadnotificationhexagonal.core.domain.NotificationDomain;
import com.br.eadnotificationhexagonal.core.domain.PageInfo;
import com.br.eadnotificationhexagonal.core.domain.enums.NotificationSatus;
import com.br.eadnotificationhexagonal.core.ports.NotificationPersistencePort;
import com.br.eadnotificationhexagonal.core.ports.NotificationServicePort;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class NotificationServicePortImpl implements NotificationServicePort {

   private final NotificationPersistencePort notificationPersistencePort;

    public NotificationServicePortImpl(NotificationPersistencePort notificationPersistencePort) {
        this.notificationPersistencePort = notificationPersistencePort;
    }


    @Override
    public NotificationDomain saveNotification(NotificationDomain NotificationDomain) {
        return notificationPersistencePort.save(NotificationDomain);
    }

    @Override
    public List<NotificationDomain> findAllNotificationsByUser(UUID userId, PageInfo pageInfo) {
        return notificationPersistencePort.findAllByUserIdAndNotificationStatus(userId, NotificationSatus.CREATED, pageInfo);
    }

    @Override
    public Optional<NotificationDomain> findByNotificationIdAndUserId(UUID notificationId, UUID userId) {
        return notificationPersistencePort.findByNotificationIdAndUserId(notificationId, userId);
    }
}
