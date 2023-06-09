package com.oguzcan.securitydemo.repository;

import com.oguzcan.securitydemo.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, UUID> {

//  @Query(value = """
//      select t from Token t inner join User u\s
//      on t.user.id = u.id\s
//      where u.id = :id and (t.expired = false or t.revoked = false)\s
//      """)
//  List<Token> findAllValidTokenByUser(Integer id);

    List<Token> findAllByUser_IdAndExpiredIsFalseOrRevokedIsFalse(long userId);

    Optional<Token> findByToken(String token);
}
