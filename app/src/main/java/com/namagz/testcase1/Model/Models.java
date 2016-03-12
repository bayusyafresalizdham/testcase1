package com.namagz.testcase1.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2/29/16.
 */
public class Models {
    public String url;
    public String forksUrl;
    public String commitsUrl;
    public String id;
    public String gitPullUrl;
    public String gitPushUrl;
    public String htmlUrl;
    public Map<String, File> files;

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


    public static class File {
        public String filename;
        public String type;
        public String language;
        public String rawUrl;
        public long size;

        public void setType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
