package lv.ctco;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

//    private List<Student> studentList = new ArrayList<Student>() {{
//
//        Student student = new Student();
//        student.setFirstName("Igorj");
//        student.setLastName("Nikholaev");
//        add(student);
//    }};

    @Transactional
    @RequestMapping(path ="/{id}/assignment" , method =  RequestMethod.POST)
    public ResponseEntity<?> addAssignment(@PathVariable("id") int id,
                                           @RequestBody Assignment assignment) {
        Student student = studentRepository.findOne(id);
        student.addAssignment(assignment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}/assignment", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAssignmentByID(@PathVariable("id") int id) {
        Student student = studentRepository.findOne(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getStudents() {
        List student = studentRepository.findAll();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getStudentsByID(@PathVariable("id") int id) {
        Student student = studentRepository.findOne(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postStudents(@RequestBody Student student) {
        studentRepository.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteStudentsById(@PathVariable("id") int id) {
        studentRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> putStudentsById(@PathVariable("id") int id, @RequestBody Student student) {
        Student newStudent = studentRepository.findOne(id);
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        studentRepository.save(newStudent);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
