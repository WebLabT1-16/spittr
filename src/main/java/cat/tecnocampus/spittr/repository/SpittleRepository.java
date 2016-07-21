package cat.tecnocampus.spittr.repository;

import cat.tecnocampus.spittr.domain.Spittle;
import sun.security.provider.ConfigFile;

import java.util.List;

/**
 * Created by roure on 20/07/2016.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long s);
}
