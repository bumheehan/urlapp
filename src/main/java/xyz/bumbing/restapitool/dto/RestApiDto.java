package xyz.bumbing.restapitool.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "restapi")
@Entity // 객체
public class RestApiDto {

	@Id // 기본키
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restapi_no")
	private int no;

	private String url;
	private String requestMethod;
	private String contentType;
	private String templateUrl;
	private String className;
	private String methodName;

	@OneToMany(mappedBy = "restapi", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RestApiParameterDto> parameter = new ArrayList<RestApiParameterDto>();

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public List<RestApiParameterDto> getParameter() {
		return parameter;
	}

	public void setParameter(List<RestApiParameterDto> parameter) {
		this.parameter = parameter;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getTemplateUrl() {
		return templateUrl;
	}

	public void setTemplateUrl(String templateUrl) {
		this.templateUrl = templateUrl;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

}
