package com.oguzcan.securitydemo.mapper;

import com.oguzcan.securitydemo.dto.request.CreateCourseRequestDTO;
import com.oguzcan.securitydemo.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "CourseMapperImpl", componentModel = "spring")
public interface CourseMapper {


    @Mapping(target = "isActive", constant = "true")
//    @Mapping(target = "teacherId", expression = "java()")
    Course toCourse(CreateCourseRequestDTO createCourseRequestDTO);
}
