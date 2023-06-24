package com.springmvc.api;

public class WebsiteInfoDTO {

	private String websiteName;
	private String websiteCategory;

	public WebsiteInfoDTO() {
		System.out.println("WebsiteInfoDTO constructor called");
	}

	public String getWebsiteName() {
		return websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}

	public String getWebsiteCategory() {
		return websiteCategory;
	}

	public void setWebsiteCategory(String websiteCategory) {
		this.websiteCategory = websiteCategory;
	}

	@Override
	public String toString() {
		return "WebsiteInfoDTO [websiteName=" + websiteName + ", websiteCategory=" + websiteCategory + "]";
	}
}
