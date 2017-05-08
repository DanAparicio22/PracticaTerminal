package com.ucbcba.tallerprogra.Services;

import com.ucbcba.tallerprogra.Entities.Terminal;
import com.ucbcba.tallerprogra.Repositories.TerminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by da_20 on 26/4/2017.
 */
@Service
public class TerminalServiceImpl implements TerminalService {

    private TerminalRepository terminalRepository;

    public TerminalRepository getTerminalRepository() {
        return terminalRepository;
    }

    @Autowired
    @Qualifier(value = "terminalRepository")
    public void setTerminalRepository(TerminalRepository terminalRepository) {
        this.terminalRepository = terminalRepository;
    }

    @Override
    public Iterable<Terminal> listAllTerminals() {
        return terminalRepository.findAll();
    }

    @Override
    public Terminal getTerminalById(Integer id) {
        return terminalRepository.findOne(id);
    }

    @Override
    public Terminal saveTerminal(Terminal terminal) {
        return terminalRepository.save(terminal);
    }

    @Override
    public void deleteTerminal(Integer id) {
        terminalRepository.delete(id);
    }
}
