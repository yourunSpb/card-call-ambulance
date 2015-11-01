package ru.ccamgmt.service.handler;

import ru.ccamgmt.contracts.AnswerDetails;
import ru.ccamgmt.contracts.FormSectionsResponse;
import ru.ccamgmt.contracts.QuestionDetails;
import ru.ccamgmt.contracts.SectionDetails;
import ru.ccamgmt.domain.dao.SectionDAO;
import ru.ccamgmt.domain.entity.section.Answer;
import ru.ccamgmt.domain.entity.section.Question;
import ru.ccamgmt.domain.entity.section.Section;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Yuriy Stolyarenko on 01.11.2015.
 */
@Stateless
public class CardCallHandler {

    @EJB
    SectionDAO sectionDAO;

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
