package osu.kip.prodmis.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import osu.kip.prodmis.domain.Document;
import osu.kip.prodmis.domain.DocumentRevision;
import osu.kip.prodmis.service.api.DocumentService;
import osu.kip.prodmis.service.api.StorageService;

@RooServiceImpl(service = DocumentService.class)
public class DocumentServiceImpl {

	@Autowired
	StorageService storageService;

	@Transactional(readOnly = false)
	public void delete(Iterable<Long> ids) {
		List<Document> toDelete = documentRepository.findAll(ids);
		documentRepository.deleteInBatch(toDelete);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {

		Document document = findOne(id);

		Set<DocumentRevision> revisons = document.getRevisions();
		for (DocumentRevision documentRevision : revisons) {
			storageService.delete(documentRevision.getFileName());
		}

		documentRepository.delete(id);

	}

}
