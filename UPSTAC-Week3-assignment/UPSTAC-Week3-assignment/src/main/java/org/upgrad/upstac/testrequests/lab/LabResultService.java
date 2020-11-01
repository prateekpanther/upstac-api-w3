package org.upgrad.upstac.testrequests.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.upgrad.upstac.testrequests.TestRequest;
import org.upgrad.upstac.users.User;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Validated
public class LabResultService {


    @Autowired
    private LabResultRepository labResultRepository;


    private static Logger logger = LoggerFactory.getLogger(LabResultService.class);



    private LabResult createLabResult(User tester, TestRequest testRequest) {
        //Implement this method to create the lab result module service
        // create object of LabResult class and use the setter methods to set tester
        // and testRequest details
        // make use of saveLabResult() method to return the LabResult object

        LabResult lr= new LabResult();
        lr.setTester(tester);
       // lr.setTemperature("200");
        lr.setRequest(testRequest);
  //      return labResultRepository.save(lr);
        return saveLabResult(lr);

  //prateek      return null; // replace this line with your code
    }

    @Transactional
    LabResult saveLabResult(LabResult labResult) {
        return labResultRepository.save(labResult);
    }



    public LabResult assignForLabTest(TestRequest testRequest, User tester) {

        return createLabResult(tester, testRequest);


    }


    public LabResult updateLabTest(TestRequest testRequest, CreateLabResult createLabResult) {

        //Implement this method to update the lab test
        // create an object of LabResult and make use of setters to set Blood Pressure, Comments,
        // HeartBeat, OxygenLevel, Temperature, Result and UpdatedOn values
        // make use of the saveLabResult() method to return the object of LabResult
        LabResult lr1 = labResultRepository.findByRequest(testRequest).get();
       // LabResult lr1=new LabResult();
        lr1.setBloodPressure(createLabResult.getBloodPressure());
        lr1.setComments(createLabResult.getComments());
        lr1.setHeartBeat(createLabResult.getHeartBeat());
        lr1.setOxygenLevel(createLabResult.getOxygenLevel());
        lr1.setTemperature(createLabResult.getTemperature());
        lr1.setResult(createLabResult.getResult());
        lr1.setUpdatedOn(LocalDate.now());
        lr1.setRequest(testRequest);
        lr1.setResult(createLabResult.getResult());

  //      return labResultRepository.save(lr);
        return saveLabResult(lr1);




     //prateek   return null; // replace this line with your code


    }


}
