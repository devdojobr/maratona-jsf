package br.com.devdojo.maratonajsf.validators;

import br.com.devdojo.maratonajsf.bean.login.LoginBean;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.io.Serializable;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author William Suane on 5/3/2017.
 */
@Named
@RequestScoped
public class Validators implements Serializable {
    private List<String> emailsDB = asList("william.suane@devdojo.com.br", "contato@devdojo.com.br");
    @Inject
    private LoginBean loginBean;

    public void validateDuplicatedEmail(FacesContext facesContext, UIComponent uiComponent, Object o)
            throws ValidatorException {
//        System.out.println(loginBean.getLanguage());
        String email = (String) o;
        if (emailsDB.contains(email)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "O email já existe cadastrado",
                    "");
            throw new ValidatorException(message);
        }
    }

    public void validateFile(FacesContext facesContext, UIComponent uiComponent, Object o)
            throws ValidatorException {
        Part file = (Part) o;
        try {
            validateFileNameLength(file);
            validateContentType(file);
            validateFileSize(file);
        } catch (RuntimeException e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    e.getMessage(),
                    "");
            throw new ValidatorException(message);
        }
    }

    private void validateFileNameLength(Part file) {
        if (file.getSubmittedFileName().length() > 10)
            throw new RuntimeException("O nome + extensão não pode ser maior que 10 car");
    }

    private void validateContentType(Part file) {
        String contentType = file.getContentType();
        if (!contentType.equals("image/png") && !contentType.equals("image/jpge"))
            throw new RuntimeException("Apenas imagens PNG e JPGE são permitidas");
    }

    private void validateFileSize(Part file) {
        if (file.getSize() > 1048576)
            throw new RuntimeException("O arquivo não pode exceder 1Mb");
    }
}