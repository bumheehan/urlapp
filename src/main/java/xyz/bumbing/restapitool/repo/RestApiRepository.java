package xyz.bumbing.restapitool.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.bumbing.restapitool.dto.RestApiDto;

public interface RestApiRepository extends JpaRepository<RestApiDto, Integer> {

	public RestApiDto findByUrl(String url);

}
