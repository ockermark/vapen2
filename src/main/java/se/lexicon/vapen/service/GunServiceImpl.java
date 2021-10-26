package se.lexicon.vapen.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.vapen.dto.ManufacturerDto;
import se.lexicon.vapen.dto.GunDto;
import se.lexicon.vapen.entity.Manufacturer;
import se.lexicon.vapen.entity.Gun;
import se.lexicon.vapen.repository.ManufacturerRepository;
import se.lexicon.vapen.repository.GunRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GunServiceImpl implements GunService {


    ManufacturerRepository manufacturerRepository;
    GunRepository gunRepository;
    ModelMapper modelMapper;



@Autowired
public GunServiceImpl(ManufacturerRepository manufacturerRepository, GunRepository gunRepository, ModelMapper modelMapper){
    this.manufacturerRepository = manufacturerRepository;
    this.gunRepository = gunRepository;
    this.modelMapper = modelMapper;
    }

    @Override
    public ManufacturerDto buildGun(GunDto dto) {

        Gun gunEntity = modelMapper.map(dto.getName(), Gun.class);
        Gun createGun = gunRepository.save(gunEntity);
        Manufacturer manufacturerEntity = modelMapper.map(dto, Manufacturer.class);
        manufacturerEntity.setName(createGun);
        Manufacturer createManufacturer = manufacturerRepository.save(manufacturerEntity);

        return modelMapper.map(createManufacturer, ManufacturerDto.class);
    }
    @Override
    public List<Gun> advanceSearch(String name, String model, String version) {
        List<Gun> result = new ArrayList<>();

        return result;

    }



    @Override
    public void addGun(String name, String model, String version) {

    }

    @Override
    public void scrapGun(int id, String name, String model, String version) {

    }
}


