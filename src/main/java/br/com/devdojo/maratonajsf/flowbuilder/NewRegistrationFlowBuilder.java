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

public class NewRegistrationFlowBuilder implements Serializable {
    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {
        String flowId = "newregistration";
        flowBuilder.id("", flowId);
        flowBuilder.viewNode(flowId, "/newregistration/newregistration.xhtml").markAsStartNode();
        flowBuilder.viewNode(flowId, "/newregistration/newregistration2.xhtml");
        flowBuilder.viewNode(flowId, "/newregistration/newregistration3.xhtml");

        flowBuilder.switchNode("newRegistrationPage2")
                .defaultOutcome(flowId)
                .switchCase()
                .condition("#{not empty testeFlowBuilderBean.nome and not empty testeFlowBuilderBean.sobrenome}")
                .fromOutcome("newregistration2");

        flowBuilder.flowCallNode("callNewPendencies")
                .flowReference("","newpendencies")
                .outboundParameter("userName","#{testeFlowBuilderBean.nome}")
                .outboundParameter("userSurname","#{testeFlowBuilderBean.sobrenome}");

        flowBuilder.returnNode("exitToInicio").fromOutcome("/inicioflow.xhtml");
        flowBuilder.returnNode("exitToIndex").fromOutcome("/index.xhtml");
        flowBuilder.finalizer("#{testeFlowBuilderBean.salvar}");
        return flowBuilder.getFlow();
    }
}
