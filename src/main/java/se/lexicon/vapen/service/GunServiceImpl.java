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
import java.util.Optional;

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
    public ManufacturerDto saveGun(GunDto dto) {

        Gun gunEntity = modelMapper.map(dto.getName(), Gun.class); //class?
        Gun saveGun = gunRepository.save(gunEntity);
        Manufacturer manufacturerEntity = modelMapper.map(dto, Manufacturer.class);
        Manufacturer createManufacturer = manufacturerRepository.save(manufacturerEntity);

        return modelMapper.map(createManufacturer, ManufacturerDto.class);
    }





    @Override
    public List<Gun> findAll() {
        List<Gun>list = new ArrayList<>();
        gunRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Gun findById(int id) {
        Optional<Gun> optionalGun = gunRepository.findById(id);
        if (optionalGun.isPresent()){
            return optionalGun.get();
        }
        return null;
    }

    @Override
    public Gun findByName(String name) {
        Gun result = gunRepository.findGunByName(name);
        return result;
    }

    @Override
    public Gun findByModel(String model) {
        Gun result = gunRepository.findGunByModel(model);

        return result;
    }

    @Override
    public Gun findByNameAndVersion(String name, String version) {
        return null;
    }

    @Override
    public List<Gun> advanceSearch(String name, String model, String version) {
        List<Gun> result = new ArrayList<>();

        if (name != null && model != null) {
            result = gunRepository.findByNameAndModel(name, model);
        } else if (version != null) {
            result = gunRepository.findGunbyVersion(version);
        }
        return result;
    }




    @Override
    public void delete(int id) {

    }

    @Override
    public Gun saveGun(Gun gun){
    Gun result = gunRepository.save(gun);
    return result;
    }
}


