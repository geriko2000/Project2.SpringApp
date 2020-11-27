package com.example.Project2.SpringApp.repos;

import com.example.Project2.SpringApp.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Integer> {

    List<Message> findByTag(String tag);
}
