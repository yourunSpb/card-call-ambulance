package ru.ccamgmt.service.handler;

import ru.ccamgmt.contracts.MedicDetails;
import ru.ccamgmt.contracts.MedicsResponse;
import ru.ccamgmt.domain.dao.MedicDAO;
import ru.ccamgmt.domain.entity.medic.Medic;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuriy Stolyarenko on 28.10.2015.
 */
@Stateless
public class UserHandler {

    @EJB
    MedicDAO medicDAO;


    public Response medicListHandle() {
        MedicsResponse medicResponse = new MedicsResponse();
        List<MedicDetails> medicDetailsList = new ArrayList<>();
        List<Medic> medicList = medicDAO.findAll();
        for (Medic medic : medicList) {
            MedicDetails medicDetails = new MedicDetails();
            medicDetails.setMedicId(medic.getId());
            medicDetails.setFirstName(medic.getMedicUser().getFirstName());
            medicDetails.setMiddleName(medic.getMedicUser().getMiddleName());
            medicDetails.setPosition(medic.getMedicPosition().getPositionValue());
            medicDetailsList.add(medicDetails);
        }
        medicResponse.setMedics(medicDetailsList);
        return Response.ok(medicResponse).build();
    }
}
