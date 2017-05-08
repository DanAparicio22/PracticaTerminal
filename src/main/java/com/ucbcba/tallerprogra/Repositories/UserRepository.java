package com.ucbcba.tallerprogra.Repositories;

import com.ucbcba.tallerprogra.Entities.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by da_20 on 26/4/2017.
 */
@Transactional
public interface UserRepository extends CrudRepository<User,Integer>{
}
