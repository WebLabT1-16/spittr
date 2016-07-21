package cat.tecnocampus.spittr.web;

import cat.tecnocampus.spittr.domain.Spittle;
import cat.tecnocampus.spittr.repository.SpittleRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by roure on 20/07/2016.
 */
public class SpittlesControllerTest {
    @Test
    public void shouldShowRecentSpittes() throws Exception {
        List<Spittle> expectedSpittes = createSpittleList(50);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles((Long.MAX_VALUE), 50)).thenReturn(expectedSpittes);

        SpittleController controller = new SpittleController(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller).setSingleView((new InternalResourceView("/WEB-INF/views/spittles.jsp"))).build();

        mockMvc.perform(get(String.format("/spittles?max=%d&count=%d",Long.MAX_VALUE,50)))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))  //this is the name inferred (see SpittleController's code)
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittes.toArray())));

    }

    @Test
    public void testSpittle() throws Exception {
        Spittle expectedSpittle = new Spittle("Hello", new Date());
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spittles/12345"))
                .andExpect(view().name("spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", expectedSpittle));
    }


    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }
}
