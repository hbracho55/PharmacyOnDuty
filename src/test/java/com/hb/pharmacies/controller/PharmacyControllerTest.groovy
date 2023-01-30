package com.hb.pharmacies.controller

import com.hb.pharmacies.dto.PharmacyRequestDto
import com.hb.pharmacies.dto.PharmacyResponseDto
import com.hb.pharmacies.service.PharmacyService
import com.hb.pharmacies.service.PharmacyServiceImpl
import spock.lang.Specification
import spock.lang.Unroll

class PharmacyControllerTest extends Specification {

    PharmacyServiceImpl service
    PharmacyController controller

    def setup(){
        service = Mock(PharmacyService)
        controller = new PharmacyController(service)
        controller.pharmacyService = service
    }

    @Unroll
    def "sucessful request"(){

        given:
        service.getPharmaciesOnDuty(_) >> new ArrayList<PharmacyResponseDto>()

        when:
        def requestParams = new PharmacyRequestDto()
        requestParams.commune = "QUILLOTA"
        requestParams.store = "SALCOBRAND"
        controller.getPharmaciesOnDuty(requestParams)

        then:
        noExceptionThrown()

    }
}
