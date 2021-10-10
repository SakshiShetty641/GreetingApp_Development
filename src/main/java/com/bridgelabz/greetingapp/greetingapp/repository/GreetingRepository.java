package com.bridgelabz.greetingapp.greetingapp.repository;

import com.bridgelabz.greetingapp.greetingapp.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Integer> {

}