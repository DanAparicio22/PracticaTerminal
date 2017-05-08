package com.ucbcba.tallerprogra.Repositories;

import com.ucbcba.tallerprogra.Entities.TerminalHistory;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by da_20 on 8/5/2017.
 */
@Transactional
public interface TerminalHistoryRepository extends CrudRepository<TerminalHistory,Integer> {
}
