package org.arkena;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.activiti.engine.form.FormProperty;
import org.activiti.explorer.Messages;
import org.activiti.explorer.ui.form.AbstractFormPropertyRenderer;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Field;

public class CompaniesFormPropertyRenderer extends AbstractFormPropertyRenderer {
 
  private static final long serialVersionUID = 1L;
 
  public CompaniesFormPropertyRenderer() {
    super(CompaniesFormType.class);
  }
  
  @Override
  public Field getPropertyField(FormProperty formProperty) {
    ComboBox comboBox = new ComboBox(getPropertyLabel(formProperty));
    comboBox.setRequired(formProperty.isRequired());
    comboBox.setRequiredError(getMessage(Messages.FORM_FIELD_REQUIRED, getPropertyLabel(formProperty)));
    comboBox.setEnabled(formProperty.isWritable());
    
    
  	Map<String, String> companies = CompaniesFormType.getCompagnies();
 
  	Iterator<Entry<String, String>> it = companies.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry<String, String> pairs = (Map.Entry<String, String>)it.next();
        
        comboBox.addItem(pairs.getKey());
        comboBox.setItemCaption(pairs.getKey(), pairs.getValue().toString());
    }
  	
    return comboBox;
  }
 
}
