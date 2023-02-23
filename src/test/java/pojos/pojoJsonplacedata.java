package pojos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class pojoJsonplacedata {

  /*  Request Body
    {
        "title": "Ahmet",
            "body": "Merhaba",
            "userId": 10,
            "id": 70
    }
*/

    private String title;
    private String body;
    private int userId;
    private int id;















}
