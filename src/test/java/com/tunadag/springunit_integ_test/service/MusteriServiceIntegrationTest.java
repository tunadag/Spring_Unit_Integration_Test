package com.tunadag.springunit_integ_test.service;

import com.tunadag.springunit_integ_test.repository.entity.Musteri;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Gerçek ortam testi yapılacağı için Spring in ayağa kalkması gereklidir. Bu nedenle
 * bu anotasyon eklenir.
 */
@SpringBootTest
@ActiveProfiles("test")
public class MusteriServiceIntegrationTest {
    /**
     * Birim test, tüm methodların dış etmenlerden uzak soyutlanarak kontrol edildiği test yöntemidir.
     * Bu test için kullanılan tüm bileşenler sanal nesneler olduğu için DB işlemleri gibi işlemler yapılmaz.
     * Integration Test, gerçek sistem üzerinde tüm nesnelerin gerçek nesne olarak yaratıldığı sistemin
     * işleyişinin kontrol edildiği testlerdir.
     */
    @Autowired
    private MusteriService musteriService;

    @Test
    void save(){
        Musteri musteri = musteriService.save("Tuna", "Antalya", "0545 3667766");
        Assertions.assertNotNull(musteri.getId());
        System.out.println(musteri.toString());
    }
}
