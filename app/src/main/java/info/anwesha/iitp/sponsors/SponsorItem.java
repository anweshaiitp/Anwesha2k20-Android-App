package info.anwesha.iitp.sponsors;

import androidx.annotation.Keep;

@Keep
public class SponsorItem {

    private String website;
    private String name;
    private String image;
    private String sponsor_name;

    public SponsorItem(){

    }

    public SponsorItem(String name, String image, String website, String sponsor_name) {
        this.name = name;
        this.image = image;
        this.website = website;
        this.sponsor_name = sponsor_name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSponsor_name() {
        return sponsor_name;
    }

    public void setSponsor_name(String sponsor_name) {
        this.sponsor_name = sponsor_name;
    }
}
