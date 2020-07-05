package com.rk.gifstore.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.rk.gifstore.entity.GiffEntity;

public interface GiffRepository extends R2dbcRepository<GiffEntity, Long>{

}
