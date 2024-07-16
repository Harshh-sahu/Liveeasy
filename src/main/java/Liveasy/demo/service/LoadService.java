package Liveasy.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Liveasy.demo.dao.loadRepository;
import Liveasy.demo.entities.Load;

@Service
public class LoadService {
      
	@Autowired
	private loadRepository loadRepository;
	
	public Load addLoad(Load load) {
		return loadRepository.save(load);
	
	}
	
	public List<Load> getLoadByShipperId(String shipperId){
		return loadRepository.findByShipperId(shipperId);
	}
	
	public Load getLoadById(UUID loadId) {
		return loadRepository.findById(loadId).orElse(null);
	}
	
	public Load updateLoad(UUID loadId, Load loadDetails) {
		Load load = loadRepository.findById(loadId).orElse(null);
		if(load!= null) {
			load.setLoadingPoint(loadDetails.getLoadingPoint());
            load.setUnloadingPoint(loadDetails.getUnloadingPoint());
            load.setProductType(loadDetails.getProductType());
            load.setTructType(loadDetails.getTructType());
            load.setNoOfTruck(loadDetails.getNoOfTruck());
            load.setWeight(loadDetails.getWeight());
            load.setComment(loadDetails.getComment());
            load.setDate(loadDetails.getDate());
            return loadRepository.save(load);
        }
        return null;

	}
    public void deleteLoad(UUID loadId) {
        loadRepository.deleteById(loadId);
    }



}
