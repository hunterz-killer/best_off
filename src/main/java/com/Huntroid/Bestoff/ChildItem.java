package com.Huntroid.Bestoff;

public class ChildItem {

    private String childName, childImage, childSite,childLink,childMrp;

    public ChildItem(){}

    public ChildItem(String childName, String childImage, String childSite, String childLink, String childMrp) {
        this.childName = childName;
        this.childImage = childImage;
        this.childSite = childSite;
        this.childLink = childLink;
        this.childMrp = childMrp;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildImage() {
        return childImage;
    }

    public void setChildImage(String childImage) {
        this.childImage = childImage;
    }

    public String getChildSite() {
        return childSite;
    }

    public void setChildSite(String childSite) {
        this.childSite = childSite;
    }

    public String getChildLink() {
        return childLink;
    }

    public void setChildLink(String childLink) {
        this.childLink = childLink;
    }

    public String getChildMrp() {
        return childMrp;
    }

    public void setChildMrp(String childMrp) {
        this.childMrp = childMrp;
    }
}
