package com.tunadag.springunit_integ_test.service;

import com.tunadag.springunit_integ_test.repository.ISatisRepository;
import com.tunadag.springunit_integ_test.repository.entity.Satis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SatisService {

    private final ISatisRepository satisRepository;
    private final MusteriService musteriService;
    public Long satis(Long musteriId, String urun, Double fiyat, int adet){
        if (!musteriService.findByMusteriId(musteriId))
            throw new RuntimeException("Böyle bir müşteri kayıtlı değil. İşlem iptal edildi.");
        if (adet>0 && fiyat>0){
            Satis satis = satisRepository.save(Satis.builder()
                            .adet(adet)
                            .fiyat(fiyat)
                            .urun(urun)
                            .tarih(System.currentTimeMillis())
                            .musteriid(musteriId)
                            .toplamfiyat(fiyat*adet)
                    .build());
            return satis.getId();
        }else
            throw new IllegalArgumentException("Adet ve Fiyat bilgilerinde geçersiz giriş");


    }
}
