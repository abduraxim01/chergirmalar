package org.example.chegirmalar.service;

import org.example.chegirmalar.DTO.MahsulotDTO;
import org.example.chegirmalar.mapper.MahsulotMapper;
import org.example.chegirmalar.model.Mahsulot;
import org.example.chegirmalar.repository.MahsulotRepository;
import org.example.chegirmalar.repository.SotuvchiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MahsulotService {

    @Autowired
    private MahsulotRepository mahsulotRep;

    @Autowired
    private SotuvchiRepository sotuvchiRep;

    MahsulotMapper mahsulotMapper = new MahsulotMapper();

    //
    // barcha mahsulot ro'yhatini olish
    public List<Mahsulot> getAllMahsulot() {
        return mahsulotRep.findAll();
    }

    // ma'lum bir usernamega tegishli  barcha mahsulotlar ro'yhatini olish
    public List<Mahsulot> getAllMahsulot(String username) {
        return mahsulotRep.findAll().stream().filter(
                        mahsulot -> mahsulot.getSotuvchi().getUsername().equals(username))
                .collect(Collectors.toList());
    }

    // admin va sotuvchi uchun
    // active mahsulotlar ro'yhatini olish
    public List<Mahsulot> getActiveMahsulot() {
        List<Mahsulot> activeMahsulotList = getAllMahsulot();
        for (Mahsulot s : activeMahsulotList) {
            if (LocalDateTime.now().isAfter(s.getToDate()) || LocalDateTime.now().isBefore(s.getFromDate())) {
                activeMahsulotList.remove(s);
            }
        }
        return activeMahsulotList;
    }

    // ma'lum bir usernamega tegishli  activemahsulotlar ro'yhatini olish
    public List<Mahsulot> getActiveMahsulot(String username) {
        List<Mahsulot> activeMahsulotList = getAllMahsulot();
        for (Mahsulot s : activeMahsulotList) {
            if (LocalDateTime.now().isAfter(s.getToDate())
                    || LocalDateTime.now().isBefore(s.getFromDate())
                    || !s.getSotuvchi().getUsername().equals(username)) {
                activeMahsulotList.remove(s);
            }
        }
        return activeMahsulotList;
    }

    // admin uchun
    // inactivemahsulotlar ro'yhatini olish
    public List<Mahsulot> getInActiveMahsulot() {
        List<Mahsulot> activeMahsulotList = getAllMahsulot();
        for (Mahsulot s : activeMahsulotList) {
            if (LocalDateTime.now().isBefore(s.getToDate()) && LocalDateTime.now().isAfter(s.getFromDate())) {
                activeMahsulotList.remove(s);
            }
        }
        return activeMahsulotList;
    }

    // ma'lum bir usernamega tegishli  inactivemahsulotlar ro'yhatini olish
    public List<Mahsulot> getInActiveMahsulot(String username) {
        List<Mahsulot> activeMahsulotList = getAllMahsulot();
        for (Mahsulot s : activeMahsulotList) {
            if (LocalDateTime.now().isBefore(s.getToDate())
                    && LocalDateTime.now().isAfter(s.getFromDate())
                    && !s.getSotuvchi().getUsername().equals(username)) {
                activeMahsulotList.remove(s);
            }
        }
        return activeMahsulotList;
    }


    // sotuvchi uchun
    // mahsulot qo'shish
    public Mahsulot addMahsulot(String username, MahsulotDTO mahsulotDTO) {
        Mahsulot mahsulot = mahsulotMapper.toMahsulot(mahsulotDTO);
        mahsulot.setSotuvchi(sotuvchiRep.findByUsername(username));
        return mahsulotRep.save(mahsulot);
    }
}
