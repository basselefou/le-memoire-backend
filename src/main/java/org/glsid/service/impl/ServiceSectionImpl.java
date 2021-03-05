package org.glsid.service.impl;

import java.util.List;

import org.glsid.dao.SectionRepository;
import org.glsid.entitie.Section;
import org.glsid.service.ServiceSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ServiceSectionImpl implements ServiceSection{
	@Autowired
	private SectionRepository sectionRepository;

	@Override
	public Section saveSection(Section section) {
		
		return sectionRepository.save(section);
	}

	@Override
	public List<Section> getSections() {
		return sectionRepository.findAll();
	}

	@Override
	public Section getSection(Long idsection) {
	
		return sectionRepository.findOne(idsection);
	}

	@Override
	public void deleteSection(Long idsection) {
		sectionRepository.delete(idsection);
		
	}

	@Override
	public void updateSection(Section section, Long idsection) {
	    section.setIdsection(idsection);
	    sectionRepository.save(section);
		
	}

}
