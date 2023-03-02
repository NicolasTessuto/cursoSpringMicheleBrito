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

    public Boolean existsByLicensePlateCar(String licensePlateCar){
        return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public Boolean existsByParkingNumber(String parkingNumber){
        return parkingSpotRepository.existsByParkingNumber(parkingNumber);
    }

    public Boolean existsByApartmentBlock(String parkingApartment, String parkingBlock){
        return parkingSpotRepository.existsByApartmentBlock(parkingApartment, parkingBlock);
    }


}
