package com.duhjent.postsmachine.data;

import com.duhjent.postsmachine.entities.commands.Command;

import org.springframework.data.repository.CrudRepository;

public interface CommandRepo extends CrudRepository<Command, Long>{

}