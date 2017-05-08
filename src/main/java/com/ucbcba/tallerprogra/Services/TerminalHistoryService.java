package com.ucbcba.tallerprogra.Services;

import com.ucbcba.tallerprogra.Entities.TerminalHistory;

/**
 * Created by da_20 on 8/5/2017.
 */
public interface TerminalHistoryService {
    Iterable<TerminalHistory> listAllTerminalHistory();

    TerminalHistory getTerminalHistoryById(Integer id);

    TerminalHistory saveTerminalHistory(TerminalHistory terminalHistory);

    void deleteTerminalHistory(Integer id);
}
