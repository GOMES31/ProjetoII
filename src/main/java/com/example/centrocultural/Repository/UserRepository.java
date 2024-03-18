package com.example.centrocultural.Repository;

import com.example.centrocultural.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Integer> {

    // Não é necessário código nenhum apenas só se for uma query especifica

}
