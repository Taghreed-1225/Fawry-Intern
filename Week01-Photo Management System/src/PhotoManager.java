import java.util.*;

public class PhotoManager {
    Map<String, Set<Photo>> tagToPhotos = new HashMap<>();
    List<Photo> allPhotos = new ArrayList<>();


    public void addPhoto(Photo photo){
        allPhotos.add(photo);
        addTag(photo.getName(),photo);
        addTag(photo.getDate().toString(),photo);

        addTag(photo.getLocation().getCity(photo.getLocation()),photo);

    }
    public void addTag(String tag,Photo photo){// can photo be list ?
        tagToPhotos.putIfAbsent(tag,new HashSet<>());
        tagToPhotos.get(tag).add(photo);
    }
    public Set<Photo> search(String tag){
        return tagToPhotos.getOrDefault(tag, new HashSet<>());

    }
}
