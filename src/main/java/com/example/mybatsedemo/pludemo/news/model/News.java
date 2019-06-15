package com.example.mybatsedemo.pludemo.news.model;

import java.util.Date;
import com.alibaba.fastjson.JSON;
import com.example.mybatsedemo.pludemo.base.BaseModel;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.TableId;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotation.TableField;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 新闻信息表
 * </p>
 *
 * @author xpw
 * @since 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="News对象", description="新闻信息表")
public class News extends BaseModel<News> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "新闻ID")
    @TableId("NEWS_ID")
    private String newsId;

    @ApiModelProperty(value = "新闻分类ID")
    @TableField("NEWS_TYPE_ID")
    private String newsTypeId;

    @ApiModelProperty(value = "领导信息编码")
    @TableField("LEADER_ID")
    private String leaderId;

    @ApiModelProperty(value = "新闻标题")
    @TableField("NEWS_TITLE")
    private String newsTitle;

    @ApiModelProperty(value = "主题图片")
    @TableField("TITLE_PIC_STORE_PATH")
    private String titlePicStorePath;

    @ApiModelProperty(value = "新闻远程URL")
    @TableField("NEWS_URL")
    private String newsUrl;

    @ApiModelProperty(value = "新闻本地路径")
    @TableField("NEWS_LOCAL_URL")
    private String newsLocalUrl;

    @ApiModelProperty(value = "创建日期")
    @TableField("CREATE_DATE")
    private Date createDate;

    @ApiModelProperty(value = "修改日期")
    @TableField("MODIFY_DATE")
    private Date modifyDate;

    @ApiModelProperty(value = "创建者ID")
    @TableField("CREATOR_ID")
    private String creatorId;

    @ApiModelProperty(value = "创建者姓名")
    @TableField("CREATOR_NAME")
    private String creatorName;

    @ApiModelProperty(value = "审核者ID")
    @TableField("AUDITOR_ID")
    private String auditorId;

    @ApiModelProperty(value = "审核者姓名")
    @TableField("AUDITOR_NAME")
    private String auditorName;

    @ApiModelProperty(value = "图片个数")
    @TableField("PICS")
    private Integer pics;

    @ApiModelProperty(value = "新闻富文本内容")
    @TableField("NEWS_CONTENT")
    private String newsContent;

    @ApiModelProperty(value = "是否置顶，0未置顶，1置顶")
    @TableField("AT_TOP")
    private Integer atTop;

    @ApiModelProperty(value = "是否热点，0未热点，1热点")
    @TableField("AT_HOT")
    private Integer atHot;

    @ApiModelProperty(value = "是否幻灯播放，0不播放，1播放")
    @TableField("SLIDE_SHOW")
    private Integer slideShow;

    @ApiModelProperty(value = "点击数量")
    @TableField("VIEW_COUNT")
    private Integer viewCount;

    @ApiModelProperty(value = "新闻状态，0未审核，1审核通过，2下线")
    @TableField("NEWS_STATUS")
    private Integer newsStatus;

    @ApiModelProperty(value = "新闻来源")
    @TableField("NEWS_SOURCE")
    private String newsSource;

    @ApiModelProperty(value = "信息发布来源，0：本站发布，1：来自省厅主站，2：来自地市州分站")
    @TableField("CREATED_BY")
    private Integer createdBy;

    @ApiModelProperty(value = "新闻发布类型：0本地发布，1远程链接")
    @TableField("LOCAL_RANGE_STATUS")
    private String localRangeStatus;

    @ApiModelProperty(value = "静态页面相对URL")
    @TableField("STATIC_URL")
    private String staticUrl;

    @ApiModelProperty(value = "服务器存储路径")
    @TableField("LOCAL_FILE")
    private String localFile;

    @ApiModelProperty(value = "是否推送，0不推送，1已推送")
    @TableField("PUSHED")
    private Integer pushed;

    @ApiModelProperty(value = "推送时间")
    @TableField("PUSH_DATE")
    private Date pushDate;

    @ApiModelProperty(value = "新闻摘要")
    @TableField("NEWS_ABSTRACT")
    private String newsAbstract;

    @ApiModelProperty(value = "微信静态页面地址")
    @TableField("WE_CHAT_URL")
    private String weChatUrl;

    @ApiModelProperty(value = "0草稿，1已发布")
    @TableField("DRAFT_STATUS")
    private Integer draftStatus;

    @ApiModelProperty(value = "同步栏目ID")
    @TableField("REF_NEWS_TYPE_ID")
    private String refNewsTypeId;

    @ApiModelProperty(value = "是否优先轮播，0，否，1，是")
    @TableField("NEWS_SLIDER_ORDER")
    private Integer newsSliderOrder;

    @ApiModelProperty(value = "新闻副标题")
    @TableField("SUB_NEWS_TITLE")
    private String subNewsTitle;


    @Override
    protected Serializable pkVal() {
        return this.newsId;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
