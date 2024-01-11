package com.spr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spr.entity.Travel;
import com.spr.repo.TravelRepository;

@Service
public class TravelService {
	@Autowired
	private TravelRepository travelRepo;

	public Travel postTravel(Travel travel) 
	{
		// TODO Auto-generated method stub
		return travelRepo.save(travel);
	}

	public List<Travel> readTravel() {
		// TODO Auto-generated method stub
		return travelRepo.findAll();
	}

	public void deleteTravel(int id) {
		// TODO Auto-generated method stub
		travelRepo.deleteById(id);
	}

	public Travel getTravelById(int id) {
		// TODO Auto-generated method stub
		return travelRepo.findById(id).orElse(null);
	}

	public Travel updateTravel(int id, Travel travel) {
		// TODO Auto-generated method stub
		Optional<Travel> optionalTravel =travelRepo.findById(id);
		if(optionalTravel.isPresent())
		{
			Travel obj=optionalTravel.get();
			obj.setName(travel.getName());
			obj.setCity(travel.getCity());
			obj.setState(travel.getState());
			obj.setDetail(travel.getDetail());
			return travelRepo.save(obj);
		}
		return null;
	}
	

}
