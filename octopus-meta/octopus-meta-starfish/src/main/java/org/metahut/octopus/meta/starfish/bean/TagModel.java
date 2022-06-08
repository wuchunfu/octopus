package org.metahut.octopus.meta.starfish.bean;

import java.util.Date;

/**
 * TagModel
 * which is marking for searching、sorting、comment、comment、limit etc.
 * TODO 如何解耦 并且 与 实际功能挂钩
 */
public class TagModel {

    /**
     * Tag category
     */
    private TagCategory sfTagCategory;
    /**
     * Tag Name
     */
    private String tagName;

    /**
     * Tag detail
     */
    private String tagDetail;

    /**
     * tag owner
     */
    private String tagOwner;

    /**
     * tag date
     */
    private Date tagDate;

    /**
     * tag order;
     */
    private Long tagOrder;

    private TagLife sfTagLife;

    public TagCategory getSfTagCategory() {
        return sfTagCategory;
    }

    public void setSfTagCategory(TagCategory sfTagCategory) {
        this.sfTagCategory = sfTagCategory;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagDetail() {
        return tagDetail;
    }

    public void setTagDetail(String tagDetail) {
        this.tagDetail = tagDetail;
    }

    public String getTagOwner() {
        return tagOwner;
    }

    public void setTagOwner(String tagOwner) {
        this.tagOwner = tagOwner;
    }

    public Date getTagDate() {
        return tagDate;
    }

    public void setTagDate(Date tagDate) {
        this.tagDate = tagDate;
    }

    public Long getTagOrder() {
        return tagOrder;
    }

    public void setTagOrder(Long tagOrder) {
        this.tagOrder = tagOrder;
    }

    public TagLife getSfTagLife() {
        return sfTagLife;
    }

    public void setSfTagLife(TagLife sfTagLife) {
        this.sfTagLife = sfTagLife;
    }
}
