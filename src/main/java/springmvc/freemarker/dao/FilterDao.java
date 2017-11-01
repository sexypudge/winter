package springmvc.freemarker.dao;

import java.util.*;
import springmvc.freemarker.model.User;

public interface FilterDao {
    List<User> search(Integer de, Integer ti, Integer po );
}
