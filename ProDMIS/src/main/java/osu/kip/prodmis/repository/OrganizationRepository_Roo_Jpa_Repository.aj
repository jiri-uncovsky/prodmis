// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package osu.kip.prodmis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import osu.kip.prodmis.domain.Organization;
import osu.kip.prodmis.repository.OrganizationRepository;
import osu.kip.prodmis.repository.OrganizationRepositoryCustom;

privileged aspect OrganizationRepository_Roo_Jpa_Repository {
    
    declare parents: OrganizationRepository extends JpaRepository<Organization, Long>;
    
    declare parents: OrganizationRepository extends OrganizationRepositoryCustom;
    
    declare @type: OrganizationRepository: @Repository;
    
    declare @type: OrganizationRepository: @Transactional(readOnly = true);
    
}