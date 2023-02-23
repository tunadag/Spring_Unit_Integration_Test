package com.tunadag.springunit_integ_test.service;

import com.tunadag.springunit_integ_test.repository.IMusteriRepository;
import com.tunadag.springunit_integ_test.repository.entity.Musteri;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MusteriService {

    private final IMusteriRepository repository;

    public Musteri save(String ad, String adres, String telefon){
        if(repository.findAll().stream().filter(x-> x.getAd().equals(ad)).count()>0)
            throw new IllegalArgumentException("Böyle bir müşteri zaten var");
        Musteri musteri = repository.save(Musteri.builder()
                .ad(ad)
                .adres(adres)
                .telefon(telefon)
                .build());
        return  musteri;
    }

    public boolean findByMusteriId(Long id){
        return repository.existsById(id);
    }
}
