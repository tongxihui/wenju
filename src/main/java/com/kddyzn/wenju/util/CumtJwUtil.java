package com.kddyzn.wenju.util;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.kddyzn.wenju.constant.AppConstant;
import lombok.Data;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Objects;

@Component
public class CumtJwUtil {

    /**
     * 获取统一认证登录token
     *
     * @param userId
     * @param password
     * @return
     */
    public String getLoginToken(String userId, String password) {
        String url = AppConstant.CUMT_TY_API + "/login";
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("username", userId);
        paramMap.add("password", password);
        RestTemplate client = new RestTemplateBuilder().build();
        ResponseEntity<LoginResult> responseEntity = client.postForEntity(url, paramMap, LoginResult.class);
        return Objects.requireNonNull(responseEntity.getBody()).token;
    }

    @Data
    private static class LoginResult {
        private Integer code;
        private String msg;
        private String token;
    }

    /**
     * 获取真实姓名
     * @param userId
     * @param password
     * @return
     */
    public String getRealName(String userId, String password) {
        try {
            String url = AppConstant.CUMT_TY_DOMAIN;
            WebClient webClient = new WebClient();
            webClient.getOptions().setJavaScriptEnabled(true);
            webClient.getOptions().setCssEnabled(false);

            HtmlPage loginPage = webClient.getPage(url);
            HtmlForm form = loginPage.getForms().get(0);

            HtmlTextInput usernameInput = form.getInputByName("username");
            HtmlPasswordInput passwordInput = form.getInputByName("password");
            HtmlButton loginButton = form.getButtonByName("signIn");

            usernameInput.setText(userId);
            passwordInput.setText(password);

            HtmlPage page = loginButton.click();
            HtmlElement name = page.getHtmlElementById("welcomeMsg");
            String result = name.getFirstChild().asXml()
                    .replace("欢迎您：", "")
                    .replace("\r", "")
                    .replace("\n", "");
            System.out.println(result);
            return result;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}