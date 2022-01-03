package com.rofat.HttpClients;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.html.parser.Parser;

@Service
public class ATTServiceIpm implements ATTService{


    @Override
    public String amountToText(int amount) {
        RestClient restClient = new RestClient();

        String xml = restClient.post("","<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">\n" +
                "      <ubiNum>"+amount+"\n" +
                "      </ubiNum>\n" +
                "    </NumberToWords>\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>");
        String[] split1 = StringUtils.split(xml,"<m:NumberToWordsResult>");
        assert split1 != null;
        String[] result = split1[1].split(" </m:NumberToWordsResult>");
        System.out.println(result[0]);
        return result[0];
    }

}
