package com.namagz.testcase1.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2/29/16.
 */
public class Models {
    private String id;
    private String files;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The nama
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The nama
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
