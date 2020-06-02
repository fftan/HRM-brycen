package com.brycen.hrm.service.implService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brycen.hrm.model.Cms;
import com.brycen.hrm.repository.CmsRepository;
import com.brycen.hrm.service.CmsService;

@Service
public class CmsImplService implements CmsService{
	private CmsRepository cmsRep;

	@Autowired
	public CmsImplService(CmsRepository cmsRep) {
		super();
		this.cmsRep = cmsRep;
	}

	@Override
	public List<Cms> findAllCms() {
		List<Cms> cmsList = (List<Cms>) cmsRep.findAll();
		return cmsList;
	}

	@Override
	public Optional<Cms> findCmsById(int id) {
		Optional<Cms> cms = cmsRep.findById(id);
		return cms;
	}

	@Override
	public void save(Cms cms) {
		cmsRep.save(cms);
	}

	@Override
	public void remove(Cms cms) {
		cmsRep.delete(cms);
	}
}
