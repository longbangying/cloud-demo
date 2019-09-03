package com.exmple.provider.config.prooertis;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "local.file")
public class FileStoreProperty {

    private String storePath;

    public String getStorePath() {
        return storePath;
    }

    public void setStorePath(String storePath) {
        this.storePath = storePath;
    }
}
