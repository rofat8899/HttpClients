package com.rofat.HttpClients.number;

import com.rofat.HttpClients.RestClient;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class numberServiceImp implements numberService{
    @Override
    public String Operation(String type, int num) {
        RestClient restClient = new RestClient();
        String numtype="";
        String toSplit1="";
        String toSplit2="";
        if(type.equals("NumberToWords"))
        {
            numtype="ubiNum";
            toSplit1="<m:NumberToWordsResult>";
            toSplit2="</m:NumberToWordsResult>";
        }
        else
        {
            numtype="dNum";
            toSplit1="<m:NumberToDollarsResult>";
            toSplit2="</m:NumberToDollarsResult>";
        }
        String xml = restClient.post("","<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <"+type+" xmlns=\"http://www.dataaccess.com/webservicesserver/\">\n" +
                "      <"+numtype+">"+num+"\n" +
                "      </"+numtype+">\n" +
                "    </"+type+">\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>");
        String[] split1 = StringUtils.split(xml,toSplit1);
        assert split1 != null;
        String[] result = split1[1].split(toSplit2);
        return result[0];
    }
}
