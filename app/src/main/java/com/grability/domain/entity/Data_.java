package com.grability.domain.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rogerp91 on 19/01/17.
 */

public class Data_ {

    private int id_aux;

    public int getId_aux() {
        return id_aux;
    }

    public void setId_aux(int id_aux) {
        this.id_aux = id_aux;
    }

    @SerializedName("banner_img")
    private String bannerImg;

    @SerializedName("user_sr_theme_enabled")
    private Boolean userSrThemeEnabled;

    @SerializedName("submit_text_html")
    private String submitTextHtml;

    @SerializedName("wiki_enabled")
    private Boolean wikiEnabled;

    @SerializedName("show_media")
    private Boolean showMedia;

    @SerializedName("id")
    private String id;

    @SerializedName("submit_text")
    private String submitText;

    @SerializedName("display_name")
    private String displayName;

    @SerializedName("header_img")
    private String headerImg;

    @SerializedName("description_html")
    private String descriptionHtml;

    @SerializedName("title")
    private String title;

    @SerializedName("collapse_deleted_comments")
    private Boolean collapseDeletedComments;

    @SerializedName("over18")
    private Boolean over18;

    @SerializedName("public_description_html")
    private String publicDescriptionHtml;

    @SerializedName("suggested_comment_sort")
    private String suggestedCommentSort;

    @SerializedName("icon_img")
    private String iconImg;

    @SerializedName("header_title")
    private String headerTitle;

    @SerializedName("description")
    private String description;

    @SerializedName("submit_link_label")
    private String submitLinkLabel;

    @SerializedName("public_traffic")
    private Boolean publicTraffic;

    @SerializedName("subscribers")
    private Integer subscribers;

    @SerializedName("submit_text_label")
    private String submitTextLabel;

    @SerializedName("lang")
    private String lang;

    @SerializedName("key_color")
    private String keyColor;

    @SerializedName("name")
    private String name;

    @SerializedName("created")
    private Double created;

    @SerializedName("url")
    private String url;

    @SerializedName("quarantine")
    private Boolean quarantine;

    @SerializedName("hide_ads")
    private Boolean hideAds;

    @SerializedName("created_utc")
    private String createdUtc;

    @SerializedName("public_description")
    private String publicDescription;

    @SerializedName("show_media_preview")
    private Boolean showMediaPreview;

    @SerializedName("comment_score_hide_mins")
    private Integer commentScoreHideMins;

    @SerializedName("subreddit_type")
    private String subredditType;

    @SerializedName("submission_type")
    private String submissionType;


    public String getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public Boolean getUserSrThemeEnabled() {
        return userSrThemeEnabled;
    }

    public void setUserSrThemeEnabled(Boolean userSrThemeEnabled) {
        this.userSrThemeEnabled = userSrThemeEnabled;
    }

    public String getSubmitTextHtml() {
        return submitTextHtml;
    }

    public void setSubmitTextHtml(String submitTextHtml) {
        this.submitTextHtml = submitTextHtml;
    }

    public Boolean getWikiEnabled() {
        return wikiEnabled;
    }

    public void setWikiEnabled(Boolean wikiEnabled) {
        this.wikiEnabled = wikiEnabled;
    }

    public Boolean getShowMedia() {
        return showMedia;
    }

    public void setShowMedia(Boolean showMedia) {
        this.showMedia = showMedia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubmitText() {
        return submitText;
    }

    public void setSubmitText(String submitText) {
        this.submitText = submitText;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getHeaderImg() {
        return headerImg;
    }

    public void setHeaderImg(String headerImg) {
        this.headerImg = headerImg;
    }

    public String getDescriptionHtml() {
        return descriptionHtml;
    }

    public void setDescriptionHtml(String descriptionHtml) {
        this.descriptionHtml = descriptionHtml;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCollapseDeletedComments() {
        return collapseDeletedComments;
    }

    public void setCollapseDeletedComments(Boolean collapseDeletedComments) {
        this.collapseDeletedComments = collapseDeletedComments;
    }

    public Boolean getOver18() {
        return over18;
    }

    public void setOver18(Boolean over18) {
        this.over18 = over18;
    }

    public String getPublicDescriptionHtml() {
        return publicDescriptionHtml;
    }

    public void setPublicDescriptionHtml(String publicDescriptionHtml) {
        this.publicDescriptionHtml = publicDescriptionHtml;
    }

    public String getSuggestedCommentSort() {
        return suggestedCommentSort;
    }

    public void setSuggestedCommentSort(String suggestedCommentSort) {
        this.suggestedCommentSort = suggestedCommentSort;
    }

    public String getIconImg() {
        return iconImg;
    }

    public void setIconImg(String iconImg) {
        this.iconImg = iconImg;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubmitLinkLabel() {
        return submitLinkLabel;
    }

    public void setSubmitLinkLabel(String submitLinkLabel) {
        this.submitLinkLabel = submitLinkLabel;
    }

    public Boolean getPublicTraffic() {
        return publicTraffic;
    }

    public void setPublicTraffic(Boolean publicTraffic) {
        this.publicTraffic = publicTraffic;
    }

    public Integer getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Integer subscribers) {
        this.subscribers = subscribers;
    }

    public String getSubmitTextLabel() {
        return submitTextLabel;
    }

    public void setSubmitTextLabel(String submitTextLabel) {
        this.submitTextLabel = submitTextLabel;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getKeyColor() {
        return keyColor;
    }

    public void setKeyColor(String keyColor) {
        this.keyColor = keyColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCreated() {
        return created;
    }

    public void setCreated(Double created) {
        this.created = created;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getQuarantine() {
        return quarantine;
    }

    public void setQuarantine(Boolean quarantine) {
        this.quarantine = quarantine;
    }

    public Boolean getHideAds() {
        return hideAds;
    }

    public void setHideAds(Boolean hideAds) {
        this.hideAds = hideAds;
    }

    public String getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(String createdUtc) {
        this.createdUtc = createdUtc;
    }

    public String getPublicDescription() {
        return publicDescription;
    }

    public void setPublicDescription(String publicDescription) {
        this.publicDescription = publicDescription;
    }

    public Boolean getShowMediaPreview() {
        return showMediaPreview;
    }

    public void setShowMediaPreview(Boolean showMediaPreview) {
        this.showMediaPreview = showMediaPreview;
    }

    public Integer getCommentScoreHideMins() {
        return commentScoreHideMins;
    }

    public void setCommentScoreHideMins(Integer commentScoreHideMins) {
        this.commentScoreHideMins = commentScoreHideMins;
    }

    public String getSubredditType() {
        return subredditType;
    }

    public void setSubredditType(String subredditType) {
        this.subredditType = subredditType;
    }

    public String getSubmissionType() {
        return submissionType;
    }

    public void setSubmissionType(String submissionType) {
        this.submissionType = submissionType;
    }
}