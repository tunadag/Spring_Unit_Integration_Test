package com.tunadag.springunit_integ_test.service;

import com.tunadag.springunit_integ_test.repository.IMusteriRepository;
import com.tunadag.springunit_integ_test.repository.entity.Musteri;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MusteriServiceTest {

    @InjectMocks
    private MusteriService musteriService;

    /**
     * Bir method ve Mock olarak yaratılan sınıfların içinde kullanılan
     * tüm bağımlılıklar NULL olarak döner. Çünkü onlar için Mock nesneleri
     * ek bir işlem yapmaz. Bu nedenle bağımlılığı olan tüm bileşenleri tanımlamak
     * ve inject etmek zorundasınız.
     */
    @Mock
    private IMusteriRepository repository;
    @Test
    void save(){
        Mockito.when(repository.findAll()).thenReturn(new ArrayList<>());
        Mockito.when(repository.save(ArgumentMatchers.any(Musteri.class))).thenReturn(
                Musteri.builder()
                        .id(1L)
                        .ad("Tuna")
                        .adres("Antalya")
                        .telefon("0 545 3667766")
                        .build()
        );
        Musteri musteri = musteriService.save("Tuna", "Antalya", "0 545 3667766");
        assertNotNull(musteri.getId(), "Müşteri kayıt işleminde id, NULL dönmüştür.");
    }

    @Test
    void saveAdVarIse(){
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(Musteri.builder()
                .id(1L)
                .ad("Tuna")
                .adres("Antalya")
                .telefon("0 545 3667766")
                .build()
        ));

        assertThrows(IllegalArgumentException.class, ()->{
            musteriService.save("Tuna", "Antalya", "0 545 3667766");
        });
    }
}
