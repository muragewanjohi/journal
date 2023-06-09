package com.journal.journal.repository;

import com.journal.journal.model.Account;
import com.journal.journal.model.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {
}
