package br.com.devdojo.maratonajsf.flowbuilder;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import java.io.Serializable;

/**
 * Created by William on 4/5/2017.
 */
public class NewPendenciesFlowBuilder implements Serializable {
    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {
        String flowId = "newpendencies";
        flowBuilder.id("", flowId);
        flowBuilder.viewNode(flowId, "/newpendencies/newpendencies.xhtml").markAsStartNode();
        flowBuilder.returnNode("proceedToNewRegistration3")
                .fromOutcome("/newregistration/newregistration3.xhtml");
        flowBuilder.returnNode("exitToNewInicio")
                .fromOutcome("/newregistration/newregistration.xhtml");
        flowBuilder.inboundParameter("userName", "#{testeFlowBuilderNestedBean.userName}");
        flowBuilder.inboundParameter("userSurname", "#{testeFlowBuilderNestedBean.userSurname}");
        return flowBuilder.getFlow();
    }
}
