package com.monster.test.domain;

import java.util.List;

/**
 * @Author: zhiyu
 * @Date: 2023/12/24 20:55
 */
public class Personal {

    private String name;

    // 人员标签
    private List<String> tagList;

    public Personal(String name, List<String> tagList) {
        this.name = name;
        this.tagList = tagList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "name='" + name + '\'' +
                ", tagList=" + tagList +
                '}';
    }
}
