package com.example.springcustomers;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.springcustomers.*;
import java.util.ArrayList;
import java.util.List;



@Service
@Transactional
public class ProcessService {

	@Autowired
	private ProcessRepository processRepository ;

	public Process findById(Long id){
		return processRepository.findById(id);
	}

	public void updateProcess (Long orderid, Long id){
		processRepository.updateProcess(orderid, id);
	}

	public void deleteById(Long id){
		processRepository.deleteById(id);
	}

	public void save(Process process){
		processRepository.save(process);
	}

	public Long count() {
		return processRepository.count();
	}
}