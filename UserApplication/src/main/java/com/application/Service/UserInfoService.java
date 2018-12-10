package com.application.Service;


import com.application.Entity.UserDetails;

public interface UserInfoService {

	Iterable<UserDetails> findAll();

UserDetails findById(Long id);

	void deleteById(Long id);

	UserDetails findByEmail(String email);

	UserDetails save(UserDetails userinfo);
}
