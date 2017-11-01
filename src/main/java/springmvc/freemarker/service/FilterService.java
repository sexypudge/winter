package springmvc.freemarker.service;

import springmvc.freemarker.model.User;

import java.util.List;

public interface FilterService {
    List<User> search(Integer de, Integer ti, Integer po );
}
