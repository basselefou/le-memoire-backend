package org.glsid.service;

import java.util.List;

import org.glsid.entitie.Section;

public interface ServiceSection {
	Section saveSection(Section section);
	List<Section> getSections();
	Section getSection(Long idsection);
	void deleteSection(Long idsection);
	void updateSection(Section section, Long idsection); 


}
