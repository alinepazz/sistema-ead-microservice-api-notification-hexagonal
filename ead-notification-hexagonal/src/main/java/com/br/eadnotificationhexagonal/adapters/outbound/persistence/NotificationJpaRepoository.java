package com.br.eadnotificationhexagonal.adapters.outbound.persistence;

import com.br.eadnotificationhexagonal.adapters.outbound.persistence.entities.NotificationEntity;
import com.br.eadnotificationhexagonal.core.domain.enums.NotificationSatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface NotificationJpaRepoository extends JpaRepository<NotificationEntity, UUID> {

    Page<NotificationEntity> findAllByUserIdAndNotificationStatus(UUID userId, NotificationSatus notificationSatus, Pageable pageable);

    Optional<NotificationEntity> findByNotificationIdAndUserId(UUID notificationId, UUID userId);
}
