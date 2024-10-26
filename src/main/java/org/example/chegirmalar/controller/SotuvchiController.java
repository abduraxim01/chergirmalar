package org.example.chegirmalar.controller;

import jakarta.persistence.PostUpdate;
import org.example.chegirmalar.DTO.SotuvOzgarQiymat;
import org.example.chegirmalar.DTO.SotuvchiDTO;
import org.example.chegirmalar.model.Sotuvchi;
import org.example.chegirmalar.service.SotuvchiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/api/sotuvchi", consumes = MediaType.APPLICATION_JSON_VALUE)
public class SotuvchiController {

    @Autowired
    private SotuvchiService sotuvchiSer;

    // admin
    @GetMapping(value = "/getAllSotuvchiAsDTO")
    public List<SotuvchiDTO> getAllSotuvchiAsDTO() {
        return sotuvchiSer.getAllSotuvchiAsDTO();
    }

    // admin
    @GetMapping(value = "getInactiveSotuvchi")
    public List<SotuvchiDTO> getInactiveSotuvchi() {
        return sotuvchiSer.getInactiveSotuvchi();
    }

    // permit all
    @GetMapping(value = "getActiveSotuvchi")
    public List<SotuvchiDTO> getActiveSotuvchi() {
        return sotuvchiSer.getActiveSotuvchi();
    }

    // admin
    @PostMapping(value = "/addSotuvchi")
    public void addSotuvchi(SotuvchiDTO dt) {
        sotuvchiSer.addSotuvchi(dt);
    }

    // permit all
    @PostMapping(value = "/changeSotuvchiDetails")
    public SotuvchiDTO changeSotuvchiDetails(Long id, SotuvOzgarQiymat sotuvOzgarQiymat) {
        return sotuvchiSer.changeSotuvchiDetails(id, sotuvOzgarQiymat);
    }

    // admin
    @PostMapping(value = "/changeSotuvchiDate")
    public SotuvchiDTO changeSotuvchiDate(Long id, LocalDateTime dateTime) {
        return sotuvchiSer.changeSotuvchiDate(id, dateTime);
    }


}
