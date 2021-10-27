package se.lexicon.vapen.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.lexicon.vapen.dto.ManufacturerDto;
import se.lexicon.vapen.entity.Manufacturer;

import se.lexicon.vapen.exception.ArgumentException;
import se.lexicon.vapen.repository.ManufacturerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    ManufacturerRepository manufacturerRepository;
    ModelMapper modelMapper;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository ;

    }

    @Override
    public ManufacturerDto addManufacturer(ManufacturerDto dto) {
        if (dto == null) throw new ArgumentException("ManufacturerDto cannot be null");

        Manufacturer manufacturerEntity = modelMapper.map(dto, Manufacturer.class);
        Manufacturer createdManufacturer = manufacturerRepository.save(manufacturerEntity);

        return modelMapper.map(createdManufacturer, ManufacturerDto.class);

    }


    @Override
    public Manufacturer saveManufacturer (Manufacturer manufacturer) {
        Manufacturer result = manufacturerRepository.save(manufacturer);
        return result;
    }

    @Override
    public void deleteManufacturer(Integer id) {
        Optional<Manufacturer> optionalManufacturer = manufacturerRepository.findById(id);
        if (optionalManufacturer.isPresent()) {
            manufacturerRepository.delete(optionalManufacturer.get());
        }

    }

    @Override
    public Manufacturer findByName(String name) {
        if (name != null){
            Manufacturer result = manufacturerRepository.findByName(name);
            return result;
        }
        else throw new ArgumentException("manufacturerName cannot be null");
    }

    @Override
    public Manufacturer findById(Integer id) {
        Optional<Manufacturer> optionalManufacturer = manufacturerRepository.findById(id);
        if (optionalManufacturer.isPresent()){
            return optionalManufacturer.get();
        }
        return null;
    }

    @Override
    public List<Manufacturer> findAll() {
        List<Manufacturer> manufacturerList = new ArrayList<>();
        manufacturerRepository.findAll().iterator().forEachRemaining(manufacturerList::add);
        return manufacturerList;
    }
}
