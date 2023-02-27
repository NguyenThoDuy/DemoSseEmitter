package com.tutorial.Common.repository;

import com.tutorial.Common.model.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {
    @Query(value = "SELECT * FROM ( SELECT * FROM message_entity m\n" +
            "   order by m.create_at desc limit 30) a order by a.create_at asc", nativeQuery = true)
    List<MessageEntity> getAll();
}
