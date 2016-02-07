package ru.ccamgmt.service.handler;

import ru.ccamgmt.contracts.*;
import ru.ccamgmt.domain.dao.CardCallDAO;
import ru.ccamgmt.domain.dao.DepartmentDAO;
import ru.ccamgmt.domain.dao.ProfileDAO;
import ru.ccamgmt.domain.dao.SectionDAO;
import ru.ccamgmt.domain.entity.CardCall;
import ru.ccamgmt.domain.entity.StatusType;
import ru.ccamgmt.domain.entity.brigade.Brigade;
import ru.ccamgmt.domain.entity.brigade.BrigadeProfile;
import ru.ccamgmt.domain.entity.brigade.Department;
import ru.ccamgmt.domain.entity.medic.Medic;
import ru.ccamgmt.domain.entity.section.Answer;
import ru.ccamgmt.domain.entity.section.LookupSection;
import ru.ccamgmt.domain.entity.section.Question;
import ru.ccamgmt.domain.entity.section.Section;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Yuriy Stolyarenko on 01.11.2015.
 */
@Stateless
public class CardCallHandler {

    @EJB
    SectionDAO sectionDAO;

    @EJB
    CardCallDAO cardCallDAO;

    @EJB
    DepartmentDAO departmentDAO;

    @EJB
    ProfileDAO profileDAO;


    public Response cardCallListHandler() {
        CardCallListResponse cardCallListResponse = new CardCallListResponse();
        List<CardCallDetails> cardCallDetails = new ArrayList<>();
        List<CardCall> cardCalls = cardCallDAO.findAll();
        for (CardCall cardCall : cardCalls) {
            CardCallDetails details = new CardCallDetails();
            details.setCardCallId(cardCall.getId());
            details.setCreateDataTime(cardCall.getCreateDate());
            details.setStatus(cardCall.getStatus().name());


            MedicDetails medicDetails = new MedicDetails();
            medicDetails.setMedicId(cardCall.getUpdateBy().getId());
            medicDetails.setFirstName(cardCall.getUpdateBy().getMedicUser().getFirstName());
            medicDetails.setMiddleName(cardCall.getUpdateBy().getMedicUser().getMiddleName());
            medicDetails.setPosition(cardCall.getUpdateBy().getMedicPosition().getPositionValue());
            details.setUpdatedBy(medicDetails);

            BrigadeDetails brigadeDetails = new BrigadeDetails();
            brigadeDetails.setBrigadeId(cardCall.getBrigade().getId());
            brigadeDetails.setBrigadeNumber(cardCall.getBrigade().getBrigadeNumber());
            brigadeDetails.setDepartmentId(cardCall.getBrigade().getDepartment().getId());
            List<Long> medics = new ArrayList<>();
            for (Medic medic : cardCall.getBrigade().getMedics()) {
                medics.add(medic.getId());
            }
            brigadeDetails.setMedicList(medics);
            details.setBrigade(brigadeDetails);
            details.setUpdatedDataTime(cardCall.getUpdateDate());


            if (cardCall.getLookupSections() != null && !cardCall.getLookupSections().isEmpty()) {
                List<LookupSectionDetails> sectionDetails = new ArrayList<>();
                for (LookupSection section : cardCall.getLookupSections()) {
                    LookupSectionDetails lookupSectionDetails = new LookupSectionDetails();
                    if (section.getAnswer() != null) {
                        lookupSectionDetails.setAnswerId(section.getAnswer());
                    }
                    lookupSectionDetails.setAnswerValue(section.getAnswerValue());
                    lookupSectionDetails.setQuestionId(section.getQuestion());
                    sectionDetails.add(lookupSectionDetails);
                }
                details.setSections(sectionDetails);
            }
            cardCallDetails.add(details);
        }
        cardCallListResponse.setCardCalls(cardCallDetails);
        return Response.ok(cardCallListResponse).build();
    }


    public Response cardCallProfileListHandler() {
        ProfileResponse profileRespons = new ProfileResponse();
        List<ProfileDetails> profileDetails = new ArrayList<>();
        List<BrigadeProfile> profiles = profileDAO.findAll();
        for (BrigadeProfile profile : profiles) {
            ProfileDetails details = new ProfileDetails();
            details.setProfileId(profile.getId());
            details.setTranscript(profile.getTranscript());
            details.setReduction(profile.getReduction());

            profileDetails.add(details);
        }
        profileRespons.setProfiles(profileDetails);
        return Response.ok(profileRespons).build();
    }

