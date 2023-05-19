package com.oguzcan.securitydemo.mapper;

import com.oguzcan.securitydemo.dto.request.CreateCourseRequestDTO;
import com.oguzcan.securitydemo.model.Course;
import com.oguzcan.securitydemo.utils.SecurityUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "CourseMapperImpl", componentModel = "spring", imports = SecurityUtil.class)
public interface CourseMapper {


    @Mapping(target = "isActive", constant = "true")
    @Mapping(target = "teacherId", expression = "java(SecurityUtil.getLoggedOnUserId())")
    Course toCourse(CreateCourseRequestDTO request);
}
