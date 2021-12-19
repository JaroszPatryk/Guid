package com.applicatiot.guid_application.external;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuidRepository extends JpaRepository<GuidEntity, Long> {

    GuidEntity findGuidEntityById(Long id);
}
