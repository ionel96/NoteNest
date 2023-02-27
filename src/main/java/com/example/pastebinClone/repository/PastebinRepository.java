package com.example.pastebinClone.repository;

import com.example.pastebinClone.entity.PastebinClone;
import org.springframework.data.repository.CrudRepository;

public interface PastebinRepository extends CrudRepository<PastebinClone, Long> {
}
