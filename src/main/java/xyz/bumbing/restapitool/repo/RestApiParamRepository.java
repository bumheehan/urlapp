package xyz.bumbing.restapitool.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.bumbing.restapitool.dto.RestApiParameterDto;

public interface RestApiParamRepository extends JpaRepository<RestApiParameterDto, Integer> {

	public List<RestApiParameterDto> findAllByOrderByNameAsc();
}
