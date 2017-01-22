package com.daoben.youwenmanager.bean;

/**
 * Created by Administrator on 2017/1/22.
 */

public class NoteBookBean
{
    /**
     * 日期
     */
    private String date;
    /**
     * 时间
     */
    private String time;
    /**
     * 内容
     */
    private String content;
    /**
     * 地点
     */
    private String address;
    /**
     * 图片
     */
    private String image;

    /**
     * 获取日期
     * @return
     */
    public String getDate()
    {
        return date;
    }

    public NoteBookBean(String date, String time, String content, String address)
    {
        this.date = date;
        this.time = time;
        this.content = content;
        this.address = address;
    }

    /**
     * 修改日期
     * @param date
     */
    public void setDate(String date)
    {
        this.date = date;
    }

    /**
     * 获取时间
     * @return
     */
    public String getTime()
    {
        return time;
    }

    /**
     * 修改时间
     * @param time
     */
    public void setTime(String time)
    {
        this.time = time;
    }

    /**
     * 获取内容
     * @return
     */
    public String getContent()
    {
        return content;
    }

    /**
     * 修改内容
     * @param content
     */
    public void setContent(String content)
    {
        this.content = content;
    }

    /**
     * 获取位置
     * @return
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * 修改位置
     * @param address
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * 获取图片
     * @return
     */
    public String getImage()
    {
        return image;
    }

    /**
     * 修改图片
     * @param image
     */
    public void setImage(String image)
    {
        this.image = image;
    }
}
