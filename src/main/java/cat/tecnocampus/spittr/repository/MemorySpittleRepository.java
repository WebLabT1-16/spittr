package cat.tecnocampus.spittr.repository;

import cat.tecnocampus.spittr.domain.Spittle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by roure on 21/07/2016.
 */
@Component
public class MemorySpittleRepository implements SpittleRepository {
    private ArrayList<Spittle> spittles = new ArrayList<>();

    public MemorySpittleRepository() {
        for (int i = 0; i <50 ; i++) {
            Spittle s = new Spittle("Hola " + i, new Date(), new Double(i), new Double(i));
            spittles.add(s);
        }
    }

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return spittles.subList(0,count-1);
    }

    @Override
    public Spittle findOne(long s) {
        return spittles.get((int)s);
    }
}
