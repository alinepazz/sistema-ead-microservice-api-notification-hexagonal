package com.br.eadnotificationhexagonal.core.ports;

import com.br.eadnotificationhexagonal.core.domain.NotificationDomain;
import com.br.eadnotificationhexagonal.core.domain.PageInfo;
import com.br.eadnotificationhexagonal.core.domain.enums.NotificationStatus;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NotificationPersistencePort {

    NotificationDomain save(NotificationDomain notificationDomain);
    List<NotificationDomain> findAllByUserIdAndNotificationStatus(UUID userId, NotificationStatus notificationStatus, PageInfo pageInfo);
    Optional<NotificationDomain> findByNotificationIdAndUserId(UUID notificationId, UUID userId);
}
