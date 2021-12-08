package se.lexicon.vapen.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.vapen.dto.GunDto;
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
    public GunDto saveGun(GunDto dto) {

        GunDto gunEntity = modelMapper.map(dto, GunDto.class); //class?
        GunDto saveGun = gunRepository.save(gunEntity);

        return modelMapper.map(saveGun, GunDto.class);
    }





    @Override
    public List<GunDto> findAll() {
        List<GunDto>list = new ArrayList<>();
        gunRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public GunDto findById(int id) {
        Optional<Gun> optionalGun = gunRepository.findById(id);
        if (optionalGun.isPresent()){
            return optionalGun.get();
        }
        return null;
    }

    @Override
    public GunDto findByName(String name) {
        GunDto result = gunRepository.findGunByName(name);
        return result;
    }

    @Override
    public GunDto findByModel(String model) {
        GunDto result = gunRepository.findGunByModel(model);

        return result;
    }

    @Override
    public GunDto findByNameAndVersion(String name, String version) {
        return null;
    }

    @Override
    public List<GunDto> advanceSearch(String name, String model, String version) {
        List<GunDto> result = new ArrayList<>();

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
    public GunDto saveGun(GunDto gunDto){
    GunDto result = gunRepository.save(gunDto);
    return result;
    }
}


