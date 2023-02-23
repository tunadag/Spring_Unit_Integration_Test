package com.tunadag.springunit_integ_test.repository;

import com.tunadag.springunit_integ_test.repository.entity.Satis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISatisRepository extends JpaRepository<Satis, Long> {
}
