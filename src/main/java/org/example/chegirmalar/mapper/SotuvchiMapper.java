package org.example.chegirmalar.mapper;

import org.example.chegirmalar.DTO.SotuvchiDTO;
import org.example.chegirmalar.model.Sotuvchi;

import java.util.ArrayList;
import java.util.List;

public class SotuvchiMapper {

    MahsulotMapper mapper = new MahsulotMapper();

    public Sotuvchi toSotuvchi(SotuvchiDTO dto) {
        Sotuvchi s = new Sotuvchi();
        s.setUsername(dto.getUsername());
        s.setPassword(dto.getPassword());
        s.setImage(dto.getImage());
        return s;
    }

    public SotuvchiDTO toSotuvchiDTO(Sotuvchi s) {
        SotuvchiDTO dto = new SotuvchiDTO();
        dto.setUsername(s.getUsername());
        dto.setPassword(s.getPassword());
        dto.setImage(s.getImage());
        dto.setMahsulotDTOS(mapper.toMahsulotDTOS(s.getMahsulots()));
        dto.setCreated_at(s.getCreated_at());
        dto.setToDate(s.getToDate());
        return dto;
    }

    public List<SotuvchiDTO> toSotuvchiDTO(List<Sotuvchi> sotuvchiList) {
        List<SotuvchiDTO> dtos = new ArrayList<SotuvchiDTO>();
        for (Sotuvchi s : sotuvchiList) {
            dtos.add(toSotuvchiDTO(s));
        }
        return dtos;
    }
}
