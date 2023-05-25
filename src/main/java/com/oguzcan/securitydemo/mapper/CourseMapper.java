package com.oguzcan.securitydemo.mapper;

import com.oguzcan.securitydemo.dto.request.CreateCourseRequestDTO;
import com.oguzcan.securitydemo.model.Course;
import com.oguzcan.securitydemo.utils.SecurityUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(implementationName = "CourseMapperImpl", componentModel = "spring", imports = SecurityUtil.class,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseMapper {


    @Mapping(target = "isActive", constant = "true")
    @Mapping(target = "teacher.id", source = "teacherId")
    @Mapping(target = "createdBy", expression = "java(SecurityUtil.getLoggedOnUserUsername())")
    Course toCourse(CreateCourseRequestDTO request);
}
