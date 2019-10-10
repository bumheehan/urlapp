package xyz.bumbing.restapitool.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "restapiparam")
@Entity
public class RestApiParameterDto {

	@Id // 기본키
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pno;

	@JsonIgnore
	@ManyToOne(targetEntity = RestApiDto.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "restapi_no")
	private RestApiDto restapi;

	private String direct;
	private String type;
	private String name;
	private String data;

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public RestApiDto getRestapi() {
		return restapi;
	}

	public void setRestapi(RestApiDto restapi) {
		this.restapi = restapi;
	}

	public String getDirect() {
		return direct;
	}

	public void setDirect(String direct) {
		this.direct = direct;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
