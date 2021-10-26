package se.lexicon.vapen.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.lexicon.vapen.entity.Manufacturer;

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
    public void addManufacturer(String name, String contactInformation) {


    }

    @Override
    public void deleteManufacturer(Integer id) {

    }

    @Override
    public List<Manufacturer> searchManufacturer(String name) {
        List<Manufacturer> result = new ArrayList<>();

        if (name != null) {
            result = ManufacturerRepository.findByName (name);
        }

        return result;
    }
}
