package com.ucbcba.tallerprogra.Services;

import com.ucbcba.tallerprogra.Entities.Terminal;

/**
 * Created by da_20 on 26/4/2017.
 */
public interface TerminalService {
    Iterable<Terminal> listAllTerminals();

    Terminal getTerminalById(Integer id);

    Terminal saveTerminal(Terminal terminal);

    void deleteTerminal(Integer id);
}
