package org.glsid.controller;

import java.util.Collection;

import org.glsid.entitie.Section;
import org.glsid.service.ServiceSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SectionController {
	@Autowired
	private ServiceSection servicesection;
	
	@GetMapping(value="/section")
	public Collection<Section> getSection(){
		return servicesection.getSections();	
	}
	@GetMapping(value="/section/{id}")
	public Section getSection(@PathVariable Long idsection) {
		return servicesection.getSection(idsection);
	}
	@PostMapping(value="/section")
	public Section saveSection(@RequestBody Section section) {
		return servicesection.saveSection(section);
	}
	 @DeleteMapping(value="/section/{id}")
	    public void deleteSection(@PathVariable Long idsection) {
			servicesection.deleteSection(idsection);
			
		}
	@PutMapping(value="/section/{id}")
	private void updateSection(@RequestBody Section section,@PathVariable Long idsection) {
	    section.setIdsection(idsection);
	    servicesection.saveSection(section);
	}

}
