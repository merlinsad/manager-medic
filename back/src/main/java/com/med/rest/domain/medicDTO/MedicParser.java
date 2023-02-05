package com.med.rest.domain.medicDTO;

import com.med.rest.domain.entitys.Medic;

public class MedicParser {

	public MedicDTOProfile parseMedicToMedicDTOProfile(Medic medic) {
		MedicDTOProfile medicDTOProfile = new MedicDTOProfile();
		medicDTOProfile.setCrm(medic.getCrm());
		medicDTOProfile.setEmail(medic.getEmail());
		medicDTOProfile.setName(medic.getName());
		medicDTOProfile.setSpecialty(medic.getSpecialty());

		return medicDTOProfile;
	}
}
