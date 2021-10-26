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

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository ;
    }

    @Override
    public ManufacturerDto createManufacturer(ManufacturerDto dto) {
        if (dto == null) throw new ArgumentException("ManufacturerDto cannot be null");

        Manufacturer manufacturerEntity = modelMapper.map(dto.getClass(), Manufacturer.class);
        Manufacturer createdManufacturer = manufacturerRepository.save(manufacturerEntity);


    }

    @Override
    public void deleteManufacturer(Integer id) {

    }

    @Override
    public List<Manufacturer> searchManufacturer(String name) {
        List<Manufacturer> result = new ArrayList<>();

        if (name != null) {
            result = manufacturerRepository.findByName (name);
        }

        return result;
    }
}
