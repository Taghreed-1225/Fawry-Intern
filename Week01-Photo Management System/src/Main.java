
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

        // embty
        System.out.println(photoManager.search("Alex"));















//        Photo photo2=new Photo("taghreed",location);
//        Photo photo3=new Photo("mayar",location);

//        photoManager.addPhoto(photo2);
//        photoManager.addPhoto(photo3);
//        photoManager.addPhoto(photo3);
//        System.out.println(photoManager.search("ahmed"));
//        System.out.println(photoManager.search("taghreed"));
//        System.out.println(photoManager.search("mayar"));
//        photoManager.addTag("holiday",photo1);
       // photoManager.addTag("holiday",photo2);
//        Photo p= (Photo) photoManager.search("holiday");
    //    System.out.println(p.getName());




    }
}
