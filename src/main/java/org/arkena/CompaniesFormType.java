package org.arkena;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ActivitiIllegalArgumentException;
import org.activiti.engine.form.AbstractFormType;

public class CompaniesFormType extends AbstractFormType {
  
  static Map<String, String> getCompagnies(){
	  Map<String, String> companiesList;
	  companiesList = new HashMap<String, String>();
	  
	  companiesList.put("company1", "Company 1");
	  companiesList.put("company2", "Company 2");
	  companiesList.put("company3", "Company 3");
	  
	  return companiesList;
  }
  
  public CompaniesFormType() {
	  super();
  }
  
  public CompaniesFormType(Map<String, String> companies) {
	  super();
  }
  
  public String getName(){
    return "companies";
  }
  
  @Override
  public Object getInformation(String key) {
    if (key.equals("values")) {
      return getCompagnies();
    }
    return null;
  }
  
  @Override
  public Object convertFormValueToModelValue(String propertyValue) {
	validateValue(propertyValue);
	return propertyValue;
  }
 
  @Override
  public String convertModelValueToFormValue(Object modelValue) {
	if(modelValue != null) {
	  if(!(modelValue instanceof String)) {
	    throw new ActivitiIllegalArgumentException("Model value should be a String");
	  }
	  validateValue((String) modelValue);
	}
	return (String) modelValue;
  }
  
  protected void validateValue(String company) {
	Map<String, String> companies = getCompagnies();
	
	if(company != null) {
	  if(companies != null && !companies.containsKey(company)) {
	    throw new ActivitiIllegalArgumentException("Invalid value for companies form property: " + company);
	  }
	}
  }
}
