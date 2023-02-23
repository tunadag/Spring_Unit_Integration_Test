package com.tunadag.springunit_integ_test.repository.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "tblsatis")
public class Satis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long musteriid;
    String urun;
    Double fiyat;
    int adet;
    Double toplamfiyat;
    Long tarih;
}
