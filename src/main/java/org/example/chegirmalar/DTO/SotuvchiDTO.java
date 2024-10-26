package org.example.chegirmalar.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.chegirmalar.model.Mahsulot;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SotuvchiDTO {

    private String username;
    private String password;
    private String image;
    private List<MahsulotDTO> mahsulotDTOS;
    private LocalDateTime toDate;
    private Timestamp created_at;
}
