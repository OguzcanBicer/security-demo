package com.oguzcan.securitydemo.mapper;

import com.oguzcan.securitydemo.dto.request.StudentEnrollRequestDTO;
import com.oguzcan.securitydemo.model.Enroll;
import com.oguzcan.securitydemo.utils.SecurityUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(implementationName = "EnrollMapperImpl", componentModel = "spring", imports = SecurityUtil.class,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnrollMapper {


    @Mapping(target = "course.id", source = "courseId")
    @Mapping(target = "student.id", source = "studentId")
    @Mapping(target = "createdBy", expression = "java(SecurityUtil.getLoggedOnUserUsername())")
    Enroll toEnroll(StudentEnrollRequestDTO request);
}
