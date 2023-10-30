package ims.dev.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ims.dev.entity.Transctions;

public interface TransctionsRepo extends JpaRepository<Transctions, Integer> {

}
