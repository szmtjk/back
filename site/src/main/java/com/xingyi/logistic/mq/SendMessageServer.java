package com.xingyi.logistic.mq;

import com.xingyi.logistic.business.model.DispatchPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;

/**
 * Created by WCL on 2018/1/12.
 */
@Component
public class SendMessageServer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;


    /**
     * 向MQ发送消息
     * @param dispatchPlan
     * @throws JAXBException
     */
    public void funSendMsg(DispatchPlan dispatchPlan) throws JAXBException
    {
        JAXBContext context = JAXBContext.newInstance(DispatchPlan.class);
        Marshaller marshaller = context.createMarshaller(); // 根据上下文获取marshaller对象

        //marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");  // 设置编码字符集
        // marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化XML输出，有分行和缩进

        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);// 去掉生成xml的默认报文头
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        marshaller.marshal(dispatchPlan, baos);
        String xmlObj = new String(baos.toByteArray());
        System.out.println(xmlObj);
        jmsMessagingTemplate.convertAndSend("DISPATCHPLANSEND.QUEUE", xmlObj);
    }
}
