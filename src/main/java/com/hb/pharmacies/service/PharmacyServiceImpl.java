package com.hb.pharmacies.service;

import com.hb.pharmacies.client.InterviewServiceClient;
import com.hb.pharmacies.dto.InterviewServiceDto;
import com.hb.pharmacies.dto.PharmacyRequestDto;
import com.hb.pharmacies.dto.PharmacyResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PharmacyServiceImpl implements PharmacyService{

    private final InterviewServiceClient interviewServiceClient;

    @Override
    public List<PharmacyResponseDto> getPharmaciesOnDuty(PharmacyRequestDto pharmacyRequestDto) {
        try{
            List<InterviewServiceDto> response = interviewServiceClient.getPharmacies();

            String commune = pharmacyRequestDto.getCommune().trim().toUpperCase();
            String store = pharmacyRequestDto.getStore().trim().toUpperCase();

            if (!pharmacyRequestDto.getCommune().trim().equals("") && !pharmacyRequestDto.getStore().trim().equals("")){
                System.out.println("entro a la opcion doble");
                List<InterviewServiceDto> listCommuneStore = response.stream().filter(
                        (p)->p.getComunaNombre().equals(commune) &&
                                p.getLocalNombre().equals(store)).toList();

                return convertData(listCommuneStore);

            }else {
                if (!pharmacyRequestDto.getCommune().trim().equals("")) {
                    List<InterviewServiceDto> listComunne = response.stream().filter(
                            (p) -> p.getComunaNombre().equals(commune)).toList();
                    return convertData(listComunne);
                }
                if (!pharmacyRequestDto.getStore().trim().equals("")) {
                    List<InterviewServiceDto> listStore = response.stream().filter(
                            (p) -> p.getLocalNombre().equals(store)).toList();
                    return convertData(listStore);
                }

                return convertData(response);
            }

        }catch(Exception e){
            log.error("Error in PharmayService");
            throw e;
        }

    }

    public List<PharmacyResponseDto> convertData(List<InterviewServiceDto> list){
        return list.stream().map((p)->PharmacyResponseDto.builder()
                .localNombre(p.getLocalNombre())
                .localDireccion(p.getLocalDireccion())
                .localTelefono(p.getLocalTelefono())
                .localLat(p.getLocalLat())
                .localLng(p.getLocalLng())
                .build()).toList();
    }
}
