package com.code4life.dscatcap01.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.code4life.dscatcap01.dto.ClientDTO;
import com.code4life.dscatcap01.entities.Client;
import com.code4life.dscatcap01.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll() {
		List<Client> list = repository.findAll();
		
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
		/*
		List<ClientDTO> listDto = new ArrayList<>();
		for (Client cat : list) {
			listDto.add(new ClientDTO(cat));
		}
		
		return listDto;
		*/
	}
}
