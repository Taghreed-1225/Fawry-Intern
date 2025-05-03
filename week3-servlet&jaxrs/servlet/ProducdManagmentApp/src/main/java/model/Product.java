package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data  // equal to @Setter , @Getter , @ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {
   // @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
  //  @Column(name = "id")

   private int id;

 //   @Column(name = "name")
    private String name;




}

