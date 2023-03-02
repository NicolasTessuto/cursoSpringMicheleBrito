package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Repository //Comunicação entre o sistema e o banco de dados
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {




}
