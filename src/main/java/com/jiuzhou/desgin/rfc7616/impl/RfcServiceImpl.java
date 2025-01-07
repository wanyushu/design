package com.jiuzhou.desgin.rfc7616.impl;

import com.jiuzhou.desgin.rfc7616.RfcService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Random;

/**
 * github地址 http://www.github.com/wanyushu
 * gitee地址 http://www.gitee.com/wanyushu
 *
 * @author yushu
 * @email 921784721@qq.com
 * @date 2024/2/21 14:53
 */
@Service
public class RfcServiceImpl implements RfcService {

    String username = "admin";
    String password = "admin123";

    @Override
    public String digestAuth(String url) {
        try {
            String uri = dealUrl(url);
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                String wwwAuthenticateHeader = connection.getHeaderField("WWW-Authenticate");
                String realm = extractHeaderValue(wwwAuthenticateHeader, "Digest realm");
                String nonce = extractHeaderValue(wwwAuthenticateHeader, "nonce");
                String opaque = extractHeaderValue(wwwAuthenticateHeader, "opaque");
                String qop = "auth";
                String nc = "00000002";
                String cnonce = generateNonce();
                String responseDigest = calculateResponseDigest(username, password, "GET", uri, realm, nonce,qop,nc,cnonce);
                StringBuilder digestBuilder = new StringBuilder();
                digestBuilder.append("username=\"").append(username).append("\", ");
                digestBuilder.append("realm=\"").append(realm).append("\", ");
                digestBuilder.append("nonce=\"").append(nonce).append("\", ");
                digestBuilder.append("uri=\"").append(uri).append("\", ");
                digestBuilder.append("response=\"").append(responseDigest).append("\", ");
                digestBuilder.append("opaque=\"").append(opaque).append("\", ");
                digestBuilder.append("qop=").append(qop).append(", ");
                digestBuilder.append("nc=").append(nc).append(", ");
                digestBuilder.append("cnonce=\"").append(cnonce).append("\"");
                return  "Digest " + digestBuilder.toString();
            }else{
                System.out.println("响应成功");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private  String calculateResponseDigest(String username, String password, String method, String url,
                                                  String realm, String nonce,String qop,String nc,String cnonce) {

        return calculateResponse(calculateHA1(username, realm, password),  nonce,qop, calculateHA2(method, url),nc,cnonce);
    }

    private  String calculateHA1(String username, String realm, String password) {
        String ha1 = username + ":" + realm + ":" + password;
        return calculateMD5Hash(ha1);
    }

    private  String calculateHA2(String method, String url) {
        String ha2 = method + ":" + url;
        return calculateMD5Hash(ha2);
    }

    private  String calculateResponse(String ha1, String nonce,String qop,String ha2,String nc,String cnonce) {
        String response = ha1 + ":" + nonce + ":" +nc  + ":" +cnonce+ ":" + qop + ":" + ha2;
        return calculateMD5Hash(response);
    }

    private  String calculateMD5Hash(String input) {
        return MD5(input);
    }

    private  String generateNonce() {
        // 在实际应用中，应该使用更安全的随机数生成方法
        int length = 16;
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public  String MD5(String inStr) {
        MessageDigest md5 = null;

        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }

        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();

        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    private String extractHeaderValue(String header, String key) {
        String[] parts = header.split(", ");
        for (String part : parts) {
            if (part.startsWith(key + "=\"")) {
                return part.substring(key.length() + 2, part.length() - 1);
            }
        }
        return null;
    }

    private String dealUrl(String url){
        // 获取第三个斜杠的下标
        int thirdSlashIndex = getThirdSlashIndex(url);
        System.out.println("第三个斜杠的下标：" + thirdSlashIndex);

        // 获取除去域名部分的后面路径
        String path = url.substring(thirdSlashIndex + 1);
        System.out.println("除去域名部分的后面路径：" + path);
        return path;
    }

    private static int getThirdSlashIndex(String url) {
        int count = 0;
        int index = -1;

        for (int i = 0; i < url.length(); i++) {
            if (url.charAt(i) == '/') {
                count++;
                if (count == 3) {
                    index = i;
                    break;
                }
            }
        }

        return index;
    }

    @Override
    public String testApi(String url,String digest) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization",digest);
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 处理服务端返回的数据
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line).append("\n");
                }
                reader.close();
                connection.disconnect();
                System.out.println("Response: " + response.toString());
            } else {
                System.out.println("Authentication failed. Response code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
