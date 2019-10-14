package xyz.bumbing.restapitool.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.bumbing.restapitool.dto.RestApiDto;

public interface RestApiRepository extends JpaRepository<RestApiDto, Integer> {

	public RestApiDto findByUrl(String url);

	public List<RestApiDto> findAllByUrlContainingOrderByUrlAsc(String search);
}
