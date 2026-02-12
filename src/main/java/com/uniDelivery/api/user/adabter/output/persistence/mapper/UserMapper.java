package com.uniDelivery.api.user.adabter.output.persistence.mapper;

import com.uniDelivery.api.user.adabter.output.persistence.entity.UserEntity;
import com.uniDelivery.api.user.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toDomain(UserEntity entity);
    UserEntity toEntity(User domain);
}
