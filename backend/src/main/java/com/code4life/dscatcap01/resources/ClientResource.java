package com.code4life.dscatcap01.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.code4life.dscatcap01.dto.ClientDTO;
import com.code4life.dscatcap01.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll() {
		/*
		List<Client> list = new ArrayList<>();		
		Instant instantOne = Instant.parse("2010-01-19T17:35:30.01Z");
		Instant instantTwo = Instant.parse("1975-09-26T13:35:30.01Z");
		Instant instantThree = Instant.parse("1981-01-14T10:35:30.01Z");
		Instant instantFour = Instant.parse("1989-06-10T10:30:30.01Z");
		Instant instantFive = Instant.parse("2007-06-10T10:30:30.01Z");		
		list.add(new Client(1L, "Martim Ferrer Silva Pestana", "1234567891", 7000.0, instantOne, 0));
		list.add(new Client(2L, "Fernando Miguel", "5876567891", 7000.0, instantTwo, 2));
		list.add(new Client(3L, "Ricardo Manuel dos Santos", "5581567891", 6500.0, instantThree, 0));
		list.add(new Client(4L, "Joana Margarida Narciso", "5581567891", 6200.0, instantFour, 4));
		list.add(new Client(5L, "Daniel Alexandre Silva Antunes", "5585681891", 6000.0, instantFive, 0));
		*/
		List<ClientDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
		ClientDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody ClientDTO dto) {
		dto = service.update(id, dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
