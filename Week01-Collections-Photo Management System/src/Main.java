import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Location location=new Location(30.0444,31.2357);
        Photo photo1=new Photo("Ahmed",location);
        PhotoManager photoManager=new PhotoManager();

        //add photo one
        photoManager.addPhoto(photo1);

       // add tag "holiday" to photo one"
        photoManager.addTag("holiday",photo1);

        //search by name
        System.out.println(photoManager.search("Ahmed"));
        //search by location
        System.out.println(photoManager.search("Cairo"));
        // search ny date
        System.out.println(photoManager.search("2025-04-18"));
        //search by tag
        System.out.println(photoManager.search("holiday"));


        System.out.println("================================================");

        //add photo two
        Photo photo2=new Photo("Taghreed",location);
        photoManager.addPhoto(photo2);

        // add tag "family" to photo two"
        photoManager.addTag("family",photo2);

        //search by name
        System.out.println(photoManager.search("Taghreed"));
        //search by location
        System.out.println(photoManager.search("Cairo"));
        // search ny date
        System.out.println(photoManager.search("2025-04-18"));
        //search by tag
        System.out.println(photoManager.search("family"));

        // empty
        System.out.println(photoManager.search("Alex"));

        //add photo three
        Photo photo3=new Photo("mayar",location);
        photoManager.addPhoto(photo3);


        // search between 2 dates
        System.out.println(PhotoManager.searchBtw2Date(LocalDate.parse("2025-04-18"),LocalDate.parse("2025-04-19")));


        //searchByMultipleTags
        System.out.println("multi tags"+ PhotoManager.searchByMultipleTags("family","holiday"));



















    }
}
