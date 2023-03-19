import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;

@SpringBootTest(classes = test01.class)
public class test01 {

    @Test
    void testMap(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put(null,null);
        System.out.println(map);

        ArrayList<Object> list = new ArrayList<>();
        list.add(null);
        System.out.println(list);
    }
}
