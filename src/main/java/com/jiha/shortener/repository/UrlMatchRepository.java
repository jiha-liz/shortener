package com.jiha.shortener.repository;

import com.jiha.shortener.domain.UrlMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlMatchRepository extends JpaRepository<UrlMatch, String> {

    Optional<UrlMatch> findByUrl(String url);

    Optional<UrlMatch> findByUrlKey(String urlKey);
}
