package com.jiha.shortener.repository;

import com.jiha.shortener.domain.UrlMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlMatchRepository extends JpaRepository<UrlMatch, String> {

}
