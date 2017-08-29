package br.com.devdojo.maratonajsf.util;

import javax.faces.context.FacesContext;

/**
 * @author William Suane on 4/27/2017.
 */
public class ApplicationMapUtil {
    public static Object getValueFromApplicationMap(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get(key);
    }

    public static void setValueInApplicationMap(String key, Object value) {
        FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put(key, value);
    }
}
