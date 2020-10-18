package models;

public class Musics {
    private int id;
    private String name;
    private String artist;
    private String duration;
    private String category;

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getArtist(){
        return this.artist;
    }

    public String getDuration(){
        return this.duration;
    }

    public String getCategory(){
        return this.category;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

    public void setDuration(String duration){
        this.duration = duration;
    }

    public void setCategory(String category){
        this.category = category;
    }
}