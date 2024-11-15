package sg.nus.edu.iss.vttp5_sdf_day12l.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sg.nus.edu.iss.vttp5_sdf_day12l.model.Student;

@Controller
@RequestMapping("/students")
public class StudentController {

    @RequestMapping(path = {"","/allStudents"}, method=RequestMethod.GET)
    public String studentListing(Model model) throws ParseException{
        List<Student> students = new ArrayList<>();

        String dob = "18 Dec 1975 10:25:00.000 SGT";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSS zzz");
        Date dDob = sdf.parse(dob);
        Long ePochDob = dDob.getTime();

        Student s1 = new Student(1, "Damien", "Cumming", ePochDob, "damient@nus.edu.sg", "25 HMKT 119615");
        Student s2 = new Student(1, "Darryl", "Ng", ePochDob, "darrylng@nus.edu.sg", "25 HMKT 119615");
        Student s3 = new Student(1, "Brandon", "Ng", ePochDob, "brandonng@nus.edu.sg", "25 HMKT 119615");

        students.add(s1);
        students.add(s2);
        students.add(s3);

        model.addAttribute("students", students);
        
        return "studentList";
    }
}
