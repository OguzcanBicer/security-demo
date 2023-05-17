package com.oguzcan.securitydemo.repository;

import com.oguzcan.securitydemo.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, UUID> {
}
