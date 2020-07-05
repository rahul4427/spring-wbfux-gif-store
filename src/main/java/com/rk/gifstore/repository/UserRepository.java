package com.rk.gifstore.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.rk.gifstore.entity.UserEntity;

public interface UserRepository extends R2dbcRepository<UserEntity, Long>{

}
