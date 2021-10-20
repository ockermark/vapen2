package se.lexicon.vapen.service;


import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import se.lexicon.vapen.repository.ManufacturerRepository;
import se.lexicon.vapen.repository.WeaponRepository;

@Service
public class VapenServiceImpl implements VapenService {


    ManufacturerRepository manufacturerRepository;
    WeaponRepository weaponRepository;
    ModelMapper modelMapper;

}
