package com.rama.db.repository;

import com.rama.db.model.Message;
import com.rama.db.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MessageDataRepository extends CrudRepository<Message, Integer> {
}

