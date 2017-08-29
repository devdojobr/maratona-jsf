package br.com.devdojo.maratonajsf.bean.taglibfunction;

import org.apache.commons.lang3.text.WordUtils;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author William Suane on 6/22/2017.
 */
@Named
@ViewScoped
public class TaglibFunctionTesteBean implements Serializable{
    private List<String> names = asList("shimazu toyohisa","oda nobunaga","nasu no yoichi");
    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