    public Response cardCallDepartmentListHandler() {
        DepartmentsResponse departmentsResponse = new DepartmentsResponse();
        List<DepartmentDetails> departmentsDetails = new ArrayList<>();
        List<Department> departments = departmentDAO.findAll();
        for (Department department : departments) {
            DepartmentDetails details = new DepartmentDetails();
            details.setDepartmentId(department.getId());
            details.setDepartmentName(department.getDepartmentName());

            departmentsDetails.add(details);
        }
        departmentsResponse.setDepartments(departmentsDetails);
        return Response.ok(departmentsResponse).build();
    }

    public Response addOrEditHandler(AddCardCallRequest body) {
        CardCall cardCall = new CardCall();
        cardCall.setId(body.getCardCallId());
        cardCall.setBrigade(converterBrigade(body.getBrigade()));
        cardCall.setStatus(StatusType.DRAFT);
        cardCall.setCreateDate(new Date());
        cardCall.setUpdateBy(new Medic(body.getUpdatedBy()));
        cardCall.setLookupSections(converterLookupSection(body.getSections(), cardCall));
        cardCallDAO.persist(cardCall);
        return Response.ok().build();
    }

    private Brigade converterBrigade(BrigadeDetails brigadeDetails) {
        Brigade brigade = new Brigade();
        brigade.setId(brigadeDetails.getBrigadeId());
        brigade.setBrigadeNumber(brigadeDetails.getBrigadeNumber());
        brigade.setBrigadeProfile(new BrigadeProfile(brigadeDetails.getProfileId()));
        brigade.setDepartment(new Department(brigadeDetails.getDepartmentId()));
        Set<Medic> medics = new HashSet<>();
        for (Long medicId : brigadeDetails.getMedicList()) {
            medics.add(new Medic(medicId));
        }
        brigade.setMedics(medics);
        return brigade;
    }

    private Set<LookupSection> converterLookupSection(List<LookupSectionDetails> lookupSectionDetails, CardCall cardCall) {
        Set<LookupSection> lookupSections = new HashSet<>();

        for (LookupSectionDetails details : lookupSectionDetails) {
            LookupSection lookupSection = new LookupSection();
            lookupSection.setId(details.getLookupSectionId());
            if (details.getAnswerId() != null) {
                lookupSection.setAnswer(details.getAnswerId());
            }
            lookupSection.setQuestion(details.getQuestionId());
            lookupSection.setAnswerValue(details.getAnswerValue());
            lookupSection.setCardCallSection(cardCall);

            lookupSections.add(lookupSection);
        }
        return lookupSections;
    }


    public Response sectionListHandler() {
        FormSectionsResponse sectionsResponse = new FormSectionsResponse();
        List<SectionDetails> sectionDetailList = new ArrayList<>();
        List<Section> sectionList = sectionDAO.findAll();
        for (Section section : sectionList) {
            SectionDetails sectionDetails = new SectionDetails();
            sectionDetails.setSectionId(section.getId());
            sectionDetails.setSectionDescription(section.getSectionDescription());
            sectionDetails.setSectionName(section.getSectionName());
            sectionDetails.setQuestions(getQuestionsDetail(section.getQuestions()));

            sectionDetailList.add(sectionDetails);
        }
        sectionsResponse.setSections(sectionDetailList);
        return Response.ok(sectionsResponse).build();
    }

    private List<QuestionDetails> getQuestionsDetail(Set<Question> questionSet) {
        List<QuestionDetails> questionDetailses = new ArrayList<>();
        if (questionSet != null && !questionSet.isEmpty()) {
            for (Question question : questionSet) {
                QuestionDetails questionDetails = new QuestionDetails();
                questionDetails.setQuestionId(question.getId());
                questionDetails.setAnswerType(question.getAnswerType().getLabel());
                questionDetails.setQuestionOrder(question.getQuestionOrder());
                questionDetails.setQuestionText(question.getQuestionText());
                questionDetails.setAnswers(getAnswersDetail(question.getAnswers()));

                questionDetailses.add(questionDetails);
            }
        }
        return questionDetailses;
    }

    private List<AnswerDetails> getAnswersDetail(Set<Answer> answerSet) {
        List<AnswerDetails> answerDetailses = new ArrayList<>();
        if (answerSet != null && !answerSet.isEmpty()) {
            for (Answer answer : answerSet) {
                AnswerDetails answerDetails = new AnswerDetails();
                answerDetails.setAnswerId(answer.getId());
                answerDetails.setAnswerValue(answer.getAnswerValue());

                answerDetailses.add(answerDetails);
            }
        }
        return answerDetailses;
    }
}
