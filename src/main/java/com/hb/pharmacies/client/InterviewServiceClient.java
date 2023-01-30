package com.hb.pharmacies.client;

import com.hb.pharmacies.dto.InterviewServiceDto;
import java.util.List;

public interface InterviewServiceClient {

    public List<InterviewServiceDto> getPharmacies();
}
