package com.med.rest.serviceimpl;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.med.rest.domain.repository.MedicRepository;
import com.med.rest.domain.entitys.Medic;
import com.med.rest.domain.medicDTO.MedicDTO;
import com.med.rest.domain.medicDTO.MedicDTOProfile;
import com.med.rest.domain.medicDTO.UpdateMedicDTO;
import com.med.rest.service.MedicService;

import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;

@Service
public class MedicServiceImpl implements MedicService {

	private static final Logger logger = Logger.getLogger(MedicServiceImpl.class.getName());

	// Classe para armazenar métodos parser
	// private MedicParser medicParser = new MedicParser();

	@Autowired
	private MedicRepository medicRepository;

	@Override
	@Transactional
	public void save(MedicDTO medicDTO) {
		Medic medic = new Medic(medicDTO);

		this.medicRepository.save(medic);
		logger.info("Criando usuário: " + medic.getName());
	}

	@Override
	public Page<MedicDTOProfile> listMedics(@PageableDefault(size = 10) Pageable pagination) {
		// Efetua o parser de Medic para MedicDTOProfile
		Page<MedicDTOProfile> listMedicDTOs = this.medicRepository.findAll(pagination).map(MedicDTOProfile::new);

		logger.info("Listando médicos.");
		return listMedicDTOs;
	}

	@Override
	public void updateMedic(UpdateMedicDTO updateMedicDTO) {
		Medic medic = this.medicRepository.getReferenceById(updateMedicDTO.getId());
		if (StringUtils.isNotBlank(updateMedicDTO.getEmail())) {
			medic.setEmail(updateMedicDTO.getEmail());
		}

		if (StringUtils.isNotBlank(updateMedicDTO.getPhoneNumber())) {
			medic.setPhoneNumber(updateMedicDTO.getPhoneNumber());
		}

		if (StringUtils.isNotBlank(updateMedicDTO.getName())) {
			medic.setName(updateMedicDTO.getName());
		}

		this.medicRepository.save(medic);
	}

	@Override
	public void deleteMedic(Long id) {
		this.medicRepository.deleteById(id);
	}

	@Override
	public MedicDTO getMedicById(Long id) {
		MedicDTO medicDTO = new MedicDTO(this.medicRepository.getReferenceById(id));

		return medicDTO;
	}
}
