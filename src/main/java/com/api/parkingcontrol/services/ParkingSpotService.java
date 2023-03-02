package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service //Camada intermediária entre o controller e o repository e onde ficam as regras de negócio
public class ParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Transactional //Garante o rowback caso os dados sejam perdidos no meio da transação.
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }

    public boolean verifyDuplicate(ParkingSpotModel parkingSpotModel){
        ParkingSpotModel parkingSpotModelBanco = parkingSpotRepository.getReferenceById(parkingSpotModel.getId());
        if (parkingSpotModelBanco == null){
            return false;
        }
        else{
            return true;
        }
    }









}
