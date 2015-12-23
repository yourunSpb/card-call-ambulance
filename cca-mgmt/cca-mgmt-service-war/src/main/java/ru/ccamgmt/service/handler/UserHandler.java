package ru.ccamgmt.service.handler;

import ru.ccamgmt.contracts.AddMedicUserRequest;
import ru.ccamgmt.contracts.MedicDetails;
import ru.ccamgmt.contracts.MedicsResponse;
import ru.ccamgmt.domain.dao.MedicDAO;
import ru.ccamgmt.domain.entity.medic.Medic;
import ru.ccamgmt.domain.entity.medic.MedicPosition;
import ru.ccamgmt.domain.entity.medic.MedicRole;
import ru.ccamgmt.domain.entity.medic.MedicUser;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import java.util.*;

/**
 * Created by Yuriy Stolyarenko on 28.10.2015.
 */
@Stateless
public class UserHandler {

    @EJB
    MedicDAO medicDAO;


    public Response medicListHandler() {
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

    public Response addMedicUser(AddMedicUserRequest body) {
        Medic medic = new Medic();


        MedicUser medicUser = new MedicUser();
        medicUser.setFirstName(body.getFirstName());
        medicUser.setMiddleName(body.getMiddleName());
        medicUser.setLastName(body.getLastName());
        medicUser.seteMailAddress(body.getMailAddress());
        medic.setMedicUser(medicUser);

        MedicPosition position = new MedicPosition();
        position.setId(body.getMedicPositionId());
        medic.setMedicPosition(position);

        Set<MedicRole> medicRoles = new HashSet<>();
        for (Long roleId: body.getRoleList()) {
            MedicRole role = new MedicRole();
            role.setId(roleId);
            medicRoles.add(role);
        }
        medic.setMedicRoles(medicRoles);

        medicDAO.persist(medic);
        return Response.ok().build();
    }





}
