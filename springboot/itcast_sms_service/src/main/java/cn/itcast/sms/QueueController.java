package cn.itcast.sms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class QueueController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/send")
    public void sendMap(){

        HashMap<String, String> map = new HashMap<>();
        map.put("mobile","19950167037");
        map.put("sign_name","品优购");
        map.put("template","SMS_147196327");
        map.put("param","{\"code\":\"123\"}");
        jmsMessagingTemplate.convertAndSend("pinyougou_sms_register",map);


    }

}
