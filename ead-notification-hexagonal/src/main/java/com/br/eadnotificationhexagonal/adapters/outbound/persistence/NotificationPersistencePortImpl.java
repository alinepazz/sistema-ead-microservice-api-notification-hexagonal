package com.br.eadnotificationhexagonal.adapters.outbound.persistence;

import com.br.eadnotificationhexagonal.adapters.outbound.persistence.entities.NotificationEntity;
import com.br.eadnotificationhexagonal.core.domain.NotificationDomain;
import com.br.eadnotificationhexagonal.core.domain.PageInfo;
import com.br.eadnotificationhexagonal.core.domain.enums.NotificationSatus;
import com.br.eadnotificationhexagonal.core.ports.NotificationPersistencePort;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class NotificationPersistencePortImpl implements NotificationPersistencePort {

    private final NotificationJpaRepoository notificationJpaRepoository;
    private final ModelMapper modelMapper;

    public NotificationPersistencePortImpl(NotificationJpaRepoository notificationJpaRepoository, ModelMapper modelMapper) {
        this.notificationJpaRepoository = notificationJpaRepoository;
        this.modelMapper = modelMapper;
    }

    @Override
    public NotificationDomain save(NotificationDomain notificationDomain) {
        NotificationEntity entity = notificationJpaRepoository.save(modelMapper.map(notificationDomain, NotificationEntity.class));
        return modelMapper.map(entity, NotificationDomain.class);
    }

    @Override
    public List<NotificationDomain> findAllByUserIdAndNotificationStatus(UUID userId, NotificationSatus notificationSatus, PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize());
        return notificationJpaRepoository.findAllByUserIdAndNotificationStatus(userId, notificationSatus, pageable).stream().map(entity -> modelMapper.map(entity, NotificationDomain.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<NotificationDomain> findByNotificationIdAndUserId(UUID notificationId, UUID userId) {
        Optional<NotificationEntity> notificationEntity = notificationJpaRepoository.findByNotificationIdAndUserId(notificationId, userId);
        if (notificationEntity.isPresent()){
            return Optional.of(modelMapper.map(notificationEntity.get(), NotificationDomain.class));
        }
        return Optional.empty();
    }
}
