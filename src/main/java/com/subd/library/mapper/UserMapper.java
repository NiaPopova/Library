package com.subd.library.mapper;

import com.subd.library.entity.UserDTO;
import com.subd.library.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "email", target = "email")
    @Mapping(source = "registrationDate", target = "registrationDate")
    UserDTO mapUserToDTO(UserEntity userEntity);
}
