package com.dompet.sigopback.service;

import com.dompet.sigopback.entity.Catalog;
import com.dompet.sigopback.entity.Command;

import java.util.List;
import java.util.Optional;

public interface CommandService {

    void  create(Command command);
    List<Command> findAll();
    Command findById(Long id);
    void update (Long id, Command command);
    void remove (Command command);
}
