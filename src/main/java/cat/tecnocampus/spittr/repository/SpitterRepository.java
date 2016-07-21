package cat.tecnocampus.spittr.repository;

import cat.tecnocampus.spittr.domain.Spitter;

/**
 * Created by roure on 21/07/2016.
 */
public interface SpitterRepository {
    public Spitter save(Spitter u);
    public Spitter findByUserName(String userName);
}
