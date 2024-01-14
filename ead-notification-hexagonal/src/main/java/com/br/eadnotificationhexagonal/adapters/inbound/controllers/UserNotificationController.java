package com.br.eadnotificationhexagonal.adapters.inbound.controllers;

import com.br.eadnotificationhexagonal.adapters.dtos.NotificationDto;
import com.br.eadnotificationhexagonal.core.domain.NotificationDomain;
import com.br.eadnotificationhexagonal.core.domain.PageInfo;
import com.br.eadnotificationhexagonal.core.ports.NotificationServicePort;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserNotificationController {

    final NotificationServicePort notificationServicePort;

    public UserNotificationController(NotificationServicePort notificationServicePort) {
        this.notificationServicePort = notificationServicePort;
    }


    @PreAuthorize("hasAnyRole('STUDENT')")
    @GetMapping("/users/{userId}/notifications")
    public ResponseEntity<Page<NotificationDomain>> getAllNotificationsByUser(@PathVariable(value = "userId")
                                                                             UUID userId, @PageableDefault(page = 0, size = 10, sort = "notificationId",direction = Sort.Direction.ASC) Pageable pageable,
                                                                              Authentication authentication){
        PageInfo pageInfo = new PageInfo();
        BeanUtils.copyProperties(pageable, pageInfo);
        List<NotificationDomain> notificationDomains = notificationServicePort.findAllNotificationsByUser(userId, pageInfo);
        return ResponseEntity.status(HttpStatus.OK).body(new PageImpl<NotificationDomain>(notificationDomains, pageable, notificationDomains.size()));
    }
    @PreAuthorize("hasAnyRole('STUDENT')")
    @PutMapping("/users/{userId}/notifications/{notificationId}")
    public ResponseEntity<Object> updateNotification(@PathVariable(value = "userId")
                                                     UUID userId, @PathVariable(value = "notificationId") UUID notificationId,
                                                     @RequestBody @Valid NotificationDto notificationDto){
        Optional<NotificationDomain> NotificationDomainOptional =
                notificationServicePort.findByNotificationIdAndUserId(notificationId, userId);
        if (NotificationDomainOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notification not found!");
        }
        NotificationDomainOptional.get().setNotificationSatus(notificationDto.getNotificationSatus());
        notificationServicePort.saveNotification(NotificationDomainOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(NotificationDomainOptional.get());
    }
}
