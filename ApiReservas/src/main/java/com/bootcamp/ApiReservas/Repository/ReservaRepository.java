package com.bootcamp.ApiReservas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.ApiReservas.Model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
