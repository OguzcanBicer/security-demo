package com.oguzcan.securitydemo.mapper;

import com.oguzcan.securitydemo.dto.request.UserRegisterRequestDTO;
import com.oguzcan.securitydemo.model.User;
import com.oguzcan.securitydemo.utils.SecurityUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

@Mapper(implementationName = "UserMapperImpl", componentModel = "spring", imports = {SecurityUtil.class, Objects.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper {

    @Autowired
    protected PasswordEncoder passwordEncoder;


    @Mapping(target = "password", expression = "java(passwordEncoder.encode(request.password()))")
    @Mapping(target = "createdBy", expression = "java(SecurityUtil.getLoggedOnUserUsername())")
    public abstract User toUser(UserRegisterRequestDTO request);

}
