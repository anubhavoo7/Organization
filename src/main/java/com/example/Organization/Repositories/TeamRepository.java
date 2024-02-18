package com.example.Organization.Repositories;

import com.example.Organization.entity.Teams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Teams, Integer> {

}
