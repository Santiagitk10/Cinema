package com.sofka.cinema.repository;

import com.sofka.cinema.model.Billboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillboardRepository extends JpaRepository<Billboard, Long> {



}
