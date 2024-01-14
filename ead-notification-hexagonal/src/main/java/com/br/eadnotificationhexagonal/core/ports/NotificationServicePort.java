package com.br.eadnotificationhexagonal.core.ports;


import com.br.eadnotificationhexagonal.core.domain.NotificationDomain;
import com.br.eadnotificationhexagonal.core.domain.PageInfo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NotificationServicePort {
    NotificationDomain saveNotification(NotificationDomain notificationDomain);
    List<NotificationDomain> findAllNotificationsByUser(UUID userId, PageInfo pageable);
    Optional<NotificationDomain> findByNotificationIdAndUserId(UUID notificationId, UUID userId);
}
