package AutoWithAll.AutoWithAll.security.services;

import AutoWithAll.AutoWithAll.models.Test;
import AutoWithAll.AutoWithAll.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDetailsImpl {
    @Autowired
    private TestRepository testRepository;

    public Test saveTestDetails(Test test){
        return testRepository.save(test);
    }


    public Test editTestDetails(Test test){
        Test testUpdate = testRepository.findById(test.getId()).orElse(null);
        testUpdate.setName(test.getName());
        testUpdate.setAge(test.getAge());
        return testRepository.save(testUpdate);
    }
    public String deleteTestDetails(Long id){
        testRepository.deleteById(id);
        return "Dete remove" + id;
    }
}
