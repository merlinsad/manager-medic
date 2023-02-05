package com.med.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.med.rest.domain.medicDTO.MedicDTOProfile;
import com.med.rest.domain.medicDTO.UpdateMedicDTO;
import com.med.rest.domain.medicDTO.MedicDTO;

@Service
public interface MedicService {

	public void save(MedicDTO medic);

	public Page<MedicDTOProfile> listMedics(Pageable pagination);

	public void updateMedic(UpdateMedicDTO updateMedicDTO);

	public void deleteMedic(Long id);

	public MedicDTO getMedicById(Long id);
}
