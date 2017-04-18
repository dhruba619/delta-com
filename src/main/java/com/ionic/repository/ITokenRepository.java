package com.ionic.repository;

import org.springframework.data.repository.CrudRepository;

import com.ionic.model.Token;

public interface ITokenRepository extends CrudRepository<Token, String> {

}
