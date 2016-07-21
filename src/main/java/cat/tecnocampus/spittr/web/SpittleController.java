package cat.tecnocampus.spittr.web;

import cat.tecnocampus.spittr.domain.Spittle;
import cat.tecnocampus.spittr.repository.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by roure on 20/07/2016.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private final SpittleRepository spittleRepository;
    private static final String MAX_LOG_VALUE_AS_STRING = "9223372036854775807"; //Long.toString(Long.MAX_VALUE);

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    //in this way the model is fed with a new attribute and the "spittles" is returned for the view resolver
    //see that the model key is inferred using the type added List<Spittle> -> spittleList
/*
    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model) {
        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles"; //this is the logic view that will be called (after being resolved by the ViewResolver). See WebConfig
    }
*/

    //This is an alternative implementation of the previous method. It returns the list which is added to the model
    // whith the key as before. Th
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value="max", defaultValue = MAX_LOG_VALUE_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count)
    {
        return spittleRepository.findSpittles(max, count);
    }

    //We cannot use the provious approach (returning Spittle) because the call doesn't correspond to the logic view name
    @RequestMapping(value="/{spittleId}", method = RequestMethod.GET)
    public String spittle(
            //@PathVariable("spittleId") long spittleId,
            @PathVariable long spittleId, // the name of the placeholder can be omitted  as it is the same as the parameter
            Model model
        )
    {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }
}
