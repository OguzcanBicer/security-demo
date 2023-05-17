package com.oguzcan.securitydemo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@Tag(name = "Teacher")
public class TeacherController {


    @Operation(
            description = "Get endpoint for teacher",
            summary = "This is a summary for teacher get endpoint",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }

    )
    @GetMapping
    public String get() {
        return "GET:: teacher controller";
    }
    @PostMapping
    public String post() {
        return "POST:: teacher controller";
    }
    @PutMapping
    public String put() {
        return "PUT:: teacher controller";
    }
    @DeleteMapping
    public String delete() {
        return "DELETE:: teacher controller";
    }
}
