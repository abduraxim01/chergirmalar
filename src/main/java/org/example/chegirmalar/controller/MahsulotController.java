package org.example.chegirmalar.controller;

import org.example.chegirmalar.service.MahsulotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/mahsulot")
public class MahsulotController {
    @Autowired
    private MahsulotService mahsulotSer;
}
