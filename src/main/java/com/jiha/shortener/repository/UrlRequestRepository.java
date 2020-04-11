package com.jiha.shortener.repository;

import com.jiha.shortener.domain.UrlRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRequestRepository extends JpaRepository<UrlRequest, String> {

    int countByUrlKey(String urlKey);

}
