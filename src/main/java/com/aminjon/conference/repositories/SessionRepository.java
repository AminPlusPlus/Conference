package com.aminjon.conference.repositories;

import com.aminjon.conference.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long> {
}
