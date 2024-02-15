package com.excelsheet.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelsheet.com.model.UserDetails;


@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{

}
