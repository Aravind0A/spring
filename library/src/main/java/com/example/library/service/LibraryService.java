package com.example.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.library.dto.LibraryDto;
import com.example.library.model.LibraryDetails;
import com.example.library.repository.LibraryRepository;

@Service
public class LibraryService {

	@Autowired
	private LibraryRepository libraryRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public LibraryDetails save(LibraryDto libraryDto) {
		
		LibraryDetails details = new LibraryDetails(libraryDto.getName(),libraryDto.getDob(), libraryDto.getAddress(), libraryDto.getEmail(),
				passwordEncoder.encode(libraryDto.getPassword()));
		return libraryRepository.save(details);
	}
}
