package br.com.devdojo.maratonajsf.converters;

import br.com.devdojo.maratonajsf.model.Estudante;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.List;
import java.util.Map;

/**
 * @author William Suane on 5/3/2017.
 */
@FacesConverter(value = "estudanteConverter")
public class EstudanteConverter implements Converter {
    private List<Estudante> estudanteList = Estudante.estudanteList();

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value == null || !value.matches("\\d+"))
            return null;
//        Estudante estudante = new Estudante();
//        estudante.setId(Integer.parseInt(value));
//        int index = estudanteList.indexOf(estudante);
//        return estudanteList.get(index);
        return this.getAttributesFrom(uiComponent).get(value);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value != null && !value.equals("")) {
            Estudante estudante = (Estudante) value;
            if (estudante.getId() != null) {
                this.addAttribute(uiComponent, estudante);
                return estudante.getId().toString();
            }
        }
        return null;
    }

    private Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }

    private void addAttribute(UIComponent component, Estudante estudante) {
        this.getAttributesFrom(component).put(estudante.getId().toString(), estudante);
    }
}
