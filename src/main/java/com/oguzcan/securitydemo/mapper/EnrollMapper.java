package com.oguzcan.securitydemo.mapper;

import com.oguzcan.securitydemo.dto.request.StudentEnrollRequestDTO;
import com.oguzcan.securitydemo.model.Enroll;
import com.oguzcan.securitydemo.utils.SecurityUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "EnrollMapperImpl", componentModel = "spring", imports = SecurityUtil.class)
public interface EnrollMapper {


    @Mapping(target = "studentId", expression = "java(SecurityUtil.getLoggedOnUserId())")
    Enroll toEnroll(StudentEnrollRequestDTO request);
}
