package xyz.bumbing.restapitool.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.bumbing.restapitool.dto.RestApiParameterDto;

public interface RestApiParamRepository extends JpaRepository<RestApiParameterDto, Integer> {

}
