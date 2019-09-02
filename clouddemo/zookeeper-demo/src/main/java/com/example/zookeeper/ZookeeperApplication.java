package com.example.zookeeper;

import com.alibaba.fastjson.JSON;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

public class ZookeeperApplication {

    public static ZooKeeper zooKeeper = null;


    static {

        try {
            zooKeeper = new ZooKeeper("localhost",2000,null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) throws InterruptedException, KeeperException {


       List<String> childs = zooKeeper.getChildren("/long",false);

       childs.forEach(System.out::println);
    }

}
