package ru.ccamgmt.service.handler;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.ccamgmt.contracts.MedicsResponse;
import ru.ccamgmt.domain.dao.MedicDAO;
import ru.ccamgmt.domain.entity.medic.Medic;
import ru.ccamgmt.domain.entity.medic.MedicPosition;
import ru.ccamgmt.domain.entity.medic.MedicUser;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by Денис on 23.12.2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserHandlerTest {


    @InjectMocks
    private UserHandler userHandler;

    @Mock
    private MedicDAO medicDAO;

    @Before
    public void setUp() throws Exception {
        //setUP
    }


    @Test
    public void testMedicListHandler() {
        MedicPosition position = new MedicPosition();
        position.setPositionValue("главврач");

        MedicUser user = new MedicUser();
        user.setMiddleName("Stolyarenko");
        user.setFirstName("Yuriy");

        Medic medic = new Medic();
        medic.setId(5L);
        medic.setMedicUser(user);
        medic.setMedicPosition(position);

        List<Medic> medics = new ArrayList<>();
        medics.add(medic);

        when(medicDAO.findAll()).thenReturn(medics);

        Response response = userHandler.medicListHandle();
        assertEquals(200, response.getStatus());
        assertTrue(response.getEntity() instanceof MedicsResponse);
        MedicsResponse medicsResponse = (MedicsResponse) response.getEntity();
        assertEquals(1, medicsResponse.getMedics().size());
        assertEquals("Yuriy", medicsResponse.getMedics().get(0).getFirstName());
        assertEquals("Stolyarenko", medicsResponse.getMedics().get(0).getMiddleName());
        assertEquals((Long)5L, medicsResponse.getMedics().get(0).getMedicId());
        assertEquals("главврач", medicsResponse.getMedics().get(0).getPosition());

    }

}
