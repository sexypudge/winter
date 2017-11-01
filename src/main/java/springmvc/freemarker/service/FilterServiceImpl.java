package springmvc.freemarker.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springmvc.freemarker.dao.FilterDao;
import springmvc.freemarker.model.User;

import java.util.List;

@Service
@Transactional
public class FilterServiceImpl implements FilterService {

    @Autowired
    private FilterDao filterDao;

    @Override
    public List<User> search(Integer de, Integer ti, Integer po) {
        return filterDao.search(de,ti,po);
    }
}
