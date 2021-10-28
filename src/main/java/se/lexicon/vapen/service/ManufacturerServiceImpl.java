package se.lexicon.vapen.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.lexicon.vapen.dto.ManufacturerDto;
import se.lexicon.vapen.entity.Manufacturer;

import se.lexicon.vapen.exception.ArgumentException;
import se.lexicon.vapen.repository.ManufacturerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    ManufacturerRepository manufacturerRepository;
    ModelMapper modelMapper;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository ;

    }

    @Override
    public ManufacturerDto saveManufacturer(ManufacturerDto dto) {
        if (dto == null) throw new ArgumentException("ManufacturerDto cannot be null");
        Manufacturer manufacturerEntity = modelMapper.map(dto, Manufacturer.class);
        Manufacturer saveManufacturer = manufacturerRepository.save(manufacturerEntity);
        return modelMapper.map(saveManufacturer, ManufacturerDto.class);

    }

    @Override
    public void deleteManufacturer (Integer id) {
        Optional<Manufacturer> optionalManufacturer = manufacturerRepository.findById(id);
        if (optionalManufacturer.isPresent()) {
            manufacturerRepository.delete(optionalManufacturer.get());
        }
    }

    @Override
    public ManufacturerDto findById (Integer id) {
        Optional<Manufacturer> optionalManufacturer = manufacturerRepository.findById(id);
        if (optionalManufacturer.isPresent()){
            return modelMapper.map(optionalManufacturer.get(),ManufacturerDto.class);
        }
        return null;
    }

    @Override
    public ManufacturerDto findByName (String name) {
        if (name != null){
            Manufacturer result = manufacturerRepository.findByName(name);
            return modelMapper.map(result, ManufacturerDto.class);
        }
        else throw new ArgumentException("manufacturerName cannot be null");
    }

    @Override
    public List<ManufacturerDto> findAll () {
        List<Manufacturer> manufacturerList = new ArrayList<>();
        List<ManufacturerDto> manufacturerDtoList = new ArrayList<>();

        manufacturerRepository.findAll().iterator().forEachRemaining(manufacturerList::add);

        //int index=0;
        //while (manufacturerList.size() > index){
        //   manufacturerDtoList.set( index, modelMapper.map(manufacturerList, ManufacturerDto.class));
        //}

        for (Manufacturer manufacturer:manufacturerList){
        manufacturerDtoList.set(manufacturerList.indexOf(this), modelMapper.map(manufacturer, ManufacturerDto.class));
        }

        return manufacturerDtoList;
    }

    // old stuff below *****

    @Override
    public Manufacturer saveManufacturerx (Manufacturer manufacturer) {
        Manufacturer result = manufacturerRepository.save(manufacturer);
        return result;
    }

    @Override
    public void deleteManufacturerx (Integer id) {
        Optional<Manufacturer> optionalManufacturer = manufacturerRepository.findById(id);
        if (optionalManufacturer.isPresent()) {
            manufacturerRepository.delete(optionalManufacturer.get());
        }

    }

    @Override
    public Manufacturer findByNamex (String name) {
        if (name != null){
            Manufacturer result = manufacturerRepository.findByName(name);
            return result;
        }
        else throw new ArgumentException("manufacturerName cannot be null");
    }

    @Override
    public Manufacturer findByIdx (Integer id) {
        Optional<Manufacturer> optionalManufacturer = manufacturerRepository.findById(id);
        if (optionalManufacturer.isPresent()){
            return optionalManufacturer.get();
        }
        return null;
    }

    @Override
    public List<Manufacturer> findAllx () {
        List<Manufacturer> manufacturerList = new ArrayList<>();
        manufacturerRepository.findAll().iterator().forEachRemaining(manufacturerList::add);
        return manufacturerList;
    }
}
