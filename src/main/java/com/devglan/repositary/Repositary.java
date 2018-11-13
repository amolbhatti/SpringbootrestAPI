package com.devglan.repositary;

import com.devglan.model.Model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repositary extends JpaRepository<Model, Long> {

	

}
