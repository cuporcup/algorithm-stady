package cn.itcast.sms;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SmsListener {

    @Autowired
    private SmsUtil smsUtil;


    @JmsListener(destination = "smsDestination")
    public void sendSms(Map<String,String> map){
        try {
            SendSmsResponse response = smsUtil.sendSms(
                    map.get("mobile"),
                    map.get("sign_name"),
                    map.get("template_code"),
                    map.get("param"));
            System.out.println("结果是："+response.getCode());
            System.out.println("信息是"+response.getMessage());
        } catch (ClientException e) {
            e.printStackTrace();
        }


    }
}
