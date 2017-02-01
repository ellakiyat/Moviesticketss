package com.realimage.administrator.moviesticket.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Movies {
    //To get the single item in the list
    //@serializedname properties helps you to modify the json property name
    //@expose
    //null handling, you could think that you would just set a Java object field to null, if you don't want it to show up in the JSON.
    //Gson offers a simpler solution with the annotation @Expose.
    //@Expose is optional and offers two configuration parameters: serialize and deserialize.
    // By default everything is set to true
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("release_date")
    @Expose
    private String release;
    @SerializedName("synopsis")
    @Expose
    private String synopsis;
    @SerializedName("trailer")
    @Expose
    private Trailer trailer;
    @SerializedName("cast")
    @Expose
    public List<Cast> cast = null;
    @SerializedName("crew")
    @Expose
    public List<Crew> crew = null;
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
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getRelease() {
        return release;
    }
    public void setRelease(String release) {
        this.release = release;
    }
    public String getSynopsis() {
        return synopsis;
    }
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    public Trailer getTrailer() {
        return trailer;
    }
    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }
    public class Trailer {
        @SerializedName("link")
        @Expose
        private String link;
        @SerializedName("thumbnail")
        @Expose
        private String thumbnail;
        public String getLink() {
            return link;
        }
        public void setLink(String link) {
            this.link = link;
        }
        public String getThumbnail() {
            return thumbnail;
        }
        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }
    }
    public class Cast {

        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("role")
        @Expose
        public String role;
        @SerializedName("uuid")
        @Expose
        public String uuid;
        @SerializedName("poster_url")
        @Expose
        public String posterUrl;
        @SerializedName("url")
        @Expose
        public String url;
        @SerializedName("moviebuff_url")
        @Expose
        public String moviebuffUrl;

    }

    public class Crew {

        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("role")
        @Expose
        public String role;
        @SerializedName("uuid")
        @Expose
        public String uuid;
        @SerializedName("poster_url")
        @Expose
        public Object posterUrl;
        @SerializedName("url")
        @Expose
        public String url;
        @SerializedName("moviebuff_url")
        @Expose
        public String moviebuffUrl;

    }
}
// JSON is a format that encodes objects in a string. Serialization means to convert an object into that string, and
// deserialization is its inverse operation. When transmitting data or storing them in a file,
// the data are required to be byte strings, but complex objects are seldom in this format.