package dm;

import androidx.annotation.DrawableRes;

public class GameProduct {
    private String id;
    private String name;
    private String publishedCompany;
    private String genre;
    private String releaseDate;
    @DrawableRes
    private int image;
    private String description;

    public GameProduct(){

    }

    public GameProduct(String id, String name, String publishedCompany, String genre, String releaseDate, int image, String description) {
        this.id = id;
        this.name = name;
        this.publishedCompany = publishedCompany;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.image = image;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishedCompany() {
        return publishedCompany;
    }

    public void setPublishedCompany(String publishedCompany) {
        this.publishedCompany = publishedCompany;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "GameProduct{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", publishedCompany='" + publishedCompany + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", image=" + image +
                ", description='" + description + '\'' +
                '}';
    }
}
