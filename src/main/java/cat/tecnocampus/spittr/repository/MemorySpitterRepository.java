package cat.tecnocampus.spittr.repository;

import cat.tecnocampus.spittr.domain.Spitter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by roure on 21/07/2016.
 */
@Component
public class MemorySpitterRepository implements SpitterRepository {
    private HashMap<String, Spitter> spitters = new HashMap<>();
    private static long id=100;

    public MemorySpitterRepository() {
        for (int i = 0; i < 100; i++) {
            Spitter s = new Spitter("pepe" + i, "pass" + i, "Josep" + i, "Roure" + i, "email@"+i);
            s.setId(new Long(i));
            spitters.put("pepe" + i, s);
        }
    }

    @Override
    public Spitter save(Spitter u) {
        u.setId(new Long(id));
        id++; //that should be synchronized
        spitters.put(u.getUserName(), u);
        return u;
    }

    @Override
    public Spitter findByUserName(String userName) {
        return spitters.get(userName);
    }
}
