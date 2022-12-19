package com.example.consumingrestful.repository;

import com.example.consumingrestful.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

}
