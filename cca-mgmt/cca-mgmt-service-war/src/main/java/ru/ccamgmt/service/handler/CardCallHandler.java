package ru.ccamgmt.service.handler;

import ru.ccamgmt.contracts.AddCardCallRequest;
import ru.ccamgmt.contracts.AnswerDetails;
import ru.ccamgmt.contracts.BrigadeDetails;
import ru.ccamgmt.contracts.FormSectionsResponse;
import ru.ccamgmt.contracts.LookupSectionDetails;
import ru.ccamgmt.contracts.QuestionDetails;
import ru.ccamgmt.contracts.SectionDetails;
import ru.ccamgmt.domain.dao.CardCallDAO;
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
        for (Long medicId: brigadeDetails.getMedicList()) {
            medics.add(new Medic(medicId));
        }
        brigade.setMedics(medics);
        return brigade;
    }

    private Set<LookupSection> converterLookupSection(List<LookupSectionDetails> lookupSectionDetails, CardCall cardCall) {
        Set<LookupSection> lookupSections = new HashSet<>();

        for (LookupSectionDetails details: lookupSectionDetails) {
            LookupSection lookupSection = new LookupSection();
            lookupSection.setId(details.getLookupSectionId());
            if (details.getAnswerId() != null) {
                lookupSection.setAnswer(new Answer(details.getAnswerId()));
            }
            lookupSection.setQuestion(new Question(details.getQuestionId()));
            lookupSection.setAnswerValue(details.getAnswerValue());
            lookupSection.setCardCall(cardCall);

            lookupSections.add(lookupSection);
        }
        return lookupSections;
    }




    public Response sectionListHandler() {
        FormSectionsResponse sectionsResponse = new FormSectionsResponse();
        List<SectionDetails> sectionDetailList = new ArrayList<>();
        List<Section> sectionList = sectionDAO.findAll();
        for (Section section: sectionList) {
            SectionDetails sectionDetails = new SectionDetails();
            sectionDetails.setSectionId(section.getId());
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
                questionDetails.setQuestuinText(question.getQuestionText());
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
