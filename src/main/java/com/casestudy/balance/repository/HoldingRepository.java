package com.casestudy.balance.repository;

import com.casestudy.balance.model.Holding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HoldingRepository extends JpaRepository<Holding, String> {

    List<Holding> findByMemberCode(String memberCode);

}
