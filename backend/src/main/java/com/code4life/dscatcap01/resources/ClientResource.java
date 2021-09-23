package com.code4life.dscatcap01.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code4life.dscatcap01.entities.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
		
	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> list = new ArrayList<>();
		Instant instantOne = Instant.parse("1980-11-29T13:35:30.01Z");
		Instant instantTwo = Instant.parse("1975-09-26T13:35:30.01Z");
		Instant instantThree = Instant.parse("1981-01-14T10:35:30.01Z");
		Instant instantFour = Instant.parse("1989-06-10T10:30:30.01Z");
		list.add(new Client(1L, "Martim Pestana", "1234567891", 7000.0, instantOne, 1));
		list.add(new Client(2L, "Fernando Miguel", "5876567891", 7000.0, instantTwo, 2));
		list.add(new Client(3L, "Ricardo Manuel dos Santos", "5581567891", 6500.0, instantThree, 0));
		list.add(new Client(4L, "Joana Margarida Narciso", "5581567891", 6500.0, instantFour, 0));
		return ResponseEntity.ok().body(list);
	}
}
