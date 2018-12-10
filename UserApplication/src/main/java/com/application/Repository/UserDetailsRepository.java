package com.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;



import com.application.Entity.UserDetails;
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {


	UserDetails findByEmail(String email);

}
