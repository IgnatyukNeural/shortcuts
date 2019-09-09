package com.ignatyuk.shortcuts.repositories;

import com.ignatyuk.shortcuts.models.Shortcut;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortcutRepository extends CrudRepository<Shortcut, Integer> {
}
