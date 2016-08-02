package model.dto;

import java.io.Serializable;

public class New
        implements Serializable
{
    private String TypeOfNew;
    private String body;
    private String image;
    private String link;
    private String title;

    public String getBody()
    {
        return this.body;
    }

    public String getImage()
    {
        return this.image;
    }

    public String getLink()
    {
        return this.link;
    }

    public String getShortNew()
    {
        String str2 = this.body;
        String str1 = str2;
        if (str2.length() > 220) {
            str1 = str2.substring(0, 220) + "...";
        }
        return str1;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getTypeOfNew()
    {
        return this.TypeOfNew;
    }

    public void setBody(String paramString)
    {
        this.body = paramString;
    }

    public void setImage(String paramString)
    {
        this.image = paramString;
    }

    public void setLink(String paramString)
    {
        this.link = paramString;
    }

    public void setTitle(String paramString)
    {
        this.title = paramString;
    }

    public void setTypeOfNew(String paramString)
    {
        this.TypeOfNew = paramString;
    }

    public String toString()
    {
        return this.title;
    }
}
