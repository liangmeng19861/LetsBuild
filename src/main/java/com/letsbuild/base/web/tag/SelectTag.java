package com.letsbuild.base.web.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.letsbuild.cache.CacheFactory;
import com.letsbuild.dao.mapper.bo.SysLabel;

public class SelectTag extends TagSupport {
    
    private String tableName;

    private String columnName;

    private String defaultLabel;

    private String value;

    private String name;

    private String id;

    private String cssClass;

    private String styleClass;

    private String multiple;

    private String onChange;

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public String getMultiple() {
        return multiple;
    }

    public void setMultiple(String multiple) {
        this.multiple = multiple;
    }

    public String getOnChange() {
        return onChange;
    }

    public void setOnChange(String onChange) {
        this.onChange = onChange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDefaultLabel() {
        return defaultLabel;
    }

    public void setDefaultLabel(String defaultLabel) {
        this.defaultLabel = defaultLabel;
    }

    @Override
    public int doEndTag() throws JspException {
        SysLabel dict = new SysLabel();
        List<SysLabel> dict_list = CacheFactory.getLabel(this.tableName,this.columnName);
        JspWriter out = pageContext.getOut();
        StringBuffer sb = new StringBuffer();
        sb.append("<select name='" + this.getName() + "' id='" + this.getId() + "'");
        if (!StringUtils.isEmpty(this.getCssClass())) {
            sb.append("class=\"" + this.getCssClass() + "\" ");
        }
        if (!StringUtils.isEmpty(this.getStyleClass())) {
            sb.append("style=\"" + this.getStyleClass() + "\" ");
        }
        if (!StringUtils.isEmpty(this.getMultiple())) {
            sb.append("multiple=\"" + this.getMultiple() + "\" ");
        }
        if (!StringUtils.isEmpty(this.getOnChange())) {
            sb.append("onchange=\"" + this.getOnChange() + "\" ");
        }
        sb.append(">");
        if(!StringUtils.isEmpty(defaultLabel)){
            sb.append("<option value=''>").append(defaultLabel).append("</option>");
        }
        for (SysLabel dc : dict_list) {
            if (dc.getValue().equals(this.getValue())) {
                sb.append("<option value='" + dc.getValue() + "' selected='selected'>");
            } else {
                sb.append("<option value='" + dc.getValue() + "'>");
            }
            sb.append(dc.getLabel() + "</option>");
        }
        sb.append("</select>");
        try {
            out.write(sb.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new JspException(e);
        }
        return TagSupport.EVAL_PAGE;
    }
    
    private static class StringUtils{
        public static boolean isEmpty(String str) {
            if (null == str) {
                return true;
            }
            if ("".equals(str.trim())) {
                return true;
            }
            return false;
        }
    }

}