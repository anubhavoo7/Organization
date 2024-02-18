package com.example.Organization.Repositories;

import com.example.Organization.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Members, Integer> {
    List<Members> findByTeamId(int teamId);
}
