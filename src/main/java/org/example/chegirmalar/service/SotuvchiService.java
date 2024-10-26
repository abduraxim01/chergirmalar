package org.example.chegirmalar.service;

import org.example.chegirmalar.DTO.SotuvOzgarQiymat;
import org.example.chegirmalar.DTO.SotuvchiDTO;
import org.example.chegirmalar.mapper.SotuvchiMapper;
import org.example.chegirmalar.model.Sotuvchi;
import org.example.chegirmalar.repository.SotuvchiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SotuvchiService {

    @Autowired
    private SotuvchiRepository sotuvchiRep;

    SotuvchiMapper sotuvchiMap = new SotuvchiMapper();


    // admin va sotuvchi uchun
    // barcha sotuvchilar ro'yhatini olish
    public List<SotuvchiDTO> getAllSotuvchiAsDTO() {
        return sotuvchiMap.toSotuvchiDTO(sotuvchiRep.findAll());
    }


    public List<Sotuvchi> getAllSotuvchi() {
        return sotuvchiRep.findAll();
    }

    // admin uchun
    // active sotuvchilar ro'yhatini olish
    public List<SotuvchiDTO> getActiveSotuvchi() {
        List<Sotuvchi> activeSotuvchiList = getAllSotuvchi();
        for (Sotuvchi s : activeSotuvchiList) {
            if (LocalDateTime.now().isAfter(s.getToDate())) {
                activeSotuvchiList.remove(s);
            }
        }
        return sotuvchiMap.toSotuvchiDTO(activeSotuvchiList);
    }

    // admin uchun
    // inactive sotuvchilar ro'yhatini olish
    public List<SotuvchiDTO> getInactiveSotuvchi() {
        List<Sotuvchi> inActiveSotuvchiList = getAllSotuvchi();
        for (Sotuvchi s : inActiveSotuvchiList) {
            if (LocalDateTime.now().isBefore(s.getToDate())) {
                inActiveSotuvchiList.remove(s);
            }
        }
        return sotuvchiMap.toSotuvchiDTO(inActiveSotuvchiList);
    }

    // admin uchun
    // yangi sotuvchi qo'shish
    public void addSotuvchi(SotuvchiDTO dto) {
        Sotuvchi sotuvchi = sotuvchiMap.toSotuvchi(dto);
        sotuvchiRep.save(sotuvchi);
    }

    private Boolean isPresent(Long id) {
        return sotuvchiRep.findById(id).isPresent();
    }

    // sotuvchi uchun
    // sotuvchini password, name va image ni o'zgartirish
    public SotuvchiDTO changeSotuvchiDetails(Long id, SotuvOzgarQiymat sotuvOzgarQiymat) {
        if (isPresent(id)) {
            Sotuvchi sotuvchi = sotuvchiRep.findById(id).get();
            sotuvchi.setUsername(sotuvOzgarQiymat.getUsername());
            sotuvchi.setPassword(sotuvOzgarQiymat.getPassword());
            sotuvchi.setName(sotuvOzgarQiymat.getName());
            sotuvchi.setImage(sotuvOzgarQiymat.getImage());
            return sotuvchiMap.toSotuvchiDTO(sotuvchiRep.save(sotuvchi));
        }
        return null;
    }

    // admin uchun
    // sotuvchini sotuv muddatini uzaytirish
    public SotuvchiDTO changeSotuvchiDate(Long id, LocalDateTime dateTime) {
        if (isPresent(id)) {
            Sotuvchi sotuvchi = sotuvchiRep.findById(id).get();
            sotuvchi.setToDate(dateTime);
            return sotuvchiMap.toSotuvchiDTO(sotuvchiRep.save(sotuvchi));
        }
        return null;
    }
}
