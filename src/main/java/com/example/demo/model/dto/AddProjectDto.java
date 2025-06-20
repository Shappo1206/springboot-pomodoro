package com.example.demo.model.dto;


// ProjectCreateDTO - 用於建立專案
public class AddProjectDto {

	    private String title;
	    private String description;
	    
	    public AddProjectDto() {}
	    
	    public String getTitle() { return title; }
	    public void setTitle(String title) { this.title = title; }
	    
	    public String getDescription() { return description; }
	    public void setDescription(String description) { this.description = description; }

}
