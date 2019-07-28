package com.shanhe.comsume.service;

import com.shanhe.comsume.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private LoadBalancerClient loadBalancerClient ;//ribbon 负载均衡器
    public List<User> getUser(){
        // 选择调用的服务的名称
        //ServiceInstance 封装了服务的基本信息， 如IP , 端口
        ServiceInstance si = loadBalancerClient.choose("eureka-provider");

        //拼接访问服务的URL
        StringBuffer urlStr = new StringBuffer();
        //http://49.234.188.186:9090/getUser
        urlStr.append("http://").append(si.getHost()).append(":").append(si.getPort()).append("/getUser") ;

        RestTemplate rest = new RestTemplate();
        ParameterizedTypeReference<List<User>> type = new ParameterizedTypeReference<List<User>>() {} ;
        ResponseEntity<List<User>> response = rest.exchange(urlStr.toString(), HttpMethod.GET,null,type);
        List<User> list = response.getBody();
        System.out.println("list.size =========== " + list.size());
        return list ;
    }

}
