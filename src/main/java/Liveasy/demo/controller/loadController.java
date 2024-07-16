package Liveasy.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Liveasy.demo.entities.Load;
import Liveasy.demo.service.LoadService;

@RestController
@RequestMapping("/load")
public class loadController {
	@Autowired
	private LoadService loadService;
	
	@PostMapping
	public ResponseEntity<String> addLoad(@RequestBody Load load){
		loadService.addLoad(load);
		return ResponseEntity.ok("Details added successfully");
		
		
	}
	
	@GetMapping("/{loadId}")
	public ResponseEntity<Load> getLoadById(@PathVariable UUID loadId){
		Load load = loadService.getLoadById(loadId);
		return load != null ? ResponseEntity.ok(load) : ResponseEntity.notFound().build();
	}
	
	
	  @GetMapping
	    public ResponseEntity<List<Load>> getLoadsByShipperId(@RequestParam String shipperId) {
	        List<Load> loads = loadService.getLoadByShipperId(shipperId);
	        return ResponseEntity.ok(loads);
	    }
	
	@PutMapping("/{loadId}")
	public ResponseEntity<Load> updateLoad(@PathVariable UUID loadId, @RequestBody Load loadDetails){
		Load updateLoad = loadService.updateLoad(loadId, loadDetails);
		return updateLoad != null ? ResponseEntity.ok(updateLoad) : ResponseEntity.notFound().build();
		
	}

	@DeleteMapping("/{loadId}")
	public ResponseEntity<Void> deleteLoad(@PathVariable UUID loadId){
		loadService.deleteLoad(loadId);
		return ResponseEntity.noContent().build();
	}
	
	
}
