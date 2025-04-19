import java.time.LocalDate;
import java.util.*;

public class PhotoManager {
  static   Map<String, Set<Photo>> tagToPhotos = new HashMap<>();
   static List<Photo> allPhotos = new ArrayList<>();


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

    public  static Set<Photo> searchBtw2Date(LocalDate date1,LocalDate date2)
    {

        System.out.println("all"+allPhotos);
        Set<Photo> date=new HashSet<>();
        for (Photo p:allPhotos){

            if(p.getDate().equals(date1)||p.getDate().equals(date2)||p.getDate().isAfter(date1)&&p.getDate().isBefore(date2))

            {
                date.add(p);

            }
        }
        return date;
    }

    public static Set<Set<Photo>> searchByMultipleTags(String... tags)
    {
        Set<Set<Photo>> Mul=new HashSet<>();

        for (Map.Entry<String, Set<Photo>> entry : tagToPhotos.entrySet())
        {
            int i=0;
            System.out.println("entry"+entry);
            System.out.println("key"+entry.getKey());
            System.out.println("value"+entry.getValue());
            while (i<tags.length)
            {
                System.out.println("while");
            if(entry.getKey().equals(tags[i]))
            {
                System.out.println("if");
                Mul.add(entry.getValue());
            }


                i++;
            }
        }
        return Mul;

    }
}
