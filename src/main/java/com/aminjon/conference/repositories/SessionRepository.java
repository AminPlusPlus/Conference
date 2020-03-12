package com.aminjon.conference.repositories;

import com.aminjon.conference.models.Session;
import com.aminjon.conference.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session,Long> {

}
