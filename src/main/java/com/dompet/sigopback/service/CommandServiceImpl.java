package com.dompet.sigopback.service;

import com.dompet.sigopback.entity.Catalog;
import com.dompet.sigopback.entity.Command;
import com.dompet.sigopback.exception.EntityNotFoundException;
import com.dompet.sigopback.repository.CatalogRepository;
import com.dompet.sigopback.repository.CommandRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommandServiceImpl implements CommandService {

    @Autowired
    private final CommandRepository commandRepository;

    public void create(Command command) {
        this.commandRepository.save(command);
    }

    public List<Command> findAll() {
        Optional<List<Command>> optionalCommandList = Optional.of(this.commandRepository.findAll());
        return optionalCommandList.orElseThrow(
                ()-> new EntityNotFoundException("Not Found")
        );
    }

    public Command findById(Long id) {
        Optional<Command> optionalCommand = this.commandRepository.findById(id);
        return optionalCommand.orElseThrow(
                ()-> new EntityNotFoundException("Not Found")
        );
    }

    public void update(Long id, Command command) {

    }

    public void remove(Command command) {
        this.commandRepository.delete(command);

    }
}
