package br.com.devdojo.maratonajsf.validators;

import br.com.devdojo.maratonajsf.bean.login.LoginBean;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author William Suane on 5/3/2017.
 */
@FacesValidator
public class DuplicatedEmailValidator implements Validator {
    private List<String> emailsDB = asList("william.suane@devdojo.com.br","contato@devdojo.com.br");
    @Inject
    private LoginBean loginBean;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o)
            throws ValidatorException {
        System.out.println(loginBean.getLanguage());
        String email = (String) o;
        if(emailsDB.contains(email)){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "O email já existe cadastrado",
                    "");
            throw new ValidatorException(message);
        }
    }
}
