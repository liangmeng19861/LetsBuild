package com.letsbuild.base.web.tag;
 
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.web.servlet.tags.form.OptionsTag;

import com.letsbuild.cache.CacheFactory;
import com.letsbuild.dao.mapper.bo.SysLabel;
 
 
public class LabelTag extends TagSupport {
    
    private String tableName;
    
    private String columnName;
    
    private String value;
 
 
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


    @Override
    public int doEndTag() throws JspException {
        String dict = CacheFactory.getLabel(this.tableName, this.columnName, String.valueOf(this.value));
        JspWriter out = pageContext.getOut();
        try {
            out.write(dict);
        } catch (IOException e) {
            throw new JspException(e);
        }
        return TagSupport.EVAL_PAGE;
    }
}