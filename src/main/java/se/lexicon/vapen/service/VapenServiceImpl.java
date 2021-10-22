package se.lexicon.vapen.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.vapen.dto.ManufacturerDto;
import se.lexicon.vapen.dto.WeaponDto;
import se.lexicon.vapen.entity.Manufacturer;
import se.lexicon.vapen.entity.Weapon;
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
    public ManufacturerDto buildGun(WeaponDto dto) {

        Weapon weaponEntity = modelMapper.map(dto.getName(),Weapon.class); //class?
        Weapon createWeapon = weaponRepository.save(weaponEntity);
        Manufacturer manufacturerEntity = modelMapper.map(dto, Manufacturer.class);
        manufacturerEntity.setName(createWeapon);
        Manufacturer createManufacturer = manufacturerRepository.save(manufacturerEntity);

        return modelMapper.map(createManufacturer, ManufacturerDto.class);
    }




    @Override
    public void addGun(String name, String model, String version) {

    }

    @Override
    public void scrapGun(int id, String name, String model, String version) {

    }
}


