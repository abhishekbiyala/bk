package domain;

import annotation.BusinessKey;

public class MmyComponent {

	@BusinessKey
	private String componentCd;
	
	private String componentDesc;

	public String getComponentCd() {
		return componentCd;
	}

	public void setComponentCd(String componentCd) {
		this.componentCd = componentCd;
	}

	public String getComponentDesc() {
		return componentDesc;
	}

	public void setComponentDesc(String componentDesc) {
		this.componentDesc = componentDesc;
	}
}
