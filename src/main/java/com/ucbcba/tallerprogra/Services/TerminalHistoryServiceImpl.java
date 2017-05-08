package com.ucbcba.tallerprogra.Services;

import com.ucbcba.tallerprogra.Entities.TerminalHistory;
import com.ucbcba.tallerprogra.Repositories.TerminalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by da_20 on 8/5/2017.
 */
@Service
public class TerminalHistoryServiceImpl implements TerminalHistoryService{

    TerminalHistoryRepository terminalHistoryRepository;

    public TerminalHistoryRepository getTerminalHistoryRepository() {
        return terminalHistoryRepository;
    }

    @Autowired
    @Qualifier(value = "terminalHistoryRepository")
    public void setTerminalHistoryRepository(TerminalHistoryRepository terminalHistoryRepository) {
        this.terminalHistoryRepository = terminalHistoryRepository;
    }

    @Override
    public Iterable<TerminalHistory> listAllTerminalHistory() {
        return terminalHistoryRepository.findAll();
    }

    @Override
    public TerminalHistory getTerminalHistoryById(Integer id) {
        return terminalHistoryRepository.findOne(id);
    }

    @Override
    public TerminalHistory saveTerminalHistory(TerminalHistory terminalHistory) {
        return terminalHistoryRepository.save(terminalHistory);
    }

    @Override
    public void deleteTerminalHistory(Integer id) {
        terminalHistoryRepository.delete(id);
    }
}
