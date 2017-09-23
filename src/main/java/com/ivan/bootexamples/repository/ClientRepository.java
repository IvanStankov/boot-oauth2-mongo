package com.ivan.bootexamples.repository;

import com.ivan.bootexamples.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

    Client findByClientId(String clientId);

}
