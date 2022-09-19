package com.amadeus.notification.infra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.amadeus.notification.domain.model.UserCredential;
import com.amadeus.notification.infra.db.entity.AppUser;

@Mapper
public interface InfraNotificationMapper {

    InfraNotificationMapper INSTANCE = Mappers.getMapper(InfraNotificationMapper.class);

    UserCredential map(AppUser user);

}
