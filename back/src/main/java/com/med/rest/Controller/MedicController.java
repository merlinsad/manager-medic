package com.med.rest.Controller;

import java.net.URI;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.UriComponentsBuilder;

import com.med.rest.domain.entitys.Medic;
import com.med.rest.domain.medicDTO.MedicDTO;
import com.med.rest.domain.medicDTO.MedicDTOProfile;
import com.med.rest.domain.medicDTO.UpdateMedicDTO;
import com.med.rest.service.MedicService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicController {

	private static final Logger logger = Logger.getLogger(MedicController.class.getName());

	@Autowired
	private MedicService medicService;

	@InitBinder //Método responsável por bloquear paramêtros de requisição que não são requisitados
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.setDisallowedFields("isAdmin");
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Medic> createMedic(@RequestBody @Valid MedicDTO medicDTO, UriComponentsBuilder uriBuilder) {
		this.medicService.save(medicDTO);

		Medic medic = new Medic(medicDTO);
		URI uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medic.getId()).toUri();

		return ResponseEntity.created(uri).body(medic);
	}

	@GetMapping
	public ResponseEntity<Page<MedicDTOProfile>> listMedics(Pageable pagination) {
		Page<MedicDTOProfile> listMedics = this.medicService.listMedics(pagination);

		return ResponseEntity.ok(listMedics);
	}

	//Uma boa prática em atualização de dados é devolver os dados atualizados
	@PutMapping
	public ResponseEntity<UpdateMedicDTO> updateMedic(@RequestBody @Valid UpdateMedicDTO updateMedicDTO) {
		this.medicService.updateMedic(updateMedicDTO);

		return ResponseEntity.ok(updateMedicDTO);
	}

	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMedic(@PathVariable Long id) {
		this.medicService.deleteMedic(id);

		logger.info("deleteMedic - Deletando o usuário: " + id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/medic/{id}")
	public ResponseEntity<MedicDTO> getMedicById(@PathVariable Long id) {
		MedicDTO medicDTO = this.medicService.getMedicById(id);

		logger.info("getMedicById - Buscando o usuário: " + id);
		return ResponseEntity.ok(medicDTO);
	}
}
