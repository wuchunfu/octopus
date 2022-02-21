package org.metahut.octopus.meta.parser.domain.compile.support;

import org.metahut.octopus.meta.parser.domain.enums.TagCategory;
import org.metahut.octopus.meta.parser.domain.enums.TagLife;

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
    private TagCategory tagCategory;
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

    private TagLife tagLife;

}
