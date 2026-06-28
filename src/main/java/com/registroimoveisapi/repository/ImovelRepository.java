package com.registroimoveisapi.repository;

import com.registroimoveisapi.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {
}
