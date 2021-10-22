package se.lexicon.vapen.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.vapen.dto.ManufacturerDto;
import se.lexicon.vapen.dto.WeaponDto;
import se.lexicon.vapen.repository.ManufacturerRepository;
import se.lexicon.vapen.repository.WeaponRepository;

@Service
public class VapenServiceImpl implements VapenService {


    ManufacturerRepository manufacturerRepository;
    WeaponRepository weaponRepository;
    ModelMapper modelMapper;



@Autowired
public VapenServiceImpl(ManufacturerRepository manufacturerRepository, WeaponRepository weaponRepository, ModelMapper modelMapper){
    this.manufacturerRepository = manufacturerRepository;
    this.weaponRepository = weaponRepository;
    this.modelMapper = modelMapper;
    }

    @Override
    public WeaponDto buildGun(WeaponDto dto) {
        return null;
    }

    @Override
    public void addGun(String name, String model, String version) {

    }

    @Override
    public void scrapGun(int id, String name, String model, String version) {

    }
}


