package cat.tecnocampus.spittr.web;

import cat.tecnocampus.spittr.domain.Spitter;
import cat.tecnocampus.spittr.repository.SpitterRepository;
import cat.tecnocampus.spittr.repository.SpittleRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by roure on 21/07/2016.
 */
public class SpitterControllerTest {
    @Test
    public void shouldShowRegistration() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spitter/register"))
            .andExpect(view().name("registerForm"));

    }

    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("jroure", "24hours", "Josep", "Roure");
        Spitter saved = new Spitter(24L,"jroure", "24hours", "Josep", "Roure");
        when(mockRepository.save(unsaved)).thenReturn(saved);

        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spitter/register")
                .param("firstName", "Josep")
                .param("lastName", "Roure")
                .param("userName", "jroure")
                .param("password", "24hours"))
                .andExpect(redirectedUrl("/spitter/jroure"));
        verify(mockRepository, atLeastOnce()).save(unsaved); //for this to work spitter needs equals. It compares the unsaved with the one created by the POST call

    }
}
