package com.example.commons.utils;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
public class NetUtils {

    private  NetUtils(){

    }
    public static String getLocalHostAddress(){
        String localIp;
        try{
            InetAddress inet4Address = InetAddress.getLocalHost();
            localIp = inet4Address.getHostAddress();
            return localIp;
        }catch (UnknownHostException e){
            log.error("error:{}",e.getMessage());
        }
        return "";
    }
}
